import java.util.Scanner;

public class crt {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int MAX = 10;
		int arguments;
		String repeat = "y";
		int[] x = new int[MAX];
		int[] y = new int[MAX];
		int[] a = new int[MAX];
		int[] b = new int[MAX];
		int B,z;
		while (repeat == "Y" || repeat == "y") {
			System.out.print("Please enter the number of arguments: ");
			arguments = scan.nextInt();
			System.out.println("Enter the values...");
			for (int i=1; i<=arguments; i++) {
				System.out.println();
				System.out.print("a" +i+ "=");
				x[i] = scan.nextInt();
				System.out.print("m" +i+ "=");
				y[i] = scan.nextInt();
			}
			System.out.println("Solving...");
			for (int i=1; i<=arguments; i++)
				System.out.println("z = " + x[i] + " mod " + y[i]);
			B = 1;
			for (int i=1; i<=arguments; i++)
				B = B * y[i];
			for (int i=1; i<=arguments; i++)
				b[i] = B/y[i];
			for (int i=1; i<=arguments; i++)
				a[i] = SolveEqn(b[i], y[i]);
			z = 0;
			for (int i=1; i<=arguments; i++)
				z += a[i]*b[i]*x[i];
			z = z%B;
			System.out.println("z = "+ z);
			repeat = scan.nextLine();
		}
	}
	public static int SolveEqn(int co_ef, int mod) {
		int i=0;
		boolean solved = false;
		co_ef = co_ef%mod;
		while (solved == false) {
			i++;
			if ( (co_ef * i)%mod == 1)
				solved = true;
		}
		return i;
	}
}