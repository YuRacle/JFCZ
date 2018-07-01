package cn.zlc.util;

import cn.zlc.JFCZ.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static cn.zlc.util.Constant.Finalbg;
import static cn.zlc.util.Constant.NOWLEVEL;
import static cn.zlc.util.Start.operation;


/**
 * Created by YuRacle on 2017/10/28.
 */
public class Operation {

    public static GameFrame gf = new GameFrame();
    public static FailFrame failFrame =new FailFrame();


    public void StartPress(StartFrame sf) {
        sf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x >= 450 && x <= 450 + 911 / 2 && y >= 150 && y <= 150 + 805 / 2)
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        gf.play();
                        sf.setVisible(false);
                    }
            }
        });
    }

    public void PlayPress(GameFrame gf) {
        gf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        operation.shiftBall(GameFrame.centerBall, GameFrame.waitingBalls, GameFrame.sideBalls);
                    }
            }
        });
    }

    public void RestartPress(FailFrame ff) {
        ff.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //contiune
                if (x >= 520 && x <= 520 + 150 && y >= 320 && y <= 320 + 35)
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        ff.setVisible(false);
                        operation.recontinue();
                    }
                //restart
                if (x >= 520 && x <= 520 + 150 && y >= 360 && y <= 360 + 35)
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        NOWLEVEL = 0;
                        ff.setVisible(false);
                        operation.restart();
                    }
            }
        });
    }

    public void shiftBall(Ball centerBall, WaitingBalls[] waitingBalls, SideBalls[] sideBalls)  {
    	this.moveWaitBall(waitingBalls);

        if(this.judgePaste(sideBalls)==1) {
            
    //           if(waitingBalls[Constant.NOWNUM].getY_Ball()==(550-6*Constant.sideRadius)) {
    //
    //           }
            if(Constant.SIDENUM<Constant.MAXSIDENUM) {
                sideBalls[Constant.SIDENUM] = new SideBalls(centerBall, Constant.sideRadius, 200, Constant.speed);
                sideBalls[Constant.SIDENUM].setDegree(Math.PI / 2);
                sideBalls[Constant.SIDENUM].move();  //��λ��
                Constant.SIDENUM++;
            }


            if(Constant.NOWNUM==Constant.WAITNUM)
            {
            	
//                System.out.println("Win");
                if (Finalbg !=1)
                    SideBalls.stop();
                for(int i=0;i<Constant.SIDENUM;i++)
                {
                    sideBalls[i].record();
                }
              Constant.status=1;

            }
        }
        else {
            if(Constant.SIDENUM<Constant.MAXSIDENUM) {
                sideBalls[Constant.SIDENUM] = new SideBalls(centerBall, Constant.sideRadius, 200, Constant.speed);
                sideBalls[Constant.SIDENUM].setDegree(Math.PI / 2);
                sideBalls[Constant.SIDENUM].move();
            }
            if (Finalbg !=1)
                SideBalls.stop();
            for(int i=0;i<Constant.SIDENUM;i++)
            {
                sideBalls[i].record();
            }
            if (Constant.SIDENUM < Constant.MAXSIDENUM)
                Constant.SIDENUM++;
          
            Constant.status=0;
//          try {
//              Thread.sleep(1000);
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }

        }
        
    }
    



    public void moveWaitBall(WaitingBalls[] waitingBalls)
    {  int i;
        for(i=Constant.NOWNUM+1;i<Constant.WAITNUM;i++)
        {
            waitingBalls[i].setY_Ball(waitingBalls[i].getY_Ball()-2*Constant.sideRadius);
        }
        Constant.NOWNUM++;
        //Constant.NEXTNUM++;



    }

    public int judgePaste(SideBalls[] sideBalls) {
        for(int i=0;i<Constant.SIDENUM;i++) {

            System.out.println(i);
            System.out.println(sideBalls[i].getDegree());
            System.out.println(Math.abs(sideBalls[i].getDegree() - Math.PI / 2.0) < 2 * Math.atan(Constant.sideRadius / sideBalls[i].getRadius()));
            System.out.println("a:" + Math.abs(sideBalls[i].getDegree() - Math.PI / 2.0));
            System.out.println("b:" + 2 * Math.asin(Constant.sideRadius / sideBalls[i].getRadius()));
            if(Math.abs(sideBalls[i].getDegree()-Math.PI/2)<2*Math.atan(Constant.sideRadius/sideBalls[i].getRadius())) {
                return 0;
            }
//            boolean f = Math.sqrt(Math.pow((sideBalls[i].getNowx()-640),2)+Math.pow((sideBalls[i].getNowy()-515),2)) < 2*Constant.sideRadius;
//            if(f) {
//                return 0;
//            }
        }
        return 1;

    }

    public void recontinue() {
        
        Constant.setLevel();
        gf.setVisible(true);
        gf.play();
    }

    public void restart() {

        Constant.NOWNUM = 0;
        Constant.speed = 0.02;
        Constant.WAITNUM = 3;
        Constant.SIDENUM = 3;
        Constant.NOWSIDENUM = 3;
        // System.out.println(Constant.NOWLEVEL);
        gf.setVisible(true);
        gf.play();
    }

}
