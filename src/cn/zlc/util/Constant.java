package cn.zlc.util;

import cn.zlc.JFCZ.SideBalls;
import cn.zlc.JFCZ.WaitingBalls;

import java.util.Random;

/**
 * ��Ϸ��Ŀ���õ��ĳ���
 * @author 
 *
 */
public class Constant {

	static java.util.Random r = new java.util.Random(1);
	public static final int GAME_WIDTH = 1280;//��Ϸ���ڿ�
	public static final int GAME_HEIGHT = 720;//��Ϸ���ڳ�
	public static int WAITNUM = 3;//�ȴ�����
	public static int MAXWAITNUM = 20;//�ȴ�����������������ֹ����Խ��
	public static int SIDENUM = 3;//��ת����
	public static int MAXSIDENUM = 25;//������ת��������Խ�磬���ùؿ���
//	public static int MAXNUM = WAITNUM + SIDENUM;//��ǰת�����������
	public static int NOWSIDENUM = 3;//����ɫָ��
	public static int NOWNUM = 0;//��ǰ�ȴ������ָ��
	//public static  int NEXTNUM = 1;//��һ���ȴ�������ָ��
	public static double speed = 0.04; // ת��
	public static int sideRadius = 15; //С��뾶
	public static double centerBallRadius = 75;
	public static int TOPLEVEL = 2;//������
	public static int NOWLEVEL = 0;//��ǰ����
	public static int status = 0;//״̬
	public static int ballcolor = 0;//��ɫ
	public static int extendspeed = 100;//��ЧС����չ�ٶ�
	public static int threadsleep = 10;//�߳�˯��ʱ��
	public static int flag = 0;  //�ж���Чֹͣ
	public static int flagpass = 0;  //�ж�ͨ����ǰ��
	public static int Finalbg = 0; //�ж��Ƿ�ͨ�أ����ñ���


	public static void setLevel() {

		int x;
		if (NOWLEVEL < TOPLEVEL) {
			if (status == 1) {
				while ((x = r.nextInt() % 6) != 0)
					break;
				NOWLEVEL++;
				speed = (Math.abs(speed) + 0.005) * Math.pow(-1, x);  //�������ּ��ٶ�
			}

			NOWNUM = 0;
			WAITNUM = 3+NOWLEVEL*2;  //���صȴ�����

			Random random = new Random();
			SIDENUM = random.nextInt(3)+2;//��ת���������2-4��
			NOWSIDENUM = SIDENUM;

			SideBalls.start(speed);
		}

		if (NOWLEVEL == TOPLEVEL) {
//			System.out.println("a:"+WAITNUM);
			NOWSIDENUM = 10;
			MAXSIDENUM = 10;
			NOWNUM = 0;
			Finalbg = 1;

		}

		System.out.println("������ת����"+SIDENUM);
		System.out.println("���ڵȴ�����"+WAITNUM);
	}
}



//	public static void setLevel(int status) {
//
//		int x;
//		if (NOWLEVEL < TOPLEVEL) {
//			if (status == 1) {
//				while ((x = r.nextInt() % 6) != 0)
//					break;
//				NOWLEVEL++;
//				NOWNUM = 0;
//				WAITNUM = Math.abs(4 + ((NOWLEVEL + 1) % 3 + 1) * x);  //��󲻳�M��19��   ������ 4 + 3*5
//				if (WAITNUM >= MAXNUM && MAXNUM < MAXSIDENUM - 2)
//					MAXNUM = WAITNUM + 3;//��֤����������������ת
//				else if (WAITNUM < MAXSIDENUM - 5)
//					WAITNUM++;
//				//speed = speed*Math.pow(-1,x);  //ֻ������
//				speed = (Math.abs(speed) + 0.005) * Math.pow(-1, x);  //�������ּ��ٶ�
//			}
//			SIDENUM = MAXNUM - WAITNUM;
//			NOWSIDENUM = SIDENUM;
//			NOWNUM = 0;
//			SideBalls.start(speed);
//		}
//
//		if (NOWLEVEL == TOPLEVEL) {
//			NOWSIDENUM = MAXNUM;
//			NOWNUM = WAITNUM;
//			Finalbg = 1;
//		}
//
//	}
//}


