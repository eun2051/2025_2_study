package finall;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ch11_2_5 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        FileWriter fw = new FileWriter("Lecture/src/finall/e4.txt");
        String inStr;

        while (true) {
            System.out.print("좋아하는 것은? ");
            inStr = s.nextLine();
            if (inStr.equals(""))
                break;
            fw.write(inStr + "\n");
        }
        fw.close();
        try {
            Scanner sc = new Scanner(new File("Lecture/src/finall/e4.txt"));
            while (sc.hasNext()) {
                String line = sc.next();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다");
        }
        s.close();
    }
}
