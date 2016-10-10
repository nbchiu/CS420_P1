/**
 * Created by CHIU on 10/8/2016.
 */

import java.lang.*;

public class Ex2 {

    public static void main(String[] args) {

        UThread UI = new UThread("U/I");
        PThread PT = new PThread("PROCESS");
        RThread RT = new RThread("READ");
        UI.start();
        PT.start();
        RT.start();
    }
}
