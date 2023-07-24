class Solution {
    public double myPow(double x, int n) {
        double power = power(x,n);
        return n < 0 ? 1.0 / power : power;
    }
    public double power(double x, int n) {
        if(x==0)
            return 0;
        if(n==0)
            return 1;
        double result = 1.0;
        result = power(x,n/2);
        result *= result;
        return n % 2 == 0 ? result : x * result;
    }
}