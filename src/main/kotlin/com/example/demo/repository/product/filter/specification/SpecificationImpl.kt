package com.example.demo.repository.product.filter.specification

import com.example.demo.repository.product.filter.criteria.SearchCriteria
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

class SpecificationImpl<T>(private val criteria: SearchCriteria) : Specification<T> {
    override fun toPredicate(root: Root<T>, query: CriteriaQuery<*>, builder: CriteriaBuilder): Predicate? {
        return when (criteria.operation) {
            ">" -> builder.greaterThanOrEqualTo(root[criteria.key], criteria.value.toString())
            "<" -> builder.lessThanOrEqualTo(root[criteria.key], criteria.value.toString())
            ":" -> if (root.get<Any>(criteria.key).javaType == String::class.java) {
                builder.like(builder.lower(root[criteria.key]), "%" + criteria.value.toString().lowercase() + "%")
            } else if (criteria.value == null) {
                builder.isNull(root.get<Any>(criteria.key))
            } else {
                builder.equal(root.get<Any>(criteria.key), criteria.value)
            }

            else -> null
        }
    }
}