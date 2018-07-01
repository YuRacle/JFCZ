package cn.zlc.JFCZ;

import cn.zlc.util.Constant;

import java.awt.*;

/**
 * SideBalls绕着中间大球，沿着圆轨道运行
 *
 *
 */

public class SideBalls extends Ball{
		
	double radius;	//圆轨道的半径
	public static double fspeed;	//飞行的速度
	Ball centerBall;	//中间大球
	double degree;	//角度
	double smallRadius;	//小球的半径
	double nowx=0;
	double nowy=0;
	
	public void draw(Graphics g,int i) {

		Color c = new Color(38,107,255);
		if(i>=Constant.NOWSIDENUM)
			g.setColor(c);
		if(fspeed==0)
		{
			extend();
			Constant.flag=1;
		}
		
		else
			move();

		g.drawOval((int)(x - smallRadius), (int)(y - smallRadius), (int)(2 * smallRadius), (int)(2 * smallRadius));
		g.fillOval((int)(x - smallRadius), (int)(y - smallRadius), (int)(2 * smallRadius), (int)(2 * smallRadius));
		Color c2 = new Color(255,100,99);
		g.setColor(c2);
		g.drawLine((int)(x-smallRadius*Math.cos(degree)), (int)(y-smallRadius*Math.sin(degree)), (int)(centerBall.x + centerBall.length / 2), (int)(centerBall.y + centerBall.height / 2));
//		g.drawLine((int)x, (int)y, (int)(centerBall.x + centerBall.length / 2), (int)(centerBall.y + centerBall.height / 2));

	}
	

	public void move() {
		//沿着圆轨迹飞行
		x = (centerBall.x + centerBall.length / 2) + radius*Math.cos(degree);
		y = (centerBall.y + centerBall.height / 2) + radius*Math.sin(degree);
		degree = (fspeed+degree)%(2*Math.PI);

	}
	 

	public SideBalls(Ball centerBall, double smallRadius, double radius, double speed) {
		this.centerBall = centerBall;
		this.radius = radius;
		this.x = centerBall.x  + centerBall.length/2 + radius;
		this.y = centerBall.y + centerBall.height / 2;
		this.smallRadius = smallRadius;
		this.fspeed = speed;
	}

	public void record()
	{
		nowx = x;
		nowy = y;
	}
	public void recover()
	{   x = nowx;
		y = nowy;
	}
	public void extend()
	{   if(x>=-100&&x<=1500&&y<=1000&&y>=-300) {
			x = x + Constant.extendspeed * Math.cos(degree);
			y = y + Constant.extendspeed * Math.sin(degree);
        }
	   
	}

	public static void stop()
	{
		fspeed = 0;
	}

	public SideBalls() {
		// TODO ????????????????
	}

	public static void start(double speed)
	{
		fspeed = speed;
	}

	public double getRadius() {
		return radius;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	public double getDegree() {
		return degree;
	}

	public double getNowx() {
		return nowx;
	}

	public double getNowy() {
		return nowy;
	}
}
