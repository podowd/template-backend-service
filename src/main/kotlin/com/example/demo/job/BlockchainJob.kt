package com.example.demo.job

import mu.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class BlockchainJob {

	companion object {
		private val logger = KotlinLogging.logger {}
	}

	@Scheduled(initialDelay = 2000, fixedDelay=Long.MAX_VALUE)
	fun execute() {
		logger.info("Executing job")
	}
}

