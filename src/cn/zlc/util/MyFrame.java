package cn.zlc.util;

import cn.zlc.JFCZ.GameFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static cn.zlc.util.Constant.GAME_HEIGHT;
import static cn.zlc.util.Constant.GAME_WIDTH;


@SuppressWarnings("serial")
public class MyFrame extends Frame implements Runnable{
	/**
	 * 加载窗口
	 */
    public MyFrame()
    {
    	new Thread(this).start();
    }
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(300, 150);
		setBackground(Color.black);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			/**
			 * 窗口关闭
			 */
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
	}

	//二重缓冲
	@Override
	public void update(Graphics g) {

		Image offScreenImage = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
		if (offScreenImage == null) {
			// 截取窗体所在位置的图片
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		// 获得截取图片的画布
		Graphics gImage = offScreenImage.getGraphics();
		// 获取画布的底色并且使用这种颜色填充画布（默认的颜色为黑色）
		Color c = Color.BLACK;
		gImage.setColor(c);
		gImage.fillRect(0, 0, WIDTH, HEIGHT); // 有清除上一步图像的功能，相当于gImage.clearRect(0, 0, WIDTH, HEIGHT)
		// 将截下的图片上的画布传给重绘函数，重绘函数只需要在截图的画布上绘制即可，不必在从底层绘制
		paint(gImage);
		//将接下来的图片加载到窗体画布上去，才能考到每次画的效果
		g.drawImage(offScreenImage, 0, 0, null);

	}


	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(Constant.threadsleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
