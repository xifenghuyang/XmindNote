package com.yq.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        String[] parenthesis = {"(", ")"};

        List<String> pathList = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int leftCount = n;
        int rightCount = n;
        search(leftCount, rightCount, path, pathList,parenthesis);
        return pathList;
    }

    private void search(int leftCount, int rightCount, StringBuilder path, List<String> pathList,String[] parenthesis) {
        if (leftCount == rightCount) {
            if(leftCount==0){
                pathList.add(path.toString());
                return;
            }else {
                path.append(parenthesis[0]);
                search(leftCount-1,rightCount,path,pathList,parenthesis);
                path.deleteCharAt(path.length()-1);
            }

        }else if(leftCount > rightCount){
            return;
        }else {
            if(leftCount>0){
                path.append(parenthesis[0]);
                search(leftCount-1,rightCount,path,pathList,parenthesis);
                path.deleteCharAt(path.length()-1);
            }
            if(rightCount>0){
                path.append(parenthesis[1]);
                search(leftCount,rightCount-1,path,pathList,parenthesis);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

}
