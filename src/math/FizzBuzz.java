package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 412. Fizz Buzz
 * @Author: 吴智慧
 * @Date: 2020/12/23 20:04
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class FizzBuzz {

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz();

        List<String> result = fizzBuzz.fizzBuzz(15);

        System.out.println(result);
    }

    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String temp = "";
            if (i % 3 == 0 && i % 5 == 0) {
                temp = "FizzBuzz";
            }else if (i % 3 == 0) {
                temp = "Fizz";
            }else if (i % 5 == 0) {
                temp = "Buzz";
            }else {
                temp = temp + i;
            }
            result.add(temp);
        }

        return result;
    }


}
