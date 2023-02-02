package com.example.demo.handler

import com.example.demo.model.Blockchain
import com.example.demo.model.toJson
import com.example.demo.service.BlockchainService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class BlockchainHandlerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var blockchainService: BlockchainService

    @Test
    fun `getNameById_happyPathTest`() {
        every { blockchainService.getNameById(any()) } returns "TestBlockchain"

        mockMvc.perform(get("/api/blockchain/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json("{\"name\":\"TestBlockchain\"}"))
    }

    @Test
    fun `getNameById_blockchainNotFound404Test`() {
        every { blockchainService.getNameById(any()) } returns null

        mockMvc.perform(get("/api/blockchain/99"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `createBlockchain_happyPathTest`() {
        every { blockchainService.addNewBlockchain(any()) } returns 2

        mockMvc.perform(post("/api/blockchain/add")
            .content(Blockchain(name = "Fantom").toJson())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json("{\"id\":2}"))
    }

    @Test
    fun `createBlockchain_InvalidRequestTest`() {
        mockMvc.perform(post("/api/blockchain/add")
            .content("")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest)
    }
}
