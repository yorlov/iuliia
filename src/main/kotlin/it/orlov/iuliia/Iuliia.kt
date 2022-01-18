package it.orlov.iuliia

import it.orlov.iuliia.internal.TranslatorRegistry

private val translators = TranslatorRegistry()

fun Schema.translate(sentence: String): String {
    return translators[this].translate(sentence)
}