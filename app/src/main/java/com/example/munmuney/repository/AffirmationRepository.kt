package com.example.munmuney.repository

import com.example.munmuney.api.AffirmationApi
import com.example.munmuney.entity.Affirmation
import com.example.munmuney.utils.MyResponse
import com.example.munmuney.utils.ResponseUtils
import javax.inject.Inject

/**
 * Created by natasha.santoso on 16/10/20.
 */
class AffirmationRepository @Inject constructor() {
  @Inject lateinit var affirmationApi: AffirmationApi

  suspend fun getAffirmation(): MyResponse<Affirmation> {
    val response = affirmationApi.getAffirmation()
    return ResponseUtils.convert(response)
  }
}