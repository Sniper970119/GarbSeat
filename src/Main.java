import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.*;

/**
 * Created by admin on 2017/12/23.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("1.html"), "gbk"));
        BufferedWriter fileWriter2 = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("2.html"), "gbk"));
        WebClient webClient =  new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage htmlPage = webClient.getPage("URL");          //目的URL地址


        HtmlForm form = htmlPage.getFormByName("form1");
        HtmlSubmitInput button = form.getInputByValue("预订报名");
        HtmlTextInput textField = form.getInputByName("TextBox1");
        textField.setValueAttribute("xxxxxxxx");    //报名信息
        HtmlPage nextPage = button.click();
        String result = nextPage.asXml();
        if ((result.indexOf("请勿重复报名"))!=-1){
            System.out.println("报过了");
            System.exit(0);
        }
        HtmlImage valicode = nextPage.getHtmlElementById("ImageCheck");
        valicode.saveAs(new File("ValidateCode.aspx"));
        valicode.saveAs(new File("valicode.jpg"));

        fileWriter.write(result);
        fileWriter.flush();
        fileWriter.close();


        HtmlPage htmlPage2 = nextPage;
        HtmlForm form2 = htmlPage2.getFormByName("form1");
        HtmlTextInput textField2 = form2.getInputByName("TextBox1");
        HtmlSubmitInput button2 = form2.getInputByValue("提交");

        String code;
        code = new JudgeCode().run();

        textField2.setValueAttribute(code);
        HtmlPage nextPage2 = button2.click();
        String result2 = nextPage2.asXml();

        if ((result2.indexOf("恭喜，报名成功！"))!=-1){
            System.out.println("成功");
        }
        fileWriter2.write(result2);
        fileWriter2.flush();
        fileWriter2.close();


    }
}
