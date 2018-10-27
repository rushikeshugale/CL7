import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

class rsa {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int p,q,n,z,e,i,d=0;
		System.out.print("Enter the number to be encrypted and decrypted:");
		int msg = scan.nextInt();
		double c,msgback;
		System.out.print("Enter the first prime number P:");
		p = scan.nextInt();
	    System.out.print("Enter the Second prime number Q:");
		q = scan.nextInt();
		
		n = p*q;
		System.out.println("n=" +n);
		
		z = (p-1)*(q-1);
		System.out.println("Z=" +z);
		
		for(e=2;e<z;e++) {
			if(gcd(e,z)==1)
				break;
		}
		System.out.println("e=" +e);
		
		for(i=0;i<=9;i++) {
			int x = 1+(i*z);
			if(x%e==0) {
				d=x/e;	
				break;	
			}
		}
		
		System.out.println("d=" +d);
		c = (Math.pow(msg,e))%n;
		System.out.println("Encrypted message is :" +c);
		msgback = (Math.pow(c,d))%n;
		System.out.println("Decrypted message is :" +msgback);
	}
	static int gcd(int e,int z) {
		if(e==0)
			return z;
		else
			return gcd(z%e,e);
	}
}