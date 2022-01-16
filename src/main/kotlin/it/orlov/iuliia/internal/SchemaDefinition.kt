package it.orlov.iuliia.internal

import it.orlov.iuliia.Schema
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

@Serializable
class SchemaDefinition(
    val mapping: Map<String, String>,
    val prev_mapping: Map<String, String>?,
    val next_mapping: Map<String, String>?,
    val ending_mapping: Map<String, String>?,
    val samples: List<List<String>>
)

private val decoder = Json {
    ignoreUnknownKeys = true
}

fun schemaDefinitionOf(schema: Schema): SchemaDefinition {
    val resource = "schemas/${schema.name.lowercase()}.json"
    val stream = schema.javaClass.classLoader.getResourceAsStream(resource) ?: throw RuntimeException("Resource '$resource' not found")
    return stream.use(decoder::decodeFromStream)
}