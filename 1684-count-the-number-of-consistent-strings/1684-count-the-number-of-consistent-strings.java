class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;

        // Check each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                // If any character in the word is not in allowedSet, mark it as inconsistent
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            // If the word is consistent, increase the count
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}