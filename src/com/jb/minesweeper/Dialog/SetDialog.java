package com.jb.minesweeper.Dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jb.minesweeper.frame.MineFrame;
import com.jb.minesweeper.tool.Tools;

public class SetDialog extends JDialog {

    private JButton jb1, jb2;
    private JLabel hight, wide, mineCounts;
    private JTextField text1, text2, text3;
    private MineFrame mineFrame;

    public SetDialog(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        this.setTitle("自定义设置");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(250, 250);
        init();
        this.setModal(true);
        this.setVisible(true);
    }

    public void init() {
        jb1 = new JButton("确定");
        jb2 = new JButton("取消");
        hight = new JLabel("限制(10-30):");
        wide = new JLabel("限制(10-30):");
        mineCounts = new JLabel("限制(1-899):");
        text1 = new JTextField(20);
        text2 = new JTextField(20);
        text3 = new JTextField(20);

        this.setLayout(new FlowLayout());
        this.add(hight);
        this.add(text1);
        this.add(wide);
        this.add(text2);
        this.add(mineCounts);
        this.add(text3);
        this.add(jb1);
        this.add(jb2);
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Tools.col = Integer.parseInt(text2.getText());
                    Tools.row = Integer.parseInt(text2.getText());
                    Tools.mineCounts = Integer.parseInt(text3.getText());
                    if (Tools.col > 9 && Tools.col <= 30) {
                        if (Tools.row > 9 && Tools.row <= 30) {
                            if (Tools.mineCounts >= 10
                                    && Tools.mineCounts <= Tools.row
                                    * Tools.col) {
                                mineFrame.newGame();
                                SetDialog.this.dispose();

                            }
                        }
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "ֻ设置失败", "设置失败",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetDialog.this.dispose();

            }
        });

    }

}
