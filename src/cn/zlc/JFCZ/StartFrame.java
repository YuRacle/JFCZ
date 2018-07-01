package cn.zlc.JFCZ;

import cn.zlc.util.GameUtil;
import cn.zlc.util.MyFrame;

import java.awt.*;


public class StartFrame extends MyFrame {

    Image bg = GameUtil.getImage("images/final.jpg");
    Image sb = GameUtil.getImage("images/StartButton.png");


    //Icon sb1 = new ImageIcon("images/StartButton.png");
    //Icon sb2 = new ImageIcon("background.jpg");
    // JButton buttonEnter = new JButton(sb2);

    public StartFrame() {
        super();
    }

    public void paint(Graphics g) {

        g.drawImage(bg, 0, 0, 1280, 720, null);
        g.drawImage(sb, 450, 150, 911 / 2, 805 / 2, null);
    }


}
