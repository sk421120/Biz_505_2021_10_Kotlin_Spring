package com.callor.readbook.repository

import com.callor.readbook.model.ReadBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.awt.print.Book

interface ReadRepository: JpaRepository<ReadBook,Long> {

    @Query("SELECT max(seq) FROM ReadBook")
    fun maxSeq(): Long?
}