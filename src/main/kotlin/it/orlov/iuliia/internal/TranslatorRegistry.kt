package it.orlov.iuliia.internal

import it.orlov.iuliia.Transliteration
import java.nio.file.Path
import java.util.concurrent.ConcurrentHashMap

class TranslatorRegistry(private val contextOf: (Transliteration) -> TransliterationContext) {

    private val cache = ConcurrentHashMap<Transliteration, Translator>()

    operator fun get(transliteration: Transliteration) = cache.computeIfAbsent(transliteration) {
        Translator(contextOf(transliteration))
    }

    companion object {
        fun of(path: Path) = TranslatorRegistry { transliteration ->
            val schema = schemaOf(path.resolve("${transliteration.name.lowercase()}.json"))
            TransliterationContext(
                schema.mapping,
                schema.prev_mapping ?: emptyMap(),
                schema.next_mapping ?: emptyMap(),
                schema.ending_mapping ?: emptyMap()
            )
        }
    }
}