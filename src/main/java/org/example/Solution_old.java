package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_old {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        long iterations = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int lastI = 0;
        for (int i = 0; i <= nums.length - 3; i ++) {
            lastI = i;
            if (nums[i] > 0) {
                break;
            }
            if (!(nums[i] > 0) && (i == 0 || (i != 0 && nums[i] != nums[i-1]))) {
                for (int j = i + 1; j <= nums.length - 2; j++) {
                    if ((nums[i] + nums[j] > 0 && nums[j] > 0 )) {
                        break;
                    }
                    if (j == i + 1 || ((j > i + 1 && nums[j] != nums[j-1]) && !(nums[i] + nums[j] > 0 && nums[j] > 0 ) )) {
                        for (int k = j + 1; k <= nums.length -1; k++) {
                            if (k == j + 1 || (k > j + 1 && nums[k] != nums[k-1])) {
                                iterations ++;
                                int sum = nums[i] + nums[j] + nums[k];
                                if (sum == 0) {
                                    List<Integer> triplet = new ArrayList<>();
                                    triplet.add(nums[i]);
                                    triplet.add(nums[j]);
                                    triplet.add(nums[k]);
                                    results.add(triplet);
                                } else if (sum > 0) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("n = " + nums.length);
        System.out.println("lasti = " + lastI);
        System.out.println("iteraciones: " + iterations);
        return results;
    }
}
