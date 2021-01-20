package com.example.kotlinsingletondemo.Modles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User (

    @Expose
    @SerializedName("email")
    val email:String? = null,

    @SerializedName("username")
    @Expose
    val username:String? = null,

    @SerializedName("image")
    @Expose
    val image:String? = null
){
    override fun toString():String{
        return "User( $email , $username , $image )"
    }
}