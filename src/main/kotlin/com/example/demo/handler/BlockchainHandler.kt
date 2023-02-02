package com.example.demo.handler

import com.example.demo.handler.response.BlockchainResponse
import com.example.demo.model.Blockchain
import com.example.demo.service.BlockchainService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/blockchain")
class BlockchainHandler(
	private val blockchainService: BlockchainService,
) {
	companion object {
		private val logger = KotlinLogging.logger {}
	}

	@GetMapping("/{id}")
	fun getNameById(@PathVariable id: Int, @RequestParam queryParams: Map<String,String>): BlockchainResponse {
		logger.info("Query params: $queryParams")
		logger.info("Getting blockchain name by id: $id")

		val blockchainName = blockchainService.getNameById(id) ?:
			throw ResponseStatusException(HttpStatus.NOT_FOUND, "No blockchain matching id found")
		return BlockchainResponse(blockchainName)
	}

	@PostMapping("/add", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
	fun createBlockchain(@RequestBody blockchain: Blockchain) =
		mapOf( "id" to blockchainService.addNewBlockchain(blockchain))
}
