package com.callor.readbook.service.impl

import com.callor.readbook.model.BookDTO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.service.BookService
import org.springframework.stereotype.Service

@Service("bookService")
class BookServiceImpl(val bDao: BookRepository) : BookService {
    override fun selectAll(): Array<BookDTO> {
        return bDao.findAll().toTypedArray()
    }

    override fun findByIsbn(isbn: String): BookDTO {
        return bDao.findById(isbn).get()
    }

    override fun findByTitle(title: String): Array<BookDTO> {
        return bDao.findByTitle(title)
    }

    override fun insert(book: BookDTO): BookDTO {

        return bDao.save(book)
    }

    override fun delete(isbn: String) {
        bDao.deleteById(isbn)
    }

    override fun update(book: BookDTO): BookDTO {
        return bDao.save(book)
    }
}