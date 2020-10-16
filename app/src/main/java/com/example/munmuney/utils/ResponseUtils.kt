package com.example.munmuney.utils

import retrofit2.Response

/**
 * Created by natasha.santoso on 16/10/20.
 */
object ResponseUtils {
  fun <T> convert(response: Response<in T>): MyResponse<T> {
    return try {
      if (response.isSuccessful) {
        MyResponse.success(response.body() as T)
      } else {
        MyResponse.failed(response.errorBody().toString())
      }
    } catch (t: Throwable) {
      MyResponse.error(null, t.message)
    }
  }
}