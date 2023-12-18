package FinalGameProjectPackage1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends Information{
	JFrame frame=new JFrame(getGameName());
	Game1Frame game1=new Game1Frame(playerNumber);//讀秒王
	Game2Frame game2=new Game2Frame(playerNumber);//好朋友挑戰
	Game3Frame game3=new Game3Frame(playerNumber);//殺與閃
	ScoreBoard scoreBoard=new ScoreBoard(playerNumber);//記分板
	
	Timer timer;
	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "同歡會";
	}
	
	public Window() {
	}
	@Override
	public void openFrame(int playerNumber) {
		// TODO Auto-generated method stub
		this.playerNumber= playerNumber;
		System.out.println("進入window時PlayerNumer:"+playerNumber+"p1:");
		
		frame.setSize(new Dimension(300,500)); 
		frame.setLayout(null); //格式設定
		frame.add(getEnterPanel());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉全部視窗
		frame.setVisible(true);
		scoreBoard.openFrame(playerNumber);
	}
	
	@Override
	public boolean isOpenFrame() {
		// TODO Auto-generated method stub
		if(frame.isVisible()) {
			return true;
		}
		return false;
	}

	
	
	public JPanel getEnterPanel() {
		JPanel jpl = new JPanel();
		jpl.setSize(new Dimension(300,500)); 
		jpl.setLayout(null);
		
		JLabel title = new JLabel("遊戲清單"); 
		title.setFont(font);
		title.setSize(200,50);//標籤(x,y)
		title.setLocation(80,30); //位置(x,y)
		
		jpl.add(title); 
		
		JLabel reScoreBoard = new JLabel("重啟記分板"); 
		reScoreBoard.setFont(font4);
		reScoreBoard.setSize(200,50);//標籤(x,y)
		reScoreBoard.setLocation(125,430); //位置(x,y)
		jpl.add(reScoreBoard);
		
		
		jpl.addMouseListener(new MouseAdapter() {//滑鼠監聽確認座標軸
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int x = e.getX(); 
	                int y = e.getY(); 
	                System.out.println("Mouse Clicked at: " + x + ", " + y);
	                if(x>0&&y>450) {
	                	if(scoreBoard.isOpenFrame()) {
	                		System.out.println("記分板開著");
	                	}else {
	                		scoreBoard.openFrame(playerNumber);
	                		System.out.println("開啟記分板");
	                	}
	                }
	            }
	        });
		/////////////////////////////////////////////////////////////////////////////////////Game1Button////////////////
		JButton Game1Button=new JButton(game1.getGameName());
		Game1Button.setFont(font);
		Game1Button.setBackground(Color.YELLOW);
		Game1Button.setSize(200,60); //寬高
		Game1Button.setLocation(40,100); 
		Game1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(game1.isOpenFrame()) {
            		System.out.println(game1.getGameName()+"開著");
            	}else {
            		game1.openFrame(playerNumber);//開啟遊戲，給人數
            		game1.setPlayer(scoreBoard);//得到目前玩家訊息
            		System.out.println("開啟"+game1.getGameName());
            		timer.start();
            	}
				
			}
			
		});
		jpl.add(Game1Button);
		/////////////////////////////////////////////////////////////////////////////////////Game2Button////////////////
		JButton Game2Button=new JButton(game2.getGameName());
		Game2Button.setFont(font);
		Game2Button.setBackground(Color.ORANGE);
		Game2Button.setSize(200,60); //寬高
		Game2Button.setLocation(40,160); 
		Game2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(game2.isOpenFrame()) {
            		System.out.println(game2.getGameName()+"開著");
            	}else {
            		System.out.println("開啟"+game2.getGameName());
            		game2.openFrame(playerNumber);//開啟遊戲，給人數
            		game2.setPlayer(scoreBoard);//得到目前玩家訊息
            		timer.start();
            	}
				
			}
			
		});
		jpl.add(Game2Button);
		/////////////////////////////////////////////////////////////////////////////////////Game3Button////////////////
		JButton Game3Button=new JButton(game3.getGameName());
		Game3Button.setFont(font);
		Game3Button.setBackground(Color.CYAN);
		Game3Button.setSize(200,60); //寬高
		Game3Button.setLocation(40,220); 
		Game3Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(game3.isOpenFrame()) {
            		System.out.println(game3.getGameName()+"開著");
            	}else {
            		System.out.println("開啟"+game3.getGameName());
            		game3.openFrame(playerNumber);//開啟遊戲，給人數
            		game3.setPlayer(scoreBoard);//得到目前玩家訊息
            		timer.start();
            	}
				
			}
			
		});
		jpl.add(Game3Button);
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton Game4Button=new JButton("待續");
		Game4Button.setFont(font);
		Game4Button.setBackground(Color.LIGHT_GRAY);
		Game4Button.setSize(200,60); //寬高
		Game4Button.setLocation(40,280); 
		Game4Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "施工中");
				
			}
			
		});
		jpl.add(Game4Button);
		/////////////////////////////////////////////////////////////////////////////////////timer////////////////
		timer=new Timer(1000, new ActionListener() {  
			@Override
			public void actionPerformed(ActionEvent e) {
				if(game1.getGameOver()) {
					scoreBoard.setPlayer(game1);
					scoreBoard.timer.start();
					timer.stop();
				}
				if(game2.getGameOver()) {
					scoreBoard.setPlayer(game2);
					scoreBoard.timer.start();
					if(!game2.isOpenFrame()) {
						timer.stop();
					}
				}
				if(game3.getGameOver()) {
					scoreBoard.setPlayer(game3);
					scoreBoard.timer.start();
					if(!game2.isOpenFrame()) {
						timer.stop();
					}
				}
			}
		});
/////////////////////////
		jpl.setFocusable(true);//增加焦點。
		jpl.requestFocusInWindow();
		
		return jpl;
	}
	//////////////////獲得得分資訊//////////////////

	@Override
	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return false;
	}
	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			    @Override
			    public void run() {
			    	PlayerNumberFrame playerNumberFrame=new PlayerNumberFrame();//人數
			    	playerNumberFrame.openFrame();
			    	
			    }
			});
	 }
}
//actionPerformed:gui元件發生動作觸發感應