package com.dev.svs.demoprofileandcountrylist.network

import com.dev.svs.demoprofileandcountrylist.models.CountryDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetDataService {
//    @GET("search?")
//    fun getSearchResults(@Query("q") searchQuery: String,
//                         @Query("part") part: String = "snippet",
//                         @Query("maxResults") maxResults: Int = 20,
//                         @Query("key") key: String = BuildConfig.YoutubeApiKey): Call<YouTubeSearchList>
    @GET("name/{name}")
    fun countryDetail(@Path("name") searchQuery: String,
                      @Query("fullText") fullText: Boolean? = true)  : Call<ArrayList<CountryDetail>>
}