package finall;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.*;
public class Ch12_2_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("보더 레이아웃 창");
        frame.setLayout(new BorderLayout(10, 10));

        JTextField txt1 = new JTextField(10);
        frame.add(txt1, BorderLayout.NORTH);
        JTextField txt2 = new JTextField(10);
        frame.add(txt2, BorderLayout.EAST);
        JTextField txt3 = new JTextField(10);
        frame.add(txt3, BorderLayout.WEST);

        JButton button1 = new JButton("버튼1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "버튼1을 눌렀습니다");
            }            
        });
        frame.add(button1, BorderLayout.SOUTH);

        frame.setSize(250, 250);
        frame.setVisible(true);
    }
    
}
