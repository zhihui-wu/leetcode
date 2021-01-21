package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 228. 汇总区间
 * @Author: 吴智慧
 * @Date: 2021/1/21 20:00
 * https://leetcode-cn.com/problems/summary-ranges/
 */
public class SummaryRanges {

    public static void main(String[] args) {

    }


    /**
     * 插入排序
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ n ）
     */
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if(nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (end+1 < nums[i]) {
                String temp = start + "";
                if (start != end) {
                    temp = temp + "->" + end;
                }
                result.add(temp);
                start = nums[i];
                end = nums[i];
            }else {
                end++;
            }
        }

        String temp = start + "";
        if (start != end) {
            temp = temp + "->" + end;
        }
        result.add(temp);

        return result;

    }


}
