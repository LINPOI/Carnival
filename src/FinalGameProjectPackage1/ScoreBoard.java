package FinalGameProjectPackage1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScoreBoard extends Information{
	public int playerNumber;
	Timer timer;
	private JFrame jfscoreBoard= new JFrame(getGameName());
	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "記分板";
	}
	
	
	@Override
	public void openFrame(int playerNumber) {
		// TODO Auto-generated method stub
		this.playerNumber=playerNumber;
		jfscoreBoard.setSize(new Dimension(300,160));
		jfscoreBoard.setLayout(null); //格式設定
		jfscoreBoard.setContentPane(getJPScore());
		jfscoreBoard.setLocation(400, 0);
		jfscoreBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jfscoreBoard.setVisible(true);
	}
	
	@Override
	public boolean isOpenFrame() {
		// TODO Auto-generated method stub
		if(jfscoreBoard.isVisible()) {
			return true;
		}
		return false;
	}
	
	public ScoreBoard() {}
	public ScoreBoard(int playerNumber) {
		this.playerNumber=playerNumber;
	}
	
	public JPanel getJPScore() {
		JPanel jp2 = new JPanel();
		jp2.setSize(new Dimension(400,200));
		jp2.setLayout(null);
		//////////得分標籤/////////////////
		JLabel scoreLabel=new JLabel("得分");
		scoreLabel.setFont(font2);	
		scoreLabel.setSize(200,60);
		scoreLabel.setLocation(10,40);
		jp2.add(scoreLabel);
		//////////得分標籤/////////////////
		JLabel Player1Label=new JLabel("P1");//之後設定得到正確分數
		Player1Label.setFont(font3);
		Player1Label.setOpaque(true);//讓背景顏色可見
		Player1Label.setHorizontalAlignment(JLabel.CENTER);
		Player1Label.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		Player1Label.setSize(40,20);
		Player1Label.setLocation(70,25);
		jp2.add(Player1Label);
		
		
		Player1scoreLabel.setText(String.valueOf(p1.getFraction()));
		Player1scoreLabel.setFont(font2);
		Player1scoreLabel.setOpaque(true);//讓背景顏色可見
		Player1scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		Player1scoreLabel.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		Player1scoreLabel.setBackground(Color.ORANGE);
		Player1scoreLabel.setSize(40,40);
		Player1scoreLabel.setLocation(70,50);
		jp2.add(Player1scoreLabel);
		///////////////////////////////////////////
		if(playerNumber>=2) {
			JLabel Player2Label=new JLabel("P2");//之後設定得到正確分數
			Player2Label.setFont(font3);
			Player2Label.setOpaque(true);//讓背景顏色可見
			Player2Label.setHorizontalAlignment(JLabel.CENTER);
			Player2Label.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
			Player2Label.setSize(40,20);
			Player2Label.setLocation(120,25);
			jp2.add(Player2Label);
			
			
			Player2scoreLabel.setText(String.valueOf(p2.getFraction()));
			Player2scoreLabel.setFont(font2);
			Player2scoreLabel.setOpaque(true);//讓背景顏色可見
			Player2scoreLabel.setHorizontalAlignment(JLabel.CENTER);
			Player2scoreLabel.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
			Player2scoreLabel.setBackground(Color.YELLOW);
			Player2scoreLabel.setSize(40,40);
			Player2scoreLabel.setLocation(120,50);
			jp2.add(Player2scoreLabel);
		}
		
		////////////////////////////////////////////
		if(playerNumber>=3) {
			JLabel Player3Label=new JLabel("P3");//之後設定得到正確分數
			Player3Label.setFont(font3);
			Player3Label.setOpaque(true);//讓背景顏色可見
			Player3Label.setHorizontalAlignment(JLabel.CENTER);
			Player3Label.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
			Player3Label.setSize(40,20);
			Player3Label.setLocation(170,25);
			jp2.add(Player3Label);
			
			
			Player3scoreLabel.setText(String.valueOf(p3.getFraction()));
			Player3scoreLabel.setFont(font2);
			Player3scoreLabel.setOpaque(true);//讓背景顏色可見
			Player3scoreLabel.setHorizontalAlignment(JLabel.CENTER);
			Player3scoreLabel.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
			Player3scoreLabel.setBackground(Color.CYAN);
			Player3scoreLabel.setSize(40,40);
			Player3scoreLabel.setLocation(170,50);
			jp2.add(Player3scoreLabel);
		}
		/////////////////////////////////////////////////////
		if(playerNumber>=4) {
			JLabel Player4Label=new JLabel("P4");//之後設定得到正確分數
			Player4Label.setFont(font3);
			Player4Label.setOpaque(true);//讓背景顏色可見
			Player4Label.setHorizontalAlignment(JLabel.CENTER);
			Player4Label.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
			Player4Label.setSize(40,20);
			Player4Label.setLocation(220,25);
			jp2.add(Player4Label);
			
			
			Player4scoreLabel.setText(String.valueOf(p4.getFraction()));
			Player4scoreLabel.setFont(font2);
			Player4scoreLabel.setOpaque(true);//讓背景顏色可見
			Player4scoreLabel.setHorizontalAlignment(JLabel.CENTER);
			Player4scoreLabel.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
			Player4scoreLabel.setBackground(Color.GREEN);
			Player4scoreLabel.setSize(40,40);
			Player4scoreLabel.setLocation(220,50);
			jp2.add(Player4scoreLabel);
		}
		/////////////////////////
		timer=new Timer(1000, new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("已記錄得分--來自ScoreBoard提醒");
        		Player1scoreLabel.setText(String.valueOf(p1.getFraction()));
        		Player2scoreLabel.setText(String.valueOf(p2.getFraction()));
        		Player3scoreLabel.setText(String.valueOf(p3.getFraction()));
            	Player4scoreLabel.setText(String.valueOf(p4.getFraction()));
            	timer.stop();
            }
		});
		/////////////////////////
          jp2.setFocusable(true);//增加焦點。
           jp2.requestFocusInWindow();
		return jp2;
	}
	public void setScore(Player p1,Player p2,Player p3,Player p4) {
		this.p1=p1;
		this.p2=p1;
		this.p3=p1;
		this.p4=p1;
	}
	public void setScore(int p1,int p2,int p3,int p4) {
		this.p1.setFraction(p1);
		this.p2.setFraction(p2);
		this.p3.setFraction(p3);
		this.p4.setFraction(p4);
	}
	@Override
	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}



	