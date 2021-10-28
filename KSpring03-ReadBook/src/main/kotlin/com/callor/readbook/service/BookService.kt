package com.callor.readbook.service

import com.callor.readbook.model.Book

interface BookService {

    fun selectAll():Array<Book>

    fun findByIsbn(isbn:String):Book
    fun findByTitle(title:String):Array<Book>

    fun insert(book:Book):Book
    fun delete(isbn:String)
    fun update(book:Book):Book
}