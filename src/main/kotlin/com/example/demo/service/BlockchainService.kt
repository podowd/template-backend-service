package com.example.demo.service

import com.example.demo.model.Blockchain
import com.example.demo.repo.BlockchainRepo
import org.springframework.stereotype.Service

@Service
class BlockchainService(
	private val blockchainRepo: BlockchainRepo,
) {
	fun getNameById(id: Int): String? {
		return blockchainRepo.getById(id)
	}

	fun addNewBlockchain(blockchain: Blockchain): Int {
		return blockchainRepo.insert(blockchain)
	}
}

