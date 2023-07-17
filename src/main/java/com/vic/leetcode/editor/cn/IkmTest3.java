package com.vic.leetcode.editor.cn;

import java.util.stream.Stream;

public class IkmTest3 {
    public static void main(String[] args) {
        // 字符串比较大小，判断每一位的字符大小
        System.out.println(Stream.of("green","yellow","blue")
                .max((s1,s2) -> s1.compareTo(s2))
                .filter(s ->s.endsWith("n"))
                        .orElse("yel"));
    }
}
