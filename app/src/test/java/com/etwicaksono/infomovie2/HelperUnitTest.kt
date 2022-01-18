package com.etwicaksono.infomovie2

import com.etwicaksono.infomovie2.utils.Helper
import org.junit.Assert.assertEquals
import org.junit.Test


class HelperUnitTest {
    @Test
    fun getRuntime() {
        assertEquals("2h 5m", Helper.getRuntime(125))
    }

    @Test
    fun getReleaseYear() {
        assertEquals("2021", Helper.getReleaseYear("2021-01-02", "-"))
    }

}