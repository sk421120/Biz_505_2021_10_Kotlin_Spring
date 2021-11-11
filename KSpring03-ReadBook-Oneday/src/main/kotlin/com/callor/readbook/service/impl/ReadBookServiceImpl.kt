package com.callor.readbook.service.impl

import com.callor.readbook.model.BookDTO
import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.repository.ReadRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Service

@Service("readbookService")
class ReadBookServiceImpl(val rbDao: ReadRepository, val bDao: BookRepository)
    : ReadBookService {
    override fun findByIsbn(isbn: String): Array<ReadBookDTO> {
        return rbDao.findByIsbn(isbn)
    }

    override fun selectAll(): Array<ReadBookDTO> {
        return rbDao.findAll().toTypedArray()
    }

    override fun findBySeq(seq: Long): ReadBookDTO {
        return rbDao.findById(seq).get()
    }

    override fun insert(readBook: ReadBookVO) {
        val readBookDTO = ReadBookDTO(
            0, readBook.isbn, readBook.title, readBook.sdate,
            readBook.edate, readBook.stime, readBook.etime,
            readBook.subject, readBook.content )
        val bookDTO = BookDTO(readBook.isbn, readBook.title)

        rbDao.save(readBookDTO)
        bDao.save(bookDTO)
    }

    override fun delete(seq: Long) {
        TODO("Not yet implemented")
    }

    override fun update(readBook: ReadBookDTO): ReadBookDTO {
        TODO("Not yet implemented")
    }
}