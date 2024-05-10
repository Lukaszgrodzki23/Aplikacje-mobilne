package com.example.myapplication

import java.io.Serializable

class Trail(private val name:String, private val info:String): Serializable {

    fun getName(): String {
        return name
    }

    fun getInfo(): String {
        return info
    }
}