package csgo;

import org.junit.Test;

public class CSGOServiceTest {
    @Test
    public void runServiceLeft() throws Exception {
        CSGOService.main(new String[] {"0", "Scum V, you are punished for your racism/hate talk. Ruining your game experience...", "30", "300"});
    }

    @Test
    public void runServiceRight() throws Exception {
        CSGOService.main(new String[] {"1", "good to see your name up there http://www.reportedplayers.com/dota2/12v12-hall-of-shame/", "30", "300"});
    }
}

