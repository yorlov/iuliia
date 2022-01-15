package it.orlov.iuliia

import it.orlov.iuliia.internal.TranslatorRegistry
import it.orlov.iuliia.internal.schemaOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Stream
import kotlin.io.path.extension
import kotlin.io.path.nameWithoutExtension

class TranslatorRegistryTest {

    private val registry = TranslatorRegistry.of(Path.of("src/main/resources/schemas"))

    @ParameterizedTest
    @ArgumentsSource(TransliterationArgumentsProvider::class)
    fun translate(transliteration: Transliteration, sentence: String, translated: String) {
        val translator = registry[transliteration]
        assertEquals(translated, translator.translate(sentence), "$transliteration")
    }

    private class TransliterationArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Files.list(Path.of("src/main/resources/schemas"))
                .filter { file -> file.extension == "json" }
                .flatMap { file ->
                    val transliteration = Transliteration.valueOf(file.nameWithoutExtension.uppercase())
                    schemaOf(file).samples.stream()
                        .map { (sentence, translated) -> Arguments.of(transliteration, sentence, translated) }
                }
    }
}