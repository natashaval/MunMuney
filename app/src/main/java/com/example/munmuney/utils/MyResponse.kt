package com.example.munmuney.utils

/**
 * Created by natasha.santoso on 16/10/20.
 */
data class MyResponse<out T>(val status: Status, val data: T?, val message: String?) {
  companion object {
    fun <T> success(data: T): MyResponse<T> = MyResponse(Status.SUCCESS, data, null)
    fun <T> failed(message: String?): MyResponse<T> = MyResponse(Status.FAILED, null, message)
    fun <T> error(data: T?, message: String?): MyResponse<T> = MyResponse(Status.ERROR, data, message)
    fun <T> loading(data: T?): MyResponse<T> = MyResponse(Status.LOADING, data, null)
  }
  enum class Status { SUCCESS, FAILED, ERROR, LOADING }
}