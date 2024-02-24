package com.example.demo.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

class ProductResponseDTO (
        var id:Long,
        var title: String,
        var description: String,
        var imageUrl: String,
        var price: Double
)