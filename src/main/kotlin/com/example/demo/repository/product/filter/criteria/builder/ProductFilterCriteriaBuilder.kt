package com.example.demo.repository.product.filter.criteria.builder

import com.example.demo.model.Product
import com.example.demo.repository.product.filter.criteria.SearchCriteria
import com.example.demo.repository.product.filter.dto.ProductFilter
import com.example.demo.repository.product.filter.specification.SpecificationImpl
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component

@Component
class ProductFilterCriteriaBuilder : FilterCriteriaBuilder<ProductFilter, Product> {

    override fun buildQuery(source: ProductFilter): Specification<Product> {
        val specificationList = mutableListOf<Specification<Product>>()

        source.category?.run {
            specificationList.add(SpecificationImpl(SearchCriteria("category", ":", this)))
        }

        source.title?.run {
            specificationList.add(SpecificationImpl(SearchCriteria("title", ":", this)))
        }

        return Specification.allOf(specificationList)
    }
}