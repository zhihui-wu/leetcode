package array;

/**
 * @Description: 66. 加一
 * @Author: 吴智慧
 * @Date: 2020/12/1 20:03
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();

        int[] digits = new int[]{4,3,2,1};

        int[] result = plusOne.plusOne(digits);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }else {
                digits[i] = 0;
                // 数字超出位数特殊处理，如：999
                if (i == 0) {
                    int[] temp = new int[digits.length + 1];
                    for (int j = 0; j < temp.length; j++) {
                        temp[j] = 0;
                    }
                    temp[0] = 1;
                    return temp;
                }
            }
        }
        return digits;
    }


}
