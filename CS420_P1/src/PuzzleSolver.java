import java.sql.Connection;
import java.util.*;

/**
 * Created by CHIU on 10/21/2016.
 */
public class PuzzleSolver {
    private final int SIZE = 3;
    private PriorityQueue Frontier;
    private Hashtable Explore;
    private char[][] Puzzle;
    private ArrayList<String> pool;

    PuzzleSolver() {
        Frontier = new PriorityQueue();
        Explore = new Hashtable();
        Puzzle = new char[SIZE][SIZE];
        pool = new ArrayList<>();
        for(int i = 0 ; i <9 ; i++) {
            pool.add(Integer.toString(i));
        }
        Collections.shuffle(pool);
        /*for(int i = 0 ; i <9 ; i++) {
            System.out.println(pool.get(i));
        }*/
    }

    public static void main (String[] args) {
        PuzzleSolver ps = new PuzzleSolver();
        int opt = choice();
        if(opt==0) {
            randomizeArray(ps);
            printTest(ps);
        }
        else {
            inputInfo(ps);
            printTest(ps);
        }
    }

    public static int choice(){
        Scanner sc = new Scanner(System.in);
        System.out.print("RANDOM[0] or INPUT[1]: ");
        int opt = sc.nextInt();
        if(!(opt==0 || opt==1)) {
            System.out.println("ERROR: INVALID INPUT.");
            System.out.println("PLEASE TRY AGAIN.");
            System.out.println("CHOICES: 0 1");
            System.exit(1);
        }
        sc.close();
        return opt;
    }

    public static void randomizeArray(PuzzleSolver ps) {
        int temp = 0;
        for(int row = 0 ; row < 3 ; row++) {
            for (int col = 0 ; col < 3 ; col++){
                ps.Puzzle[row][col] = ps.pool.get(temp++).charAt(0);
            }
        }
    }

    public static void inputInfo(PuzzleSolver ps) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER PUZZLE: ");
        int col,row = 0;
        while(row<=2){
            col = 0;

            StringBuilder sb = new StringBuilder(sc.nextLine());
            removeBlank(sb);
            while(col!=3){
                ps.Puzzle[row][col]= sb.charAt(col);
                col++;
            }

            row++;
        }
        printTest(ps);
        sc.close();
    }

    public static void printTest(PuzzleSolver ps) {
        for(int i =0; i < ps.Puzzle.length ; i++) {
            for(int j = 0 ; j < ps.Puzzle[i].length ; j++) {
                System.out.print(ps.Puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void removeBlank(StringBuilder sb) {
        int j =0;
        for(int i = 0 ; i <sb.length() ; i++) {
            if(!Character.isWhitespace(sb.charAt(i))) {
                sb.setCharAt(j++,sb.charAt(i));
            }
        }
        sb.delete(j, sb.length());
    }

}
