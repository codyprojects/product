plugins {
    kotlin("jvm")
    id("org.openapi.generator") version "5.2.0"
}

openApiValidate {
    inputSpec.set("$rootDir/src/main/resources/product-api.yaml")
    recommend.set(true)
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/src/main/resources/product-api.yaml")
//	outputDir.set("$buildDir/generated/")
    apiPackage.set("com.fuwumai.product.api")
    modelPackage.set("com.fuwumai.product.model")
//	supportingFilesConstrainedTo.set(listOf("Exceptions.kt", "ApiUtil.kt"))
    configOptions.set(mapOf(
        Pair("serializableModel", "ture"),
        Pair("basePackage", "com.fuwumai.product"),
        Pair("delegatePattern", "true")
    ))
    globalProperties.set(mapOf(
        Pair("apis", ""), //no value or comma-separated api names
        Pair("models", ""), //no value or comma-separated api names
        Pair("supportingFiles", "ApiUtil.kt,Exceptions.kt"), //no value or comma-separated api names
    ))
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "11"
//    }
////	dependsOn("openApiGenerate")
//}

// Builds a Kotlin client by default.
//openApiGenerate {
//	generatorName = "kotlin"
//	inputSpec = "$rootDir/petstore-v3.0.yaml".toString()
//	outputDir = "$buildDir/kotlin".toString()
//	apiPackage = "org.openapitools.example.api"
//	invokerPackage = "org.openapitools.example.invoker"
//	modelPackage = "org.openapitools.example.model"
//	configOptions = [
//		dateLibrary: "java8"
//	]
//	globalProperties = [
//		modelDocs: "false"
//	]
//	skipValidateSpec = true
//	logToStderr = true
//	generateAliasAsModel = false
//	// set to true and set environment variable {LANG}_POST_PROCESS_FILE
//	// (e.g. SCALA_POST_PROCESS_FILE) to the linter/formatter to be processed.
//	// This command will be passed one file at a time for most supported post processors.
//	enablePostProcessFile = false
//}