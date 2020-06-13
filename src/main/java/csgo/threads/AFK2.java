package csgo.threads;

import csgo.CSGOCore;

import java.util.Random;


public class AFK2 extends Thread{
    private static final int tick = 1;
    private static final long smallGap = 30;
    private static final long mediumGap = 50;
    private static final long largeGap = 130;
    private static final long timeChecker1 = 100;
    private static final long timeChecker2 = 300;
    private boolean aDown = false;
    private boolean dDown = false;
    private long aTime;
    private long dTime;


    @Override
    public void run() {
        try {
            afk();
        }
        catch (InterruptedException e) {
            System.out.println("afk2 ends! Reason: " + e);
        }
    }

    private void afk() throws InterruptedException {
        System.out.println("afk2 start!");
        Random r = new Random();

        while(true) {
            int n = r.nextInt(10000) + 1000;
//            CSGOCore.pressW(1000);
            CSGOCore.pressLMouse();
            //CSGOCore.pressSpace();
            Thread.sleep(n);
        }
    }
}
