package csgo;

import csgo.threads.AFK;

import static csgo.CSGOCore.beep;
import static csgo.CSGOCore.is6Down;
import static csgo.CSGOCore.isAltDown;

public class CSGOService {
    private static final int tick = 100; //100ms
    private static boolean afkServiceOn = false;
    private static AFK afkService = null;
    //private static AFK1 afkService1 = null;
    //private static AFK2 afkService2 = null;

    //for follow direction; 0 is bottom left home
    public static int DIREC = 0;
    public static String PRINT = "this stupid player";
    public static int MAP_OFFSET_LEFT;
    public static int MAP_OFFSET_RIGHT;

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println("4 args required");
            return;
        }
        DIREC = Integer.parseInt(args[0]) == 0? 0 : 1;
        PRINT = args[1];
        MAP_OFFSET_LEFT = Integer.parseInt(args[2]);
        MAP_OFFSET_RIGHT = Integer.parseInt(args[3]);

        while(true) {
            Thread.sleep(tick);
            if(isAltDown()) {
                if(afkServiceOn) {
                    beep(400, 600);
                    afkServiceOn = false;
                    if(afkService != null) {
                        afkService.interrupt();
                        //afkService1.interrupt();
                        //afkService2.interrupt();
                        afkService = null;
                        //afkService1 = null;
                        //afkService2 = null;
                    }
                } else {
                    beep(800, 600);
                    afkServiceOn = true;
                    if(afkService == null) {
                        afkService = new AFK();
                        //afkService1 = new AFK1();
                        //afkService2 = new AFK2();
                        afkService.start();
                        //afkService1.start();
                        //afkService2.start();
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
