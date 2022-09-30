import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class practice5 extends JFrame {
	
//	private final ArrayList box = new ArrayList<JLabel>();
	
	private final JLabel actor = new JLabel();
	private final JLabel lgoal = new JLabel();
	private final JLabel kevinLabel = new JLabel();
	private final JLabel hanLabel = new JLabel();
	private final JButton UpButton = new JButton();
	private final JButton RightButton = new JButton();
	private final JButton LeftButton = new JButton();
	private final JButton DownButton = new JButton();
	private final JButton Reset = new JButton();
	private final JLabel successLabel = new JLabel();


	Icon road1_icon = new ImageIcon(getClass().getResource("/png/road1.png"));
	Icon road3_icon = new ImageIcon(getClass().getResource("/png/road3.png"));
	Icon tower101_icon = new ImageIcon(getClass().getResource("/png/101tower.png"));
	Icon hsr_icon = new ImageIcon(getClass().getResource("/png/hsr.png"));
	Icon land_icon = new ImageIcon(getClass().getResource("/png/land.png"));
	Icon river_icon = new ImageIcon(getClass().getResource("/png/river.png"));
	Icon taxi_icon = new ImageIcon(getClass().getResource("/png/taxi.png"));
	Icon tower85_icon = new ImageIcon(getClass().getResource("/png/tower85.png"));
	Icon han_icon = new ImageIcon(getClass().getResource("/png/koreahan.png"));
	Icon rich = new ImageIcon(getClass().getResource("/png/fuckingrich.png"));
	Icon richg = new ImageIcon(getClass().getResource("/png/fuckingrichgun.png"));
	Icon kevin_icon = new ImageIcon(getClass().getResource("/png/clap.gif"));
	Icon kevinup_Icon = new ImageIcon(getClass().getResource("/png/clapup.gif"));
	Icon kevindown_Icon = new ImageIcon(getClass().getResource("/png/clapdown.png"));
	Icon kevinright_Icon = new ImageIcon(getClass().getResource("/png/clapright.png"));
	Icon kevinleft_Icon = new ImageIcon(getClass().getResource("/png/clapleft.gif"));
	Icon ohnoabei = new ImageIcon(getClass().getResource("/png/ohnoabei.png"));
	Icon gun = new ImageIcon(getClass().getResource("/png/gun.png"));
	Icon ggabei = new ImageIcon(getClass().getResource("/png/ggabei.png"));
	
	Icon magic_icon = new ImageIcon(getClass().getResource("/png/magic.png"));
	Icon stone_icon = new ImageIcon(getClass().getResource("/png/stone.png"));
	Icon barrier_icon = new ImageIcon(getClass().getResource("/png/barrier.jpg"));
	Icon goal_icon = new ImageIcon(getClass().getResource("/png/goal.png"));

	private int[][] map;
	int current_x=0, current_y=0;
	boolean getGun = false;
	boolean broke = false;
	boolean[] abei = {false , false , false};
	int abeiindex = 0;
	char op;
	private final JLabel messageLabel = new JLabel();
	private final JLabel box = new JLabel();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			practice5 frame = new practice5();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public practice5() {
		super();
		setTitle("Kevin Be RICH");
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		getContentPane().addKeyListener(new ThisContentPaneKeyListener());
		getContentPane().add(actor);
		actor.setIcon(kevin_icon);
		actor.setBounds(0, 0, 40, 40);
		getContentPane().getFocusListeners();
		
		map=readMap("map1.txt");
		
		for (int i=0; i<5; i++ )
		  for (int j=0; j<10; j++ )
		  {	
			  JLabel tmp = new JLabel();
			getContentPane().add(tmp);
			switch (map[i][j]){
			case 0: 
			    tmp.setIcon(road1_icon);
			    break;
			case 1: 
			    tmp.setIcon(tower101_icon);
			    break;
			case 2: 
			    tmp.setIcon(hsr_icon);
			    break;
			case 3: 
			    tmp.setIcon(land_icon);
			    break;
			case 4:
				tmp.setIcon(river_icon);
				break;
			case 5:
				tmp.setIcon(taxi_icon);
				break;
			case 6: 
			    tmp.setIcon(tower85_icon);
			    break;
			case 7: 
			    tmp.setIcon(han_icon);
			    break;
			case 8: 
			    tmp.setIcon(gun);
			    break;
			case 9: 
			    tmp.setIcon(ohnoabei);
			    break;
			case 10: 
			    tmp.setIcon(road3_icon);
			    break;
			case 11: 
			    tmp.setIcon(magic_icon);
			    break;
			case 12: 
			    tmp.setIcon(stone_icon);
			    break;
			case 13: 
			    tmp.setIcon(barrier_icon);
			    break;
			default:
			    tmp.setIcon(road1_icon);				
			}
			tmp.setBounds(0+j*40, 0+i*40,40, 40);
		  } 
			
		getContentPane().add(Reset);
		Reset.addActionListener(new ResetListener());
		Reset.setText("Reset");
		Reset.setBounds(280, 272, 80, 20);
		
		getContentPane().add(kevinLabel);
		kevinLabel.setIcon(kevin_icon);
		kevinLabel.setText("Kevin");
		kevinLabel.setBounds(171, 262, 40, 40);
		
		getContentPane().add(hanLabel);
		hanLabel.setIcon(han_icon);
		hanLabel.setText("Han");
		hanLabel.setBounds(217, 262, 40, 40);
		
		getContentPane().add(UpButton);
		UpButton.addActionListener(new UpButtonActionListener());
		UpButton.setText("Up");
		UpButton.setBounds(62, 236, 56, 20);
		
		getContentPane().add(RightButton);
		RightButton.addActionListener(new RightButtonActionListener());
		RightButton.setText("Right");
		RightButton.setBounds(97, 262, 68, 20);
		
		getContentPane().add(LeftButton);
		LeftButton.addActionListener(new LeftButtonActionListener());
		LeftButton.setText("Left");
		LeftButton.setText("Left");
		LeftButton.setBounds(10, 262, 68, 20);
		
		getContentPane().add(DownButton);
		DownButton.addActionListener(new DownButtonActionListener());
		DownButton.setText("Down");
		DownButton.setBounds(56, 288, 68, 20);
		
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	private int[][] readMap(String mapfile) throws FileNotFoundException {
		
		File f = new File(mapfile);
		int[][] map=new int[5][10];
		Scanner sc = new Scanner(f);
			for(int i=0;i<5;i++){
				for(int j=0;j<10;j++){
					map[i][j]=sc.nextInt();
				}
			}
		return map;
	}
	
	private class ResetListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				Reset_actionPerformed(e);}
			 catch (Throwable A) {
				A.printStackTrace();
			}
		}
	}
	
	private class UpButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			upButton_actionPerformed(e);
		}
	}
	private class DownButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			downButton_actionPerformed(e);
		}
	}
	private class RightButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rightButton_actionPerformed(e);
		}
	}
	private class LeftButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			leftButton_actionPerformed(e);
		}
	}
	private class ThisContentPaneKeyListener extends KeyAdapter {
			
		public void keyPressed(KeyEvent e) {
			thisContentPane_keyPressed(e);
		}
	}

	protected void Reset_actionPerformed(ActionEvent e) throws FileNotFoundException{
		map=readMap("map1.txt");
		actor.setBounds(40, 40, 40, 40);
		change_map();
		
		getGun = false;
		broke = false;
		abeiindex = 0;
		abei[0] =false;
		abei[1] =false;
		abei[2] =false;
		getContentPane().requestFocus();
	}

	protected void upButton_actionPerformed(ActionEvent e) {
		if(current_y>0){
			current_y--;
			if(judge_s()) return;
			if (judge()){
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x, y-40);
			}
			else current_y++;
			actor.setIcon(kevinup_Icon);
		}
		getContentPane().requestFocus();
	}
	protected void downButton_actionPerformed(ActionEvent e) {
		if(current_y<4){
			current_y++;
			if(judge_s()) return;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x, y+40);
			}
			else current_y--;
			actor.setIcon(kevindown_Icon);
		}
		getContentPane().requestFocus();
	}

	protected void rightButton_actionPerformed(ActionEvent e) {
		if(current_x<9){
			current_x++;
			if(judge_s()) return;
			if (judge())
			{
				int x=actor.getX();
				int y=actor.getY();
				actor.setLocation(x+40,y);
			}
			else current_x--;
			actor.setIcon(kevinright_Icon);
		}
		getContentPane().requestFocus();
	}
	protected void leftButton_actionPerformed(ActionEvent e) {
		if (current_x>0){
			current_x--;
			if(judge_s()) return;
			if (judge())
			{
				int x=actor.getX();
				int y=actor.getY();
				actor.setLocation(x-40,y);
			}
			else current_x++;
			actor.setIcon(kevinleft_Icon);
		}
		getContentPane().requestFocus();
	}
	
	public void Reset_action() throws FileNotFoundException{
		map=readMap("map1.txt");
		actor.setBounds(40, 40, 40, 40);
		change_map();
		abeiindex = 0;
		getGun = false;
		abei[0] =false;
		abei[1] =false;
		abei[2] =false;
		broke = false;
		getContentPane().requestFocus();
	}
	
	public void downButton_action(){
		op = 'd';
		if(current_y<4){
			current_y++;
			if(judge_s()) return;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x, y+40);
			}
			else 	current_y--;
			actor.setIcon(kevindown_Icon);
		}
	}
	
	public void upButton_action(){
		op = 'u';
		if(current_y>0){
			current_y--;
			if(judge_s()) return;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x, y-40);
			}
			else 	current_y++;
			actor.setIcon(kevinup_Icon);
		}
	}
	
	public void rightButton_action(){
		op = 'r';
		if(current_x<9){
			current_x++;
			if(judge_s()) return;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x+40, y);
			}
			else 	current_x--;
			actor.setIcon(kevinright_Icon);
		}
	}
	
	public void leftButton_action(){
		op = 'l';
		if(current_x>0){
			current_x--;
			if(judge_s()) return;
			if (judge())
			{
			   int x= actor.getX();
			   int y= actor.getY();
			   actor.setLocation(x-40, y);
			}
			else 	current_x++;
			actor.setIcon(kevinleft_Icon);
		}
	}
	private JLabel images = new JLabel();
	private ImageIcon temp;
	protected boolean judge() {
		boolean result = false;
		//0:road ; 1:wall ; 2:goal
		if (map[current_y][current_x]==0 || map[current_y][current_x]==3 || map[current_y][current_x]==10
		 || map[current_y][current_x]==11)
		  {result = true;}
		else if(map[current_y][current_x]==12){
			if(op=='r'){
				if(map[current_y][current_x+1]==10 || map[current_y][current_x+1]==11){
				map[current_y][current_x]=10;
				setRoad3();
			
				actor.setBounds(current_x*40,current_y*40,40,40);
				current_x++;
			
				JLabel tmpg =(JLabel)getContentPane().getComponentAt((0+current_x)*40, 0+current_y*40);
				
					if(map[current_y][current_x]==11){
						broke = true;
						tmpg.setIcon(goal_icon);
						map[current_y][current_x]=99;}
					else{
						map[current_y][current_x]=12;
						tmpg.setIcon(stone_icon);}
				}
			}
			if(op=='l'){
				if(map[current_y][current_x-1]==10 || map[current_y][current_x-1]==11){
				map[current_y][current_x]=10;
				setRoad3();
				actor.setBounds(current_x*40,current_y*40,40,40);
				current_x--;
			
				JLabel tmpg =(JLabel)getContentPane().getComponentAt((0+current_x)*40, 0+current_y*40);
				
					if(map[current_y][current_x]==11){
						broke = true;
						tmpg.setIcon(goal_icon);
						map[current_y][current_x]=99;}
					else{
						map[current_y][current_x]=12;
						tmpg.setIcon(stone_icon);}
				}
			}
			if(op=='u'){
				if(map[current_y-1][current_x]==10 || map[current_y-1][current_x]==11){
				map[current_y][current_x]=10;
				setRoad3();
			
				actor.setBounds(current_x*40,current_y*40,40,40);
				current_y--;
			
				JLabel tmpg =(JLabel)getContentPane().getComponentAt((0+current_x)*40, 0+current_y*40);
				
					if(map[current_y][current_x]==11){
						broke = true;
						tmpg.setIcon(goal_icon);
						map[current_y][current_x]=99;}
					else{
						map[current_y][current_x]=12;
						tmpg.setIcon(stone_icon);}
				}
			}
			if(op=='d'){
				if(map[current_y+1][current_x]==10 || map[current_y+1][current_x]==11){
				map[current_y][current_x]=10;
				setRoad3();
			
				actor.setBounds(current_x*40,current_y*40,40,40);
				current_y++;
			
				JLabel tmpg =(JLabel)getContentPane().getComponentAt((0+current_x)*40, 0+current_y*40);
				
					if(map[current_y][current_x]==11){
						broke = true;
						tmpg.setIcon(goal_icon);
						map[current_y][current_x]=99;}
					else{
						map[current_y][current_x]=12;
						tmpg.setIcon(stone_icon);}
				}
			}
		}
		else if(map[current_y][current_x]==13){
			if(broke){
				result =true;
				map[current_y][current_x]=10;
				setRoad3();
			//	actor.setBounds(current_x*40,current_y*40,40,40);
			}
			else{
				result = false;
			}
		}
		else if (map[current_y][current_x]==8){
			getGun=true;
			map[current_y][current_x]=0;
			setRoad();
			result = true;
		}		
		else if (map[current_y][current_x]==9){
				if(getGun){
				map[current_y][current_x]=3;
				setRoad2();
				result = true;}
		}		
     	return result;
	}
	
	protected boolean judge_s() {
		boolean result = false;
		
		if(map[current_y][current_x]==2) {
			try {
				map2();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			result = true;
		}
		else if(map[current_y][current_x]==5) {
			try {
				map3();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			result = true;
		}
		else if(map[current_y][current_x]==7) {
			try {
				rich();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			result = true;
		}
		else if (map[current_y][current_x]==9){
			try {
				abeigg();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			result = true;			
		}
     		return result;
	}
	
	protected void thisContentPane_keyPressed(KeyEvent e){
		int keyCode=e.getKeyCode();
		if(keyCode==38){
			upButton_action();
		}
		else if(keyCode==40){
			downButton_action();
		}
		else if (keyCode==39){
			rightButton_action();
		}
		else if (keyCode==37){
			leftButton_action();
		}
		else if (keyCode==27){
			try {			
				Reset_action();
			} catch (Throwable ee) {
				ee.printStackTrace();
			}
		}
	}
	
	public void setRoad(){
        JLabel tmp =(JLabel)getContentPane().getComponentAt(0+current_x*40, 0+current_y*40);
        tmp.setIcon(road1_icon);
    }	
	public void setRoad2(){
        JLabel tmpland =(JLabel)getContentPane().getComponentAt(0+current_x*40, 0+current_y*40);
		
		actor.setBounds(current_x*40, current_y*40, 40, 40);
        tmpland.setIcon(land_icon);
    }	
	public void setRoad3(){
        JLabel tmp =(JLabel)getContentPane().getComponentAt(0+current_x*40, 0+current_y*40);
        tmp.setIcon(road3_icon);
    }	
	
	public void map2() throws FileNotFoundException{
		map=readMap("map2.txt");
		change_map();
	}
	
	public void map3() throws FileNotFoundException{
		map=readMap("map3.txt");
		change_map();
	}
	
	public void rich() throws FileNotFoundException{
		map=readMap("rich.txt");
		current_x=0;
		current_y=0;
		JLabel tmp =(JLabel)getContentPane().getComponentAt(399, 159);
		tmp.setBounds(0, 0, 400, 200);
		if(abei[0]&&abei[1]&&abei[2]){
		tmp.setIcon(richg);
		JOptionPane.showMessageDialog(null, "You Save the World!");}
		else
		tmp.setIcon(rich);
	}
	
	public void abeigg() throws FileNotFoundException{
		
	if(getGun){
			map[current_y][current_x]=3;
			setRoad2();
			abei[abeiindex]=true;
			abeiindex++;
		JOptionPane.showMessageDialog(null, "!!! You Kill the Devil !!!");
	}
	else{
		map=readMap("rich.txt");
		current_x=0;
		current_y=0;
		change_map();
		JOptionPane.showMessageDialog(null, "!!! You DIE !!!");
	
		}
	}
	
	public void change_map() throws FileNotFoundException{		
		current_x=0;
		current_y=0;		
		
		for (int i=0; i<5; i++ )
		  for (int j=0; j<10; j++ )
		  {	
			JLabel tmp =(JLabel)getContentPane().getComponentAt(0+j*40, 0+i*40);
			switch (map[i][j]){
			case 0: 
		        tmp.setIcon(road1_icon);
			    break;
			case 1: 
			    tmp.setIcon(tower101_icon);
			    break;
			case 2: 
			    tmp.setIcon(hsr_icon);
			    break;
			case 3: 
			    tmp.setIcon(land_icon);
			    break;
			case 4:
				tmp.setIcon(river_icon);
				break;
			case 5:
				tmp.setIcon(taxi_icon);
				break;
			case 6: 
			    tmp.setIcon(tower85_icon);
			    break;
			case 7: 
			    tmp.setIcon(han_icon);
			    break;
			case 8: 
			    tmp.setIcon(gun);
			    break;
			case 9: 
			    tmp.setIcon(ohnoabei);
			    break;
			case 10: 
			    tmp.setIcon(road3_icon);
			    break;
			case 11: 
			    tmp.setIcon(magic_icon);
			    break;
			case 12: 
			    tmp.setIcon(stone_icon);
			    break;
			case 13: 
			    tmp.setIcon(barrier_icon);
			    break;
			default:
			    tmp.setIcon(road1_icon);				
			}
		  } 

		actor.setIcon(kevin_icon);
		actor.setBounds(0, 0, 40, 40);
		
		for (int i=0; i<5; i++ )
			  for (int j=0; j<10; j++ )
			  {	
				JLabel tmp =(JLabel)getContentPane().getComponentAt(0+j*40, 0+i*40);
				switch (map[i][j]){
				case 0: 
			        tmp.setIcon(road1_icon);
				    break;
				case 1: 
				    tmp.setIcon(tower101_icon);
				    break;
				case 2: 
				    tmp.setIcon(hsr_icon);
				    break;
				case 3: 
					tmp.setIcon(land_icon);
					break;
				case 4:
					tmp.setIcon(river_icon);
					break;
				case 5:
					tmp.setIcon(taxi_icon);
					break;
				case 6: 
					tmp.setIcon(tower85_icon);
					break;
				case 7: 
					tmp.setIcon(han_icon);
					break;
				case 8: 
					tmp.setIcon(gun);
					break;
				case 9: 
					tmp.setIcon(ohnoabei);
					break;
				case 10: 
					tmp.setIcon(road3_icon);
					break;
				case 11: 
					tmp.setIcon(magic_icon);
					break;
				case 12: 
					tmp.setIcon(stone_icon);
					break;
				case 13: 
					tmp.setIcon(barrier_icon);
					break;
				default:
				    tmp.setIcon(road1_icon);					
				}
			  }
			  
		actor.setIcon(kevin_icon);
		actor.setBounds(0, 0, 40, 40);
	}	
}