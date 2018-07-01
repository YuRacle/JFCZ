package cn.zlc.JFCZ;

import cn.zlc.util.Constant;

import java.awt.*;


public class WaitingBalls extends Ball {

	private int x_Ball;
	private int y_Ball;
	private int w_Ball;
	private int h_Ball;

	public WaitingBalls(int x_Ball, int y_Ball, int w_Ball, int h_Ball) {
		this.x_Ball = x_Ball;
		this.y_Ball = y_Ball;
		this.w_Ball = w_Ball;
		this.h_Ball = h_Ball;
	}

	WaitingBalls(double x_Ball, double y_Ball, double w_Ball, double h_Ball) {
		super(x_Ball, y_Ball, w_Ball, h_Ball);
	}

	public void draw(Graphics g) {

		Color c = new Color(38,107,255);
		g.setColor(c);
		g.drawOval(x_Ball, y_Ball, w_Ball, h_Ball);
		g.fillOval(x_Ball, y_Ball, w_Ball, h_Ball);
		
	}


	public void setX_Ball(int x_Ball) {
		this.x_Ball = x_Ball;
	}

	public void setY_Ball(int y_Ball) {
		this.y_Ball = y_Ball;
	}


	public int getX_Ball() {
		return x_Ball;
	}

	public int getY_Ball() {
		return y_Ball;
	}
}
