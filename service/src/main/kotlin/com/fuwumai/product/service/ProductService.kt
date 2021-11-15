package com.fuwumai.product.service

import org.springframework.stereotype.Service

@Service
class ProductService {

    fun getProduct(): List<String> = listOf("hello","world")
}