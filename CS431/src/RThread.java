/**
 * Created by Nathaniel on 10/9/2016.
 */
import java.util.*;
import java.lang.*;

public class RThread implements Runnable {
    protected Thread R;
    private String nam;
    protected PriorityQueue<String> q_F;
    protected Iterator<String> it;

    RThread(String s) {
        nam = s;
        q_F = new PriorityQueue<String>();
        it = q_F.iterator();
    }

    public void run() {
        try {
            System.out.println("Running");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNext()){
                if(R.getState()== Thread.State.BLOCKED)
                    R.notify();
                if(sc.next() == "read")
                    q_F.add(sc.next());
            }
            else
                R.wait(); // blocking thread
            System.out.print(".");
            R.sleep(50);

        }
        catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
    public void start() {
        System.out.println("Starting: " + nam);
        if(R == null) {
            R = new Thread(this, nam);
            R.start();
        }
    }
}
