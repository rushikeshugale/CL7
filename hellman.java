import java.util.*;

class hellman {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter two prime number:");
		int p = scan.nextInt();
		int q = scan.nextInt();

		System.out.print("For side A enter secret integer number:");
		int a = scan.nextInt();

		System.out.print("For side B enter secret integer number:");
		int b = scan.nextInt();
		
		int A = (int)(Math.pow(q,a))%p;
		System.out.println("A=" +A);
		int B = (int)(Math.pow(q,b))%p;
		System.out.println("B=" +B);

		int k1 = (int)(Math.pow(B,a))%p;
		System.out.println("Key calculated for A side:" +k1);
		int k2 = (int)(Math.pow(A,b))%p;
		System.out.println("Key calculated for B side:" +k2);
		if(k1==k2)
			System.out.println("A & B agree for future communication...");
		else
			System.out.println("A & B are not agree for communication...");
	}
}
