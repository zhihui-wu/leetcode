package search.binarySearch;

/**
 * @Description: 278. 第一个错误的版本
 * @Author: 吴智慧
 * @Date: 2020/10/24 15:12
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    public static void main(String[] args) {

        FirstBadVersion firstBadVersion = new FirstBadVersion();

        // 二分法 - 迭代 - wzh
        int result = firstBadVersion.firstBadVersion(5);

        System.out.println(result);
    }

    /**
     * 二分法 - 迭代 - wzh
     * 时间复杂度：O（ log(n) ）
     * 空间复杂度：O（ 1 ）
     */
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                }else {
                    r = mid - 1;
                }
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public boolean isBadVersion(int n) {
        return true;
    }
}
