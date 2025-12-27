package middle;
import java.util.Scanner;

public class Ch6_5{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num, hit = 1;
		System.out.print("횟수를 입력하시오 : ");
		num= s.nextInt();
		
		while (hit <= num) {
			if (hit % 5 == 0) {
				System.out.printf("나무 %d번 찍는 중\n", hit);
			}
			hit++;
		}
		System.out.println("나무가 쓰러짐");
		s.close();
	}
}