package com.jb.minesweeper.Dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jb.minesweeper.frame.MineFrame;
import com.jb.minesweeper.tool.Tools;

public class Win extends JDialog {

    private MineFrame mineFrame;
    private JTextField text1;

    public Win(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        setTitle("获胜");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(200, 170);
        setModal(true);
        init();
        setVisible(true);
    }

    public void init() {
        int times = mineFrame.getMineState().getTimeCounts();

        JLabel lable1 = new JLabel("你赢啦");
        JLabel lable2 = new JLabel("哈哈哈");
        JLabel lable3 = new JLabel(" 使用" + times + "     秒           ");
        text1 = new JTextField(10);
        JButton butSure = new JButton("确定");
        JButton butCancel = new JButton("关闭");
        this.setLayout(new FlowLayout());
        this.add(lable1);
        this.add(lable2);
        this.add(text1);
        this.add(lable3);
        this.add(butSure);
        this.add(butCancel);
        butSure.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (mineFrame.getLevel().getLevel().equals(Tools.LOWER_LEVEL)) {
                    mineFrame.getLevel().setNameLow(text1.getText());
                    mineFrame.getLevel().setTimeLow(
                            mineFrame.getMineState().getTimeCounts());
                    // ����ʱ���¼
                    Integer l = new Integer(mineFrame.getMineState()
                            .getTimeCounts());
                    String low = l.toString();
                    mineFrame.getRecord().setValue("lowTime", low);
                    // �������ּ�¼
                    mineFrame.getRecord().setValue("lowName",
                            text1.getText());

                } else if (mineFrame.getLevel().getLevel().equals(Tools.MIDDLE_LEVEL)) {
                    mineFrame.getLevel().setNameMid(text1.getText());
                    mineFrame.getLevel().setTimeMid(
                            mineFrame.getMineState().getTimeCounts());
                    // ����ʱ���¼
                    Integer m = new Integer(mineFrame.getMineState()
                            .getTimeCounts());
                    String mid = m.toString();
                    mineFrame.getRecord().setValue("midTime", mid);
                    // �������ּ�¼
                    mineFrame.getRecord().setValue("midName",
                            text1.getText());
                } else if (mineFrame.getLevel().getLevel() == Tools.HEIGHT_LEVEL) {
                    mineFrame.getLevel().setNameHei(text1.getText());
                    mineFrame.getLevel().setTimeHei(
                            mineFrame.getMineState().getTimeCounts());

                    Integer h = new Integer(mineFrame.getMineState()
                            .getTimeCounts());
                    String hei = h.toString();
                    mineFrame.getRecord().setValue("heiTime", hei);

                    // �������ּ�¼
                    mineFrame.getRecord().setValue("heiName",
                            text1.getText());
                }
                Win.this.dispose();

            }
        });
        butCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Win.this.dispose();

            }
        });

    }
}
