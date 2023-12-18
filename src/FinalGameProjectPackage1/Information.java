package FinalGameProjectPackage1;
import java.awt.*;
import javax.swing.*;


public abstract class Information {
	protected int playerNumber=0;
	protected boolean GameOver=false;
	//////////////////////////////
///////////////////////////////////////////玩家
	protected Player p1=new Player("P1");
	protected Player p2=new Player("P2");
	protected Player p3=new Player("P3");
	protected Player p4=new Player("P4");
////////////////////////////////////////////////分數板
	protected JLabel Player1scoreLabel=new JLabel();
	protected JLabel Player2scoreLabel=new JLabel();
	protected JLabel Player3scoreLabel=new JLabel();
	protected JLabel Player4scoreLabel=new JLabel();
////////////////////////////////////////////////字體設定
	protected Font font0 = new Font("宋體", Font.BOLD, 50);//字型，字體，字體大小
	protected Font font = new Font("宋體", Font.BOLD, 30);//字型，字體，字體大小
	protected Font font2 = new Font("宋體", Font.BOLD, 26);//字型，字體，字體大小
	protected Font font3 = new Font("宋體", Font.PLAIN, 18);//字型，字體，字體大小
	protected Font font4 = new Font("宋體", Font.PLAIN, 10);//字型，字體，字體大小

	////////////////////////////////////////////////
	public void setPlayer(Information information) {//讓兩個類別的資料相當
		p1=information.p1;
		p2=information.p2;
		p3=information.p3;
		p4=information.p4;
	}
	public int[] getScore() {//拿陣列把分數記下丟回其他類別
		int[] A=new int[4];
		A[0]=p1.getFraction();
		A[1]=p2.getFraction();
		A[2]=p3.getFraction();
		A[3]=p4.getFraction();
		return A;
	}
	public void InfPlayerReset() {
		p1.playerReset();
		p2.playerReset();
		p4.playerReset();
		p3.playerReset();
	}
	public void getNumberPlayerAndWinnner(int playerNumber) {
	}
//////////////////////////////////////////////////////
	public abstract String getGameName();///各frame名稱
	public abstract void openFrame(int playerNumber);//入口與建構子分離
	public abstract boolean isOpenFrame();//frame是否開啟
	public abstract boolean getGameOver();
}
