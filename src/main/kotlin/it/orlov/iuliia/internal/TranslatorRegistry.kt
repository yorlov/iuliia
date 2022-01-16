package it.orlov.iuliia.internal

import it.orlov.iuliia.Schema
import java.util.concurrent.ConcurrentHashMap

class TranslatorRegistry {

    private val cache = ConcurrentHashMap<Schema, Translator>()

    operator fun get(schema: Schema) = cache.computeIfAbsent(schema) {
        val schemaDefinition = schemaDefinitionOf(schema)
        Translator(SchemaContext(
            schemaDefinition.mapping,
            schemaDefinition.prev_mapping ?: emptyMap(),
            schemaDefinition.next_mapping ?: emptyMap(),
            schemaDefinition.ending_mapping ?: emptyMap()
        ))
    }
}