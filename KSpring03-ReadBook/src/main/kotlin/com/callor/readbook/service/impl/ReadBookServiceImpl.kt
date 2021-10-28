package com.callor.readbook.service.impl

import com.callor.readbook.model.ReadBook
import com.callor.readbook.repository.ReadRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Service

@Service("readbookService")
class ReadBookServiceImpl(val rbDao:ReadRepository) : ReadBookService {
    override fun selectAll(): Array<ReadBook> {
        return rbDao.findAll().toTypedArray()
    }

    override fun findBySeq(seq: Long): ReadBook {
        return rbDao.findById(seq).get()
    }

    override fun insert(readBook: ReadBook): ReadBook {
        var seq:Long? = 1
        if( selectAll().size > 1) {
            seq = rbDao.maxSeq()

            if (seq != null) seq += 1
        }

        readBook.seq = seq

        return rbDao.save(readBook)
    }

    override fun delete(seq: Long) {
        TODO("Not yet implemented")
    }

    override fun update(readBook: ReadBook): ReadBook {
        TODO("Not yet implemented")
    }
}