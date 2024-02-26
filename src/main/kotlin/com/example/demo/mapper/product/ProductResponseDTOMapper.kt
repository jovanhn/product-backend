package com.example.demo.mapper.product

import com.example.demo.dto.response.ProductResponseDTO
import com.example.demo.mapper.Mapper
import com.example.demo.model.Product
import org.springframework.stereotype.Component

@Component
class ProductResponseDTOMapper() : Mapper<Product, ProductResponseDTO> {
    override fun map(source: Product): ProductResponseDTO {
        return with(source) {
            ProductResponseDTO(
                    id!!,
                    title,
                    description,
                    imageUrl,
                    price
            )
        }
    }
}