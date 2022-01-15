package it.orlov.iuliia.internal

class TransliterationContext(
    private val mapping: Map<String, String>,
    private val prevMapping: Map<String, String>,
    private val nextMapping: Map<String, String>,
    private val endingMapping: Map<String, String>
) {

    fun translate(previous: Char?, current: Char, after: Char?): String {
        val curr = current.lowercase()
        val prev = previous?.lowercase() ?: ""
        val next = after?.lowercase() ?: ""

        val translated = prevMapping[prev + curr] ?: nextMapping[curr + next] ?: mapping[curr] ?: curr

        return if (current.isUpperCase()) translated.replaceFirstChar(Char::titlecase) else translated
    }

    fun translate(ending: String): String? {
        return endingMapping[ending]
    }

}