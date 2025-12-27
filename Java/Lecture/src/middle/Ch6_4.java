package middle;
import java.util.Scanner;

public class Ch6_4{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num;
		System.out.print("횟수를 입력하시오 : ");
		num= s.nextInt();
		
		for (int i = 1; i <= num; i++) {
			System.out.printf("나무 %d번 찍는 중\n", i);
		}
		System.out.println("나무가 쓰러짐");
		s.close();
	}
}

/* while로 구현
 * while (hit <= line)
 * {
 * 	System.out.println("나무" + hit + "번 찍는 중");
 *	hit++;
 * }
 * */
 