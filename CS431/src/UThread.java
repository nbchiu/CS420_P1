/**
 * Created by CHIU on 10/8/2016.
 */
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.*;

public class UThread extends PThread implements Runnable{
    private Thread U;
    private String name;
    //private int[] Occurrences = new int[2]; //Processing Thread
    //private int numUpper;
    //private int numLower;
    //private int numNum;

    UThread(String s) {
        super("Process");
        name = s;
        System.out.println("Creating: " + name);
    }

    public void run() {
        System.out.println("Running " + name);
        Scanner sc = new Scanner(System.in);
        try{
            //-------------------------------------------UI
            System.out.print("COMMAND: ");
            String trash = sc.next();
            System.out.print(trash);
            //if(sc.hasNext()){
                if(sc.next().equals("read")) {
                    q_F.add(sc.next());
                }
                else if(trash.equals("counts")){
                    System.out.println("UPPERCASE: " + Occurrences[0]);
                    System.out.println("LOWERCASE: " + Occurrences[1]);
                    System.out.println("DIGIT: " + Occurrences[2]);
                }
                else if(trash.equals("exit")){
                    U.interrupt();
                    P.interrupt();
                    R.interrupt();
                }
            else
                    System.out.print(trash);
            //}

            System.out.print(".");
            U.sleep(50);
        }
        catch(InterruptedException e) {
            System.out.println(e.toString());
            System.out.println("Thread " + name + " interrupted.");
        }
    }

    public void start() {
        System.out.println("Starting: " + name);
        if(U == null) {
            U = new Thread(this, name);
            U.start();
        }
    }
}
