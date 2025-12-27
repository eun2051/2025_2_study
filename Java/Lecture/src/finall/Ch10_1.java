package finall;

class Rabbit_ {
	String shape;
	int xPos;
	int yPos;
	static int count; // 생성한 토끼 수
	
	Rabbit_() {
		count++; // count 변수가 공유가 되므로 count++이 작동함
	}
}

public class Ch10_1 {
	public static void main(String[] args) {
		System.out.println("객체 생성 전의 총 토끼 수 ==> " + Rabbit_.count);
		
		Rabbit_ r1 = new Rabbit_();
		System.out.println("토끼 객체1 생성 후의 총 토끼 수 ==> " + Rabbit_.count);
		
		Rabbit_ r2 = new Rabbit_();
		System.out.println("토끼 객체2 생성 후의 총 토끼 수 ==> " + Rabbit_.count);
	}
}