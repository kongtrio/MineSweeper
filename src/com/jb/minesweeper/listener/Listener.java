package com.jb.minesweeper.listener;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jb.minesweeper.bean.MineLable;
import com.jb.minesweeper.frame.MineFrame;

public class Listener extends MouseAdapter {

    private MineFrame mineFrame;
    private int clickCountLeft;

    private int clickEvent = 0;
    private boolean doubleClick = false;

    public Listener(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
    }

    public void mousePressed(MouseEvent e) {
        clickEvent ^= e.getButton();

        MineLable minelable = (MineLable) e.getSource();
        int rows = minelable.getRows();
        int cols = minelable.getCols();
        if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
            mineFrame.getMineField().faceChange1(rows, cols);
            mineFrame.getMineField().put(rows, cols);
        }

        if (e.getModifiersEx() == (InputEvent.BUTTON1_DOWN_MASK + InputEvent.BUTTON3_DOWN_MASK)) {
            mineFrame.getMineField().doubleClickPress(rows, cols);
            mineFrame.getMineField().faceChange1(rows, cols);
            doubleClick = true;
        }

    }

    public void mouseReleased(MouseEvent e) {
        clickEvent ^= e.getButton();

        MineLable minelable = (MineLable) e.getSource();
        int rows = minelable.getRows();
        int cols = minelable.getCols();

        if (clickEvent == 0 && doubleClick) {
            mineFrame.getMineField().faceChange2(rows, cols);
            mineFrame.getMineField().doubleClickReleased(rows, cols);
            doubleClick = false;
        } else {
            if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                mineFrame.getMineField().setFlag(rows, cols);
            }
            if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                mineFrame.getMineField().faceChange2(rows, cols);
                clickCountLeft++;
                if (clickCountLeft == 1) {
                    mineFrame.getMineField().bulidMine(rows, cols);
                    mineFrame.getMineState().getTime().start();
                    mineFrame.getMineState().setTimeCounts(0);
                }
                mineFrame.getMineField().faceChange2(rows, cols);
                mineFrame.getMineField().open(rows, cols);
            }
        }
    }
}
