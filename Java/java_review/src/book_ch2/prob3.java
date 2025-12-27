package book_ch2;
import java.util.Scanner;

public class prob3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name, tel;
		int	num;
		
		
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름: ");
		name = s.next();
		
		System.out.print("2. 주민번호 앞 6자리: ");
		num = s.nextInt();
		
		System.out.print("3. 전화번호: ");
		tel = s.next();
		
		System.out.println("[입력된 내용]");
		System.out.println("1. 이름: " + name);
		System.out.println("2. 주민번호 앞 6자리: " + num);
		System.out.println("3. 전화번호: " + tel);
		
		s.close();
	}
}
