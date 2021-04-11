package com.leetcode.exercise.day2;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Remove {

    public static void main(String[] args) {
        /*System.out.println(removeElement(new int[]{1, 2, 2, 3}, 2));
        System.out.println(removeElement(new int[]{2, 3}, 2));
        System.out.println(removeElement(new int[]{1}, 2));
        System.out.println(removeElement(new int[]{2, 2}, 2));*/


        System.out.println(removeElement2(new int[]{1, 2, 2, 3}, 2));
        System.out.println(removeElement2(new int[]{2, 3}, 2));
        System.out.println(removeElement2(new int[]{1}, 2));
        System.out.println(removeElement2(new int[]{2, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) {
            if (nums[0] == val) {
                return 0;
            }
            return 1;
        }
        for (int low = 0, high = nums.length - 1; low <= high; ) {
            while (low <= high && nums[low] != val) {
                low++;
            }
            while (low <= high && nums[high] == val) {
                high--;
                size--;
            }
            if (low <= high) {
                nums[low] = nums[high];
                low++;
                high--;
                size--;
            }
        }
        return size;
    }

    public static int removeElement2(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size++] = nums[i];
            }
        }
        return size;
    }

}
