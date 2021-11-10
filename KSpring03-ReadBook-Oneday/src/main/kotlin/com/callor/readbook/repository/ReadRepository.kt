package com.callor.readbook.repository

import com.callor.readbook.model.ReadBookDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ReadRepository: JpaRepository<ReadBookDTO,Long> {
}