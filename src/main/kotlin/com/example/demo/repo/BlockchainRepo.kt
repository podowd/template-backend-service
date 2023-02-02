package com.example.demo.repo

import com.example.demo.generated.tables.Blockchain.BLOCKCHAIN
import com.example.demo.model.Blockchain
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class BlockchainRepo(dslContext: DSLContext) {

    val jooq: DSLContext = dslContext

    fun getById(id: Int): String? =
        jooq.select(BLOCKCHAIN.NAME)
            .from(BLOCKCHAIN)
            .where(BLOCKCHAIN.ID.eq(id))
            .fetchOne(BLOCKCHAIN.NAME)

    fun insert(blockchain: Blockchain): Int =
        jooq.insertInto(BLOCKCHAIN)
            .set(BLOCKCHAIN.NAME, blockchain.name)
            .returningResult(BLOCKCHAIN.ID)
            .fetchOne()!!
            .getValue(BLOCKCHAIN.ID)

    fun getAll(pageSize: Int, page: Int): List<Blockchain> =
        jooq.selectFrom(BLOCKCHAIN)
            .limit(pageSize)
            .offset(pageSize * page)
            .fetchInto(Blockchain::class.java)
}
