package com.example.demo

import com.example.demo.handler.response.BlockchainResponse
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


@SpringBootTest(
    classes = arrayOf(DemoApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationIntegrationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `contextLoads`() {
    }

    @Test
    fun `happyPath`() {
        val getNameByIdUrl = "/api/blockchain/1"
        val response = restTemplate.getForEntity("$getNameByIdUrl", String::class.java)
        assertEquals(response.statusCode, HttpStatus.OK)

        val blockchainResponse = Gson().fromJson(response.body, BlockchainResponse::class.java)

        assertNotNull(blockchainResponse)
        assertEquals("Ethereum", blockchainResponse.name)
    }
}
