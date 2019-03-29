
public class Junit {
	public static int Factorial(int t) {
		if (t==0) {
			return 1;
		}else if (t>0){
			return(t * Factorial(t-1)); 
		}else {
			return 0;
		}
	}
	public static int sumOdds(int z) {		
		int sum=0;
		while (z <= 100 && z>0) {
			if (z % 2 != 0) {
				sum = sum + z;
			}
			z--;
		}
		return sum;
	}
	public static String concateText(String a, String b) {
		return a+" "+b;
	}
}
