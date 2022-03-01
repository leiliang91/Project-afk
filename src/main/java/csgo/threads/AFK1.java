package csgo.threads;

import csgo.CSGOCore;

public class AFK1 extends Thread{
    @Override
    public void run() {
        try {
            afk();
        }
        catch (InterruptedException e) {
            System.out.println("afk1 ends! Reason: " + e);
        }
    }

    private void afk() throws InterruptedException {
        System.out.println("afk1 start!");
        while(true) {
            CSGOCore.pressSpace();
             Thread.sleep(15000);
        }
    }
}
