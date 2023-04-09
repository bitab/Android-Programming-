package com.example.miuapp

import java.io.Serializable

data class User(var firstName:String, var lastName:String, var userName:String, var password:String):
    Serializable
