package primary.others;

import java.util.Arrays;

/**
 * Created by HYDYD.
 * 2019/7/8 12:03
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // 判断 n 是否出现在末位
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }

        // 此时缺失的数字一定在 (0, n) 中
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // 未缺失任何数字（保证函数有返回值）
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
