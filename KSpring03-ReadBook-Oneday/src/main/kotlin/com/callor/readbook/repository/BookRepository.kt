package com.callor.readbook.repository

import com.callor.readbook.model.BookDTO
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<BookDTO,String> {

    fun findByTitle(title: String): Array<BookDTO>

}