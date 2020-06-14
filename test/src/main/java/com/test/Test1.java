package com.test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author xyq
 * @date 2020/5/7 22:28
 */
public class Test111 {
    public static void main(String[] args) {
        // TODO 输出最长对称字符串：goog
        String input1 = "google";

        System.out.println(maxs(input1));
        // TODO 输出3个最长对称字符串：aba/aca/ada
        String input2 = "abcda";
        System.out.println(maxs(input2));
        // TODO 输出2个最长对称字符串：pop/upu，不会输出特殊字符的对称字符串p-p
        String input3 = "pop-upu";
        System.out.println(maxs(input3));
    }

    /**
     * 根据特殊字符进行字符串分割
     *
     * @param str 输入字符串
     * @return
     */
    private static String[] stringFilter(String str) {
        String regEx = "[^a-zA-Z0-9]";
        Pattern p = Pattern.compile(regEx);
        return p.split(str);
    }

    /**
     * 遍历生成的二维数组，递归查找最长路径
     *
     * @param a     第一个字符串
     * @param b     第二个字符串
     * @param mux   二维中间数组
     * @param i     二维数组raw位置
     * @param j     二维数组column位置
     * @param path  一次查找的字符串
     * @param paths 最终结果集合
     */
    private static void getAllLcs(String a, String b, int[][] mux, int i, int j, String path, Set<String> paths) {

        StringBuilder pathBuilder = new StringBuilder(path);
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                pathBuilder.append(a.charAt(i - 1));
                --i;
                --j;
            } else {
                if (mux[i - 1][j] > mux[i][j - 1]) {
                    --i;
                } else if (mux[i - 1][j] < mux[i][j - 1]) {
                    --j;
                } else {
                    getAllLcs(a, b, mux, i - 1, j, pathBuilder.toString(), paths);
                    getAllLcs(a, b, mux, i, j - 1, pathBuilder.toString(), paths);
                    return;
                }
            }
        }
        paths.add(pathBuilder.toString());
    }

    /**
     * 字符串s，我们可以删除字符串s中的任意字符，让剩下的字符串形成一个对称字符串，且该字符串为最长对称字符串。
     * 原字符串反转，成为查找最大公共子序列问题
     *
     * @param input 待查找字符串
     * @return 查找结果
     */
    private static String findLCS(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        // 将字符串反转
        String reverse = new StringBuilder(input).reverse().toString();

        // 字符串长度
        int len = input.length();

        // 矩阵 -> 二维数组，第一行与第一列皆为零，两个原因，一是方便算法越界处理，二是在
        // 通过矩阵查找子串时，作为终止时间判断使用。
        int[][] tmp = new int[len + 1][len + 1];

        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                if (input.charAt(i - 1) == reverse.charAt(j - 1)) {
                    //取值为左上角值+1
                    tmp[i][j] = tmp[i - 1][j - 1] + 1;
                } else {
                    //取值为左/上最大值，通过矩阵值反向查找路径时，同一子串会有多个。
                    tmp[i][j] = Math.max(tmp[i - 1][j], tmp[i][j - 1]);
                }
            }
        }

        // 查找路径时，存在多个路径是一个字符串的情况，set去重。
        Set<String> paths = new HashSet<>();
        Test111.getAllLcs(input, reverse, tmp, input.length(), reverse.length(), "", paths);

        return String.join("/", paths);
    }

    /**
     * 包括对特殊字符，结果格式生成
     *
     * @param input 待处理字符串
     * @return
     */
    public static String maxs(String input) {
        String[] prepare = stringFilter(input);
        StringBuffer sb = new StringBuffer();
        for (String str : prepare) {
            String result = findLCS(str);
            sb.append(result);
            sb.append("/");
        }
        return sb.substring(0, sb.length() - 1);
    }

}

