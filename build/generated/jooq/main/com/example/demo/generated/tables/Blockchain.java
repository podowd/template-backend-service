/*
 * This file is generated by jOOQ.
 */
package com.example.demo.generated.tables;


import com.example.demo.generated.Indexes;
import com.example.demo.generated.Keys;
import com.example.demo.generated.Public;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Blockchain extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.blockchain</code>
     */
    public static final Blockchain BLOCKCHAIN = new Blockchain();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>public.blockchain.id</code>.
     */
    public final TableField<Record, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.blockchain.name</code>.
     */
    public final TableField<Record, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    private Blockchain(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Blockchain(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.blockchain</code> table reference
     */
    public Blockchain(String alias) {
        this(DSL.name(alias), BLOCKCHAIN);
    }

    /**
     * Create an aliased <code>public.blockchain</code> table reference
     */
    public Blockchain(Name alias) {
        this(alias, BLOCKCHAIN);
    }

    /**
     * Create a <code>public.blockchain</code> table reference
     */
    public Blockchain() {
        this(DSL.name("blockchain"), null);
    }

    public <O extends Record> Blockchain(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, BLOCKCHAIN);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.BLOCKCHAIN_NAME_IDX);
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return (Identity<Record, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.BLOCKCHAIN_PKEY;
    }

    @Override
    public Blockchain as(String alias) {
        return new Blockchain(DSL.name(alias), this);
    }

    @Override
    public Blockchain as(Name alias) {
        return new Blockchain(alias, this);
    }

    @Override
    public Blockchain as(Table<?> alias) {
        return new Blockchain(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Blockchain rename(String name) {
        return new Blockchain(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Blockchain rename(Name name) {
        return new Blockchain(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Blockchain rename(Table<?> name) {
        return new Blockchain(name.getQualifiedName(), null);
    }
}