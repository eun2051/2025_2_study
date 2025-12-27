package finall;
import javax.swing.*;
import java.awt.*;

public class Ch12_2_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("문자 입력 창");
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JTextField txt1 = new JTextField(10);
        JTextField txt2 = new JTextField(10);
        JTextField txt3 = new JTextField(10);
        frame.add(txt1);
        frame.add(txt2);
        frame.add(txt3);

        frame.setSize(250, 250);
        frame.setVisible(true);
    }
    
}
