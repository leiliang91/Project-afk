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
            //afk();
            dota_follow();
            //dota_click();
        } catch (InterruptedException | AWTException e) {
            System.out.println("afk ends! Reason: " + e);
        }
    }

    private void afk() throws InterruptedException {
        System.out.println("afk start!");
        Random r = new Random();
        while (true) {
            int type = r.nextInt(2);
            if (type == 0) {
                CSGOCore.mouse_move(1, 0);
                CSGOCore.pressW();
            } else {
                CSGOCore.mouse_move(-1, 0);
                CSGOCore.pressS();
            }
            Thread.sleep(10000);
        }
    }

    private void dota_click() throws InterruptedException, AWTException {
        while (true) {
            CSGOCore.pressLMouse();
            Thread.sleep(3000);
        }

    }

    private void dota_follow() throws InterruptedException, AWTException {
        boolean leftHome = CSGOService.DIREC == 0;
        String print = CSGOService.PRINT;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int miniMapOffset = leftHome ? CSGOService.MAP_OFFSET_LEFT : CSGOService.MAP_OFFSET_RIGHT;
        int targetX = miniMapOffset;
        int targetY = (int) screenSize.getHeight() - miniMapOffset;

        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        int pointX = (int) point.getX();
        int pointY = (int) point.getY();

        Robot robot = new Robot();
        int i = 0;
        while (true) {
            if (i % 20 == 0) {
                sendKeys(robot, print);
            }
            robot.mouseMove(pointX, pointY);
            robot.keyPress(KeyEvent.VK_V);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(5000);
            robot.mouseMove(targetX, targetY);
            Thread.sleep(300);
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            Thread.sleep(1000);
            i++;
        }

    }

    private void sendKeys(Robot robot, String keys) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(100);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_ENTER);
        String withPrefix = "[" + pstNow() + "] " + keys;
        StringSelection stringSelection = new StringSelection(withPrefix);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private String pstNow() {
        //capturing today's date
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
        df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return df.format(today);
    }

    private String generateRandomStr() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

       return "[" + generatedString + "] ";
    }
}

