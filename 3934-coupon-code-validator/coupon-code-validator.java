class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, List<String>> business = new LinkedHashMap<>();
        business.put("electronics", new ArrayList<String>());
        business.put("grocery", new ArrayList<String>());
        business.put("pharmacy", new ArrayList<String>());
        business.put("restaurant", new ArrayList<String>());

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] &&
                    business.containsKey(businessLine[i]) &&
                    code[i].matches("[a-zA-Z0-9_]+")) {

                business.get(businessLine[i]).add(code[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String key : business.keySet()) {
            List<String> coupon = business.get(key);
            if (coupon.isEmpty())
                continue;
            Collections.sort(coupon);
            result.addAll(coupon);
        }
        return result;
    }
}