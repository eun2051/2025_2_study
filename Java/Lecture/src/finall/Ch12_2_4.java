package finall;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ch12_2_4 {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("파넬 활용 창");
        frame.setLayout(new BorderLayout(20, 20));
        
        JPanel centerPanel = new JPanel();
        
        centerPanel.setLayout(new GridLayout(3, 1));
        frame.add(centerPanel, BorderLayout.CENTER);
        
        JTextField txt1 = new JTextField(10);
        centerPanel.add(txt1);
        JTextField txt2 = new JTextField(10);
        centerPanel.add(txt2);
        JTextField txt3 = new JTextField(10);
        centerPanel.add(txt3);

        JButton button1 = new JButton("버튼1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "버튼1을 눌렀습니다");
            }            
        });
        frame.add(button1, BorderLayout.SOUTH);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}
