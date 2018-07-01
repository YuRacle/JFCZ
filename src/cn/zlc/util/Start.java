package cn.zlc.util;

import cn.zlc.JFCZ.GameFrame;
import cn.zlc.JFCZ.MusicPlayer;
import cn.zlc.JFCZ.StartFrame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static cn.zlc.util.Operation.failFrame;
import static cn.zlc.util.Operation.gf;

/**
 * Created by YuRacle on 2017/10/28.
 */
public class Start {
    public static Operation operation = new Operation();
    public static void main(String[] args) {


        URL url = null;
        try {
            File file = new File("src\\music\\bgm.wav");
//            codebase = new URL("file:\\C:\\Users\\YuRacle\\Desktop\\JFCZ1.78\\JFCZ\\src\\music\\bgm.wav");
            URI uri = file.toURI();
            url = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AudioClip audio1 = Applet.newAudioClip(url);
        audio1.loop();

        StartFrame sf = new StartFrame();
        sf.launchFrame();

        operation.StartPress(sf);
        operation.PlayPress(gf);
        operation.RestartPress(failFrame);

        //operation.Press(gf);
    }
}
