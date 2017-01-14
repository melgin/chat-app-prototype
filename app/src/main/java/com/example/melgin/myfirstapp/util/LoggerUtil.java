package com.example.melgin.myfirstapp.util;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.melgin.myfirstapp.WhatsAppChat;

import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by melgin on 08/01/2017.
 */

public class LoggerUtil {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private static final DateFormat DF2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static LoggerUtil instance = null;
    private PrintWriter pw = null;

    public synchronized static LoggerUtil getInstance(){
        if(instance == null){
            instance = new LoggerUtil();
        }

        return instance;
    }

    public synchronized static void destroy(){
        if(instance != null){
            instance.close();
        }

        instance = null;
    }

    private LoggerUtil(){
        System.out.println("Creating a new instance!");
    }

    public void log(String text){
        logger.error(text);
        if(pw != null){
            pw.println(getTime() + text);
            pw.flush();
        } else {
            System.out.println("pw is null");
        }
    }

    public void close(){
        if(pw != null){
            pw.flush();
            pw.close();
            pw = null;
        }
    }

    public void error(String text){
        log(text);
    }

    private String getTime(){
        return DF2.format(new Date()) + " ";
    }

    public boolean init(WhatsAppChat whatsAppChat) {
        if (ContextCompat.checkSelfPermission(whatsAppChat, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(whatsAppChat, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(whatsAppChat, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            }
        }

        try {
            pw = new PrintWriter(Environment.getExternalStorageDirectory().getAbsoluteFile() + File.separator + "normal-prototype-" + DF.format(new Date()) + ".txt");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            pw = null;
            return false;
        }
    }
}
