package com.example.basiccomposeloginapp.repository

import com.example.basiccomposeloginapp.network.model.LoginDto
import com.example.basiccomposeloginapp.network.model.TokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth")
    suspend fun getLogin(@Body loginDto: LoginDto) : Response<TokenDto>
}