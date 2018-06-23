package com.jb.minesweeper.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import com.jb.minesweeper.frame.MineFrame;
import com.jb.minesweeper.tool.Tools;

public class MineState extends JPanel {
	private JLabel mineG, mineS, mineB, face, timeG, timeS, timeB;
	private Timer time;
	private int timeCounts;
	private MineFrame mineFrame;
	int countG=1, countS, countB;
	

	public int getTimeCounts() {
		return timeCounts;
	}

	public void setTimeCounts(int timeCounts) {
		this.timeCounts = timeCounts;
	}

	public JLabel getMineB() {
		return mineB;
	}

	public void setMineB(JLabel mineB) {
		this.mineB = mineB;
	}

	public JLabel getTimeG() {
		return timeG;
	}

	public void setTimeG(JLabel timeG) {
		this.timeG = timeG;
	}

	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}

	public JLabel getMineG() {
		return mineG;
	}

	public void setMineG(JLabel mineG) {
		this.mineG = mineG;
	}

	public JLabel getMineS() {
		return mineS;
	}

	public void setMineS(JLabel mineS) {
		this.mineS = mineS;
	}

	public JLabel getFace() {
		return face;
	}

	public void setFace(JLabel face) {
		this.face = face;
	}

	public MineState(MineFrame mineFrame) {
		
		this.mineFrame = mineFrame;
		this.setBackground(Color.LIGHT_GRAY);
		Border out = BorderFactory.createEmptyBorder(5, 10, 10, 10);
		Border in = BorderFactory.createLoweredBevelBorder();
		Border border = BorderFactory.createCompoundBorder(out, in);
		this.setBorder(border);

		this.setLayout(new BorderLayout());
		Box box = Box.createHorizontalBox();
		mineG = new JLabel(Tools.iiCount[0]);
		mineS = new JLabel(Tools.iiCount[1]);
		mineB = new JLabel(Tools.iiCount[0]);
		face = new JLabel(Tools.iiFace[0]);
		face.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				if(e.getModifiers()==InputEvent.BUTTON1_MASK){
				face.setIcon(new ImageIcon("./image/face0.gif"));}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getModifiers()==InputEvent.BUTTON1_MASK){
				face.setIcon(new ImageIcon("./image/face1.gif"));}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				MineState.this.mineFrame.newGame();
				timeB.setIcon(new ImageIcon("./image/d0.gif"));
				timeS.setIcon(new ImageIcon("./image/d0.gif"));
				timeG.setIcon(new ImageIcon("./image/d0.gif"));
				time.stop();
				timeCounts = 0;
			}
		});

		timeG = new JLabel(Tools.iiCount[0]);
		timeS = new JLabel(Tools.iiCount[0]);
		/*
		 * 设置外挂，点击时间十位处图标后再点扫雷直接获胜
		 */
		timeS.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				MineState.this.mineFrame.getMineField().setOpenCounts((Tools.row*Tools.col)-Tools.mineCounts);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		timeB = new JLabel(Tools.iiCount[0]);
        /*
         * 开始计算，以一秒为单位
         */
		time = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				timeCounts++;
				timeB.setIcon(new ImageIcon("./image/d" + countB + ".gif"));
				timeS.setIcon(new ImageIcon("./image/d" + countS + ".gif"));
				timeG.setIcon(new ImageIcon("./image/d" + countG + ".gif"));
				countG++;
				if (countG >= 10) {
					countG = countG % 10;
					countS++;
				}
				if (countS >= 10) {
					countS = countS % 10;
					countB++;
				}

			}
		});
		box.add(Box.createHorizontalStrut(6));
		box.add(mineB);
		box.add(mineS);
		box.add(mineG);
		box.add(Box.createVerticalStrut(35));
		box.add(Box.createHorizontalGlue());
		box.add(face);
		box.add(Box.createHorizontalGlue());
		box.add(Box.createVerticalStrut(35));
		box.add(timeB);
		box.add(timeS);
		box.add(timeG);
		box.add(Box.createHorizontalStrut(6));

		this.add(box);

	}
}
