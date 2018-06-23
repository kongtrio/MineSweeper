package com.jb.minesweeper.Dialog;


import javax.swing.JDialog;
import javax.swing.JLabel;

import com.jb.minesweeper.tool.Tools;

public class About extends JDialog {

    public About() {
        this.setTitle("版权所属");
        this.setSize(150, 200);
        this.setResizable(false);
        this.setModal(true);
        this.setIconImage(Tools.icon);
//		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);

    }

    public void init() {
        JLabel mineName = new JLabel("我的扫雷");
        JLabel icon = new JLabel();
        icon.setIcon(Tools.iiIcon);
        JLabel name = new JLabel("kongtrio");
        JLabel messege = new JLabel("kongtrio@sina.com");
        this.setLayout(null);
        name.setBounds(20, 110, 80, 30);
        icon.setBounds(20, 30, 30, 30);
        mineName.setBounds(55, 30, 70, 30);
        messege.setBounds(20, 70, 130, 30);
        this.add(icon);
        this.add(mineName);
        this.add(messege);
        this.add(name);


    }
}
