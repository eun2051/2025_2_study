package finall;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ch13_2_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("오늘의 메뉴");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 5));

        JFrame frame2 = new JFrame();
        frame2.setTitle("오늘의 메뉴");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(200, 200);
        frame2.setLayout(new FlowLayout());

        //JPanel panel0 = new JPanel();
        //JPanel panel1 = new JPanel();

        JPanel centerPanel = new JPanel();
        JPanel topPanel  = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new GridLayout(1, 4));
        frame.add(topPanel, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(1, 6));
        frame.add(centerPanel, BorderLayout.CENTER);

        JRadioButton rbMorning = new JRadioButton("아침");
        JRadioButton rbNoon = new JRadioButton("점심");
        JRadioButton rbEvening = new JRadioButton("저녁");

        ButtonGroup timeGroup = new ButtonGroup();
        timeGroup.add(rbMorning);
        timeGroup.add(rbNoon);
        timeGroup.add(rbEvening);

        JCheckBox cbKorean = new JCheckBox("한식");
        JCheckBox cbWestern = new JCheckBox("양식");
        JCheckBox cbChinese = new JCheckBox("중식");
        JCheckBox cbJapanese = new JCheckBox("일식");
        JCheckBox cbCake = new JCheckBox("케이크");
        
        JButton btn = new JButton("결과 보기");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = null;
                if (rbMorning.isSelected()) time = "아침에";
                else if (rbNoon.isSelected()) time = "점심에";
                else if (rbEvening.isSelected()) time = "저녁에";

                if (time == null) {
                    JOptionPane.showMessageDialog(frame, "식사 시간을 선택하세요!");
                    return ;
                }

                String foods = "";

                if (cbKorean.isSelected()) foods += "한식";
                if (cbWestern.isSelected()) foods += "양식";
                if (cbChinese.isSelected()) foods += "중식";
                if (cbJapanese.isSelected()) foods += "일식";
                if (cbCake.isSelected()) foods += "케이크";

                if (foods.equals("")) {
                    JOptionPane.showMessageDialog(frame, "무엇을 먹었는지 선택하세요!");
                    return ;
                }

                String message = time + " " + foods + "을(를) 먹었군요..";
                JOptionPane.showMessageDialog(frame, message);
                frame2.setVisible(true);
            }
        });

        topPanel.add(new JLabel("식사 시간 : "));
        topPanel.add(rbMorning);
        topPanel.add(rbNoon);
        topPanel.add(rbEvening);

        centerPanel.add(new JLabel("메뉴 : "));
        centerPanel.add(cbKorean);
        centerPanel.add(cbWestern);
        centerPanel.add(cbChinese);;
        centerPanel.add(cbJapanese);
        centerPanel.add(cbCake);

        bottomPanel.add(btn);

        frame.setSize(500, 250);
        frame.setVisible(true);
    }
}