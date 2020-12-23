package math;

import java.util.Arrays;

/**
 * @Description: 204. 计数质数
 * @Author: 吴智慧
 * @Date: 2020/12/23 20:16
 * https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {

    public static void main(String[] args) {

        CountPrimes countPrimes = new CountPrimes();

        int result = countPrimes.countPrimes(1500000);

        System.out.println(result);

    }

    /**
     * 枚举会超时
     * 时间复杂度：O（ n * sqrt(n) ）
     * 空间复杂度：O（ 1 ）
     */
    public int countPrimes(int n) {

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }

        return count;
    }

    public boolean isPrimes(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃式筛
     * 时间复杂度：O（ n * log log n）
     * 空间复杂度：O（ n ）
     */
    public int countPrimes1(int n) {

        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes, 1);

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrimes[i] == 1) {
                count++;
                if ((long)i * i < n) {
                    // 2*i, 3*i ... 肯定已被标记为合数，所以从 i*i 开始标记
                    for (long j = i * i; j < n; j += i) {
                        isPrimes[(int)j] = 0;
                    }
                }
            }
        }

        return count;
    }






}
