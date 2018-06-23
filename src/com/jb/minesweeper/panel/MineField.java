package com.jb.minesweeper.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.jb.minesweeper.Dialog.Win;
import com.jb.minesweeper.bean.MineLable;
import com.jb.minesweeper.frame.MineFrame;
import com.jb.minesweeper.listener.Listener;
import com.jb.minesweeper.tool.Tools;

public class MineField extends JPanel {

    private MineLable minelable[][];
    private MineFrame mineFrame;
    private Listener listener;
    private int openCounts;
    private int mineCounts = Tools.mineCounts;

    public int getOpenCounts() {
        return openCounts;
    }

    public void setOpenCounts(int openCounts) {
        this.openCounts = openCounts;
    }

    public MineLable[][] getMinelable() {
        return minelable;
    }

    public void setMinelable(MineLable[][] minelable) {
        this.minelable = minelable;
    }

    public MineField(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        listener = new Listener(mineFrame);
        this.setBackground(Color.LIGHT_GRAY);
        Border out = BorderFactory.createEmptyBorder(5, 10, 10, 10);
        Border in = BorderFactory.createLoweredBevelBorder();
        Border border = BorderFactory.createCompoundBorder(out, in);
        this.setBorder(border);

        minelable = new MineLable[Tools.row][Tools.col];

        this.setLayout(new GridLayout(Tools.row, Tools.col));

        for (int i = 0; i < minelable.length; i++) {
            for (int j = 0; j < minelable[i].length; j++) {
                minelable[i][j] = new MineLable();
                minelable[i][j].setRows(i);
                minelable[i][j].setCols(j);
                minelable[i][j].setIcon(Tools.iiButton);
                minelable[i][j].addMouseListener(listener);
                this.add(minelable[i][j]);
            }
        }

    }

    public void bulidMine(int rowsIndex, int colsIndex) {
        for (int i = 0; i < Tools.mineCounts; i++) {
            int x = (int) (Math.random() * Tools.row);
            int y = (int) (Math.random() * Tools.col);
            if (minelable[x][y].isMine()) {
                i--;
            } else if (x == rowsIndex && y == colsIndex) {
                i--;
            } else {
                minelable[x][y].setMine(true);
            }
        }

        for (int m = 0; m < minelable.length; m++) {
            for (int n = 0; n < minelable[m].length; n++) {

                if (!minelable[m][n].isMine()) {
                    int minecount = 0;
                    for (int j = Math.max(m - 1, 0); j <= Math.min(m + 1,
                            minelable.length - 1); j++) {
                        for (int k = Math.max(n - 1, 0); k <= Math.min(n + 1,
                                minelable[m].length - 1); k++) {
                            if (minelable[j][k].isMine()) {
                                minecount++;
                            }
                        }
                    }
                    minelable[m][n].setAroundMinecount(minecount);
                }
            }
        }

        mineFrame.getMineState().getTime().start();
    }

    public void open(int x, int y) {

        if (!minelable[x][y].isFlag()) {
            if (minelable[x][y].isMine()) {
                try {
                    lost(x, y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (!minelable[x][y].isOpen()
                    && minelable[x][y].getAroundMinecount() != 0) {
                minelable[x][y].setIcon(Tools.iiMineCounts[minelable[x][y]
                        .getAroundMinecount()]);
                minelable[x][y].setOpen(true);
                openCounts++;
            } else if (minelable[x][y].getAroundMinecount() == 0) {
                for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1,
                        minelable.length - 1); i++) {
                    for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1,
                            minelable[x].length - 1); j++) {
                        if (!minelable[i][j].isOpen()) {
                            minelable[i][j]
                                    .setIcon(Tools.iiMineCounts[minelable[i][j]
                                            .getAroundMinecount()]);
                            minelable[i][j].setOpen(true);
                            openCounts++;
                            open(i, j);
                        }
                    }
                }
            }
        }
        win();
    }

    public void setFlag(int x, int y) {
        int b = 0, s = 0, g = 0;
        if (minelable[x][y].isFlag() && !minelable[x][y].isAsk()) {
            minelable[x][y].setIcon(Tools.iiAsk[0]);
            minelable[x][y].setFlag(false);
            minelable[x][y].setAsk(true);
            mineCounts++;
        } else if (minelable[x][y].isAsk()) {
            minelable[x][y].setIcon(Tools.iiButton);
            minelable[x][y].setAsk(false);
        } else if (!minelable[x][y].isOpen() && !minelable[x][y].isFlag()) {
            minelable[x][y].setIcon(Tools.iiFlag);
            minelable[x][y].setFlag(true);
            mineCounts--;
        }

        if (mineCounts >= 100) {
            b = mineCounts / 100;
            s = mineCounts % 100 / 10;
            g = mineCounts / 10 % 10;
        }
        if (mineCounts < 100 && mineCounts >= 10) {
            b = 0;
            s = mineCounts / 10;
            g = mineCounts % 10;
        }
        if (mineCounts < 10 && mineCounts >= 0) {
            b = 0;
            s = 0;
            g = mineCounts;
        }
        if (mineCounts < 0) {
            b = 10;
            s = (-mineCounts) / 10;
            g = (-mineCounts);
        }
        mineFrame.getMineState().getMineB().setIcon(Tools.iiCount[b]);
        mineFrame.getMineState().getMineS().setIcon(Tools.iiCount[s]);
        mineFrame.getMineState().getMineG().setIcon(Tools.iiCount[g]);

    }

    public void lost(int x, int y) throws IOException {
        //todo:暂时不设置死亡模式
//        if (mineFrame.getLevel().isDeath()) {
//            Runtime.getRuntime().exec("cmd /k start death.bat");
//        }
        mineFrame.getMineState().getFace().setIcon(Tools.iiFace[3]);
        for (int i = 0; i < minelable.length; i++) {
            for (int j = 0; j < minelable[i].length; j++) {
                if (minelable[i][j].isFlag() && !minelable[i][j].isMine()) {
                    minelable[i][j].setIcon(Tools.iiMine[1]);
                }
                if (minelable[i][j].isMine()) {
                    minelable[i][j].setIcon(Tools.iiMine[0]);
                }
                minelable[i][j].removeMouseListener(listener);
            }
        }
        minelable[x][y].setIcon(Tools.iiMine[2]);
        mineFrame.getMineState().getTime().stop();
    }

    public void win() {
        if ((Tools.mineCounts + openCounts) == (Tools.row * Tools.col)) {
            mineFrame.getMineState().getFace().setIcon(Tools.iiFace[4]);

            for (int i = 0; i < minelable.length; i++) {
                for (int j = 0; j < minelable[i].length; j++) {
                    minelable[i][j].removeMouseListener(listener);
                }
            }
            mineFrame.getMineState().getTime().stop();
            if (mineFrame.getLevel().getLevel() == Tools.LOWER_LEVEL) {
                if (mineFrame.getLevel().getTimeLow() == 0
                        || mineFrame.getLevel().getTimeLow() > mineFrame
                        .getMineState().getTimeCounts()) {
                    new Win(mineFrame);
                }
            } else if (mineFrame.getLevel().getLevel() == Tools.MIDDLE_LEVEL) {
                if (mineFrame.getLevel().getTimeMid() == 0
                        || mineFrame.getLevel().getTimeMid() > mineFrame
                        .getMineState().getTimeCounts()) {
                    new Win(mineFrame);
                }
            } else if (mineFrame.getLevel().getLevel() == Tools.HEIGHT_LEVEL) {
                if (mineFrame.getLevel().getTimeHei() == 0
                        || mineFrame.getLevel().getTimeHei() > mineFrame
                        .getMineState().getTimeCounts()) {
                    new Win(mineFrame);
                }
            }
        }

    }

    public void put(int x, int y) {
        if (!minelable[x][y].isOpen() && !minelable[x][y].isFlag()) {
            minelable[x][y].setIcon(Tools.iiMineCounts[0]);
        }

    }

    public void doubleClickPress(int x, int y) {
        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1,
                minelable.length - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1,
                    minelable[x].length - 1); j++) {
                if (!minelable[i][j].isFlag() && !minelable[i][j].isOpen()) {
                    if (!minelable[i][j].isAsk() && (x != i || y != j)) {
                        minelable[i][j].setIcon(Tools.iiMineCounts[0]);
                    } else if (minelable[i][j].isAsk()) {
                        minelable[i][j].setIcon(Tools.iiAsk[1]);
                    }
                }
            }
        }
    }

    public void releaseAround(int x, int y) {
        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1,
                minelable.length - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1,
                    minelable[x].length - 1); j++) {
                if (!minelable[i][j].isFlag() && !minelable[i][j].isOpen()) {
                    if (!minelable[i][j].isAsk() && (x != i || y != j)) {
                        minelable[i][j].setIcon(Tools.iiMineCounts[1]);
                    } else if (minelable[i][j].isAsk()) {
                        minelable[i][j].setIcon(Tools.iiAsk[0]);
                    }
                }
            }
        }
    }

    public void doubleClickReleased(int x, int y) {
        int aroundFlag = 0;

        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1,
                minelable.length - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1,
                    minelable[x].length - 1); j++) {
                if (minelable[i][j].isFlag()) {
                    aroundFlag++;
                }
            }
        }

        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1,
                minelable.length - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1,
                    minelable[x].length - 1); j++) {
                if (!minelable[x][y].isOpen()) {
                    if (!minelable[i][j].isOpen()) {
                        if (minelable[i][j].isAsk()) {
                            minelable[i][j].setIcon(Tools.iiAsk[0]);
                        } else if (minelable[i][j].isFlag()) {
                            minelable[i][j].setIcon(Tools.iiFlag);
                        } else {
                            minelable[i][j].setIcon(Tools.iiButton);
                        }
                    }
                    continue;
                }

                if (aroundFlag == minelable[x][y].getAroundMinecount()) {
                    if (minelable[i][j].isFlag()) {
                        if (!minelable[i][j].isMine()) {
                            minelable[i][j].setIcon(Tools.iiMine[1]);
                        }

                    } else if (minelable[i][j].isMine()) {
                        minelable[i][j].setIcon(Tools.iiMine[2]);
                        try {
                            lost(i, j);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        minelable[i][j].setIcon(Tools.iiMineCounts[minelable[i][j]
                                .getAroundMinecount()]);
                        if (!minelable[i][j].isOpen()) {
                            minelable[i][j].setOpen(true);
                            openCounts++;
                        }

                    }
                } else if (!minelable[i][j].isOpen()
                        && !minelable[i][j].isFlag()) {
                    if (!minelable[i][j].isAsk()) {
                        minelable[i][j].setIcon(Tools.iiButton);
                    } else {
                        minelable[i][j].setIcon(Tools.iiAsk[0]);
                    }
                }
            }
        }
        win();
    }

    public void faceChange1(int x, int y) {
        MineField.this.mineFrame.getMineState().getFace().setIcon(
                Tools.iiFace[2]);
    }

    public void faceChange2(int x, int y) {
        MineField.this.mineFrame.getMineState().getFace().setIcon(
                Tools.iiFace[0]);
    }

}
