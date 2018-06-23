package com.jb.minesweeper.tool;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tools {

    public static final String LOWER_LEVEL = "低级";
    public static final String MIDDLE_LEVEL = "中级";
    public static final String HEIGHT_LEVEL = "高级";
    public static final String CUSTOM_LEVEL = "自定义";
    public static int row = 9;
    public static int col = 9;
    public static int mineCounts = 10;
    public static Image icon = new ImageIcon("./image/icon.gif").getImage();
    public static ImageIcon iiIcon = new ImageIcon("./image/icon.gif");
    public static ImageIcon iiCount[];
    public static ImageIcon iiFace[];
    public static ImageIcon iiButton = new ImageIcon("./image/blank.gif");
    public static ImageIcon iiFlag = new ImageIcon("./image/flag.gif");
    public static ImageIcon iiMine[];
    public static ImageIcon iiMineCounts[];
    public static ImageIcon iiAsk[];

    static {
        iiCount = new ImageIcon[11];
        iiMine = new ImageIcon[4];
        iiMineCounts = new ImageIcon[9];
        iiAsk = new ImageIcon[3];
        iiFace = new ImageIcon[10];
        for (int i = 0; i < iiCount.length; i++) {

            iiCount[i] = new ImageIcon("./image/d" + i + ".gif");
        }

        for (int i = 0; i < iiAsk.length; i++) {

            iiAsk[i] = new ImageIcon("./image/ask" + i + ".gif");
        }

        for (int i = 0; i < iiMine.length; i++) {

            iiMine[i] = new ImageIcon("./image/mine" + i + ".gif");
        }

        for (int i = 0; i < iiMineCounts.length; i++) {

            iiMineCounts[i] = new ImageIcon("./image/" + i + ".gif");
        }

        for (int j = 0; j < iiFace.length; j++) {
            iiFace[j] = new ImageIcon("./image/face" + j + ".gif");
        }

    }
}
