package Lap2;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n==1)
			return 1;
		else
			return getSn1(n-1) + (int)Math.pow(-1, n+1)*n;
	}
	
	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n==1)
			return 1;
		else 
			return getSn2(n-1) + giaiThua(n);
	}
	private static int giaiThua(int n) {
		// TODO Auto-generated method stub
		if (n==1)
			return 1;
		else
			return giaiThua(n-1)*n;
	}
	
	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n==1)
			return 1;
		else
			return getSn3(n-1) + (int) Math.pow(n, 2);
	}
	
	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(double n) {
		if (n==1)
			return 1;
		else 
			return getSn4(n-1) + (1 / tinhMau(n));
	}
	private static double tinhMau(double n) {
		// TODO Auto-generated method stub
		if (n==1)
			return 1;
		else 
			return tinhMau(n-1) * (n-1)*2;
	}

	public static void main(String[] args) {
		int re = getSn1(1);
		System.out.println(re);
		
		int gt = getSn2(3);
		System.out.println(gt);
		
		int a = getSn3(3);
		System.out.println(a);
		
		double b = getSn4(3);
		System.out.println(b);
	}
}
