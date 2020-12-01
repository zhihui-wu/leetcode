package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 350. 两个数组的交集 II
 * @Author: 吴智慧
 * @Date: 2020/12/1 19:35
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysIi {

    public static void main(String[] args) {

        IntersectionOfTwoArraysIi intersectionOfTwoArraysIi = new IntersectionOfTwoArraysIi();

        int[] nums1 = new int[]{1,2,2,1};

        int[] nums2 = new int[]{2,2};

        int[] result = intersectionOfTwoArraysIi.intersect(nums1, nums2);

        /**
         * 请尝试，哈希表法，
         */

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    /**
     * 时间复杂度：O（ m * log m + n * log n ）
     * 空间复杂度：O（ min(n, m) ）
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else if (nums1[i] < nums2[j]) {
                i++;
            }
        }
        int[] resultArray = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            resultArray[index] = result.get(index);
        }
        return resultArray;
    }
}
