package com.example.demo.model

import com.google.gson.Gson

data class Blockchain(val id: Int = 0, val name: String)

fun Blockchain.toJson() =
    Gson().toJson(this)