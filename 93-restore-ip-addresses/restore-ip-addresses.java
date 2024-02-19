class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        // backtrack(currentIndex, dots, currentIP, result)
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    public static void backtrack(
            String s,
            int currentIndex,
            int dots,
            StringBuilder currentIP,
            List<String> result) {
        if (dots == 4 && currentIndex == s.length()) {
            result.add(currentIP.toString().substring(0, currentIP.length() - 1));
            return;
        }
        if (dots > 4 || currentIndex >= s.length()) {
            return;
        }
        for (int i = currentIndex; i < Math.min(currentIndex + 3, s.length()); i++) {
            String segment = s.substring(currentIndex, i + 1);
            // Avoid segments starting with '0' if they are not '0' themselves
            if (segment.length() > 1 && segment.startsWith("0") || Integer.parseInt(segment) > 255)
                break;
            int len = currentIP.length();
            currentIP.append(segment).append(".");
            backtrack(s, i + 1, dots + 1, currentIP, result);
            currentIP.setLength(len); // cleaning-  backtrack: remove the last segment
        }

    }
}