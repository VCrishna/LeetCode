class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        // List to store invalid transactions
        List<String> invalidResult = new ArrayList<>();
        // Map to store transactions grouped by name
        // map with name as key and value as list of transactions for that name
        Map<String, List<Transaction>> map = new HashMap<>();

        // Grouping transactions by name
        for (String transaction : transactions) {
            Transaction trans = new Transaction(transaction);
            map.computeIfAbsent(trans.name, k -> new ArrayList()).add(trans);
        }

        // Checking each transaction for validity
        for (String transaction : transactions) {
            Transaction trans = new Transaction(transaction);

            // If transaction is invalid, adding it to the result list
            if (!isValid(map.get(trans.name), trans)) {
                invalidResult.add(transaction);
            }
        }

        return invalidResult;
    }

    // This method checks if a transaction is valid based on the provided list of
    // transactions and the transaction itself
    public boolean isValid(List<Transaction> transactions, Transaction transaction) {

        // If there's only one transaction and its amount is less than 1000, it's valid
        if (transactions.size() <= 1 && transaction.amount < 1000)
            return true;

        // Checking against all other transactions to determine validity
        for (Transaction tran : transactions) {
            if (transaction.invalidTransaction(tran.city, tran.time)) {
                return false;
            }
        }
        return true;
    }

    // Transaction class represents individual transactions
    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        // Constructor to initialize Transaction object with provided details
        Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        // Constructor to initialize Transaction object from transaction string
        Transaction(String transaction) {
            String[] t = transaction.split(",");
            this.name = t[0];
            this.time = Integer.parseInt(t[1]);
            this.amount = Integer.parseInt(t[2]);
            this.city = t[3];
        }

        public String toString() {
            return this.name + " " +
                    this.time + " " +
                    this.amount + " " +
                    this.city;
        }

        /*
         * If the amount exceeds $1000, or
         * if it occurs within (and including) 60 minutes of another transaction with
         * the same name in a different city. Each transaction string transactions[i]
         * consists of comma separated values representing the name, time (in minutes),
         * amount, and city of the transaction.
         */

        // Method to determine if a transaction is invalid based on city and time
        public boolean invalidTransaction(String city, int time) {
            return invalidAmount() || differentCity(city, time);
        }

        // Method to check if transaction amount exceeds $1000
        public boolean invalidAmount() {
            return this.amount > 1000;
        }

        // Method to check if transaction occurs within 60 minutes in a different city
        public boolean differentCity(String city, int time) {
            return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
        }
    }
}