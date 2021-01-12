package _16_数值的整数次方;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.myPow(3.0,6));
	}
	
	public double myPow(double x,int n) {
		//base
        if(x==0){
            return 0;
        }
        //判断n正负，并考虑溢出
        long b = n;
        if(b<0){
            b = -b;
            x = 1/x;
        }
        //循环实现：
        //(1)myPow(base,exponent) = myPow(base*base,exponent/2),exponent&1==0
        //(2)myPow(base,exponent) = newbase*myPow(base*base,exponent/2),exponent&1==1
        //【HDP】newbase = base*base
        double res = 1.0;
        while(b>0){
            if((b&1)==1){
                res*=x;
            }
            x*=x;//base*base
            b>>=1;//exponent/2
        }
        return res;
	}
}
