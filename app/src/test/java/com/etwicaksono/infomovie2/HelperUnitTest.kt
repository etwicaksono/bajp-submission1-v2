package com.etwicaksono.infomovie2

import com.etwicaksono.infomovie2.utils.getRuntime
import org.junit.Test

import org.junit.Assert.*


class HelperUnitTest {
    @Test
    fun getRuntime(){
        assertEquals("2h 5m",getRuntime(125))
    }

}