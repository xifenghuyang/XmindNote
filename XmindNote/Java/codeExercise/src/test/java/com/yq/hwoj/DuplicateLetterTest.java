package com.yq.hwoj;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateLetterTest {

    @Test
    public void removeDuplicateLetter() {

        String[] inputList = {"bcabc","cdgttdgc", "cdgtaaotdgc",
                "bcbab","bbcaacb"};
        String[] resultList = {"abc","cdgt","aotdgc","bca","acb"};
        DuplicateLetter duplicateLetter = new DuplicateLetter();
        for (int i=2; i<inputList.length; i++) {
            String output = duplicateLetter.removeDuplicateLetters(inputList[i]);
            assertEquals(output,resultList[i]);
        }
    }
}