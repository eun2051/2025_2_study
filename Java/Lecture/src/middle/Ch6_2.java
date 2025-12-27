package middle;
import java.util.Scanner;

public class Ch6_2{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num, con;
		System.out.print("단를 입력하시오 : ");
		num= s.nextInt();
		
		System.out.print("횟수를 입력하시오 : ");
		con = s.nextInt();
		for (int i = 1; i <= con; i++) {
			System.out.println( num + " * " + i + " = " + num * i);
			//System.out.printf("%d X %d = %d\n", num, con, num * i);
		}
		s.close();
	}
}