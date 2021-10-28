package com.callor.readbook.service

import com.callor.readbook.model.ReadBook

interface ReadBookService {

    fun selectAll():Array<ReadBook>

    fun findBySeq(seq:Long):ReadBook

    fun insert(readBook:ReadBook):ReadBook
    fun delete(seq:Long)
    fun update(readBook:ReadBook):ReadBook
}