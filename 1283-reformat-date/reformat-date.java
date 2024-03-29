class Solution {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        StringBuilder reformatedDate = new StringBuilder();
        String[] dateStrs = date.split(" ");
        String day = dateStrs[0].length() > 3 ? dateStrs[0].substring(0, 2) : "0" + dateStrs[0].substring(0, 1);
        reformatedDate.append(
                        dateStrs[2] + "-" +
                        months.get(dateStrs[1]) + "-" +
                        day);

        return reformatedDate.toString();
    }
}
