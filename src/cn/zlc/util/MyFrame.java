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
	 * ���ش���
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
			 * ���ڹر�
			 */
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
	}

	//���ػ���
	@Override
	public void update(Graphics g) {

		Image offScreenImage = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
		if (offScreenImage == null) {
			// ��ȡ��������λ�õ�ͼƬ
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		// ��ý�ȡͼƬ�Ļ���
		Graphics gImage = offScreenImage.getGraphics();
		// ��ȡ�����ĵ�ɫ����ʹ��������ɫ��仭����Ĭ�ϵ���ɫΪ��ɫ��
		Color c = Color.BLACK;
		gImage.setColor(c);
		gImage.fillRect(0, 0, WIDTH, HEIGHT); // �������һ��ͼ��Ĺ��ܣ��൱��gImage.clearRect(0, 0, WIDTH, HEIGHT)
		// �����µ�ͼƬ�ϵĻ��������ػ溯�����ػ溯��ֻ��Ҫ�ڽ�ͼ�Ļ����ϻ��Ƽ��ɣ������ڴӵײ����
		paint(gImage);
		//����������ͼƬ���ص����廭����ȥ�����ܿ���ÿ�λ���Ч��
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
