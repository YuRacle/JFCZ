package cn.zlc.JFCZ;

import cn.zlc.util.GameUtil;
import cn.zlc.util.MyFrame;
import cn.zlc.util.Operation;

import java.awt.*;

/**
 * Created by YuRacle on 2017/11/4.
 */
public class FailFrame extends MyFrame{

    Image ffimg = GameUtil.getImage("images/failFrame.jpg");
    String s1 = "Continue";
    String s2 = "Restart";
    Font font = new Font("Î¢ÈíÑÅºÚ",Font.BOLD,28);

    Color c2 = new Color(255,165,150);

    public FailFrame() {
        super();
    }

    public void paint(Graphics g) {

        g.drawImage(ffimg, 0, 0, 1280,720,null);
        g.setFont(font);
        g.setColor(c2);
        g.fillRect(520,320,150,35);
        g.setColor(Color.white);
        g.drawString(s1,530,348);

        g.setColor(c2);
        g.fillRect(520,360,150,35);
        g.setColor(Color.white);
        g.drawString(s2,530,388);
    }

//    public static void main(String[] args) {
//        FailFrame ff =new FailFrame();
//        ff.launchFrame();
//        new Operation().RestartPress(ff);
//    }

}


