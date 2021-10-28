package com.callor.readbook.service.impl

import com.callor.readbook.model.Book
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.service.BookService
import org.springframework.stereotype.Service

@Service("bookService")
class BookServiceImpl(val bDao: BookRepository) : BookService {
    override fun selectAll(): Array<Book> {
        return bDao.findAll().toTypedArray()
    }

    override fun findByIsbn(isbn: String): Book {
        return bDao.findById(isbn).get()
    }

    override fun findByTitle(title: String): Array<Book> {
        return bDao.findByTitle(title)
    }

    override fun insert(book: Book): Book {

        return bDao.save(book)
    }

    override fun delete(isbn: String) {
        bDao.deleteById(isbn)
    }

    override fun update(book: Book): Book {
        return bDao.save(book)
    }
}