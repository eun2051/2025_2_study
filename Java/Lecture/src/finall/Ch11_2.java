package finall;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ch11_2 {
	public static void main(String[] args) {
		try {
			File file = new File("/Users/eun/Desktop/Java/Lecture/src/finall/e3.txt");
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		}
	}
}