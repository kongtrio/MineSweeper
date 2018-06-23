package com.jb.minesweeper.Dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.jb.minesweeper.frame.MineFrame;

public class DeathOpen extends JDialog {

    private MineFrame mineFrame;

    public DeathOpen(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        setTitle("死亡模式");
        JLabel jl = new JLabel("是否开启死亡模式");
        JButton jb1 = new JButton("否");
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DeathOpen.this.dispose();

            }
        });
        JButton jb2 = new JButton("是");
        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DeathOpen.this.mineFrame.getLevel().setDeath(false);
                DeathOpen.this.dispose();
            }
        });
        setLayout(new FlowLayout());
        this.add(jl);
        this.add(jb1);
        this.add(jb2);
        setSize(300, 100);
        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
