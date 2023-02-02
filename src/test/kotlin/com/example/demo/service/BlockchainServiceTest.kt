package com.example.demo.service

import com.example.demo.repo.BlockchainRepo
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class BlockchainServiceTest() {

    private val blockchainRepo: BlockchainRepo = mockk();
    private val blockchainService = BlockchainService(blockchainRepo)

    @Test
    fun `getNameById_happyPathTest`() {
        every { blockchainRepo.getById(1) } returns "TestBlockchain"
        assertEquals("TestBlockchain", blockchainService.getNameById(1))
    }

    @Test
    fun `getNameById_DoesntExistTest`() {
        every { blockchainRepo.getById(2) } returns null
        assertNull(blockchainService.getNameById(2))
    }
}