package com.jb.minesweeper.frame;

import java.awt.BorderLayout;
import javax.swing.*;

import com.jb.minesweeper.bean.Level;
import com.jb.minesweeper.bean.MineLable;
import com.jb.minesweeper.menu.MineMenu;
import com.jb.minesweeper.panel.MineField;
import com.jb.minesweeper.panel.MineState;
import com.jb.minesweeper.tool.Record;
import com.jb.minesweeper.tool.Tools;

public class MineFrame extends JFrame {

    private MineField mineField;
    private MineState mineState;
    private MineMenu mineMenu;
    private MineLable mineLable[][];
    private Level level;
    private Record record;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public MineField getMineField() {
        return mineField;
    }

    public void setMineField(MineField mineField) {
        this.mineField = mineField;
    }

    public MineState getMineState() {
        return mineState;
    }

    public void setMineState(MineState mineState) {
        this.mineState = mineState;
    }

    public MineMenu getMineMenu() {
        return mineMenu;
    }

    public void setMineMenu(MineMenu mineMenu) {
        this.mineMenu = mineMenu;
    }

    public MineFrame() {
        this.setTitle("扫雷");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
        this.setIconImage(Tools.icon);
        this.pack();
        this.setVisible(true);
    }

    public void init() {
        level = new Level();
        record = new Record(level);
        mineMenu = new MineMenu(this);
        this.setJMenuBar(mineMenu);

        mineField = new MineField(this);
        mineState = new MineState(this);
        this.add(mineField, BorderLayout.SOUTH);
        this.add(mineState, BorderLayout.NORTH);

    }

    public void flush() {
        this.remove(mineField);
        this.remove(mineState);
        mineField = new MineField(this);
        mineState = new MineState(this);
        this.add(mineField, BorderLayout.SOUTH);
        this.add(mineState, BorderLayout.NORTH);
    }

    public void primary() {
        flush();
        mineState.getMineS().setIcon(new ImageIcon("./image/d1.gif"));
        this.pack();
    }

    public void second() {
        flush();
        mineState.getMineS().setIcon(new ImageIcon("./image/d4.gif"));
        this.pack();
    }

    public void superior() {
        flush();
        mineState.getMineS().setIcon(new ImageIcon("./image/d9.gif"));
        mineState.getMineG().setIcon(new ImageIcon("./image/d9.gif"));
        this.pack();
    }

    public void newGame() {
        flush();
        mineLable = new MineLable[Tools.row][Tools.col];
        for (int i = 0; i < mineLable.length; i++) {
            for (int j = 0; j < mineLable[i].length; j++) {
                mineLable[i][j] = new MineLable();
                mineLable[i][j].setOpen(false);
            }
        }
        this.pack();
    }

    public static void main(String[] args) {
        new MineFrame();
    }
}
