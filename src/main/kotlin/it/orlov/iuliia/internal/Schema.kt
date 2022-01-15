package it.orlov.iuliia.internal

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Path

@Serializable
class Schema(
    val mapping: Map<String, String>,
    val prev_mapping: Map<String, String>?,
    val next_mapping: Map<String, String>?,
    val ending_mapping: Map<String, String>?,
    val samples: List<List<String>>
)

fun schemaOf(path: Path) = decoder.decodeFromString<Schema>(Files.readString(path))

val decoder = Json {
    ignoreUnknownKeys = true
}