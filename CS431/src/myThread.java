/**
 * Created by CHIU on 10/8/2016.
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.*;

public class myThread implements Runnable{
    private Thread U;
    private Thread R;
    private Thread P;
    private String name;
    private String fileContent;
    private static final String READ = "read filename.txt";
    private static final String COUNTS = "counts";
    private static final String EXIT = "exit";
    private int[] Occurrences = new int[2]; //Processing Thread
    //private int numUpper;
    //private int numLower;
    //private int numNum;

    myThread(String s) {
        name = s;
        System.out.println("Creating: " + name);
        //numLower=0;
        //numLower=0;
        //numNum=0;
    }

    public void run() {
        System.out.println("Running " + name);
        Scanner sc = new Scanner(System.in);
        try{
            U.sleep(50);
            PriorityQueue<String> q_F = new PriorityQueue<String>();
            Iterator<String> it = q_F.iterator();
            //-------------------------------------------UI
            if(sc.hasNext()){
                if(sc.next()=="read")
                    q_F.add(sc.next());
                else if(sc.next() == "counts"){
                    System.out.println("UPPERCASE: " + Occurrences[0]);
                    System.out.println("LOWERCASE: " + Occurrences[1]);
                    System.out.println("DIGIT: " + Occurrences[2]);
                }
                else if(sc.next() == "exit"){
                    U.interrupt();
                    P.interrupt();
                    R.interrupt();
                }
            }
            //-------------------------------------------
            StringBuilder s_B = new StringBuilder();

            if(it.hasNext()){
                //------------------------------------------ PROC
                fileContent = s_B.append(Files.readAllBytes(Paths.get(it.next()))).toString();
                for(int i = 0; i < fileContent.length() ; i++) {
                    if(Character.isUpperCase(fileContent.charAt(i)))
                        Occurrences[0]++;
                    else if(Character.isLowerCase(fileContent.charAt(i)))
                        Occurrences[1]++;
                    else if(Character.isDigit(fileContent.charAt(i)))
                        Occurrences[2]++;
                }
                //-----------------------------------------------
            }
            else {
                R.wait(); // blocking file reading thread
                P.wait(); // blocking proccess thread
            }
        }
        catch(InterruptedException e) {
            System.out.println(e.toString());
            System.out.println("Thread " + name + " interrupted.");
        } catch (IOException e) {
            e.printStackTrace();
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
