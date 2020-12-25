package math;

/**
 * @Description: 190. 颠倒二进制位
 * @Author: 吴智慧
 * @Date: 2020/12/25 19:27
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static void main(String[] args) {

        ReverseBits reverseBits = new ReverseBits();

        int result = reverseBits.reverseBits(7);

        System.out.println(result);

    }


    /**
     * 时间复杂度：O（ 1 ）
     * 空间复杂度：O（ 1 ）
     */
    public int reverseBits(int n) {

        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & mask) != 0) {
                result = result + 1;
            }
            mask <<= 1;
        }
        return result;

    }


}
