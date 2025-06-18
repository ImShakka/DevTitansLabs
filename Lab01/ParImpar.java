import java.util.Scanner;

public class ParImpar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		
		while (n != -1) {
			
			if (n % 2 == 0) {
				System.out.println("PAR");
				
			} else {
				System.out.println("IMPAR");
			}
			
			n = scanner.nextInt();
		}
		
		scanner.close();
	}
}

