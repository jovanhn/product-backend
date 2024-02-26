package com.example.demo.model;

import com.fasterxml.jackson.databind.BeanDescription
import jakarta.persistence.*;

@Entity
public class Product (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bp_seq")
        @SequenceGenerator(name = "bp_seq", sequenceName = "sequence_bp")
        val id: Long?=null,

        val title: String,

        val description: String,

        val imageUrl: String,

        val price: Double
){}
