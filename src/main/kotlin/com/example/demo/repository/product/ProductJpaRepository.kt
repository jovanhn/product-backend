package com.example.demo.repository.product

import com.example.demo.model.Product
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.awt.print.Book


@Repository
interface ProductJpaRepository : JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {



}