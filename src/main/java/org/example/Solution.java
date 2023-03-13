package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        long iterations = 0;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int lastI = 0;
        for (int i = 0; i <= nums.length - 3; i ++) {
            lastI = i;
            if (nums[i] > 0) {
                break;
            }
            if (i == 0 || (i != 0 && nums[i] != nums[i-1])) {
                for (int j = i + 1; j <= nums.length - 2; j++) {
                    int numberToFind = nums[i] + nums[j];
                    if ((numberToFind > 0 && nums[j] > 0 )) {
                        break;
                    }
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j-1])) {
                        boolean loop = true;
                        int k = j + ((nums.length - j) / 2);
                        int index = j;
                        while (loop) {
                            iterations ++;
                            if (k >= nums.length || k == index) {
                                loop = false;
                            } else if (0 == numberToFind + nums[k]) {
                                List<Integer> triplet = new ArrayList<>();
                                triplet.add(nums[i]);
                                triplet.add(nums[j]);
                                triplet.add(nums[k]);
                                results.add(triplet);
                                loop = false;
                            } else if (0 > numberToFind + nums[k]) {
                                index = k;
                                k = k + ((nums.length - k) / 2);
                            } else {
                                k = index + ((k - index) / 2);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("n = " + nums.length);
        System.out.println("lastI = " + lastI);
        System.out.println("iteraciones: " + iterations);
        return results;
    }
}
