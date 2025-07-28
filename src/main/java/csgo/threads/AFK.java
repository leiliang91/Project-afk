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
            //1 shang mian, 2 xia mian
            guaji(1);
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


                robot.mouseMove(x+150, y);

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

    private void guaji(int i) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Random r = new Random();

        /*
        x: 236, y: 1082
        x: 179, y: 1080
        x: 120, y: 1098
        afk ends! Reason: java.lang.InterruptedException
        x: 138, y: 1427
        x: 188, y: 1415
        x: 252, y: 1427
        afk ends! Reason: java.lang.InterruptedException
         */
        int[] xs = i == 1? new int[] {236, 179,120}:new int[]{138, 188,252};
        int[] ys = i == 1? new int[] {1082, 1080, 1098}:new int[]{1427, 1415, 1427};

        while(true) {
            for(int j = 0; j < 3; j++) {
                int delta = -2 + r.nextInt(5);
                robot.mouseMove(xs[j] + delta, ys[j]+ delta);
                Thread.sleep(100 + r.nextInt(100));
                robot.keyPress(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_A);
                Thread.sleep(100 + r.nextInt(30000));
            }

            //找坐标用
//            if(CSGOCore.isEndDown()) {
//                PointerInfo pi = MouseInfo.getPointerInfo();
//                Point currentPoint = pi.getLocation();
//                int x = (int) currentPoint.getX();
//                int y = (int) currentPoint.getY();
//                System.out.println("x: " + x + ", y: " + y);
//                Thread.sleep(100);
//            }
//            Thread.sleep(100);
        }


    }
}

