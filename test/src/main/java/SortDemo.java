import com.alibaba.fastjson.JSON;

import java.util.Random;
import java.util.TreeSet;

/**
 * @author xyq
 * @date 2020/4/8 14:51
 */
public class SortDemo {


    public static void main(String[] args) {
        Integer[] arr = generateRandomIntegerArray(50000);
        Integer[] arr2 = arr.clone();
        System.out.println(String.format("bubbleArr1 : %s", JSON.toJSONString(arr)));
        Long time1 = System.currentTimeMillis();
        Integer[] bubbleArr = bubbleSort(arr);
        Long time2 = System.currentTimeMillis();
        System.out.println(String.format("冒泡排序费时 : %s", time2 - time1));
        System.out.println(String.format("bubbleArr2 : %s", JSON.toJSONString(bubbleArr)));

        System.out.println(String.format("quickArr1 : %s", JSON.toJSONString(arr2)));
        Long time3 = System.currentTimeMillis();
        Integer[] quickArr = quickSort(arr2);
        Long time4 = System.currentTimeMillis();
        System.out.println(String.format("快速排序费时 : %s", time4 - time3));
        System.out.println(String.format("quickArr2 : %s", JSON.toJSONString(quickArr)));
    }

    /**
     * 快速排序
     * https://blog.csdn.net/morewindows/article/details/6684558
     * 该方法的基本思想是：
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     *
     * 对挖坑填数进行总结
     *
     * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
     * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     * @param arr
     * @return
     */
    public static Integer[] quickSort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(Integer[] arr, int l, int r) {
        if (l < r) {
            int i = l, j = r, value = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= value) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && arr[i] < value) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = value;
            quickSort(arr, l, i-1);
            quickSort(arr, j+1, r);
        }

    }

    /**
     * 冒泡排序
     * 比较相邻的两个值，小的放前面，
     *
     * @param arr
     * @return
     */
    public static Integer[] bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static Integer[] generateRandomIntegerArray(Integer size) {
        size = size == null || size <= 0 ? 10 : size;
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }


}
