/**
 * Created by CHIU on 10/8/2016.
 */
import java.util.*;
import java.lang.*;

public class Ex2 {
    private static final int NUMBER_OF_THREADS = 3;
    private static final String READ = "read filename.txt";
    private static final String COUNTS = "counts";
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        myThread[] mT = new myThread[NUMBER_OF_THREADS]; //creation of 3 threads

        Scanner sc = new Scanner(System.in);
        String input="";

        PriorityQueue<String> queue = new PriorityQueue<String>();
        Iterator<String> itr = queue.iterator();
        while(true) {
            queue.add(input);
        }
    }
}
