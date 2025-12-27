package finall;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ch12_2_5 {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ID/PW 창");
        frame.setLayout(new BorderLayout(20, 20));
        
        JPanel centerPanel = new JPanel();
        JPanel topPanel  = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);

        centerPanel.setLayout(new GridLayout(3, 2));
        frame.add(centerPanel, BorderLayout.CENTER);
        
        JLabel label1 = new JLabel("ID");
        centerPanel.add(label1);
        JTextField ID = new JTextField(10);
        centerPanel.add(ID);
        JLabel label2 = new JLabel("PW");
        centerPanel.add(label2);
        JTextField PW = new JTextField(10);
        centerPanel.add(PW);
        JLabel label3 = new JLabel("결과");
        centerPanel.add(label3);
        JTextField result = new JTextField(10);
        centerPanel.add(result);

        JButton button1 = new JButton("로그인");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txt1 = ID.getText();
                String txt2 = PW.getText();
                if (txt1.equals("22412051") && txt2.equals("1004")) { 
                    result.setText("로그인 완료 !");
                } else {
                    result.setText("로그인 실패");
                }
            }            
        });
        frame.add(button1, BorderLayout.SOUTH);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}