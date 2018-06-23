package com.jb.minesweeper.bean;

import javax.swing.JLabel;
import com.jb.minesweeper.frame.MineFrame;

public class MineLable extends JLabel {
	private MineFrame mineFrame;
	private int rows;
	private int cols;
	private boolean mine ;
	private boolean open;
	private int aroundMinecount;
	private boolean flag;
	private boolean ask;



	public boolean isAsk() {
		return ask;
	}

	public void setAsk(boolean ask) {
		this.ask = ask;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getAroundMinecount() {
		return aroundMinecount;
	}

	public void setAroundMinecount(int aroundMinecount) {
		this.aroundMinecount = aroundMinecount;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

}
