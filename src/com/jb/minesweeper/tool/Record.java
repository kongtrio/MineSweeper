package com.jb.minesweeper.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.jb.minesweeper.bean.Level;

public class Record {

    private Level level;
    private Properties record;
    private File file;

    public Record(Level level) {
        this.level = level;
        file = new File("./record.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileInputStream fileIn = null;
        record = new Properties();
        try {
            fileIn = new FileInputStream(file);
            record.load(fileIn);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        save();

    }

    public void getValue() {
        int low = Integer.parseInt(record.getProperty("lowTime"));
        int mid = Integer.parseInt(record.getProperty("midTime"));
        int hei = Integer.parseInt(record.getProperty("heiTime"));
        level.setTimeLow(low);
        level.setTimeMid(mid);
        level.setTimeHei(hei);
        level.setNameLow(record.getProperty("lowName"));
        level.setNameMid(record.getProperty("midName"));
        level.setNameHei(record.getProperty("heiName"));
    }

    public void setValue(String key, String value) {
        record.setProperty(key, value);
        save();
    }

    public void save() {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
            record.store(fileOut, "添加");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
