package finall;

class Parent{
	String company = "Parent business";
	String Personality = "성격 급함";
	int worth = 50000000;
	
	public void manageCompany() {
		System.out.println("자신의 회사를 경영합니다.");
	}
	public void DriveCar() {
		System.out.println("벤츠, 제네시스");
	}
	public void Do() {
		System.out.println("회사로 매일 출근하기");
	}
}

class Me extends Parent{
	public void play(){
		System.out.println("아무것도 안하고 놀고싶다..");
	}
}

class Home extends Parent {
	@Override
	public void Do() {
		System.out.println("집에 가자");
	}
}

public class Ch10_1_1 {
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