package finall;
import javax.swing.*;
import java.awt.*;
 /*import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font; */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Ch12_1_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("기본 윈도우 창");
        frame.setLayout(new FlowLayout());
        
        /* 
         * frame.setLayout(null);
         * // frame.setLayout(new GridLayout(3, 3));
         * button1.setBounds(200, 100, 120, 50);
         */
        //레이블 나타내기
        JLabel label1 = new JLabel("안녕하세요");
        JLabel label2 = new JLabel("반갑습니다");
        label1.setForeground(Color.RED);
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        label2.setFont(font);
        
        JLabel label3 = new JLabel("어서오세요");
        label3.setOpaque(true);
        label3.setBackground(Color.YELLOW);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
    
        //버튼 나타내기
        JButton button1 = new JButton("클릭하세요");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "버튼을 눌렀습니다");
            }            
        });
        button1.setEnabled(false);
        frame.add(button1);

        //체크박스 나타내기
        JCheckBox check1 = new JCheckBox("클릭하세요");
        check1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "체크박스 ON");
                    button1.setEnabled(true);
                } else {   
                    JOptionPane.showMessageDialog(null, "체크박스 OFF");
                }
            }
        });
        frame.add(check1);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
