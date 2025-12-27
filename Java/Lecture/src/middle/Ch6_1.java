package middle;
import java.util.Scanner;

public class Ch6_1{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num;
		System.out.print("단를 입력하시오 : ");
		num= s.nextInt();
		for (int i = 1; i <= 100; i++) {
			System.out.println( num + " * " + i + " = " + num * i);
		}
		s.close();
	}
}