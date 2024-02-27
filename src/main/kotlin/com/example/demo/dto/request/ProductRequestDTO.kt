package com.example.demo.dto.request

import com.fasterxml.jackson.annotation.JsonIgnore

class ProductRequestDTO (
        @JsonIgnore var id: Long? = null,
        var title: String,
        var description: String,
        var imageUrl: String,
        var category: String,
        var price: Double
)