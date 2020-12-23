package math;

/**
 * @Description: 326. 3的幂
 * @Author: 吴智慧
 * @Date: 2020/12/23 21:02
 * https://leetcode-cn.com/problems/power-of-three/
 */
public class PowerOfThree {

    public static void main(String[] args) {

        PowerOfThree powerOfThree = new PowerOfThree();

        boolean result = powerOfThree.isPowerOfThree(45);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ log n ）
     * 空间复杂度：O（ 1 ）
     */
    public boolean isPowerOfThree(int n) {

        // 任意数字的0次方，都是1
        if (n == 1) {
            return true;
        }

        while (n >= 3) {
            // 前提是必须能被3整除
            if (n % 3 != 0) {
                break;
            }
            // 循环除3后，最终应该能等于3
            if (n == 3){
                return true;
            }
            // 循环除3
            n = n / 3;
        }

        return false;

    }

}
