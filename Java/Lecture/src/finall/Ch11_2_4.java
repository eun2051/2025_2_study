package finall;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ch11_2_4 {
    public static void main(String[] args) {
        int i = 1;
        try {
			Scanner sc = new Scanner(new File("/Users/eun/Desktop/Java/Lecture/src/finall/e2.txt"));
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(  i + " 줄 : " + line);
                i++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		}
    }
}
