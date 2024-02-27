package com.example.demo.exception


class NotExistsException(override val message: String) : RuntimeException(message)