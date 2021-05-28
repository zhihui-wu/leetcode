package PAT.basic;

import java.util.Scanner;

/**
 * @Description: 1007 素数对猜想
 * @Author: 吴智慧
 * @Date: 2021/5/28 09:30
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805317546655744
 */
public class Q1007 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int nowNum = 2;
        // 素数除了“2”，不会是偶数
        // 不超过 n，即包括 n
        for(int i = 3; i <= n; i=i+2) {
            if (confirm(i)) {
                if (i - nowNum == 2) {
                    count++;
                }
                nowNum = i;
            }
        }
        System.out.println(count);
    }

    private static boolean confirm(int i) {
        int sqrt = (int)Math.sqrt((double) i);
        // 由于不会输入偶数，可以从 3 开始计算
        for (int j = 3; j <= sqrt; j++){
            if (i % j == 0){
                return false;
            }
        }
        return true;
    }
}
