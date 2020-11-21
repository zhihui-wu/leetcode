package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1002. 查找常用字符
 * @Author: 吴智慧
 * @Date: 2020/11/19 20:49
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class FindCommonCharacters {

    public static void main(String[] args) {

        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();

        String[] A = new String[]{"bella","label","roller"};

        List<String> result = findCommonCharacters.commonChars(A);

        System.out.println(result);

    }

    /**
     * 计数
     * n 是字符串个数，m 是字符串平均长度，count 是字符集个数
     * 遍历计算freq数组：n * m
     * 更新覆盖minFreq: n * count
     * 时间复杂度：O（ n * m + n * count）
     * 空间复杂度：O（ count ）
     */
    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            int[] freq = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                freq[A[i].charAt(j) - 'a'] += 1;
            }
            for (int z = 0; z < freq.length; z++) {
                if (minFreq[z] > freq[z]) {
                    minFreq[z] = freq[z];
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < minFreq.length; i++) {
            if (minFreq[i] != Integer.MAX_VALUE && minFreq[i] != 0) {
                for (int j = 0; j < minFreq[i]; j++) {
                    result.add((char)('a' + i) +"");
                }
            }
        }
        return result;
    }
}
