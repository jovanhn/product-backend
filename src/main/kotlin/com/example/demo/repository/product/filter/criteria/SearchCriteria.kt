package com.example.demo.repository.product.filter.criteria

data class SearchCriteria(
    val key: String,
    val operation: String,
    val value: Any?
)