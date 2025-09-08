import com.example.githubexplorer.Constant.Companion.BASE_URL
import com.example.githubexplorer.data.remote.Repos
import com.example.githubexplorer.data.remote.ResultUsers
import com.example.githubexplorer.data.remote.SearchUsers
import com.example.githubexplorer.data.remote.UserDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
            val clientBuilder = okhttp3.OkHttpClient.Builder()

            clientBuilder.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                authToken?.let {
                    requestBuilder.addHeader("Authorization", "token $it")
                }
                val request = requestBuilder.build()
                val response = chain.proceed(request)
                if (!response.isSuccessful) {
                    throw java.io.IOException("HTTP error code: ${response.code()}")
                }
                response
            }

            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()

            return retrofit.create(GitHubApiService::class.java)
        }
    }
}