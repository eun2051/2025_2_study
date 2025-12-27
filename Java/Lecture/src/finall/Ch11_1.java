package finall;
import java.util.Scanner;

class Person {
	String name;
	int hp = 100;
	int att;
	public void attack(Person target) {
		System.out.println(name + " = " + target.name + " -> " + att + "% 공격 !");
		target.hp -= this.att;
	}
}

class Professor extends Person {
	public Professor (String name) {
		this.name = name;
		this.att = 70;
	}
}

class Student extends Person {
	public Student (String name) {
		this.name = name;
		this.att = 7;
	}
}

public class Ch11_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Professor Prof  = new Professor("교수");
		Student Stu = new Student("학생");
		
		System.out.print("(1) 교수의 공격 (2) 학생의 공격 : ");
		int choice = s.nextInt();
		
		switch(choice) {
			case 1:
				Prof.attack(Stu); break;
			case 2:
				Stu.attack(Prof); break;
			default:
				System.out.println("잘못된 입력입니다.");
				
		}
		System.out.println(Prof.name + "의 hp = " + Prof.hp + "%");
		System.out.println(Stu.name + "의 hp = " + Stu.hp + "%");
		s.close();
	}
}