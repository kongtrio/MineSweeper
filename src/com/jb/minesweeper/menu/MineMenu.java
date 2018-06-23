package com.jb.minesweeper.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.jb.minesweeper.Dialog.About;
import com.jb.minesweeper.Dialog.DeathExit;
import com.jb.minesweeper.Dialog.DeathOpen;
import com.jb.minesweeper.Dialog.HeroesDialog;
import com.jb.minesweeper.Dialog.SetDialog;
import com.jb.minesweeper.frame.MineFrame;
import com.jb.minesweeper.tool.Tools;

public class MineMenu extends JMenuBar {

    private MineFrame mineFrame;
    private JMenu game;
    private JMenu help;
    private JMenuItem newGame;
    private JMenuItem primary;
    private JMenuItem second;
    private JMenuItem superior;
    private JMenuItem setBySelf;
    private JMenuItem hero;
    private JMenuItem exit;
    private JMenuItem about;
    private JMenuItem death;

    public MineMenu(final MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        game = new JMenu("游戏(G)");
        help = new JMenu("帮助(F)");
        newGame = new JMenuItem("新游戏(N)");
        primary = new JMenuItem("初级(P)");
        second = new JMenuItem("中级 (S)");
        superior = new JMenuItem("高级（U）");
        setBySelf = new JMenuItem("自定义(B)");
        hero = new JMenuItem("英雄榜(o)");
        death = new JMenuItem("死亡模式");
        exit = new JMenuItem("退出 (X)");
        about = new JMenuItem("关于(A)");
        game.add(newGame);
        newGame.setMnemonic('n');
        game.add(primary);
        primary.setMnemonic('p');
        game.add(second);
        second.setMnemonic('s');
        game.add(superior);
        superior.setMnemonic('u');
        game.add(setBySelf);
        setBySelf.setMnemonic('b');
        game.add(hero);
        help.setMnemonic('o');
        game.add(death);
        game.add(exit);
        exit.setMnemonic('x');
        help.add(about);
        about.setMnemonic('a');
        this.add(game);
        game.setMnemonic('g');
        this.add(help);
        help.setMnemonic('f');
        death.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!MineMenu.this.mineFrame.getLevel().isDeath()) {
                    MineMenu.this.mineFrame.getLevel().setDeath(true);
                    new DeathOpen(mineFrame);
                } else {
                    MineMenu.this.mineFrame.getLevel().setDeath(false);
                    new DeathExit();
                }
            }
        });
        hero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new HeroesDialog(MineMenu.this.mineFrame);

            }
        });
        setBySelf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MineMenu.this.mineFrame.getLevel().setLevel(Tools.CUSTOM_LEVEL);
                new SetDialog(MineMenu.this.mineFrame);

            }
        });
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new About();

            }
        });
        newGame.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                MineMenu.this.mineFrame.newGame();
            }
        });

        primary.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Tools.col = 9;
                Tools.row = 9;
                Tools.mineCounts = 10;
                MineMenu.this.mineFrame.getLevel().setLevel(Tools.LOWER_LEVEL);
                MineMenu.this.mineFrame.primary();
            }
        });
        second.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Tools.col = 16;
                Tools.row = 16;
                Tools.mineCounts = 40;
                MineMenu.this.mineFrame.getLevel().setLevel(Tools.MIDDLE_LEVEL);
                MineMenu.this.mineFrame.second();

            }
        });
        superior.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Tools.col = 30;
                Tools.row = 16;
                Tools.mineCounts = 99;
                MineMenu.this.mineFrame.getLevel().setLevel(Tools.HEIGHT_LEVEL);
                MineMenu.this.mineFrame.superior();
            }
        });
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
