package com.example.githubexplorer.data.remote

import com.example.githubexplorer.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.IOException

interface GitHubApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("since") since: Long? = null,
        @Query("per_page") perPage: Int = 30
    ): List<SearchUsers>


    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): ResultUsers


    @GET("users/{username}")
    suspend fun getUser(
    @Path("username") username: String
    ): UserDetails


    @GET("users/{username}/repos")
    suspend fun getUserRepos (
    @Path("username") username: String,
    @Query("per_page") perPage: Int = 100,
    @Query("page") page: Int = 1,
    @Query("sort") sort: String = "stars",
    @Query("direction") direction: String = "desc"
    ): List<Repos>

    companion object {
        fun create(authToken: String? = null): GitHubApiService {
            val clientBuilder = OkHttpClient.Builder()

            clientBuilder.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                authToken?.let {
                    requestBuilder.addHeader("Authorization", "token $it")
                }
                val request = requestBuilder.build()
                val response = chain.proceed(request)
                if (!response.isSuccessful) {
                    throw IOException("HTTP error code: ${response.code}")
                }
                response
            }

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(GitHubApiService::class.java)
        }
    }
}