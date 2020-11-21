package string;

/**
 * @Description: 605. 种花问题
 * @Author: 吴智慧
 * @Date: 2020/11/21 18:13
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {

        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

//        int[] flowerbed = new int[]{1,0,0,0,1};

        int[] flowerbed = new int[]{0,0,1,0,1};

        int n = 1;

//        boolean result = canPlaceFlowers.canPlaceFlowers(flowerbed, n);

        boolean result = canPlaceFlowers.canPlaceFlowers1(flowerbed, n);

        System.out.println(result);

    }

    /**
     * wzh: 遍历，将每个连续的 0 计数并换算成可种植数，需特殊处理首尾
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 开始位置: tempCount = 1，表示多算一个O
        int tempCount = 1;
        int sum = 0;
        // 开始遍历
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                tempCount += 1;
            }else {
                if (tempCount != 0) {
                    sum += tempCount / 2;
                    if (tempCount % 2 == 0) {
                        sum--;
                    }
                    tempCount = 0;
                }
            }
        }
        // 结束位置：如果以0结束，需追加处理
        if (tempCount != 0) {
            tempCount++;
            sum += tempCount / 2;
            if (tempCount % 2 == 0) {
                sum--;
            }
        }
        return sum >= n;
    }

    /**
     * 贪心算法
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     * 如果数组中有一个 0，并且这个 0 的左右两侧都是 0，那么我们就可以在这个位置种花，即将这个位置的 0 修改成 1，并将计数器 count 增加 1。
     * 对于数组的第一个和最后一个位置，我们只需要考虑一侧是否为 0
     */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    /**
     * 贪心算法 + 常数优化
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     * 如果 count 的值已经达到 n，那么我们可以直接跳出循环并返回 True
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
        }
        return count >= n;
    }
}
