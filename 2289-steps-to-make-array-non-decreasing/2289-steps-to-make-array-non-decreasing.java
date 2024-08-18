class Solution {
    public int totalSteps(int[] nums) {
       Stack<int[]> stack = new Stack<>();
        int maxSteps = 0;

        // Traverse the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            int steps = 0;
            // Check how many steps are required for the current element to be placed correctly
            while (!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                steps = Math.max(steps + 1, stack.peek()[1]);
                stack.pop();
            }
            maxSteps = Math.max(maxSteps, steps);
            stack.push(new int[]{nums[i], steps});
        }

        return maxSteps;
    }
}