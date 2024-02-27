package com.example.demo.controller;

import com.example.demo.dto.request.ProductRequestDTO
import com.example.demo.dto.response.ProductResponseDTO
import com.example.demo.repository.product.filter.dto.ProductFilter
import com.example.demo.service.ProductService
import org.jetbrains.annotations.NotNull
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
class ProductController(val productService: ProductService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(
        pageable: Pageable,
        productFilter: ProductFilter
    ): Page<ProductResponseDTO> {
        return productService
                .findAll(pageable, productFilter)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable @NotNull id: Long): ProductResponseDTO {
        return id.let(productService::findById)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody productRequestDTO: ProductRequestDTO) : ProductResponseDTO {
        return productRequestDTO
                .let(productService::create)
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        id.let(productService::delete)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody productRequestDTO: ProductRequestDTO) : ProductResponseDTO {
        return productService
                .update(id, productRequestDTO)
    }

    // TODO - temp solution, it should be exported to separate controller, service, dao, and repository
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCategories() : List<String>{
        return listOf("smartphones","laptops","fragrances","skincare",
                "groceries","home-decoration","furniture","tops",
                "womens-dresses","womens-shoes","mens-shirts",
                "mens-shoes","mens-watches","womens-watches","womens-bags",
                "womens-jewellery","sunglasses","automotive","motorcycle","lighting")
    }
}
