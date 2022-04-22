package cn.warehouse.common.vo;


import com.alibaba.fastjson.JSON;

import java.util.*;
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

        String text = "烟火尘埃落定\n" +
                "明明之明夜、明明之夜夜、星夜无恒恒、秋水共长天、青青子衿天、明明如夜夜\n" +
                "明明如夜、明如夜天、明来天明、明明夜夜、星夜无恒、如松之盛、天下有道、青青子襟、右耀去明、秋水长天、无为徐生、清风之明、昨夜星辰\n" +
                "徐先生、明来其、名字清、一世界、雨中曲、天行健、明明了、明明夜\n" +
                "博尔、古林、明天、深岸、甲方、龙光、知一、五湖、星名、源线、小明、长天、风云、老徐、迈克、改之、择之、星夜、一柏、小徐、风格、明业、明飞、问橐、明夜、明一、米明、明云、明也、玄明、斗米、明达\n" +
                "徐、吾、风、明";
        statisticsNum(text);
        // {"明":33,"夜":15,"天":9,"之":6,"徐":5,"星":5,"一":4,"如":4,"风":4,"青":4,"恒":3,"无":3,"长":3,"清":2,"名":2,"小":2,"云":2,"生":2,"水":2,"秋":2,"子":2,"来":2,"米":2,"耀":1,"老":1,"玄":1,"了":1,"有":1,"下":1,"源":1,"尔":1,"五":1,"世":1,"林":1,"斗":1,"尘":1,"龙":1,"定":1,"业":1,"昨":1,"中":1,"辰":1,"甲":1,"岸":1,"方":1,"改":1,"为":1,"去":1,"格":1,"落":1,"达":1,"吾":1,"线":1,"埃":1,"先":1,"迈":1,"光":1,"克":1,"界":1,"行":1,"柏":1,"橐":1,"道":1,"湖":1,"字":1,"博":1,"盛":1,"飞":1,"烟":1,"襟":1,"也":1,"古":1,"健":1,"知":1,"雨":1,"择":1,"火":1,"问":1,"共":1,"深":1,"曲":1,"右":1,"其":1,"松":1,"衿":1}
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

	// 统计文字频率
    private static void statisticsNum(String text) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            String val = text.substring(i, i + 1);
            if ("、".equals(val) || "\n".equals(val)) {
                continue;
            }
            map.put(val, map.get(val) == null ? 1 : map.get(val) + 1);
        }
        System.out.println(JSON.toJSONString(sortMap(map)));
    }

    public static Map<String, Integer> sortMap(Map<String, Integer> map) {
        //利用Map的entrySet方法，转化为list进行排序
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        //利用Collections的sort方法对list排序
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //正序排列，倒序反过来
                return o2.getValue() - o1.getValue();
            }
        });
        //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> e : entryList) {
            linkedHashMap.put(e.getKey(), e.getValue());
        }
        return linkedHashMap;
    }

}

