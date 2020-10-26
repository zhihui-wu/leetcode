package search.binarySearch;

/**
 * @Description: 704. 二分查找
 * @Author: 吴智慧
 * @Date: 2020/10/24 14:50
 * https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

//        int[] s = new int[]{-1,0,3,5,9,12};
//        int target = 9;

        int[] s = new int[]{-1,0,3,5,9,12};
        int target = 2;


        int result = binarySearch.search(s, target);

        System.out.println(result);
    }


    public int search(int[] nums, int target) {
        return doSearch(nums, 0, nums.length - 1, target);
    }


    public int doSearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            int index = doSearch(nums, left, middle - 1, target);
            if (index != -1) {
                return index;
            }
        }else if (nums[middle] < target) {
            int index = doSearch(nums, middle + 1, right, target);
            if (index != -1) {
                return index;
            }
        }
        return -1;
    }
}
