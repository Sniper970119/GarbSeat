/**
 * Created by admin on 2017/12/24.
 */
public class StartCon implements Runnable{

    @Override
    public void run() {
        JudgeState judgeState = new JudgeState();
        MainFrame mainFrame = MainFrame.getInstance();
        while (true) {
            //System.out.println(judgeState.getStart());
            if (!(judgeState.getStart())) {
                return;
            }
            if (!(judgeState.JudgeSuccess())){
                new Thread(new Handle()).start();
                System.out.println("run one time");
                mainFrame.repaint();
            }
            try{Thread.sleep(4000);}catch (Exception e){}


        }
    }
}
