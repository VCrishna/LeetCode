class ProductOfNumbers {
    List<Integer> list;
    int prefix;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        prefix = 1;
    }

    public void add(int num) {
        if (num > 0) {
            prefix *= num;
            list.add(prefix);
        } else {
            list = new ArrayList<>();
            prefix = 1;
        }
    }

    public int getProduct(int k) {
        int sizeOfList = list.size();
        if (k > sizeOfList)
            return 0;
        else if (k == sizeOfList) {
            return list.get(sizeOfList - 1);
        } else {
            return list.get(sizeOfList - 1) / list.get(sizeOfList - k - 1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */