package com.example.demo.service;

import com.example.demo.dto.response.ProductResponseDTO
import com.example.demo.mapper.product.ProductResponseDTOMapper
import com.example.demo.repository.ProductJpaRepository
import org.springframework.stereotype.Service;

@Service
 class ProductService(
            val productJpaRepository: ProductJpaRepository,
            val productResponseDTOMapper: ProductResponseDTOMapper
         ){

     // TODO: Remove this after implementing repository
     fun createDummyProducts(): List<ProductResponseDTO> {
         val products: MutableList<ProductResponseDTO> = mutableListOf()
         for (i in 1..10) {
             val product:ProductResponseDTO = ProductResponseDTO(i.toLong(),"Product Name","Description of the product", "url",234.2)
            products.add(product)
         }
         return products
     }
   fun findAll() : List<ProductResponseDTO> {
       return productJpaRepository.findAll().map(productResponseDTOMapper::map);
   }
 };
