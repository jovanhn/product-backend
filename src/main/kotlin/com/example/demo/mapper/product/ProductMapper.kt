package com.example.demo.mapper.product

import com.example.demo.dto.request.ProductRequestDTO
import com.example.demo.mapper.Mapper
import com.example.demo.model.Product
import org.springframework.stereotype.Component

@Component
class ProductMapper() : Mapper<ProductRequestDTO, Product>{
    override fun map(source: ProductRequestDTO): Product {
        return with(source) {
            Product(
                    id,
                    title,
                    description,
                    imageUrl,
                    category,
                    price
            )
        }
    }


}