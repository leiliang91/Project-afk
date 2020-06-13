package csgo;

import csgo.threads.AFK;
import csgo.threads.AFK1;
import csgo.threads.AFK2;

import static csgo.CSGOCore.*;

public class CSGOService {
    private static final int tick = 100; //100ms
    private static boolean afkServiceOn = false;
    private static AFK afkService = null;
    private static AFK1 afkService1 = null;
    private static AFK2 afkService2 = null;

    public static void main(String[] args) throws Exception {
        while(true) {
            Thread.sleep(tick);
            if(isAltDown()) {
                if(afkServiceOn) {
                    beep(400, 600);
                    afkServiceOn = false;
                    if(afkService != null) {
                        afkService.interrupt();
                        afkService1.interrupt();
                        afkService2.interrupt();
                        afkService = null;
                        afkService1 = null;
                        afkService2 = null;
                    }
                } else {
                    afkServiceOn = true;
                    if(afkService == null) {
                        afkService = new AFK();
                        afkService1 = new AFK1();
                        afkService2 = new AFK2();
                        afkService.start();
                        afkService1.start();
                        afkService2.start();
                    }
                }
            }

            if(is6Down()) {
                beep(400, 600);
                beep(400, 600);
                System.exit(0);
            }
        }
    }
}
