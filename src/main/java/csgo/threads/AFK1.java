package csgo.threads;

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
//        System.out.println("afk1 start!");
//        Random r = new Random();
//        while(true) {
//            int type = r.nextInt(2);
//            if (type == 0) {
//                //CSGOCore.mouse_move(0, 500);
//            }
//            else {
//                //CSGOCore.mouse_move(0, -500);
//            }
//            Thread.sleep(100);
//        }
    }
}
