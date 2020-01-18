package com.yq.hwoj;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void hiUnit() {
        assertEquals("Hello junit!",new MyUnit().hiUnit());
    }
}