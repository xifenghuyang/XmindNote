package com.yq.leetcode;

import org.junit.Test;

import java.util.List;


public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() {
        GenerateParentheses lc22 = new GenerateParentheses();
        List<String> result = lc22.generateParenthesis(3);
        result.stream().forEach(x->System.out.println(x));
    }
}