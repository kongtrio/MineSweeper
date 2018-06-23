package com.jb.minesweeper.Dialog;

import javax.swing.JDialog;
import javax.swing.JLabel;



public class DeathExit extends JDialog{
    public DeathExit(){
    	setTitle("退出死亡模式");
    	JLabel jl = new JLabel("退出死亡模式");
    	this.add(jl);
    	this.pack();
    	setModal(true);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
}
