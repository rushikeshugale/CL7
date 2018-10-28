import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

class rsa {
        public static void main(String args[]) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter the plaintext number:");
                int plaintext = scan.nextInt();
                System.out.print("Enter the first prime number P:");
                int p = scan.nextInt();
            System.out.print("Enter the Second prime number Q:");
                int q = scan.nextInt();

                int n = p*q;
                System.out.println("n=" +n);

                int z = (p-1)*(q-1);
                System.out.println("Z=" +z);

                int e,d=0;
                for(e=2;e<z;e++) {
                        if(gcd(e,z)==1)
                                break;
                }
                System.out.println("e=" +e);

                for(int x=1;x<z;x++) {
                        e = e%z;
                        if((e*x)%z==1) {
                                d = x;
                                break;
                        }
                }
                System.out.println("d=" +d);

                double ciphertext = (Math.pow(plaintext,e))%n;
                System.out.println("Encrypted message is :" +ciphertext);
                double deplaintext = (Math.pow(ciphertext,d))%n;
                System.out.println("Decrypted message is :" +deplaintext);
        }
        static int gcd(int e,int z) {
                if(e==0)
                        return z;
                else
                        return gcd(z%e,e);
        }
}
