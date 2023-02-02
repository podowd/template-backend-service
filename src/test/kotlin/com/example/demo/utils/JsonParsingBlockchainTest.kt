package com.example.demo.utils

import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class JsonParsingBlockchainTest {

    data class TestModel(
        val id: Int,
        val description: String
    )

    companion object {
        private val gson = Gson()
    }

    @Test
    fun `toJsonTest`() {
        val jsonString = gson.toJson(TestModel(1,"Test"))
        Assertions.assertEquals(jsonString, """{"id":1,"description":"Test"}""")
    }

    @Test
    fun `fromJsonTest`() {
        var jsonString = """{"id":1,"description":"Test"}""";
        var testModel = gson.fromJson(jsonString, TestModel::class.java)
        Assertions.assertEquals(testModel.id, 1)
        Assertions.assertEquals(testModel.description, "Test")
    }
}