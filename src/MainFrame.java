import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by admin on 2017/12/23.
 */
public class MainFrame {
    int ii = 0;
    private static final MainFrame s = new MainFrame();
    JFrame MainFrame = new JFrame();
    JLabel times =new JLabel("次数：0");
    private MainFrame(){
        MainFrame.setLayout(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setBounds(870,450,300,250);
        MainFrame.setVisible(true);

        JTextField studentNumb =new JTextField("请输入学号");
        MainFrame.add(studentNumb);
        studentNumb.setBounds(100,20,150,30);

        JLabel info1 = new JLabel("学号");
        MainFrame.add(info1);
        info1.setBounds(30,20,50,30);

        JButton button1 = new JButton("开始");
        MainFrame.add(button1);
        button1.setBounds(20,80,100,30);

        JButton button2 = new JButton("停止");
        MainFrame.add(button2);
        button2.setBounds(150,80,100,30);


        MainFrame.add(times);
        times.setBounds(200,150,200,40);

        StudentNubmer studentNubmer = StudentNubmer.getInstance();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentNubmer.setNumber(studentNumb.getText());
                new JudgeState().setStart1();
                Thread a = new Thread(new StartCon());
                a.start();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JudgeState().setStart2();
            }
        });

        studentNumb.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(studentNumb.getText().equals("请输入学号")){
                    studentNumb.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(studentNumb.getText().equals("")){
                    studentNumb.setText("请输入学号");
                }
            }
        });
    }

    public void repaint(){
        this.ii++;
        times .setText("次数："+ii);
        MainFrame.repaint();
    }

    public static MainFrame getInstance()
    {
        return s;
    }
}
