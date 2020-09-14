package array;

import java.util.Arrays;

/**
 * @Description: 数组相关的必知必会的代码实现
 * @Author: 吴智慧
 * @Date: 2020/9/10 21:07
 */
public class Array {

    public static void main(String[] args) {
        Array arrayUtil = new Array();

        // 支持动态扩容数组
        arrayUtil.testDynamicCapacityArray();

        // 有序数组
        arrayUtil.testOrderArray();

        // 测试合并两个有序数组
        arrayUtil.testMergeOrderArray();
    }

    /**
     * 测试合并两个有序数组
     */
    public void testMergeOrderArray(){
        int[] array1 = new int[]{1,2,8,10,28};
        int[] array2 = new int[]{3,7,100};
        mergeOrderArray(array1, array2);
    }

    /**
     * 合并两个有序数组为一个有序数组
     * @param array1 数组
     * @param array2 数组
     */
    private void mergeOrderArray(int[] array1, int[] array2){
        int[] temp = new int[array1.length + array2.length];
        int i = 0, j = 0, index = 0;
        while ( i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                temp[index] = array1[i];
                i++;
            }else {
                temp[index] = array2[j];
                j++;
            }
            index++;
        }

        int start = i;
        int end = array1.length;
        int[] rest = array1;
        if (j < array2.length){
            start = j;
            end = array2.length;
            rest = array2;
        }

        while (start < end){
            temp[index] = rest[start];
            index++;
            start++;
        }
        System.out.println(Arrays.toString(temp));
    }

    /**
     * 测试动态扩容数组
     */
    public void testDynamicCapacityArray(){
        DynamicCapacityArray array1 = new Array.DynamicCapacityArray(6);
        // 在数组尾部插入10个元素
        for (int i = 0; i < 10; i++) {
            array1.insertLast(i);
            System.out.println(array1);
        }
        // 在指定下标插入4个元素
        for (int i = 0; i < 4; i++) {
            array1.insertIndex(4, 1);
            System.out.println(array1);
        }
        // 在指定下标删除1个元素
        array1.delete(1);
        System.out.println(array1);
    }

    /**
     * 测试有序数组，增删改
     */
    public void testOrderArray(){
        OrderArray array2 = new Array.OrderArray(6);
        // 在数组尾部插入7个元素
        for (int i = 0; i < 7; i++){
            array2.insertLast(i);
            System.out.println(array2);
        }
        // 更新第1个元素
        array2.updateIndex(0,100);
        System.out.println(array2);
        // 删除前4个元素
        for (int i = 0; i < 4; i++){
            array2.remove(0);
            System.out.println(array2);
        }
        // 在下标‘2’插入一个元素
        array2.insertIndex(2,999);
        System.out.println(array2);
    }

    /**
     * 支持动态扩容的数组
     */
    public static class DynamicCapacityArray{

        private int[] array;

        private int capacity;

        private int offset;

        private static final double FACTORY = 1.5;

        /**
         * 构造器
         * @param n 数组初始化大小
         */
        public DynamicCapacityArray(int n){
            array = new int[n];
            capacity = n;
            offset = 0;
        }

        /**
         * 在最后插入元素
         * @param n 元素值
         */
        public void insertLast(int n){
            if (offset + 1 >= capacity){
                // 扩容
                extendCapacity();
            }
            array[offset] = n;
            offset++;
        }

        /**
         * 指定下标插入元素
         * @param index 下标
         * @param n 元素值
         */
        public void insertIndex(int index, int n){
            if (offset + 1 >= capacity){
                // 扩容
                extendCapacity();
            }
            // 移动
            moveElementToAfter(index);
            array[index] = n;
            offset++;

        }

        /**
         * 删除指定下标元素，并返回其值
         * @param index 下标
         * @return 元素值
         */
        public int delete(int index) {
            int temp = array[index];
            // 移动
            moveElementToBefore(index);
            offset--;
            return temp;
        }

        /**
         * 扩容
         */
        private void extendCapacity(){
            int[] tempArray = new int[(int)Math.floor(capacity * FACTORY)];
            for (int i = 0; i < array.length; i++){
                tempArray[i] = array[i];
            }
            array = tempArray;
            capacity = (int)Math.floor(capacity * FACTORY);
        }

        /**
         * 后移数组
         * @param index 下标
         */
        private void moveElementToAfter(int index){
            for (int i = offset - 1; i >= index; i--){
                array[i+1] = array[i];
            }
        }

        /**
         * 前移数组
         * @param index 下标
         */
        private void moveElementToBefore(int index){
            for (int i = index; i < offset; i++){
                array[i] = array[i+1];
            }
        }

        @Override
        public String toString() {
            return "DynamicCapacityArray{" +
                    "array=" + Arrays.toString(array) +
                    ", capacity=" + capacity +
                    ", offset=" + offset +
                    '}';
        }
    }

    /**
     * 有序数组，支持动态增删改操作
     */
    public static class OrderArray{

        private int[] array;

        private int offset;

        public OrderArray(int n){
            array = new int[n];
            offset = 0;
        }

        /**
         * 在末尾插入元素
         * @param n 元素值
         */
        public void insertLast(int n){
            if (offset >= array.length){
                System.out.println("Exception: 元素个数超出数组大小");
                return;
            }
            array[offset] = n;
            offset++;
        }

        /**
         * 指定位置插入元素
         * @param index 下标
         * @param n 元素值
         */
        public void insertIndex(int index, int n){
            if (index < 0 || index > offset){
                System.out.println("Exception: 下标超出当前数组范围");
                return;
            }
            if (offset >= array.length){
                System.out.println("Exception: 元素个数超出数组大小");
                return;
            }
            // 移动
            moveElementToAfter(index);
            array[index] = n;
            offset++;
        }

        /**
         * 删除指定下标的元素
         * @param index 下标
         * @return 元素值
         */
        public int remove(int index){
            if (index < 0 || index >= offset){
                System.out.println("Exception: 下标不在当前数组范围");
                return -1;
            }
            int temp = array[index];
            moveElementToBefore(index);
            offset--;
            return temp;
        }

        /**
         * 更新指定下标的元素值
         * @param index 下标
         * @param n 元素值
         */
        public void updateIndex(int index, int n){
            if (index < 0 || index >= offset){
                System.out.println("Exception: 下标不在当前数组范围");
                return;
            }
            array[index] = n;
        }

        /**
         * 后移数组
         * @param index 下标
         */
        private void moveElementToAfter(int index){
            for (int i = offset - 1; i >= index; i--){
                array[i+1] = array[i];
            }
        }

        /**
         * 前移数组
         * @param index 下标
         */
        private void moveElementToBefore(int index){
            for (int i = index; i < offset - 1; i++){
                array[i] = array[i+1];
            }
        }

        @Override
        public String toString() {
            return "OrderArray{" +
                    "array=" + Arrays.toString(array) +
                    ", offset=" + offset +
                    '}';
        }
    }

}
