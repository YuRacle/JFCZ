package cn.zlc.JFCZ;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by YuRacle on 2017/11/7.
 */
public class MusicPlayer extends JFrame {

    public MusicPlayer() {

        setSize(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        URL codebase=null;
        try {
            codebase = new URL("file:\\C:\\Users\\YuRacle\\Desktop\\JFCZ1.8\\JFCZ\\src\\music\\bgm.wav");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AudioClip audio1= Applet.newAudioClip(codebase);
        audio1.loop();

    }

    public static void main(String[] args) {
        new MusicPlayer();
    }

}

