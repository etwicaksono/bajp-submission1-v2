package com.etwicaksono.infomovie2

import com.etwicaksono.infomovie2.utils.getRuntime
import org.junit.Assert.assertEquals
import org.junit.Test


class HelperUnitTest {
    @Test
    fun getRuntime() {
        assertEquals("2h 5m", getRuntime(125))
    }

    @Test
    fun getReleaseYear() {
        assertEquals("2021", com.etwicaksono.infomovie2.utils.getReleaseYear("2021-01-02", "-"))
    }

}