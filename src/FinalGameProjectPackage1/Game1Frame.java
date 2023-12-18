package FinalGameProjectPackage1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game1Frame extends Information{
	private JFrame game=new JFrame(getGameName());
	private JLabel winnerBoard = new JLabel();
	private boolean p1Press=false;
    private boolean p2Press=false;
    private boolean p3Press=false;
    private boolean p4Press=false;

	private Timer timer;
	private double times=0;
	public String getGameName() {
		// TODO Auto-generated method stub
		return "讀秒王";
	}
	public Game1Frame() {
	}
	public Game1Frame(int playplayerNumber) {
		this.playerNumber=playplayerNumber;
		
	}
	public void openFrame(int playplayerNumber) {
		/////////初始化//////////////
		times=0;
		p1Press=false;
	    p2Press=false;
	    p3Press=false;
	    p4Press=false;
		GameOver=false;
		///////////////////////
		this.playerNumber=playplayerNumber;
		System.out.println("進入game1人數:"+playerNumber);
		game.setSize(new Dimension(800,600));
		game.setLayout(null); //格式設定
		game.setContentPane(getGame1Panel());
		
		///////////////////關閉感應///////////////////////
		WindowAdapter windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("點擊關閉按鈕--來自--"+getGameName());
                //
                
                //
                game.dispose();
            }
        };
        // 移除之前的监听器
        for (WindowListener listener : game.getWindowListeners()) {
        	game.removeWindowListener(listener);
        }
        // 添加窗口关闭事件监听器
        game.addWindowListener(windowAdapter);
        /////////////////////////////////////////////////////////
        
		game.setLocation(200,0);//從視窗中跳出
		game.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		game.setVisible(true);
	}
	
	@Override
	public boolean isOpenFrame() {
		// TODO Auto-generated method stub
		if(game.isVisible()) {
			return true;
		}
		return false;
	}
	
	public JPanel getGame1Panel() {
		JPanel panel=new JPanel();
		
		panel.setLayout(null);
		JLabel title=new JLabel(getGameName());
		JLabel text =new JLabel("遊戲規則:計時 20 秒，最接近 10 秒按下的獲勝");
		JLabel hint =new JLabel("press the-> p1 (S) , p2 (H) , p3 (L) , p4 (5)");
		JLabel text2 =new JLabel("按下 space 開始");
		JLabel text3 =new JLabel("會倒數 3 秒");
		hint.setFont(font2);
		/////////////標籤title///////////////
		title.setFont(font);
		title.setSize(200,50);//標籤(x,y)
		title.setLocation(350,50); //位置(x,y)
		panel.add(title);
		////////////////標籤text///////////////////
		text.setFont(font2);
		text.setSize(600,50);//標籤寬長(x,y)
		text.setLocation(120,90); //位置(x,y)
		panel.add(text);
		////////////////標籤hint///////////////////
		hint.setFont(font2);
		hint.setSize(500,50);//標籤寬長(x,y)
		hint.setLocation(140,130); //位置(x,y)
		panel.add(hint);
		////////////////標籤text2///////////////////
		text2.setFont(font);
		text2.setSize(600,50);//標籤寬長(x,y)
		text2.setLocation(280,400); //位置(x,y)
		panel.add(text2);
		////////////////標籤text3///////////////////
		text3.setFont(font2);
		text3.setSize(600,50);//標籤寬長(x,y)
		text3.setLocation(330,430); //位置(x,y)
		panel.add(text3);
		/////////////滑鼠監聽////////////
		panel.addMouseListener(new MouseAdapter() {//滑鼠監聽確認座標軸
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(); // 獲取x
                int y = e.getY(); // 獲取y
                System.out.println("Mouse Clicked at: " + x + ", " + y);
            }
        });	
		
		
		//////////////////////////////////
		JLabel p1board = new JLabel("p1已按下");
		p1board.setFont(font2);
		p1board.setOpaque(true);//讓背景顏色可見
		p1board.setSize(200,50);//標籤(x,y)
		p1board.setLocation(0,230); //位置(x,y)
		p1board.setBackground(Color.ORANGE);
		p1board.setHorizontalAlignment(JLabel.CENTER);
		p1board.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		p1board.setVisible(false); // 先藏起來
		panel.add(p1board);
		///////////////////////////////////////////////
		JLabel p2board = new JLabel("p2已按下");
		p2board.setFont(font2);
		p2board.setOpaque(true);//讓背景顏色可見
		p2board.setSize(200,50);//標籤(x,y)
		p2board.setLocation(600,230); //位置(x,y)
		p2board.setBackground(Color.YELLOW);
		p2board.setHorizontalAlignment(JLabel.CENTER);
		p2board.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		p2board.setVisible(false); // 先藏起來
		panel.add(p2board);
		////////////////////////////////////////////////
		JLabel p3board = new JLabel("p3已按下");
		p3board.setFont(font2);
		p3board.setOpaque(true);//讓背景顏色可見
		p3board.setSize(200,50);//標籤(x,y)
		p3board.setLocation(0,430); //位置(x,y)
		p3board.setBackground(Color.CYAN);
		p3board.setHorizontalAlignment(JLabel.CENTER);
		p3board.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		p3board.setVisible(false); // 先藏起來
		panel.add(p3board);
		////////////////////////////////////////////////
		JLabel p4board = new JLabel("p4已按下");
		p4board.setFont(font2);
		p4board.setOpaque(true);//讓背景顏色可見
		p4board.setSize(200,50);//標籤(x,y)
		p4board.setLocation(600,420); //位置(x,y)
		p4board.setBackground(Color.GREEN);
		p4board.setHorizontalAlignment(JLabel.CENTER);
		p4board.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		p4board.setVisible(false); // 先藏起來
		panel.add(p4board);
		////////////////////////////////////
		winnerBoard.setFont(font);
		winnerBoard.setSize(200,50);//標籤(x,y)
		winnerBoard.setLocation(300,200); //位置(x,y)
		winnerBoard.setHorizontalAlignment(JLabel.CENTER);
		winnerBoard.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		winnerBoard.setVisible(false); // 先藏起來
		panel.add(winnerBoard);
		/////////////////////////////////////////////
		JLabel timeLabel = new JLabel("TIME");
		timeLabel.setFont(font0);
		timeLabel.setSize(200,50);//標籤(x,y)
		timeLabel.setLocation(300,300); //位置(x,y)
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setVerticalAlignment(JLabel.CENTER);//水平垂直平衡
		panel.add(timeLabel);
		
        // 创建计时器，每1000毫秒（1秒）触发一次
        timer=new Timer(50, new ActionListener() {
            private double timercount = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(timercount>=23||allPress()) {//前三秒當倒數，所以最接近13秒獲勝
            		timeLabel.setText("遊戲終");
            		int s=(int)(p1.getWinKey()*100)/100-3;
            		int roundd=(int)(p1.getWinKey()*100)-s;
            		p1board.setText(""+s+"."+roundd+"s");
            		s=(int)(p2.getWinKey()*100)/100-3;//秒數
            		roundd=(int)(p2.getWinKey()*100)-s;//後兩位(取小數後兩位太麻煩)
            		p2board.setText(""+s+"."+roundd+"s");
            		s=(int)(p3.getWinKey()*100)/100-3;//秒數
            		roundd=(int)(p3.getWinKey()*100)-s;//後兩位(取小數後兩位太麻煩)
            		p3board.setText(""+s+"."+roundd+"s");
            		s=(int)(p4.getWinKey()*100)/100-3;//秒數
            		roundd=(int)(p4.getWinKey()*100)-s;//後兩位(取小數後兩位太麻煩)
            		p4board.setText(""+s+"."+roundd+"s");
            		GameOver=true;
            		getWinner();
            		getWinnerLabel();
            		stopTimer();
            		return;
            	}
            	timercount+=0.05;
            	if(timercount<=1) {
            		timeLabel.setText("3");
            	}else if(timercount<=2) {
            		timeLabel.setText("2");
            	}else if(timercount<=3) {
            		timeLabel.setText("1");
            		p1Press=false;
                    p2Press=false;
                    p3Press=false;
                    p4Press=false;
            	}else if(timercount<23) {
            		timeLabel.setText("計時中");
            		System.out.println(timercount-3);
            		times=timercount;
            	}
            }
        });
        
		panel.addKeyListener(new KeyListener(){
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char keyChar = e.getKeyChar();
				System.out.println(keyChar);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode =e.getKeyCode();
				System.out.print("按下了:"+keyCode);
				
				if(keyCode==83&&!p1Press && times>3) {//P1
					System.out.println("==P1==\n"+times);
					p1board.setVisible(true);
					p1.setWinKey(times);
					p1Press=true;
				}
				if(keyCode==72&&!p2Press&& times>3) {
					System.out.println("==P2==\n"+times);
					p2board.setVisible(true);
					p2.setWinKey(times);
					p2Press=true;
				}
				if(keyCode==76&&playerNumber>=3&&!p3Press&& times>3) {
					System.out.println("==P3==\n"+times);
					p3board.setVisible(true);
					p3.setWinKey(times);
					p3Press=true;
				}
				if(keyCode==101&&playerNumber>=4&&!p4Press&& times>3) {
					System.out.println("==P4==\n"+times);
					p4board.setVisible(true);
					p4.setWinKey(times);
					p4Press=true;
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE && !allPress()) {
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.setFocusable(true);//增加焦點。
		panel.requestFocusInWindow();
		return panel;
	}
	public void getWinner() {
		double[] A=new double[4];
		System.out.println("chack1="+p4.getWinKey());
		A[0]=Math.abs(13.0-p1.getWinKey());
		p1.setWinKey(A[0]);
		A[1]=Math.abs(13.0-p2.getWinKey());
		p2.setWinKey(A[1]);
		A[2]=Math.abs(13.0-p3.getWinKey());
		p3.setWinKey(A[2]);
		A[3]=Math.abs(13.0-p4.getWinKey());
		p4.setWinKey(A[3]);
		System.out.println("chack2="+p4.getWinKey());
		for(int i=0 ;i<7;i++) {
			for(int j=1;j<4;j++) {
				if(A[j-1]>A[j]) {
					double temp;
					temp=A[j-1];
					A[j-1]=A[j];
					A[j]=temp;
				}
			}
		}
		for(int j=1;j<=4;j++) {
			for(int k=0;k<4;k++) {
				if(p1.getWinKey()==A[j-1]&&k+j==playerNumber) {//用人數去判斷得分
					p1.setWinKey(j);
					p1.addFraction(k);
				}
				if(p2.getWinKey()==A[j-1]&&k+j==playerNumber) {
					p2.setWinKey(j);
					p2.addFraction(k);
				}
				if(p3.getWinKey()==A[j-1]&&k+j==playerNumber) {
					p3.setWinKey(j);
					p3.addFraction(k);
				}
				if(p4.getWinKey()==A[j-1]&&k+j==playerNumber) {
					p4.setWinKey(j);
					p4.addFraction(k);
					System.out.println("chack3="+p4.getWinKey());
				}
			}
		}
		System.out.println("p1第"+p1.getWinKey()
							+"\np2第"+p2.getWinKey()
							+"\np3第"+p3.getWinKey()
							+"\np4第"+p4.getWinKey());
	}
	public void getWinnerLabel(){
		if(p1.getWinKey()==1) {
			winnerBoard.setText("P1獲勝!");
			winnerBoard.setForeground(Color.ORANGE);
		}
		if(p2.getWinKey()==1) {
			winnerBoard.setText("P2獲勝!");
			winnerBoard.setForeground(Color.YELLOW);
		}
		if(p3.getWinKey()==1) {
			winnerBoard.setText("P3獲勝!");
			winnerBoard.setForeground(Color.CYAN);
		}
		if(p4.getWinKey()==1) {
			winnerBoard.setText("P4獲勝!");
			winnerBoard.setForeground(Color.GREEN);
		}
		winnerBoard.setVisible(true);
	}
	private void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
	public boolean allPress() {
		boolean gameOver=false;
		if(playerNumber==4&& p1Press && p2Press && p3Press&& p4Press) {
			gameOver=true;
		}else if(playerNumber==3 && p1Press&& p2Press&& p3Press) {
			gameOver=true;
		}else if(playerNumber==2 && p1Press && p2Press){
			gameOver=true;
		}
		return gameOver;
	}
	
	@Override
	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return GameOver;
	}
}
