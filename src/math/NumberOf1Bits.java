package math;

/**
 * @Description: 191. 位1的个数
 * @Author: 吴智慧
 * @Date: 2020/12/24 20:47
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public static void main(String[] args) {

        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();

        int result = numberOf1Bits.hammingWeight(3);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ 1 ）
     * 空间复杂度：O（ 1 ）
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            // 1111 & 0010 = 0010
            // 1101 & 0010 = 0000
            // 所以可以判断指定位是否为1
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }


}
