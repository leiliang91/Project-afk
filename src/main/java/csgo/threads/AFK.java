package csgo.threads;

import csgo.CSGOCore;
import csgo.CSGOService;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;


public class AFK extends Thread {
    @Override
    public void run() {
        try {
            arc();
        } catch (InterruptedException | AWTException e) {
            System.out.println("afk ends! Reason: " + e);
        }
    }

    private void arc() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        while(true) {
            if (CSGOCore.isX2ButtonDown()) {
                robot.keyPress(KeyEvent.VK_F1);
                robot.keyRelease(KeyEvent.VK_F1);


                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);

                Thread.sleep(10);

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

                PointerInfo pi = MouseInfo.getPointerInfo();
                Point currentPoint = pi.getLocation();
                int x = (int) currentPoint.getX();
                int y = (int) currentPoint.getY();


                robot.mouseMove(x, y - 375);

                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);

                Thread.sleep(10);

                robot.mouseMove(x, y);

                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                Thread.sleep(100);
            }
            Thread.sleep(50);
        }

    }
}

