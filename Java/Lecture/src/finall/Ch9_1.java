package finall;

class Rabbit {
	String shape;
	int xPos;
	int yPos;
	//토끼의 기능
	
	//생성할때 기본 값을 정해줌
	//생성자 없이 그냥 생성해버리면 쓰레기값이 됨
	Rabbit() {
		shape = "토끼";
	}
	//매개변수가 있는 생성자
	/* Rabbit(String value) {
	 * 		shape = value;
	 * }
	 * >> 호출할때 Rabbit a5 = new Rabbit("토끼"); 
	 * 매개변수 넣어서 객체 생성해야함
	 * */
	
	// 함수를호출해서 값을 지정해줄수 있
	void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
}

public class Ch9_1 {
	public static void main(String[] args) {
		Rabbit a1 = new Rabbit();
		Rabbit a2 = new Rabbit();
		Rabbit a3 = new Rabbit();
		
		a1.shape = "원";
		a2.shape = "삼각형";
		a3.shape = "토끼";
		
		a1.setPosition(100, 100);
		a2.setPosition(-100, 100);
		a3.setPosition(0, -100);
		
	}
}