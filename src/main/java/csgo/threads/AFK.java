package csgo.threads;

import csgo.CSGOCore;
import csgo.CSGOService;

import java.awt.*;
import java.util.Random;


public class AFK extends Thread{
    @Override
    public void run() {
        try {
            //afk();
            dota_kick();
            //dota_click();
        }
        catch (InterruptedException | AWTException e) {
            System.out.println("afk ends! Reason: " + e);
        }
    }

    private void afk() throws InterruptedException {
        System.out.println("afk start!");
        Random r = new Random();
        while(true) {
            int type = r.nextInt(2);
            if(type == 0) {
                CSGOCore.mouse_move(1, 0);
                CSGOCore.pressW();
           }
            else {
                CSGOCore.mouse_move(-1, 0);
                CSGOCore.pressS();
            }
            Thread.sleep(10000);
        }
    }

    private void dota_click() throws InterruptedException, AWTException {
        while(true) {
            CSGOCore.pressLMouse();
            Thread.sleep(3000);
        }

    }
    private void dota_kick() throws InterruptedException, AWTException {
        boolean sony = CSGOService.SONY == 1;
        System.out.println("Running on SONY == " + sony);

        int okX;
        int okY;
        if (sony) {
            //1920 * 1080
            okX = 960;
            okY = 600;
        }
        else {
            //2560 * 1440
            okX = 1280;
            okY = 800;
        }

        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        int pointX = (int) point.getX();
        int pointY = (int) point.getY();


        Robot robot = new Robot();
        while(true) {
            CSGOCore.pressLMouse();
            CSGOCore.pressLMouse();
            robot.mouseMove(okX, okY);
            Thread.sleep(200);
            CSGOCore.pressLMouse();
            robot.mouseMove(pointX, pointY);
            Thread.sleep(200);
        }
    }}

