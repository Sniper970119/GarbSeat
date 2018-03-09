import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2017/12/24.
 */
public class Handle implements Runnable {
    private static Object lock = new Object();
    private static Object file = new Object();
    private static Object list = new Object();
    public static int number = 1;

    static boolean flag = true;

    @Override
    public void run() {
        StudentNubmer studentNubmer = StudentNubmer.getInstance();
        long RunTime = System.currentTimeMillis();
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage htmlPage = null;
        try {
            htmlPage = webClient.getPage("URL");//URL地址
            if ((System.currentTimeMillis() - RunTime) >= 10000) {
                try {
                    synchronized (list){
                        this.wait();
                    }

                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "线程终止异常", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            HtmlForm form = htmlPage.getFormByName("form1");
            HtmlSubmitInput button = form.getInputByValue("预订报名");
            HtmlTextInput textField = form.getInputByName("TextBox1");
            textField.setValueAttribute(studentNubmer.getNumber());
            HtmlPage nextPage = button.click();
            String result = nextPage.asXml();
            if ((result.indexOf("请勿重复报名")) != -1) {
                System.out.println("chongfu");
                synchronized (lock) {
                    while (true) {
                        if (flag == false) {
                            break;
                        } else {
                            return;
                        }
                    }
                }
            }

            HtmlImage valicode = nextPage.getHtmlElementById("ImageCheck");
            synchronized (file){
                valicode.saveAs(new File(number+".aspx"));
                valicode.saveAs(new File(number+".jpg"));
            }



            HtmlPage htmlPage2 = nextPage;
            HtmlForm form2 = htmlPage2.getFormByName("form1");
            HtmlTextInput textField2 = form2.getInputByName("TextBox1");
            HtmlSubmitInput button2 = form2.getInputByValue("提交");
            if ((System.currentTimeMillis() - RunTime) >= 10000) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "线程终止异常", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

            String code;
            synchronized (file){
                code = new JudgeCode().run(number++);
            }
            //System.out.println(code);
            textField2.setValueAttribute(code);
            HtmlPage nextPage2 = button2.click();
            String result2 = nextPage2.asXml();

            if ((result2.indexOf("恭喜，报名成功！")) != -1) {
                System.out.println("success");
                JOptionPane.showMessageDialog(null, "成功，请关闭尽快点停止并去网站查询确定", "ERROR", JOptionPane.ERROR_MESSAGE);
                synchronized (lock) {
                    while (true) {
                        flag = true;
                        new JudgeState().HandleSuccess();
                        JOptionPane.showMessageDialog(null, "成功，请关闭尽快点停止并去网站查询确定", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
