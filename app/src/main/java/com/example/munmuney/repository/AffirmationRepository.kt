package com.example.munmuney.repository

import com.example.munmuney.api.AffirmationApi
import javax.inject.Inject

/**
 * Created by natasha.santoso on 16/10/20.
 */
class AffirmationRepository @Inject constructor() {
  @Inject lateinit var affirmationApi: AffirmationApi


}