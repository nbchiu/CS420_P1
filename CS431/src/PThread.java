/**
 * Created by Nathaniel on 10/9/2016.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

public class PThread extends RThread implements Runnable{
    protected Thread P;
    private String fileContent;
    private String na;
    protected int[] Occurrences = new int[2];

    PThread(String s) {
        super("Read");
        na = s;
        fileContent = "";
    }
    public void run() {
        try{
            System.out.println("Running");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNext()) {
                if (sc.next() == "counts") {
                    System.out.println("UPPERCASE: " + Occurrences[0]);
                    System.out.println("LOWERCASE: " + Occurrences[1]);
                    System.out.println("DIGIT: " + Occurrences[2]);
                }
            }

            StringBuilder s_B = new StringBuilder();

            if(it.hasNext()){
                if(P.getState()== Thread.State.BLOCKED)
                    P.notify();
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
                P.wait(); // blocking thread
            }
            System.out.print(".");
            //P.sleep(50);
            
        }
        catch (InterruptedException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting: " + na);
        if(P == null) {
            P = new Thread(this, na);
            P.start();
        }
    }
}
