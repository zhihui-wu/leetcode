package PAT.basic;

import java.util.Scanner;

/**
 * @Description: 1001 害死人不偿命的(3n+1)猜想
 * @Author: 吴智慧
 * @Date: 2021/5/25 10:54
 * https://pintia.cn/problem-sets/994805260223102976/problems/994805325918486528
 */
public class Q1001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int result = doCount(a);
            System.out.println(result);
        }
    }

    private static int doCount(int a) {
        int count = 0;
        while(a != 1) {
            count++;
            if(a % 2 == 0) {
                a = a / 2;
            }else {
                a = (a * 3 + 1) / 2;
            }
        }
        return count;
    }
}
