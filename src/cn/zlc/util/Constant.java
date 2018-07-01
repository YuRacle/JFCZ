package cn.zlc.util;

import cn.zlc.JFCZ.SideBalls;
import cn.zlc.JFCZ.WaitingBalls;

import java.util.Random;

/**
 * 游戏项目中用到的常量
 * @author 
 *
 */
public class Constant {

	static java.util.Random r = new java.util.Random(1);
	public static final int GAME_WIDTH = 1280;//游戏窗口宽
	public static final int GAME_HEIGHT = 720;//游戏窗口长
	public static int WAITNUM = 3;//等待球数
	public static int MAXWAITNUM = 20;//等待球数加最大关数，防止数组越界
	public static int SIDENUM = 3;//旋转球数
	public static int MAXSIDENUM = 25;//最大的旋转球数，防越界，设置关卡用
//	public static int MAXNUM = WAITNUM + SIDENUM;//当前转动球最大数量
	public static int NOWSIDENUM = 3;//改颜色指针
	public static int NOWNUM = 0;//当前等待球号数指针
	//public static  int NEXTNUM = 1;//下一个等待球数号指针
	public static double speed = 0.04; // 转速
	public static int sideRadius = 15; //小球半径
	public static double centerBallRadius = 75;
	public static int TOPLEVEL = 2;//最大关数
	public static int NOWLEVEL = 0;//当前关数
	public static int status = 0;//状态
	public static int ballcolor = 0;//颜色
	public static int extendspeed = 100;//特效小球伸展速度
	public static int threadsleep = 10;//线程睡眠时间
	public static int flag = 0;  //判断特效停止
	public static int flagpass = 0;  //判断通过当前关
	public static int Finalbg = 0; //判断是否通关，设置背景


	public static void setLevel() {

		int x;
		if (NOWLEVEL < TOPLEVEL) {
			if (status == 1) {
				while ((x = r.nextInt() % 6) != 0)
					break;
				NOWLEVEL++;
				speed = (Math.abs(speed) + 0.005) * Math.pow(-1, x);  //调正反又加速度
			}

			NOWNUM = 0;
			WAITNUM = 3+NOWLEVEL*2;  //各关等待球数

			Random random = new Random();
			SIDENUM = random.nextInt(3)+2;//旋转球数，随机2-4个
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

		System.out.println("现在旋转球数"+SIDENUM);
		System.out.println("现在等待球数"+WAITNUM);
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
//				WAITNUM = Math.abs(4 + ((NOWLEVEL + 1) % 3 + 1) * x);  //最大不超M过19个   最坏情况是 4 + 3*5
//				if (WAITNUM >= MAXNUM && MAXNUM < MAXSIDENUM - 2)
//					MAXNUM = WAITNUM + 3;//保证至少有两个球在旋转
//				else if (WAITNUM < MAXSIDENUM - 5)
//					WAITNUM++;
//				//speed = speed*Math.pow(-1,x);  //只调正反
//				speed = (Math.abs(speed) + 0.005) * Math.pow(-1, x);  //调正反又加速度
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


