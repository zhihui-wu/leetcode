/**
 * @Description: 颜色分类
 * @Author: 吴智慧
 * @Date: 2020/9/8 20:58
 * https://leetcode-cn.com/problems/sort-colors
 * 排序
 */
public class SortColors {
    public static void main(String[] args) {
        // 输入
        int[] nums = new int[]{2,0,2,1,1,0};
        // int[] nums = new int[]{0,1,2};
        SortColors sortUtil = new SortColors();

        // -------------------- O(N ^ 2) -------------------
        // 冒泡排序

        // 选择排序

        // 插入排序
        // sortUtil.DictInsertSort(nums);

        // 希尔排序

        // ------------------- O(N log N) -------------------
        // 归并排序
        // sortUtil.mergeSort(nums, 0, nums.length - 1);

        // 快速排序
        // sortUtil.quickSort(nums, 0, nums.length - 1);

        // 堆排序
        // sortUtil.heapSort(nums);

        // -------------------- O(N) ------------------------
        // 时间复杂度低，但是适用场景比较特殊
        // 桶排序

        // 计数排序

        // 基数排序

        // ------------------- 打印数组 -----------------------
        sortUtil.printArray(nums);
    }

    /**
     * 堆排序
     * @param nums 数组
     */
    public void heapSort(int[] nums) {
        // 元素少于两个没必要排序
        if (nums.length < 2) {
            return;
        }

        // 构建堆
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            heapify(nums, nums.length - 1, i);
        }

        // 堆排序
        for (int i = 1; i < nums.length; i++) {
            swap(nums, 0, nums.length - i);
            heapify(nums, nums.length - i - 1, 0);
        }
    }

    /**
     * 堆排序-堆化函数
     * @param nums 数组
     * @param n 最大下标
     * @param i 堆顶下标
     */
    private void heapify(int[] nums, int n, int i) {
        while(true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && nums[maxPos] < nums[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && nums[maxPos] < nums[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(nums, maxPos, i);
            i = maxPos;
        }
    }


    /**
     * 插入排序
     * @param nums 数组
     */
    public void DictInsertSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            for(; j > 0; j--) {
                if(temp < nums[j - 1]) {
                    nums[j] = nums[j-1];
                }else {
                    break;
                }
            }
            nums[j] = temp;
        }
    }

    /**
     * 归并排序
     * @param nums 数组
     * @param p 第一个元素下标
     * @param r 最后一个元素下标
     */
    public void mergeSort(int[] nums, int p, int r){
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(nums, p, q);
        mergeSort(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    /**
     * 归并算法-归并函数
     * @param nums 数组
     * @param p 第一元素下标
     * @param q 中间一个元素下标
     * @param r 最后一个元素下标
     */
    private void merge(int[] nums, int p, int q, int r){
        int i = p, j = q+1, k = 0;
        int[] temp = new int[r - p + 1];
        while(i <= q && j <= r) {
            if(nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++; i++;
            }else {
                temp[k] = nums[j];
                k++; j++;
            }
        }

        int start = i, end = q;
        if(j <= r) {
            start = j;
            end = r;
        }

        while(start <= end) {
            temp[k] = nums[start];
            k++;
            start++;
        }

        for (i = 0; i < r-p+1; i++) {
            nums[p + i] = temp[i];
        }
    }

    /**
     * 快速排序
     * @param nums 数组
     * @param p 第一个元素的下标
     * @param r 最后一个元素的下标
     */
    public void quickSort(int[] nums, int p, int r) {
        if(p >= r) {
            return;
        }
        int q = partition(nums, p, r);
        quickSort(nums, p, q-1);
        quickSort(nums, q+1, r);
    }

    /**
     * 快排的分区函数
     * @param nums 数组
     * @param p 第一个元素下标
     * @param r 最后一个元素下标
     * @return 选择一个元素作为 pivot，返回其下标
     */
    private int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    /**
     * 交换数组中的两个值
     * @param nums 数组
     * @param i 要交换的其中一个元素
     * @param j 要交换的其中一个元素
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 打印数组
     * @param nums 数组
     */
    public void printArray(int[] nums) {
        System.out.print("[");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append(',');
        }
        if(sb.length() > 1){
            System.out.print(sb.substring(0, sb.length() - 1));
        }
        System.out.print("]");
    }
}
