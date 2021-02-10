package leetcode;

/**
 * @author limengtong
 * @date 2019/10/30 11:20 上午
 */
public class leetcode26 {
    public static void main(String args[]) {
        int a[] = {1, 1, 2};
        System.out.print(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        j+=1;
        return j;
    }
}
