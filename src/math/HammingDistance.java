package math;

/**
 * @Description: 461. 汉明距离
 * @Author: 吴智慧
 * @Date: 2020/12/24 21:09
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistance {

    public static void main(String[] args) {

        HammingDistance hammingDistance = new HammingDistance();

        int result = hammingDistance.hammingDistance(1, 2);

        System.out.println(result);
    }

    /**
     * 时间复杂度：O（ 1 ）
     * 空间复杂度：O（ 1 ）
     */
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            if((temp & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

}
