package it.orlov.iuliia

import it.orlov.iuliia.internal.TranslatorRegistry
import java.nio.file.Path

object Iuliia {

    private val translators = TranslatorRegistry.of(Path.of("schemas"))

    fun translate(sentence: String, transliteration: Transliteration): String {
        return translators[transliteration].translate(sentence)
    }
}

fun Transliteration.translate(sentence: String) = Iuliia.translate(sentence, this)