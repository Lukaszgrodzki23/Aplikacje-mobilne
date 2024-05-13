package com.example.myapplication

import java.io.Serializable

class Trail( private val name:String, private val info:String){
    companion object {
        val trails = arrayOf(
            Trail("Trail A", "Trail A is..."),
            Trail("Trail B", "Trail B is..."),
            Trail("Trail C", "Trail C is...")
        )
    }
    fun getName(): String {
        return name
    }

    fun getInfo(): String {
        return info
    }
}