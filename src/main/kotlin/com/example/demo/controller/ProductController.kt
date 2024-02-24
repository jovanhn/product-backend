package com.example.demo.controller;

import com.example.demo.dto.response.ProductResponseDTO
import com.example.demo.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
class ProductController(val productService: ProductService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(

    ): List<ProductResponseDTO> {
        return productService.findAll()
    }
}
