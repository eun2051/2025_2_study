package middle;
import java.util.Scanner;

public class pro1{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int exercise;
		int count = 0;
		
		while (true) {
			System.out.println("운동을 선택해주세요.");
			System.out.print("(팔굽혀펴기 1 / 스쿼트 2 / 윗몸일으키기 3 / 운동종료  4) : ");
			exercise= s.nextInt();

			if (exercise == 4) {
				System.out.println("운동종료!");
				break;
			}
			if (exercise == 1) {
				count += 50;
				continue;
			} else if (exercise == 2) {
				count += 80;
				continue;
			} else if (exercise == 3) {
				count += 100;
				continue;
			} else {
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
		System.out.printf("지금까지 한 운동의 총 칼로리는 %d입니다!", count);
		s.close();
	}
}