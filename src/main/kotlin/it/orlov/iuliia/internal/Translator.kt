package it.orlov.iuliia.internal

import java.util.regex.Pattern

class Translator(private val context: TransliterationContext) {

    fun translate(sentence: String) = WORD_SEPARATOR.split(sentence)
        .flatMap { word ->
            val (stem, ending) = analyzeWord(word)
            val mappedEnding = ending?.let(context::translate)
            if (mappedEnding == null) translateLetters(word) else translateLetters(stem) + mappedEnding
        }
        .joinToString("")

    private fun translateLetters(input: String) = input.indices.map { i ->
        when {
            input.length == 1 -> context.translate(null, input[i], null)
            i == 0 -> context.translate(null, input[i], input[i + 1])
            i == input.length - 1 -> context.translate(input[i - 1], input[i], null)
            else -> context.translate(input[i - 1], input[i], input[i + 1])
        }
    }

    private fun analyzeWord(word: String): Pair<String, String?> {
        if (word.length <= WORD_ENDING_LENGTH) return word to null
        val separateIndex = word.length - WORD_ENDING_LENGTH
        return word.substring(0, separateIndex) to word.substring(separateIndex)
    }

    companion object {
        private val WORD_SEPARATOR = Pattern.compile("\\b")
        private const val WORD_ENDING_LENGTH = 2
    }
}