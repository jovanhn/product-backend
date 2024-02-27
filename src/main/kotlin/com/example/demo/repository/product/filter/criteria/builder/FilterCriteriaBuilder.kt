package com.example.demo.repository.product.filter.criteria.builder

import org.springframework.data.jpa.domain.Specification

fun interface FilterCriteriaBuilder<S, T> {
    fun buildQuery(source: S): Specification<T>
}