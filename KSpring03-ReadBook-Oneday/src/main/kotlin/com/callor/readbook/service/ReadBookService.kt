package com.callor.readbook.service

import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO

interface ReadBookService {

    fun selectAll():Array<ReadBookDTO>

    fun findBySeq(seq:Long):ReadBookDTO

    fun insert(readBook: ReadBookVO)
    fun delete(seq:Long)
    fun update(readBook:ReadBookDTO):ReadBookDTO
}