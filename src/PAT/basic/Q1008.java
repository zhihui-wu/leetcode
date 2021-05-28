package PAT.basic;

import java.util.Scanner;

/**
 * @Description: 1008 数组元素循环右移问题
 * @Author: 吴智慧
 * @Date: 2021/5/28 09:59
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805316250615808
 */
public class Q1008 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        // 注意：偏移量可能大于数组长度
        int offset = in.nextInt() % length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = in.nextInt();
        }
        // 通过三次反转实现
        rever(0, length - 1 - offset, arr);
        rever(length - offset, length - 1, arr);
        rever(0, length - 1, arr);
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    private static void rever(int left, int right, int[] arr) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
