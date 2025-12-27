package finall;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Ch12_1_2 {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("기본 윈도우 창");
        frame.setLayout(new FlowLayout());
        

        JButton button1 = new JButton("버튼1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "버튼1을 눌렀습니다");
            }            
        });
        JButton button2 = new JButton("버튼2");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "버튼2를 눌렀습니다");
            }            
        });
    
        button1.setEnabled(false);
        button2.setEnabled(false);
        frame.add(button1);
        frame.add(button2);


        //체크박스 나타내기
        JCheckBox check1 = new JCheckBox("클릭하세요");
        check1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check1.isSelected()) {
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                } else {   
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                }
            }
        });
        frame.add(check1);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}
