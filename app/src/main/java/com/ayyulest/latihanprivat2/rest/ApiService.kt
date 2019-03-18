package com.ayyulest.latihanprivat2.rest

import com.ayyulest.latihanprivat2.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    fun getALLPost():Observable<List<Post>>
}