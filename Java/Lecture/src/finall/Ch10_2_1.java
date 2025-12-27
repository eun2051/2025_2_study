package finall;

class Plane {
	int weight, oil, engine, speed;
	
	public void Planefly() {
		System.out.println("비행(난다)");
	}
	public void Planeup() {
		System.out.println("이륙한다.");
	}
	public void Planedown() {
		System.out.println("착륙한다.");
	}
}

class normalPlane extends Plane {
	int seat;
	String start, finish;
	public void food() {
		System.out.println("기내식");
	}
	public void luggage() {
		System.out.println("수화물 내림");
	}
}

class fighter extends Plane {
	int missile, pilot;
	public void missile() {
		System.out.println("미사일 발사");
	}
	public void flare() {
		System.out.println("플레어 발사");
	}
}

public class Ch10_2_1 {
	public static void main(String[] args) {
		Me me = new Me();
		Parent parent = new Parent();
		Parent D = new Home();
		
		System.out.print("부모님 : ");
		parent.manageCompany();
		System.out.println("재산 : " + me.worth);
		System.out.println("성격 : " + me.Personality);
		System.out.print("상속받고 싶은 차 : ");
		me.DriveCar();
		System.out.print("지금의 나는.. : ");
		me.play();
		D.Do();
	}
}