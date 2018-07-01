package cn.zlc.JFCZ;

import java.awt.*;

public class Ball {
	double x, y;
	double length, height;
	Image img;
	public void draw(Graphics g) {
//		g.setColor(Color.white);
		g.drawOval((int)x, (int)y, (int)length, (int)height);
		g.fillOval((int)x, (int)y, (int)length, (int)height);
	}
	
	public Ball(double x, double y, double length, double height)
	{
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
	}
	
	public Ball(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
	public Ball() {
		
	}
	
	
	
}