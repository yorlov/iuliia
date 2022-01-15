package it.orlov.iuliia

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IuliiaTest {

    @Test
    fun translate() {
        assertEquals("Yury", Iuliia.translate("Юрий"))
    }
}