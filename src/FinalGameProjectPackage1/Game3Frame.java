package FinalGameProjectPackage1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game3Frame extends Information {
	private JFrame game = new JFrame(getGameName());
	private int Alive = playerNumber;// 存活人數
	private Player Winner = new Player();
	private boolean roundOver = false;
	private Timer timer;
	private int timess = 3;
	private boolean first=true;
	private Player[] defect=new Player[4];
	public Game3Frame(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "殺與閃";
	}

	public void openPlayer() {
		p1.setWinKey(3.0);// 當作血條
		p2.setWinKey(3.0);
		p3.setWinKey(3.0);
		p4.setWinKey(3.0);
	}

	@Override
	public void openFrame(int playerNumber) {
		// TODO Auto-generated method stub
/////////////////////////////////////////////////////////////////////////////////////////////////////初始化/////////////////////////////////
		Alive = playerNumber;
		GameOver = false;
		InfPlayerReset();
		openPlayer();
//////////////////////////////////
		this.playerNumber = playerNumber;
		System.out.println("進入" + getGameName() + "人數:" + playerNumber);
		System.out.println("hp:" + p1.getWinKey());
		game.setSize(new Dimension(800, 600));
		game.setLayout(null); // 格式設定
		game.setContentPane(getGamePanel());
		WindowAdapter windowAdapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("點擊關閉按鈕--來自--" + getGameName());
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

		game.setLocation(200, 0);// 從視窗中跳出
		game.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		game.setVisible(true);
	}

	@Override
	public boolean isOpenFrame() {
		if (game.isVisible()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getGameOver() {
		return GameOver;
	}

	public JPanel getGamePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel title = new JLabel(getGameName());
		JLabel text = new JLabel("遊戲規則:" + "每人三條命，殺中-2血，沒被殺卻閃-1血,");
		JLabel hint = new JLabel("時間內都沒點就不動作。玩家(HP)(殺)(閃)");
		JLabel text2 = new JLabel("閃避三次加血");
		JLabel questionLabel = new JLabel();
		/////////////// 標籤title///////////////
		title.setFont(font);
		title.setSize(200, 50);// 標籤(x,y)
		title.setLocation(300, 50); // 位置(x,y)
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(title);

		////////////////////////////////////////////////////////////////////////////////////// 標籤text///////////////////
		text.setFont(font2);
		text.setSize(700, 50);// 標籤寬長(x,y)
		text.setLocation(55, 90); // 位置(x,y)
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(text);
		////////////////////////////////////////////////////////////////////////////////// 標籤hint////////////////
		hint.setFont(font2);
		hint.setSize(600, 50);// 標籤寬長(x,y)
		hint.setLocation(60, 130); // 位置(x,y)
		hint.setHorizontalAlignment(JLabel.CENTER);
		hint.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(hint);
		////////////////////////////////////////////////////////////////////////////////////// 標籤text2///////////////////
		text2.setFont(font3);
		text2.setSize(600, 50);// 標籤寬長(x,y)
		text2.setLocation(340, 400); // 位置(x,y)
		panel.add(text2);
//////////////////////////////////////////////////////////////////////////////////標籤hint2////////////////
		JLabel hint2 = new JLabel("計時");
		hint2.setFont(font2);
		hint2.setSize(600, 50);// 標籤寬長(x,y)
		hint2.setLocation(85, 130); // 位置(x,y)
		hint2.setHorizontalAlignment(JLabel.CENTER);
		hint2.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		hint2.setVisible(false);
		panel.add(hint2);
//////////////////////////////////////////////////////////////////////////////////////標籤text3///////////////////
		JLabel text3 = new JLabel("");
		text3.setFont(font3);
		text3.setSize(600, 50);// 標籤寬長(x,y)
		text3.setLocation(300, 400); // 位置(x,y)
		text3.setVisible(false);
		panel.add(text3);
		////////////////////////////////////////////////////////////////////////////////// questionLabel//////////////////////
		questionLabel.setFont(font);
		questionLabel.setSize(700, 50);// 標籤(x,y)
		questionLabel.setLocation(40, 300); // 位置(x,y)
		questionLabel.setHorizontalAlignment(JLabel.CENTER);
		questionLabel.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(questionLabel);
/////////////////////////////////////////////////////////////////////////////////////p1board/////////////////
		JLabel p1board = new JLabel();
		p1board.setText("P1(" + (int) p1.getWinKey() + ")(A)(S)");
		p1board.setFont(font2);
		p1board.setOpaque(true);// 讓背景顏色可見
		p1board.setSize(200, 50);// 標籤(x,y)
		p1board.setLocation(0, 230); // 位置(x,y)
		p1board.setBackground(Color.ORANGE);
		p1board.setHorizontalAlignment(JLabel.CENTER);
		p1board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p1board.setVisible(false); // 先藏起來
		panel.add(p1board);
///////////////////////////////////////////////////////////////////////////////////////p2board////////////////////////////
		JLabel p2board = new JLabel();
		p2board.setText("P2(" + (int) p2.getWinKey() + ")(G)(H)");
		p2board.setFont(font2);
		p2board.setOpaque(true);// 讓背景顏色可見
		p2board.setSize(200, 50);// 標籤(x,y)
		p2board.setLocation(590, 230); // 位置(x,y)
		p2board.setBackground(Color.YELLOW);
		p2board.setHorizontalAlignment(JLabel.CENTER);
		p2board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p2board.setVisible(false); // 先藏起來
		panel.add(p2board);
////////////////////////////////////////////////////////////////////////////////////////p3board////////////////////////////
		JLabel p3board = new JLabel();
		p3board.setText("P3(" + (int) p3.getWinKey() + ")(;)(')");
		p3board.setFont(font2);
		p3board.setOpaque(true);// 讓背景顏色可見
		p3board.setSize(200, 50);// 標籤(x,y)
		p3board.setLocation(0, 320); // 位置(x,y)
		p3board.setBackground(Color.CYAN);
		p3board.setHorizontalAlignment(JLabel.CENTER);
		p3board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p3board.setVisible(false); // 先藏起來

////////////////////////////////////////////////////////////////////////////////////////p4board ////////////////////////////
		JLabel p4board = new JLabel();
		p4board.setText("P4(" + (int) p4.getWinKey() + ")(1)(3)");
		p4board.setFont(font2);
		p4board.setOpaque(true);// 讓背景顏色可見
		p4board.setSize(200, 50);// 標籤(x,y)
		p4board.setLocation(590, 320); // 位置(x,y)
		p4board.setBackground(Color.GREEN);
		p4board.setHorizontalAlignment(JLabel.CENTER);
		p4board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p4board.setVisible(false); // 先藏起來

		////////////////////////////////////////////////////////////////////////////////// startbutton
		JButton start = new JButton("START");
		start.setSize(200, 100); // 寬高
		start.setLocation(300, 300);
		start.setFont(font);
		start.setBackground(Color.ORANGE);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				///////////////////////////
				GameOver=false;
				Alive = playerNumber;
				GameOver = false;
				InfPlayerReset();
				openPlayer();
				p4board.setText("P4(" + (int) p4.getWinKey() + ")(1)(3)");
				p3board.setText("P3(" + (int) p3.getWinKey() + ")(;)(')");
				p2board.setText("P2(" + (int) p2.getWinKey() + ")(G)(H)");
				p1board.setText("P1(" + (int) p1.getWinKey() + ")(A)(S)");

				/////////////////////////
				text2.setVisible(false);
				text.setVisible(false);
				hint.setVisible(false);
				hint2.setVisible(true);
				text3.setVisible(true);
				p1board.setVisible(true);
				p2board.setVisible(true);
				if (playerNumber > 2) {
					p3board.setVisible(true);
					panel.add(p3board);
				}
				if (playerNumber > 3) {
					p4board.setVisible(true);
					panel.add(p4board);
				}
				start.setVisible(false);

				timer.start();
			}
		});
		start.setVisible(true);
		panel.add(start);
		/////////////////////////////////////////////////////////////////////////////// p1ToP2//////////////////////
		JLabel p1ToP2 = new JLabel("遊戲以順時針攻擊(P1->P2)");
		p1ToP2.setFont(font3);
		p1ToP2.setSize(350, 50);// 標籤(x,y)
		p1ToP2.setLocation(280, 470); // 位置(x,y)
		p1ToP2.setVisible(true); // 先藏起來
		panel.add(p1ToP2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////鍵值監聽///////////////////////
		panel.addKeyListener(new KeyListener() {
			@Override

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				System.out.print("按下了:" + keyCode);
				// TODO Auto-generated method stub
				//////////////////////////////////////////////////////////////////////////////////////////////////// 按壓
////////////////////////////////////////////////////////////////////////////////////////////////// 玩家1
				if ((keyCode == 65 || keyCode == 83) && !roundOver&&p1.getWinKey()>0) {

					if (keyCode == 65) {
						p1.setAnsKey(1);// 1是攻擊2是閃避
					}
					if (keyCode == 83) {
						p1.setAnsKey(2);// 1是攻擊2是閃避
					}

					p1board.setText("P1已選擇");
					p1.setIsOver(true);
					setPlayer(p1);
				}
////////////////////////////////////////////////////////////////////////////////////////////////////// 玩家2
				if ((keyCode == 71 || keyCode == 72) && !roundOver&&p2.getWinKey()>0) {
					if (keyCode == 71) {
						p2.setAnsKey(1);// 1是攻擊2是閃避
					}
					if (keyCode == 72) {
						p2.setAnsKey(2);// 1是攻擊2是閃避
					}

					p2board.setText("P2已選擇");
					p2.setIsOver(true);
					setPlayer(p2);
				}
//////////////////////////////////////////////////////////////////////////////////////////////////////// 玩家3
				if ((keyCode == 59 || keyCode == 222) && playerNumber > 2 && !roundOver&&p3.getWinKey()>0) {
					if (keyCode == 59) {
						p3.setAnsKey(1);// 1是攻擊2是閃避
					}
					if (keyCode == 222) {
						p3.setAnsKey(2);// 1是攻擊2是閃避
					}

					p3board.setText("P3已選擇");
					p3.setIsOver(true);
					setPlayer(p3);
				}
////////////////////////////////////////////////////////////////////////////////////////////////////////// 玩家4			
				if ((keyCode == 97 || keyCode == 99) && playerNumber > 3 && !roundOver&&p4.getWinKey()>0) {
					if (keyCode == 97) {
						p4.setAnsKey(1);// 1是攻擊2是閃避
					}
					if (keyCode == 99) {
						p4.setAnsKey(2);// 1是攻擊2是閃避
					}

					p4board.setText("P4已選擇");
					p4.setIsOver(true);
					setPlayer(p4);
				}
//////////////////////////////////////////////////////////////////////////////////////////////////////////按Enter
				if (keyCode == 10 && roundOver) {
					getPlayer(p1);
					getPlayer(p2);
					getPlayer(p3);
					getPlayer(p4);
					roundOver = false;

					if (Alive == 0) {
						hint2.setText("都死了和局，按start重來");
						openPlayer();
						p4board.setVisible(false);
						p3board.setVisible(false);
						p2board.setVisible(false);
						p1board.setVisible(false);
						start.setVisible(true);
					} else if (Alive == 1) {
						p4board.setVisible(false);
						p3board.setVisible(false);
						p2board.setVisible(false);
						p1board.setVisible(false);
						text3.setText("留多少血，得多少分!");
						hint2.setText("贏家是" + Winner.getName());
						Winner.addFraction((int) Winner.getWinKey());
						GameOver=true;
					} else {
						p4board.setText("P4(" + (int) p4.getWinKey() + ")(1)(3)");
						p3board.setText("P3(" + (int) p3.getWinKey() + ")(;)(')");
						p2board.setText("P2(" + (int) p2.getWinKey() + ")(G)(H)");
						p1board.setText("P1(" + (int) p1.getWinKey() + ")(A)(S)");

						//////////////////////////////////////////////// 判斷死亡
						if (p1.getWinKey() <= 0) {
							p1board.setText("P1已死亡");
							p1board.setVisible(false);
						} else {
							p1.setIsOver(false);
						}
						if (p2.getWinKey() <= 0) {
							p2board.setText("P2已死亡");
							p2board.setVisible(false);
						} else {
							p2.setIsOver(false);
						}
						if (p3.getWinKey() <= 0) {
							p3board.setText("P3已死亡");
							p3board.setVisible(false);
						} else {
							p3.setIsOver(false);
						}
						if (p4.getWinKey() <= 0) {
							p4board.setText("P4已死亡");
							p4board.setVisible(false);
						} else {
							p4.setIsOver(false);
						}
						timer.start();
					}

				}

////////////////////////////////////////////////////////////////////////////////////////////////////////////判斷贏家

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		timer = new Timer(500, new ActionListener() {
			private double timercount = 3.0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (timercount <= 0) {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////開局給值
					if (p1.getStart()) {
						p1.setStart(false);
						p1.setWinKey(3);
					}
					if (p2.getStart()) {
						p2.setStart(false);
						p2.setWinKey(3);
					}
					if (p3.getStart()) {
						p3.setStart(false);
						p3.setWinKey(3);
					}
					if (p4.getStart()) {
						p4.setStart(false);
						p4.setWinKey(3);
					}
					AttactkWho();
					setPlayer(p1);
					setPlayer(p2);
					setPlayer(p3);
					setPlayer(p4);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////回合結束
					System.out.println("p1.getAnsKey():" + p1.getAnsKey());
					roundOver = true;
					timer.stop();
					timercount = 3;
					text3.setText("時間到");
					hint2.setText("按Enter繼續");
					System.out.println("選擇結束");
					p1board.setText("P1選擇" + attackOrRun(p1) + " HP:" + (int) p1.getWinKey());
					p2board.setText("P2選擇" + attackOrRun(p2) + " HP:" + (int) p2.getWinKey());
					text3.setText("");
					hint2.setText("按Enter繼續");
					if (playerNumber > 2) {
						p3board.setText("P3選擇" + attackOrRun(p3) + " HP:" + (int) p3.getWinKey());
					}

					if (playerNumber > 3) {
						p4board.setText("P4選擇" + attackOrRun(p4) + " HP:" + (int) p4.getWinKey());
					}
						
				} else {////////////////////////////////////////////////////////////////////////////// 計時時
					getPlayer(p1);
					getPlayer(p2);
					getPlayer(p3);
					getPlayer(p4);

					text3.setText("               計時中");
					hint2.setText("      " + (int) (timercount + 0.8));
					timercount -= 0.5;
					timess = (int) timercount;

					if (playerNumber > 3 && p1.getIsOver() && p2.getIsOver() && p3.getIsOver() && p4.getIsOver()) {
						timercount = 0;
					} else if (playerNumber > 2 && p1.getIsOver() && p2.getIsOver() && p3.getIsOver()) {
						timercount = 0;
					} else if (playerNumber == 2 && p1.getIsOver() && p2.getIsOver()) {
						timercount = 0;
						System.out.println("都按了------------------------------------");
					}
				}
			}
		});
		///////////////////////////////
		panel.setFocusable(true);// 增加焦點。
		panel.requestFocusInWindow();

		return panel;
	}

	public void setPlayer(Player player) {
		if (player.getName() == p1.getName())
			p1 = player;
		if (player.getName() == p2.getName())
			p2 = player;
		if (player.getName() == p3.getName())
			p3 = player;
		if (player.getName() == p4.getName())
			p4 = player;
	}

	public Player getPlayer(Player player) {
		if (player.getName() == p1.getName())
			player = p1;
		if (player.getName() == p2.getName())
			player = p2;
		if (player.getName() == p3.getName())
			player = p3;
		if (player.getName() == p4.getName())
			player = p4;
		// System.out.println("已拿走"+player.getName());
		return player;
	}

	public void AttactkWho() {
		// win key=0死亡,順時針 p1-p2-p4-p3-p1...
		// 0永遠存在，作為最後勝利者
		if(first) {
			defect[0] = p1;
			defect[1] = p2;
			if (playerNumber > 3) {
				defect[2] = p4;
				defect[3] = p3;
			} else if (playerNumber > 2) {
				defect[2] = p3;
			}
			first=false;
		}
		
		for (int i = 0; i < Alive; i++) {
			if (!defect[i].getIsOver()) {
				System.out.println("進來了@!!!!!!!!!!!!");
				defect[i].setAnsKey(0);
				continue;
			}
			free(defect[i]);
			System.out.println("ALIVE IS:" + Alive + " I is" + i);
			if (defect[i].getWinKey() <= 0) {
				defect[i].setWinKey(0);
			}
			if (i == Alive - 1) {
				if (defect[Alive - 1].getAnsKey() == 1 && defect[0].getAnsKey() != 2) {// 前者攻擊後者沒閃//最後跟第一個判斷
					defect[0].setWinKey(defect[0].getWinKey() - 2);// 後者-2
					System.out.println(defect[0].getName() + "受" + defect[Alive - 1].getName() + "攻擊剩下hp:"
							+ defect[0].getWinKey());
				} else if (defect[Alive - 1].getAnsKey() != 1 && defect[0].getAnsKey() == 2) {// 前者沒攻擊後者閃
					defect[0].setWinKey(defect[0].getWinKey() - 1);// 後者-1
					System.out.println(defect[0].getName() + "失誤閃避hp:" + defect[0].getWinKey());
				}
			} else {
				if (defect[i].getAnsKey() == 1 && defect[i + 1].getAnsKey() != 2) {// 前者攻擊後者沒閃
					defect[i + 1].setWinKey(defect[i + 1].getWinKey() - 2);// 後者-2
					System.out.println(defect[i + 1].getName() + "受" + defect[i].getName() + "攻擊剩下hp:"
							+ defect[i + 1].getWinKey());
				} else if (defect[i].getAnsKey() != 1 && defect[i + 1].getAnsKey() == 2) {// 前者沒攻擊後者閃
					defect[i + 1].setWinKey(defect[i + 1].getWinKey() - 1);// 後者-1
					System.out.println(defect[i + 1].getName() + "失誤閃避剩下hp:" + defect[i + 1].getWinKey());
				}
			}

		}
		for (int i = 0; i < Alive; i++) {// 留下活著的人
			System.out.println(defect[i].getName() + " hp:" + defect[i].getWinKey());
			if (defect[i].getWinKey() <= 0) {// 將已死亡丟掉
				defect[i].setWinKey(0);
				System.out.println(defect[i].getName() + "已死亡");
				defect[i].setIsOver(true);
				for(int j=Alive;j>0;j--) {
					if (defect[j-1].getWinKey()!=0) {// 如果第j個沒死，將活著的往前擺
						defect[i]=defect[Alive-1];
					}
				}
				Alive --;
			}
			System.out.println("defect[" + i + "]=" + defect[i].getName()+"   defect[" + i + "].getwinkey="+defect[i].getWinKey());
			System.out.println("----------------------------------------------------");
		}
		
		System.out.println("Alive=" + Alive);
		if (Alive == 0) {
			System.out.println("都死了");
		}
		if (Alive == 1) {
			Winner = defect[0];
			System.out.println("遊戲結束");
		}
	}

	public String attackOrRun(Player player) {
		if (player.getAnsKey() == 1) {
			return "殺";
		} else if (player.getAnsKey() == 2) {
			return "閃";
		}
		return "停";
	}

	public void free(Player play) {
		if (play.getAnsKey() == 2) {
			play.setOtherKey(play.getOtherKey() + 1);
		}
		if (play.getAnsKey() == 1) {
			play.setOtherKey(0);
		}
		if (play.getOtherKey() == 3) {
			System.out.println("獲得福利!");
			play.setWinKey(play.getWinKey() + 1);
			play.setOtherKey(0);
		}
	}

}
