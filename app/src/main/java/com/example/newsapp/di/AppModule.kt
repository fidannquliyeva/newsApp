package com.example.newsapp.di

import com.example.newsapp.data.api.ApiKeyInterceptor
import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.usecase.GetTopHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiKeyInterceptor(): Interceptor {
        return ApiKeyInterceptor("YOUR_API_KEY")
    }

    @Provides
    fun provideOkHttpClient(apiKeyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideNewsApi(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    fun provideRepository(api: NewsApiService): NewsRepository {
        return NewsRepositoryImpl(api)
    }

    @Provides
    fun provideUseCase(repository: NewsRepository): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(repository)
    }
}