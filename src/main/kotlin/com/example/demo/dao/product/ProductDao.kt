package com.example.demo.dao.product

import com.example.demo.exception.NotExistsException
import com.example.demo.model.Product
import com.example.demo.repository.product.ProductJpaRepository
import com.example.demo.repository.product.filter.criteria.builder.ProductFilterCriteriaBuilder
import com.example.demo.repository.product.filter.dto.ProductFilter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class ProductDao(
        private val productJpaRepository: ProductJpaRepository,
        private val productFilterCriteriaBuilder: ProductFilterCriteriaBuilder
        ){
    fun findAll(pageable: Pageable, productFilter: ProductFilter): Page<Product> {
        return productJpaRepository.findAll(productFilterCriteriaBuilder.buildQuery(productFilter), pageable)

    }

    fun findById(id: Long): Product {
        return id.let(productJpaRepository::findById)
                .orElseThrow{ NotExistsException("Product with id: $id does not exist") }
    }

    fun save(product: Product): Product {
        return productJpaRepository.save(product)
    }

    fun delete(id: Long) {
        id.let(productJpaRepository::findById)
                .orElseThrow { NotExistsException("Product with id: $id does not exist") }
                .let {
                    productJpaRepository.deleteById(it.id!!)
                }
    }

    fun update(product: Product) : Product {
        return product.let { productJpaRepository.findById(it.id!!)
                    .orElseThrow { NotExistsException("Product with id: ${it.id} does not exist!") }
        }.let(productJpaRepository::save)
    }

}