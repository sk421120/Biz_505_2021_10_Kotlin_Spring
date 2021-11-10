package com.callor.readbook.service

import com.callor.readbook.model.BookDTO

interface BookService {

    fun selectAll():Array<BookDTO>

    fun findByIsbn(isbn:String):BookDTO
    fun findByTitle(title:String):Array<BookDTO>

    fun insert(book:BookDTO):BookDTO
    fun delete(isbn:String)
    fun update(book:BookDTO):BookDTO
}