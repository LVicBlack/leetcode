////请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。 
////
//// 函数 myAtoi(string s) 的算法如下： 
////
//// 
//// 读入字符串并丢弃无用的前导空格 
//// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 
//// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 
//// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步
//骤 
////2 开始）。 
//// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该
//被固
////定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。 
//// 返回整数作为最终结果。 
//// 
////
//// 注意： 
////
//// 
//// 本题中的空白字符只包括空格字符 ' ' 。 
//// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。 
//// 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "42"
////输出：42
////解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
////第 1 步："42"（当前没有读入字符，因为没有前导空格）
//// ^
////第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//// ^
////第 3 步："42"（读入 "42"）
//// ^
////解析得到整数 42 。
////由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。 
////
//// 示例 2： 
////
//// 
////输入：s = " -42"
////输出：-42
////解释：
////第 1 步：" -42"（读入前导空格，但忽视掉）
//// ^
////第 2 步：" -42"（读入 '-' 字符，所以结果应该是负数）
//// ^
////第 3 步：" -42"（读入 "42"）
//// ^
////解析得到整数 -42 。
////由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
//// 
////
//// 示例 3： 
////
//// 
////输入：s = "4193 with words"
////输出：4193
////解释：
////第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//// ^
////第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//// ^
////第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//// ^
////解析得到整数 4193 。
////由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
//// 
////
//// 示例 4： 
////
//// 
////输入：s = "words and 987"
////输出：0
////解释：
////第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
//// ^
////第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//// ^
////第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
//// ^
////解析得到整数 0 ，因为没有读入任何数字。
////由于 0 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 0 。 
////
//// 示例 5： 
////
//// 
////输入：s = "-91283472332"
////输出：-2147483648
////解释：
////第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
//// ^
////第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
//// ^
////第 3 步："-91283472332"（读入 "91283472332"）
//// ^
////解析得到整数 -91283472332 。
////由于 -91283472332 小于范围 [-2³¹, 2³¹ - 1] 的下界，最终结果被截断为 -2³¹ = -2147483648 。 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= s.length <= 200 
//// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
//// 
//// Related Topics 字符串 👍 1320 👎 0
//


package com.vic.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class No8_StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new No8_StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi("18446744073709551617"));
        System.out.println(solution.myAtoi("      -11919730356x"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("9223372036854775808"));
        System.out.println(solution.myAtoi("-5-"));
        System.out.println(solution.myAtoi("   +0 123"));
        System.out.println(solution.myAtoi("+-12"));
        System.out.println(solution.myAtoi("3.14159"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("-4193 with words"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 有限状态机（deterministic finite automaton, DFA）
        public int myAtoi(String s) {
            Automaton automaton = new Automaton();
            for (int i = 0; i < s.length(); i++) {
                automaton.work(s.charAt(i));
            }
            return (int) (automaton.result * automaton.sign);
        }
    }

    class Automaton {
        public long result = 0;
        public int sign = 1;
        private String state = "start";

        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void work(char c) {
            state = table.get(state)[process(c)];
            if ("signed".equals(state)) {
                sign = '-' == c ? -1 : 1;
            } else if ("in_number".equals(state)) {
                int digit = Character.digit(c, 10);
                result = 10 * result + digit;
                result = sign == 1 ? Math.min(result, (long) Integer.MAX_VALUE) : Math.min(result, -(long) Integer.MIN_VALUE);
            }
        }

        private int process(char c) {
            if (Character.isWhitespace(c)) {
                return 0;
            } else if ('+' == c || '-' == c) {
                return 1;
            } else if (Character.isDigit(c)) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    class Solution2 {
        // 优化
        public int myAtoi(String s) {
            long result = 0;
            int index = 0;
            int symbol = 1;
            int length = s.length();
            // 丢弃无用的前导空格
            while (index < length && Character.isWhitespace(s.charAt(index))) {
                index++;
            }
            // 符号
            if (index < length && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
                if ('-' == s.charAt(index++)) {
                    symbol = -1;
                } else {
                    symbol = 1;
                }
            }
            // 计数
            while (index < length && Character.isDigit(s.charAt(index))) {
                char c = s.charAt(index);
                int digit = Character.digit(c, 10);
                result = 10 * result + digit;
                if (symbol == 1 && result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (symbol == -1 && result - 1 >= Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
                index++;
            }
            return (int) (result * symbol);
        }

        // 第一版
        public int myAtoi1(String s) {
            long result = 0;
            int symbol = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c) && symbol != 0) break;
                if (symbol == 0) {
                    if ('-' == c) {
                        symbol = -1;
                    } else if ('+' == c) {
                        symbol = 1;
                    } else if (!Character.isDigit(c) && !Character.isWhitespace(c)) {
                        return 0;
                    }
                }
                if (Character.isDigit(c)) {
                    if (symbol == 0) symbol = 1;
                    long temp = result * 10 + Character.digit(c, 10);
                    if (result > temp) {
                        if (symbol > 0) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }
                    result = temp;
                } else if (result > 0) {
                    return (int) result * symbol;
                }
            }
            result = result * symbol;
            if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int) result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}