package com.fuwumai.product

import com.fuwumai.product.service.ProductService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}

@RestController
class SampleController(private val productService: ProductService) {

	@GetMapping("/hello")
	fun index(): List<String> = productService.getProduct()
}