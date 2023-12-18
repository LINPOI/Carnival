package FinalGameProjectPackage1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Game2Frame extends Information {
	private JFrame game = new JFrame(getGameName());
	private Random random = new Random();
	private int playWho = 0;
	private boolean isSelect = false;
	private boolean isStrat = false;
	private Player questioner = null;
	private String IconName = "E:/FinalGameProject/reset.jpg";// 設定圖片位置

	public Game2Frame() {

	}

	public Game2Frame(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	@Override
	public String getGameName() {
		return "好朋友挑戰";
	}

	@Override
	public void openFrame(int playerNumber) {
		///////////////////////////////////
		GameOver = false;
		random = new Random();
		playWho = 0;
		isSelect = false;
		isStrat = false;
		questioner = null;
		InfPlayerReset();
		//////////////////////////////////
		this.playerNumber = playerNumber;
		System.out.println("進入" + getGameName() + "人數:" + playerNumber);
		game.setSize(new Dimension(800, 600));
		game.setLayout(null); // 格式設定
		game.setContentPane(getGamePanel());

		/////////////////// 關閉感應///////////////////////
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

	public JPanel getGamePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel title = new JLabel(getGameName());
		JLabel text = new JLabel("遊戲規則:" + "根據問題玩家提供是與否");
		JLabel hint = new JLabel("提供答案者按1或2代表是否，其餘則按按鈕");
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
		text.setSize(600, 50);// 標籤寬長(x,y)
		text.setLocation(170, 90); // 位置(x,y)
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(text);
		////////////////////////////////////////////////////////////////////////////////// 標籤hint////////////////
		hint.setFont(font2);
		hint.setSize(600, 50);// 標籤寬長(x,y)
		hint.setLocation(80, 130); // 位置(x,y)
		hint.setHorizontalAlignment(JLabel.CENTER);
		hint.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(hint);
		////////////////////////////////////////////////////////////////////////////////// questionLabel//////////////////////
		questionLabel.setFont(font);
		questionLabel.setSize(700, 50);// 標籤(x,y)
		questionLabel.setLocation(40, 300); // 位置(x,y)
		questionLabel.setHorizontalAlignment(JLabel.CENTER);
		questionLabel.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		panel.add(questionLabel);
/////////////////////////////////////////////////////////////////////////////////////p1board/////////////////
		JLabel p1board = new JLabel();
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
		p2board.setFont(font2);
		p2board.setOpaque(true);// 讓背景顏色可見
		p2board.setSize(200, 50);// 標籤(x,y)
		p2board.setLocation(600, 230); // 位置(x,y)
		p2board.setBackground(Color.YELLOW);
		p2board.setHorizontalAlignment(JLabel.CENTER);
		p2board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p2board.setVisible(false); // 先藏起來
		panel.add(p2board);
////////////////////////////////////////////////////////////////////////////////////////p3board////////////////////////////
		JLabel p3board = new JLabel();
		p3board.setFont(font2);
		p3board.setOpaque(true);// 讓背景顏色可見
		p3board.setSize(200, 50);// 標籤(x,y)
		p3board.setLocation(0, 430); // 位置(x,y)
		p3board.setBackground(Color.CYAN);
		p3board.setHorizontalAlignment(JLabel.CENTER);
		p3board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p3board.setVisible(false); // 先藏起來
		panel.add(p3board);
////////////////////////////////////////////////////////////////////////////////////////p4board ////////////////////////////
		JLabel p4board = new JLabel();
		p4board.setFont(font2);
		p4board.setOpaque(true);// 讓背景顏色可見
		p4board.setSize(200, 50);// 標籤(x,y)
		p4board.setLocation(600, 420); // 位置(x,y)
		p4board.setBackground(Color.GREEN);
		p4board.setHorizontalAlignment(JLabel.CENTER);
		p4board.setVerticalAlignment(JLabel.CENTER);// 水平垂直平衡
		p4board.setVisible(false); // 先藏起來
		panel.add(p4board);
/////////////////////////////////////////////////////////////////////////////////////////setButton///////////////////////////////////
		JButton YES = new JButton("YES");
		JButton NO = new JButton("NO");
		JButton Start = new JButton("Start");
		JButton reStart = new JButton();
/////////////////////////////////////////////////////////////////////////////////// ButtonYES///////////////////

		YES.setFocusPainted(false);
		YES.setFont(font);
		YES.setBackground(Color.ORANGE);
		YES.setSize(100, 60); // 寬高
		YES.setLocation(200, 450);
		YES.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					playWhoPlayer().setAnsKey(1);
					System.out.println(playWhoPlayer().getName() + "選擇YES");
					playWhoPlayer().setIsOver(true);
					playWho++;
					hint.setText(playWhoPlayer().getName() + "請選擇");
				} catch (Exception ex) {
					System.out.println("猜題結束");
					questionLabel.setVisible(false);
					hint.setText("正確答案為:" + select((int) questioner.getAnsKey()));
					YES.setVisible(false);
					NO.setVisible(false);
					p1board.setVisible(true);
					p2board.setVisible(true);
					reStart.setVisible(true);
					String Scoreup = "";
					if (questioner.getAnsKey() == p1.getAnsKey() && questioner != p1) {
						Scoreup = "+1";
						p1.addFraction(1);
					} else
						Scoreup = "";
					p1board.setText(p1.getName() + "選擇:" + select((int) p1.getAnsKey()) + Scoreup);
					if (questioner.getAnsKey() == p2.getAnsKey() && questioner != p2) {
						Scoreup = "+1";
						p2.addFraction(1);
					} else
						Scoreup = "";
					p2board.setText(p2.getName() + "選擇:" + select((int) p2.getAnsKey()) + Scoreup);
					if (playerNumber > 2) {
						if (questioner.getAnsKey() == p3.getAnsKey() && questioner != p3) {
							Scoreup = "+1";
							p3.addFraction(1);
						} else
							Scoreup = "";
						p3board.setText(p3.getName() + "選擇:" + select((int) p3.getAnsKey()) + Scoreup);
						p3board.setVisible(true);
					}
					if (playerNumber > 3) {
						if (questioner.getAnsKey() == p4.getAnsKey() && questioner != p4) {
							Scoreup = "+1";
							p4.addFraction(1);
						} else
							Scoreup = "";
						p4board.setText(p4.getName() + "選擇:" + select((int) p4.getAnsKey()) + Scoreup);
						p4board.setVisible(true);
					}
					GameOver = true;
				}

			}

		});
		YES.setVisible(false);
		panel.add(YES);
		/////////////////////////////////////////////////////////////////////////////////////// ButtonNO//////////////////////////
		NO.setFocusPainted(false);// 選擇時不顯示小方框
		NO.setFont(font);
		NO.setBackground(Color.MAGENTA);
		NO.setSize(100, 60); // 寬高
		NO.setLocation(500, 450);
		NO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					playWhoPlayer().setAnsKey(2);
					System.out.println(playWhoPlayer().getName() + "選擇NO");
					playWhoPlayer().setIsOver(true);
					playWho++;
					hint.setText(playWhoPlayer().getName() + "請選擇");
				} catch (Exception ex) {
					System.out.println("猜題結束");
					hint.setText(questioner.getName() + "的答案為:" + select((int) questioner.getAnsKey()));

					questionLabel.setVisible(false);
					YES.setVisible(false);
					NO.setVisible(false);
					p1board.setVisible(true);
					p2board.setVisible(true);
					reStart.setVisible(true);
					String Scoreup = "";
					if (questioner.getAnsKey() == p1.getAnsKey() && questioner != p1) {
						Scoreup = "+1";
						p1.addFraction(1);
					} else
						Scoreup = "";
					p1board.setText(p1.getName() + "選擇:" + select((int) p1.getAnsKey()) + Scoreup);
					if (questioner.getAnsKey() == p2.getAnsKey() && questioner != p2) {
						Scoreup = "+1";
						p2.addFraction(1);
					} else
						Scoreup = "";
					p2board.setText(p2.getName() + "選擇:" + select((int) p2.getAnsKey()) + Scoreup);
					if (playerNumber > 2) {
						if (questioner.getAnsKey() == p3.getAnsKey() && questioner != p3) {
							Scoreup = "+1";
							p3.addFraction(1);
						} else
							Scoreup = "";
						p3board.setText(p3.getName() + "選擇:" + select((int) p3.getAnsKey()) + Scoreup);
						p3board.setVisible(true);
					}
					if (playerNumber > 3) {
						if (questioner.getAnsKey() == p4.getAnsKey() && questioner != p4) {
							Scoreup = "+1";
							p4.addFraction(1);
						} else
							Scoreup = "";
						p4board.setText(p4.getName() + "選擇:" + select((int) p4.getAnsKey()) + Scoreup);
						p4board.setVisible(true);
					}
					GameOver = true;

				}

			}

		});
		NO.setVisible(false);
		panel.add(NO);
		//////////////////////////////////////////////////////////////////////////////////////////// stratbutton////////////////////////////

		Start.setFont(font0);
		Start.setBackground(Color.PINK);
		Start.setSize(200, 150); // 寬高
		Start.setLocation(300, 300);
		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Start.setVisible(false);
				// System.out.println(question());
				questionLabel.setText(question());
				hint.setText(playWhoPlayer().getName() + "請先按按鍵選擇答案1(是)2(否)");
				isStrat = true;
			}

		});
		Start.setVisible(true);
		panel.add(Start);
		///////////////////////////////////////////////////////////////////////////////////////// reStartButton//////////////////////////

		reStart.setSize(100, 100); // 寬高
		reStart.setLocation(340, 300);
		ImageIcon icon = new ImageIcon(IconName);
		reStart.setIcon(icon);
		reStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1.setIsOver(false);
				p2.setIsOver(false);
				p3.setIsOver(false);
				p4.setIsOver(false);
				p1board.setVisible(false);
				p2board.setVisible(false);
				p3board.setVisible(false);
				p4board.setVisible(false);
				reStart.setVisible(false);
				isSelect = false;
				GameOver = false;
				questionLabel.setText(question());
				hint.setText(playWhoPlayer().getName() + "請先按按鍵選擇答案1(是)2(否)");
				questionLabel.setVisible(true);
			}

		});
		reStart.setVisible(false);
		panel.add(reStart);
//////////////////////////////////////////////////////////////////////////////////////////////////////////// 鍵值監聽///////////////////////
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
				if ((keyCode == 49 || keyCode == 97) && !isSelect && isStrat) {// 數字1

					YES.setVisible(true);
					NO.setVisible(true);
					System.out.println(playWhoPlayer().getName() + "選擇yes");
					playWhoPlayer().setAnsKey(1.0);
					playWhoPlayer().setIsOver(true);
					playWho++;
					isSelect = true;
					hint.setText(playWhoPlayer().getName() + "請選擇");

				}
				if ((keyCode == 50 || keyCode == 98) && !isSelect && isStrat) {// 數字2

					YES.setVisible(true);
					NO.setVisible(true);
					System.out.println(playWhoPlayer().getName() + "選擇no");
					playWhoPlayer().setAnsKey(2.0);
					playWhoPlayer().setIsOver(true);
					playWho++;
					isSelect = true;
					hint.setText(playWhoPlayer().getName() + "請選擇");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		///////////////////////////////
		panel.setFocusable(true);// 增加焦點。
		panel.requestFocusInWindow();
		return panel;
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

	public String question() {
		random = new Random();
		playWho = random.nextInt(playerNumber);
		whosQusetioner(playWho);

		///////////////////////////////////////////////////////////
		String[] question = new String[40];
		question[0] = "" + questioner.getName() + "今天早上起床後有喝咖啡嗎？";
		question[1] = "昨晚" + questioner.getName() + "有看電視劇嗎？";
		question[2] = "" + questioner.getName() + "最近有去健身房嗎？";
		question[3] = "" + questioner.getName() + "上個週末有跟朋友出去吃飯嗎？";
		question[4] = "" + questioner.getName() + "昨天有出去玩嗎？";
		question[5] = "" + questioner.getName() + "最近有看過一本好書嗎？";
		question[6] = "" + questioner.getName() + "有在社交媒體上發布新照片嗎？";
		question[7] = "" + questioner.getName() + "最近有參加任何聚會或派對嗎？";
		question[8] = "" + questioner.getName() + "有寵物嗎？";
		question[9] = "" + questioner.getName() + "喜歡下廚嗎？";
		question[10] = "" + questioner.getName() + "有參加過音樂會或演唱會嗎？";
		question[11] = "" + questioner.getName() + "喜歡看運動比賽嗎？";
		question[12] = "" + questioner.getName() + "有學會一項新的技能嗎？";
		question[13] = "" + questioner.getName() + "喜歡旅行嗎？";
		question[14] = "" + questioner.getName() + "有去電影院看最新上映的電影嗎？";
		question[15] = "" + questioner.getName() + "有參加過瑜珈或冥想課程嗎？";
		question[16] = "" + questioner.getName() + "喜歡戶外活動嗎？";
		question[17] = "" + questioner.getName() + "在社交媒體上分享過新的貼文嗎？";
		question[18] = "" + questioner.getName() + "有參加過學校或社區的有趣活動嗎？";
		question[19] = "" + questioner.getName() + "喜歡逛夜市嗎？";
		question[20] = "" + questioner.getName() + "喜歡和朋友一起打遊戲嗎？";
		question[21] = "" + questioner.getName() + "有參加過校內活動嗎？";
		question[22] = "" + questioner.getName() + "喜歡參加學校的社團嗎？";
		question[23] = "" + questioner.getName() + "有在學校圖書館借過書嗎？";
		question[24] = "" + questioner.getName() + "喜歡參加班級聚餐嗎？";
		question[25] = "" + questioner.getName() + "喜歡和同學一起做專案嗎？";
		question[26] = "" + questioner.getName() + "喜歡參加運動賽事嗎？";
		question[27] = "" + questioner.getName() + "有參加過戲劇表演嗎？";
		question[28] = "" + questioner.getName() + "喜歡參加舞蹈活動嗎？";
		question[29] = "" + questioner.getName() + "喜歡參加音樂活動嗎？";
		question[30] = "" + questioner.getName() + "有參加過競賽嗎？";
		question[31] = "" + questioner.getName() + "喜歡參加藝術比賽嗎？";
		question[32] = "" + questioner.getName() + "有參加過戶外露營活動嗎？";
		question[33] = "" + questioner.getName() + "喜歡參加讀書會嗎？";
		question[34] = "" + questioner.getName() + "有在學校的社交媒體群組上發布過訊息嗎？";
		question[35] = "" + questioner.getName() + "喜歡參加學校的校慶活動嗎？";
		question[36] = "" + questioner.getName() + "會參加學校的實習計畫嗎？";
		question[37] = "" + questioner.getName() + "喜歡花火節嗎？";
		question[38] = "" + questioner.getName() + "有參加過學校的志工服務嗎？";
		question[39] = "" + questioner.getName() + "有喜歡的人嗎？";
		///////////////////////////////////////////////////
		int i = random.nextInt(question.length - 1);

		return question[i];

	}

	public Player playWhoPlayer() {
		// System.out.println("檢查點"+playWho);
		if (playWho == 0 && !p1.getIsOver()) {
			return p1;
		} else if (playWho == 1 && !p2.getIsOver()) {
			return p2;
		} else if (playWho == 2 && !p3.getIsOver() && playerNumber > 2) {
			return p3;
		} else if (playWho == 3 && !p4.getIsOver() && playerNumber > 3) {
			return p4;
		} else if (playWho > 1 && !p1.getIsOver()) {
			playWho = 0;
			return playWhoPlayer();
		}
		return null;
	}

	public String select(int i) {
		if (i == 1) {
			return "是";
		}
		return "否";
	}

	public void whosQusetioner(int playWho) {
		this.playWho = playWho;
		System.out.println("進入whosQusetioner:" + playWho);
		if (playerNumber == 4 && p1.getWinKey() == 1 && p2.getWinKey() == 1 && p3.getWinKey() == 1
				&& p4.getWinKey() == 1) {
			InfPlayerReset();
		} else if (playerNumber == 3 && p1.getWinKey() == 1 && p2.getWinKey() == 1 && p3.getWinKey() == 1) {
			InfPlayerReset();
		} else if (p1.getWinKey() == 1 && p2.getWinKey() == 1) {
			InfPlayerReset();
		}
		if (playWho == 0) {
			if (p1.getWinKey() == 1) {
				whosQusetioner(1);
			} else {
				questioner = p1;
				p1.setWinKey(1);
			}
		} else if (playWho == 1) {

			if (p2.getWinKey() == 1) {
				if (playerNumber > 2) {
					whosQusetioner(2);
				} else {
					whosQusetioner(0);
				}

			} else {
				questioner = p2;
				p2.setWinKey(1);
			}
		} else if (playWho == 2) {
			if (p3.getWinKey() == 1) {
				if (playerNumber > 3) {
					whosQusetioner(3);
				} else {
					whosQusetioner(0);
				}

			} else {
				questioner = p3;
				p3.setWinKey(1);
			}
		} else if (playWho == 3) {
			if (p4.getWinKey() == 1) {
				whosQusetioner(0);
			} else {
				questioner = p4;
				p4.setWinKey(1);
			}
		}
	}
}
