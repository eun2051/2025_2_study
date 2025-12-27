/*과일 클래스 - 이름 색깔 크기 당도 신선도
 * 생성자 -> 이름 색깔, 크기 넣기
 * > 포도, 사과, 키위를 생성하고 화면에 정보 출력*/
package finall;

class fruit {
	String name;
	String color;
	int size;
	int sweet;
	int fresh;
	
	fruit(String n, String c, int s) {
		name = n;
		color = c;
		size = s;
	}
	
	void fruit_info() {
		System.out.println("이름: " + name + ", 색깔: " + color + ", 크기: " + size + ", 당도: " + sweet + ", 신선도: " + fresh);	
	}
}

public class Ch9_2_1 {
	public static void main(String[] args) {
		fruit grape = new fruit("포도", "보라", 4);
		fruit apple = new fruit("사과", "빨강", 2);
		fruit kiwii = new fruit("키위", "초록", 1);
		
		grape.sweet = 5;
		grape.fresh = 4;
		
		apple.sweet = 8;
		apple.fresh = 7;
		
		kiwii.sweet = 6;
		kiwii.fresh = 6;
		
		
		grape.fruit_info();
		apple.fruit_info();
		kiwii.fruit_info();
	}
}