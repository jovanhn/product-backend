package com.example.demo.config

import com.example.demo.dto.request.ProductRequestDTO
import com.example.demo.model.Product
import com.example.demo.repository.product.ProductJpaRepository
import com.example.demo.service.ProductService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.net.URL

@Component
class DataLoader(
        private val productJpaRepository: ProductJpaRepository,
        private val productService: ProductService,
        private val objectMapper: ObjectMapper,
) :CommandLineRunner {
    override fun run(vararg args: String?) {
        if (productJpaRepository.findAll().isEmpty()) {
            val productsUrl = "classpath:products.json"
            val products = objectMapper.readValue<List<ProductRequestDTO>>(URL(productsUrl))

            (products).map { productService.create(it) }
        }
    }

}