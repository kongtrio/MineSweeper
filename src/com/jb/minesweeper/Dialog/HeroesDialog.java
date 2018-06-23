package com.jb.minesweeper.Dialog;


import javax.swing.JDialog;
import javax.swing.JLabel;

import com.jb.minesweeper.frame.MineFrame;

public class HeroesDialog extends JDialog {

    private MineFrame mineFrame;

    public HeroesDialog(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        setTitle("英雄榜");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(200, 180);
        setModal(true);
        mineFrame.getRecord().getValue();
        init();
        setVisible(true);
    }

    public void init() {
        JLabel name = new JLabel("英雄榜");
        JLabel primary = new JLabel("初级");
        JLabel second = new JLabel("中级");
        JLabel superior = new JLabel("高级");
        JLabel time1 = new JLabel(mineFrame.getLevel().getTimeLow() + "秒");
        JLabel time2 = new JLabel(mineFrame.getLevel().getTimeMid() + "秒");
        JLabel time3 = new JLabel(mineFrame.getLevel().getTimeHei() + "秒");
        JLabel winner1 = new JLabel(mineFrame.getLevel().getNameLow());
        JLabel winner2 = new JLabel(mineFrame.getLevel().getNameMid());
        JLabel winner3 = new JLabel(mineFrame.getLevel().getNameHei());
        this.setLayout(null);
        name.setBounds(60, 10, 100, 30);
        primary.setBounds(20, 40, 100, 30);
        winner1.setBounds(70, 40, 70, 30);

        time1.setBounds(130, 40, 40, 30);

        second.setBounds(20, 80, 100, 30);

        winner2.setBounds(70, 80, 70, 30);

        time2.setBounds(130, 80, 40, 30);

        superior.setBounds(20, 120, 100, 30);
        winner3.setBounds(70, 120, 70, 30);
        time3.setBounds(130, 120, 40, 30);
        this.add(name);
        this.add(primary);
        this.add(winner1);
        this.add(time1);
        this.add(second);
        this.add(winner2);
        this.add(time2);
        this.add(superior);
        this.add(winner3);
        this.add(time3);
    }

}
