class Solution {
    public int minimumDifference(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum / 2;
        int half = nums.length / 2;
        int min = Integer.MAX_VALUE;
        int value = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i <= half; i++) {
            map1.put(i, new ArrayList<>());
            map2.put(i, new ArrayList<>());
        }

        solution(nums, 0, half, 0, 0, map1);
        solution(nums, half, nums.length, 0, 0, map2);

        for (int i = 0; i <= half; i++) {
            List<Integer> list1 = map1.get(i);
            List<Integer> list2 = map2.get(half - i);

            Collections.sort(list1);
            Collections.sort(list2);

            int l = 0;
            int r = list2.size() - 1;
            while (l < list1.size() && r >= 0) {
                int sum = list1.get(l) + list2.get(r);

                if (target == sum) {
                    return Math.abs(totalSum - 2 * sum);
                } else if (target > sum) {
                    l++;
                } else {
                    r--;
                }

                int diff = Math.abs(target - sum);

                if (diff <= min) {
                    min = diff;
                    value = sum;
                }
            }
        }
        return Math.abs(totalSum - 2 * value);
    }

    private void solution(int[] nums, int now, int max, int sum, int count, Map<Integer, List<Integer>> map) {
        if (now == max) {
            map.get(count).add(sum);
            return;
        }

        solution(nums, now + 1, max, sum + nums[now], count + 1, map);
        solution(nums, now + 1, max, sum, count, map);
    }
}