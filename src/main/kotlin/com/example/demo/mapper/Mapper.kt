package com.example.demo.mapper

fun interface Mapper<S, T> {
    fun map(source: S): T
}