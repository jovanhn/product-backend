package com.example.demo.service;

import com.example.demo.dao.product.ProductDao
import com.example.demo.dto.request.ProductRequestDTO
import com.example.demo.dto.response.ProductResponseDTO
import com.example.demo.mapper.product.ProductMapper
import com.example.demo.mapper.product.ProductResponseDTOMapper
import com.example.demo.repository.product.filter.dto.ProductFilter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional
import java.util.Locale.Category

@Service
 class ProductService(
        private val productDao: ProductDao,
        private val productResponseDTOMapper: ProductResponseDTOMapper,
        private val productMapper: ProductMapper,
         ) {

   fun findAll(pageable: Pageable, productFilter: ProductFilter) : Page<ProductResponseDTO> {
       return productDao
               .findAll(pageable, productFilter)
               .map(productResponseDTOMapper::map)
   }

    fun findById(id: Long): ProductResponseDTO {
        return productDao
                .findById(id)
                .let(productResponseDTOMapper::map)

    }

    @Transactional
    fun create(product: ProductRequestDTO) : ProductResponseDTO {
        return product
                .let(productMapper::map)
                .let(productDao::save)
                .let(productResponseDTOMapper::map)
    }

    @Transactional
    fun delete(id: Long) {
        id.let(productDao::delete)
    }

    @Transactional
    fun update(id: Long, updatedProduct: ProductRequestDTO) : ProductResponseDTO {
        return updatedProduct
                .apply { this.id = id }
                .let(productMapper::map)
                .let(productDao::update)
                .let(productResponseDTOMapper::map)
    }

 }
