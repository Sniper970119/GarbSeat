import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.BatchUpdateException;

/**
 * Created by admin on 2017/12/24.
 */
public class IDJudge {
    String Vacode = "GRJSJ65GF4SJ";
    String test = "FDGJ45G6H4J6";
    public IDJudge()throws Exception{
        JFrame id = new JFrame();
        new GetTime();
        Time time = new Time();
        id.setVisible(true);
        id.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        id.setLayout(null);
        id.setBounds(870,450,300,250);


        JLabel info = new JLabel("请输入验证码");
        id.add(info);
        info.setBounds(20,70,100,30);

        JTextField code = new JTextField();
        id.add(code);
        code.setBounds(130,70,100,30);

        JButton button = new JButton("验证");
        id.add(button);
        button.setBounds(150,150,80,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if((time.getDay()==26)&&(time.getHour()>=17)&&(time.getHour()<=20)){
                    if (code.getText().equals(Vacode)){
                        JOptionPane.showMessageDialog(null, "正式版", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        MainFrame mainFrame = MainFrame.getInstance();
                    }
                }else if(code.getText().equals(test)){
                    JOptionPane.showMessageDialog(null, "测试版", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        MainFrame mainFrame = MainFrame.getInstance();
                }else{
                    JOptionPane.showMessageDialog(null, "验证码错误", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
