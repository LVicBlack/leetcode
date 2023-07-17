package com.vic.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class IkmTest7 {
    public static void main(String[] args) {
        Long l = new Long(1234);
        Long ll =l;
        if (l==ll)
            System.out.println ("Equal Objects") ;
        else
            System.out.println ("Not Equal Objects") ;
        l++;
        if (l==ll)
            System.out.println ("Equal Objects") ;
        else
            System.out.println ("Not Equal Objects") ;
    }
}
