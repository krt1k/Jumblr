import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    static Scanner pk = new Scanner(System.in);
    public static void start(int level, dbConnect connect) throws SQLException {
        int random = (int) (Math.random() * 10);
        String question = connect.getWord(level,random);
//        String question = pk.next();
        System.out.println("Guess the word:");
        System.out.println("Level: "+level);

        LinkedList<Character> quest = new LinkedList<>();
        for (int i=0; i<question.length(); i++) {
            quest.add(question.charAt(i));
        }

        String suffled = "";
        do {
            Collections.shuffle(quest);
            for (Character i : quest) suffled += i;
        }while(suffled.equals(question));

        System.out.println(suffled);
        System.out.println("3 attempts left.");
        System.out.println("Type your guessed word: ");
        String answer = pk.nextLine();

        int attempt = 2;

        while((!answer.equals(question)) && (attempt != 0)){
            System.out.println("Retry. Wrong answer!");
            System.out.println(attempt+" attempts left.");
            System.out.println("Type your guessed word: ");
            answer = pk.nextLine();
            attempt--;
        }

        if(attempt <= 0){
            System.out.println();
        }

    }

    public static void main(String[] args) throws SQLException {
        dbConnect connect = new dbConnect();
        connect.getConnection();
        start(1, connect);
    }
}
