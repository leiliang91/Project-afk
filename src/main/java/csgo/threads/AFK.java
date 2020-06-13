package csgo.threads;

import csgo.CSGOCore;

import java.util.Random;


public class AFK extends Thread{
    @Override
    public void run() {
        try {
            afk();
        }
        catch (InterruptedException e) {
            System.out.println("afk ends! Reason: " + e);
        }
    }

    private void afk() throws InterruptedException {
        System.out.println("afk start!");
        Random r = new Random();
        while(true) {
//            int type = r.nextInt(2);
//            if(type == 0) {
                CSGOCore.mouse_move(10, 0);
//            }
//            else {
//                CSGOCore.mouse_move(-3000, 0);
//            }
            Thread.sleep(5);
        }
    }
}
