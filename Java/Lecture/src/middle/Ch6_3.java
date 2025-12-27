package middle;
import java.util.Scanner;

public class Ch6_3{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1, num2, num3, num4;
		System.out.print("첫번째 수를 입력하시오 : ");
		num1= s.nextInt();
		System.out.print("두번째 수를 입력하시오 : ");
		num2= s.nextInt();
		System.out.print("세번째 수를 입력하시오 : ");
		num3= s.nextInt();
		System.out.print("네번째 수를 입력하시오 : ");
		num4= s.nextInt();
		
		for (int i = 1; i <= num1; i++) {
			for(int j = 1; j <= num2; j++) {
				for(int p = 1; p <= num3; p++) {
					for(int q = 1; q <= num4; q++) {
						System.out.printf("%d * %d * %d * %d = %d\n",i, j, p, q, (i * j * p * q));
					}
				}
			}
		}
		s.close();
	}
}