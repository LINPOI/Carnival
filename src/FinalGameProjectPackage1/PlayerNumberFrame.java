package FinalGameProjectPackage1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PlayerNumberFrame extends Information{
	JFrame PlayerNumer =new JFrame(getGameName());
	public PlayerNumberFrame() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "設定人數";
	}
	@Override
	public void openFrame(int playerNumber) {
		// TODO Auto-generated method stub
	}
	public void openFrame() {
		// TODO Auto-generated method stub
		PlayerNumer.setSize(new Dimension(400,200));
		PlayerNumer.setLayout(null); //格式設定
		PlayerNumer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//關閉當前視窗
		PlayerNumer.add(getplayerNumber());
		PlayerNumer.setVisible(true);
	}
	@Override
	public boolean isOpenFrame() {
		// TODO Auto-generated method stub
		if(PlayerNumer.isVisible()) {
			return true;
		}
		return false;
	}

	
	public JPanel getplayerNumber() {
		JPanel pN=new JPanel();
		pN.setSize(new Dimension(400,200));
		pN.setLayout(null);
		JLabel jlPlayerNumer=new JLabel("請選擇遊玩人數:");
		jlPlayerNumer.setFont(font);	
		jlPlayerNumer.setSize(300,50);
		jlPlayerNumer.setLocation(70,1);
		jlPlayerNumer.setLayout(null);
		pN.add(jlPlayerNumer);
		/////////////2p按鈕///////////////
		JButton playerNumberButton1=new JButton("2P");
		playerNumberButton1.setFont(font2);
		playerNumberButton1.setBackground(Color.LIGHT_GRAY);
		playerNumberButton1.setSize(70,70); //寬高
		playerNumberButton1.setLocation(40,80); 
		playerNumberButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playerNumber=2;
				System.out.println("playerNumber"+playerNumber);
				SwingUtilities.getWindowAncestor(pN).dispose();
				Next();
			} 
			
		});
		pN.add(playerNumberButton1);
		/////////////3p按鈕////////////////
		JButton playerNumberButton2=new JButton("3P");
		playerNumberButton2.setFont(font2);
		playerNumberButton2.setBackground(Color.LIGHT_GRAY);
		playerNumberButton2.setSize(70,70); //寬高
		playerNumberButton2.setLocation(150,80); 
		playerNumberButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playerNumber=3;
				System.out.println("playerNumber"+playerNumber);
				SwingUtilities.getWindowAncestor(pN).dispose();
				Next();
			} 
			
		});
		pN.add(playerNumberButton2);
		/////////////4P按鈕///////////////
		JButton playerNumberButton3=new JButton("4P");
		playerNumberButton3.setFont(font2);
		playerNumberButton3.setBackground(Color.LIGHT_GRAY);
		playerNumberButton3.setSize(70,70); //寬高
		playerNumberButton3.setLocation(260,80); 
		playerNumberButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playerNumber=4;
				System.out.println("playerNumber"+playerNumber);
				SwingUtilities.getWindowAncestor(pN).dispose();
				Next();
			} 
			
		});
		pN.add(playerNumberButton3);
		////////////////////////////
		
		return pN;
	}
	public void Next() {
		Window window=new Window();
		window.openFrame(playerNumber);
	}
	
	@Override
	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return false;
	}
	

	




}
