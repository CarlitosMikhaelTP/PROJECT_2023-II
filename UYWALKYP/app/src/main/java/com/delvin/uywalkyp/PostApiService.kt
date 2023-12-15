package com.delvin.uywalkyp

import com.delvin.uywalkyc.LoginSchema.LoginRequest
import com.delvin.uywalkyc.UsuariosSchema.PostModelResponse
import com.delvin.uywalkyp.LoginSchema.LoginResponse
import com.delvin.uywalkyp.RegisterSchema.RegisterRequest
import com.delvin.uywalkyp.RegisterSchema.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PostApiService {

    //Para ver todos los usuarios
    @GET("user")
    suspend fun getUserPost():ArrayList<PostModelResponse>

    //Para ver un usuario con un ID especifico
    @GET("user/{id}")
    suspend fun getUserPostById(@Path("id") id:String):ArrayList<PostModelResponse>

    //Para logearse
    @POST("authenticate")
    suspend fun getUserLogin(@Body loginResquest: LoginRequest): Response<LoginResponse>

    //Para poder registrar usuarios
    @POST("register")
    suspend fun createUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>


}