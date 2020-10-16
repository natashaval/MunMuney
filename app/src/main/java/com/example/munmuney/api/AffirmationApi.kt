package com.example.munmuney.api

import com.example.munmuney.entity.Affirmation
import com.example.munmuney.utils.MyResponse
import retrofit2.http.GET

/**
 * Created by natasha.santoso on 16/10/20.
 */
interface AffirmationApi {
  @GET()
  fun getAffirmation(): MyResponse<Affirmation>
}