package xox;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tictactoc implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel text = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	boolean player2_turn;
	boolean restart = false;
	
	tictactoc(){
		//frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(125,125,125));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setTitle("Tic-TAc-Toc");
		
		//text in panel
		text.setBackground(new Color(100,100,100));
		text.setForeground(new Color(25,25,25));
		text.setFont(new Font("Serif",Font.BOLD,30));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("X-O-X");
		text.setOpaque(true);
		
		//panel for text
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,200);
		title_panel.add(text);
		
		//panel for 9 box
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(80,80,80));
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		//combine
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		//start
		first();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i =0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("X");
						player1_turn = false;
						text.setText("O turn");
						check();
					}
				} else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("O");
						player1_turn = true;
						text.setText("X turn");
						check();
					}
				}
				
			}
		}
	}
	
	
	
	public void first() {
		
		//delay for 2000 to show who's turn
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//show turn
		if(random.nextInt(2) ==0) {
			player1_turn = true;
			text.setText("X turn");
		} else {
			player2_turn = false;
			text.setText("O turn");
		}
	}
	
	public void check() {
		//x win condition
		//horizontal
		if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")) {
			Xwin(0,1,2);
		}
		if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")) {
			Xwin(3,4,5);
		}
		if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")) {
			Xwin(6,7,8);
		}
		//vertical
		if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")) {
			Xwin(0,3,6);
		}
		if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")) {
			Xwin(1,4,7);
		}
		if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")) {
			Xwin(2,5,8);
		}
		// x
		if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")) {
			Xwin(0,4,8);
		}
		if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")) {
			Xwin(2,4,6);
		}

		//o win condition
		//horizontal
		if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")) {
			Owin(0,1,2);
		}
		if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")) {
			Owin(3,4,5);
		}
		if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")) {
			Owin(6,7,8);
		}
		//vertical
		if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")) {
			Owin(0,3,6);
		}
		if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")) {
			Owin(1,4,7);
		}
		if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")) {
			Owin(2,5,8);
		}
		// x
		if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")) {
			Owin(0,4,8);
		}
		if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")) {
			Owin(2,4,6);
		}
	}
	
	public void Xwin(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9;i++) {
			buttons[i].setEnabled(false);
		}
		text.setText("X WIN!!!");
		restart = true;
		playagain();
	}
	
	public void Owin(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9;i++) {
			buttons[i].setEnabled(false);
		}
		text.setText("O WIN!!!");
		restart = true;
	}
	
	public void playagain() {
		if(restart) {
			new tictactoc();
			
		}
	}
}
