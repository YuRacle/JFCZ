package cn.zlc.JFCZ;

import cn.zlc.util.Constant;
import cn.zlc.util.GameUtil;
import cn.zlc.util.MyFrame;

import java.awt.*;

import static cn.zlc.util.Constant.*;
import static cn.zlc.util.Operation.gf;
import static cn.zlc.util.Operation.failFrame;
import static cn.zlc.util.Start.operation;

/**
 * ¼û·ì²åÕëÓÎÏ·Ö÷´°¿Ú
 *
 *
 */
public class GameFrame extends MyFrame {

	Image bg = GameUtil.getImage("images/background.jpg");
	public static WaitingBalls[] waitingBalls = new WaitingBalls[MAXWAITNUM];
	public static Ball centerBall = new Ball(580, 200, 150, 150);
	public static SideBalls[] sideBalls = new SideBalls[MAXSIDENUM];
	Image fimg = GameUtil.getImage("images/final.jpg");
    String s = "Congratulations! YOU ARE WIN!";
    Font font = new Font("Î¢ÈíÑÅºÚ",Font.BOLD,40);
    Font font2 = new Font("Î¢ÈíÑÅºÚ",Font.BOLD,18);
	Color c1 = new Color(100,255,200);
	Color c2 = new Color(255,100,99);

	
    public void setSideBalls() {
		for (int i = 0; i < SIDENUM; i++) {
			sideBalls[i] = new SideBalls(centerBall, Constant.sideRadius, 200, Constant.speed);
			sideBalls[i].setDegree(i*2*Math.PI/SIDENUM);
		}
	}

	public void setWaitingBalls() {
		for (int i = 0; i < WAITNUM; i++) {

			waitingBalls[i] = new WaitingBalls(620,500,30,30);
			waitingBalls[i].setX_Ball(635);
			waitingBalls[i].setY_Ball(550+2*i*Constant.sideRadius);

		}
	}

	public void paint(Graphics g) {


		if(Constant.Finalbg==0) {
			g.drawImage(bg, 0, 0,1280,720, null);
			Font font = new Font("Î¢ÈíÑÅºÚ",Font.BOLD,28);
			g.setFont(font);

			int nowlevel = NOWLEVEL+1;
			g.setColor(c2);
			String level = "µÚ" + nowlevel + "¹Ø";
			g.drawString(level,100,100);

			if(Constant.NOWNUM<Constant.WAITNUM) {
				for (int i = Constant.NOWNUM; i < WAITNUM; i++) {
					waitingBalls[i].draw(g);
				}

			/*	if(Constant.NOWNUM==Constant.NEXTNUM)
				{  double r =new SideBalls().getRadius();
					for(int j=waitingBalls[Constant.NOWNUM].getY_Ball();j>200+centerBallRadius;j-=1)
					{
						waitingBalls[Constant.NOWNUM].setY_Ball(waitingBalls[Constant.NOWNUM].getY_Ball()-j);
						waitingBalls[Constant.NOWNUM].draw(g);
					}
				}*/
			}
		}

		if(Constant.Finalbg==1) {

			gf = null;
			failFrame = null;


			g.drawImage(fimg, 0, 0, 1280,720,null);
			g.setColor(c1);
			g.fillRect(305,555,680,60);
			g.setColor(Color.white);
			g.setFont(font);
	        g.drawString(s,315,600);
	        //ÖÆ×÷ÈË
			g.setColor(c2);
			g.setFont(font2);

			g.drawString("Make by:",50,580);
			g.drawString("Feliz Zhang",50,605);
			g.drawString("Mixmixla",50,630);
			g.drawString("William Chan",50,655);

		}

		g.setColor(c2);
		centerBall.draw(g);

		for (int i = 0; i < SIDENUM; i++) {
			g.setColor(c2);
			sideBalls[i].draw(g,i);
		}

		if(sideBalls[SIDENUM-1].x<-100||sideBalls[SIDENUM-1].x>1500||sideBalls[SIDENUM-1].y>1000||sideBalls[SIDENUM-1].y<-300)
			if((sideBalls[0].x<-100||sideBalls[0].x>1500||sideBalls[0].y>1000||sideBalls[0].y<-300)) {
				 Constant.flagpass = 1;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}

	
		if (Constant.flag==1){
			if(Constant.flagpass==1) {
				if(Constant.status==1) {

					Constant.flagpass=0;
					Constant.flag=0;
					Constant.setLevel();
	       
	                 gf.play();
				}
				else if(Constant.status==0) {
					Constant.flagpass=0;
					Constant.flag=0;
					failFrame.launchFrame();
					gf.setVisible(false);
				}
			}
		}

	}

	public void play() {
		gf.setWaitingBalls();
		gf.setSideBalls();
		gf.launchFrame();
	}

}
