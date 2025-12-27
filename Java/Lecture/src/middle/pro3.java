package middle;
import java.util.Scanner;
import java.util.Random;

public class pro3{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		int a_hp, a_hit, a_hide;
		int b_hp, b_hit, b_hide;
		System.out.print("플레이어 A의 HP를 입력하시오 (1~100): ");
		a_hp = s.nextInt();
		System.out.print("플레이어 A의 공격력을 입력하시오 (1~100): ");
		a_hit = s.nextInt();
		a_hide = r.nextInt(100);
		System.out.println("플레이어 A의 회피율 : " + a_hide + "%");
		
		System.out.print("플레이어 B의 HP를 입력하시오 (1~100): ");
		b_hp = s.nextInt();
		System.out.print("플레이어 B의 공격력을 입력하시오 (1~100): ");
		b_hit = s.nextInt();
		b_hide = r.nextInt(100);
		System.out.println("플레이어 B의 회피율 : " + b_hide + "%");
		
		if ((a_hp < 1 || a_hp > 100 || a_hit < 1 || a_hit > 100 || b_hp < 1 || b_hp > 100 || b_hit < 1 || b_hit > 100)) {
			System.out.println("잘못된 입력입니다.");
		}
		
		while (true) {
			a_hp = a_hp - b_hit + a_hide;
			b_hp = b_hp - a_hit + b_hide;
			if (a_hp < 0) {
				System.out.println("승리자는 플레이어 B입니다!");
				break;
			} else if (b_hp < 0) {
				System.out.println("승리자는 플레이어 A입니다!");
				break;
			}
		}
		System.out.println("경기 종료.");
		s.close();
	}
}