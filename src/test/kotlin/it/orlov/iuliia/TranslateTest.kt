package it.orlov.iuliia

import it.orlov.iuliia.internal.schemaDefinitionOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TranslateTest {

    @Test
    fun translate() {
        Schema.values().forEach { schema ->
            schemaDefinitionOf(schema).samples.forEach { (sentence, translated) ->
                assertEquals(translated, schema.translate(sentence), "$schema")
            }
        }
    }
}