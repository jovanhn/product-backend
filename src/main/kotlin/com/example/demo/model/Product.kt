package com.example.demo.model;


import jakarta.persistence.*;


@Entity
class Product (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bp_seq")
        @SequenceGenerator(name = "bp_seq", sequenceName = "sequence_bp", initialValue = 101)
        val id: Long?=null,

        val title: String,

        val description: String,

        val imageUrl: String,

        val category: String,

        val price: Double
){}
