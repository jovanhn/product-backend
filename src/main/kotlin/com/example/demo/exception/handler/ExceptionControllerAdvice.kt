package com.example.demo.exception.handler


import com.example.demo.dto.response.ErrorResponseDTO
import com.example.demo.exception.NotExistsException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionControllerAdvice() : ResponseEntityExceptionHandler() {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(NotExistsException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotExistsException(notExistsException: NotExistsException): ErrorResponseDTO {
        return ErrorResponseDTO(notExistsException.message, HttpStatus.NOT_FOUND.value())
                .also(::logError)
    }

    private fun logError(errorResponseDTO: ErrorResponseDTO) {
        log.info(
                errorResponseDTO.message
        )
    }
}
