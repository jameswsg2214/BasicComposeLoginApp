package com.example.basiccomposeloginapp.network.model

import com.google.gson.annotations.SerializedName

data class TokenDto(@SerializedName("accessToken") val accessTokenVerify: String)
