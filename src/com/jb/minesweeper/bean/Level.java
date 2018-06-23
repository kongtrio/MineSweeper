package com.jb.minesweeper.bean;

import com.jb.minesweeper.tool.Tools;

public class Level {
	private int timeLow, timeMid, timeHei;
	private String nameLow, nameMid, nameHei;
    private String level= Tools.LOWER_LEVEL;
	private boolean death;

	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getTimeLow() {
		return timeLow;
	}

	public void setTimeLow(int timeLow) {
		this.timeLow = timeLow;
	}

	

	public String getNameLow() {
		return nameLow;
	}

	public void setNameLow(String nameLow) {
		this.nameLow = nameLow;
	}

	public int getTimeMid() {
		return timeMid;
	}

	public void setTimeMid(int timeMid) {
		this.timeMid = timeMid;
	}

	public int getTimeHei() {
		return timeHei;
	}

	public void setTimeHei(int timeHei) {
		this.timeHei = timeHei;
	}

	public String getNameMid() {
		return nameMid;
	}

	public void setNameMid(String nameMid) {
		this.nameMid = nameMid;
	}

	public String getNameHei() {
		return nameHei;
	}

	public void setNameHei(String nameHei) {
		this.nameHei = nameHei;
	}

	

}
