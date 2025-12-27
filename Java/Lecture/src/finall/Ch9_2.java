package finall;

//자동차 클래스 - 가격, 색상, 속도, 모델명
class Car {
	String name;
	String color;
	int price;
	int speed;
	
	Car() {
		String color = "흰색";
	} 
	
	Car(String n, String c, int p, int s) {
		name = n;
		color = c;
		price = p;
		speed = s;
	}
	
	void car_info() {
		System.out.println("모델명 : " + name + ", 가격 : " + price + ", 색상 : " + color + ", 속도 : " + speed);
	}
}

public class Ch9_2 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("제네시스", "검정", 7000, 220);
		
		c1.name = "벤츠";
		c1.color = "흰색";
		c1.price = 1000;
		c1.speed = 180;
		
		c1.car_info();
		c2.car_info();
		
		System.out.println(c1.color);
		System.out.println(c2.color);
	}
}