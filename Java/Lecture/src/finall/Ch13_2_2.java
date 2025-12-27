package finall;
import javax.swing.*;
import java.awt.*;

public class Ch13_2_2 {
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
        
        JLabel txtid = new JLabel("ID");
        centerPanel.add(txtid);
        JTextField ID = new JTextField(10);
        centerPanel.add(ID);
        JLabel passwd = new JLabel("PW");
        centerPanel.add(passwd);
        JPasswordField PW = new JPasswordField(10);
        centerPanel.add(PW);
        JLabel label3 = new JLabel("결과");
        centerPanel.add(label3);
        JTextField login = new JTextField(10);
        centerPanel.add(login);

        JButton button1 = new JButton("로그인");

        JFrame frame2 = new JFrame("메뉴");
        frame2.setSize(400, 300);
        frame2.setLayout(new FlowLayout());
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(false);

        JButton buttonCal = new JButton("계산기");
        JButton buttonmemo = new JButton("메모");
        frame2.add(buttonCal);
        frame2.add(buttonmemo);
    
        JFrame frame3 = new JFrame("계산기");
        frame3.setSize(250, 120);
        frame3.setLayout(new FlowLayout());
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(false);

        JTextField n1 = new JTextField(5);
        JTextField n2 = new JTextField(5);
        JButton addBtn = new JButton("+");
        JTextField result = new JTextField(5);
        frame3.add(n1);
        frame3.add(n2);
        frame3.add(addBtn);
        frame3.add(result);

        JFrame frame4 = new JFrame("메모장");
        frame4.setSize(300, 250);
        frame4.setLayout(new BorderLayout());
        frame4.setLocationRelativeTo(null);
        frame4.setVisible(false);

        JTextArea memoArea = new JTextArea(10, 20);
        frame4.add(new JScrollPane(memoArea), BorderLayout.CENTER);

        buttonCal.addActionListener(e -> frame3.setVisible(true));
        buttonmemo.addActionListener(e -> frame4.setVisible(true));

        addBtn.addActionListener((e -> {
            int a = Integer.parseInt(n1.getText());
            int b = Integer.parseInt(n2.getText());
            result.setText("" + (a + b));
        }));

        button1.addActionListener(e -> {
            String id = ID.getText();
            String pw = new String(PW.getPassword());

            if (id.equals("22412051") && pw.equals("1004")) {
                frame.setVisible(false);
                frame2.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "로그인 실패!");
            }
        });
        frame.add(button1, BorderLayout.SOUTH);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}