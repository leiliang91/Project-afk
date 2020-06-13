import csgo.CSGOCore;
import org.junit.Test;

import java.util.Random;

public class MyTest {
    @Test
    public void test() throws Exception {
        for (int i = 0; i < 2400; i++) {
            if(CSGOCore.is6Down()) {
                break;
            }
            Thread.sleep(50);
            Random r = new Random();
            int j = r.nextInt(4);
//            if (j == 0 || j == 1) {
//                CSGOCore.pressA(500);
//                CSGOCore.pressD(500);
//                CSGOCore.pressLMouse();
//            } else {
                CSGOCore.pressW(500);
                CSGOCore.pressS(200);
                CSGOCore.mouse_move(1000, 0);
                CSGOCore.mouse_move(1000, 0);
//            }
        }
    }
 }