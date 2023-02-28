import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Game extends Main{
    static Scanner pk = new Scanner(System.in);
    public static void start(int level, dbConnect connect) throws Exception {
        int random = (int) (Math.random() * 10);
        String question = connect.getWord(level,random);
//        String question = pk.next();
        System.out.println("----------------------");
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

        System.out.println("Available Coins: "+ connect.getCoins(id));
        System.out.println("----------------------");
        System.out.println("3 attempts left.");
        System.out.println(suffled);
        System.out.println("Type your guessed word: ");
        String answer = pk.nextLine();

        if(!answer.equals(question)) {

            int attempt = 2;

            while ((!answer.equals(question)) && (attempt != 0)) {
                System.out.println("Retry. Wrong answer!");
                System.out.println("----------------------");
                System.out.println("3 Coins Debited..");

                connect.debitCoins(3);
                System.out.println("Available Coins: " + connect.getCoins(id));
                System.out.println(attempt + " attempts left.");
                if (gameOver(connect)) {
                    start(connect.getPlayerLvl(id), connect);
                }
                System.out.println(suffled);
                System.out.println("Type your guessed word: ");
                answer = pk.nextLine();
                attempt--;
            }

            if (attempt <= 0) {
                System.out.println("----------------------");
                System.out.println("5 Coins Debited..");
                System.out.println("Available Coins: " + connect.getCoins(id));
                
                //retry to be implemented
                System.out.println("Press y to Retry or n to exit..");
                
                String tempChoice = pk.next(); pk.nextLine();
                if(tempChoice.equals("y")){
                    start(connect.getPlayerLvl(id),connect);
                } else {
                    loggedIn();
                }
            }
        } else{
            System.out.println("Correct answer!!\n 2 Coins Credited..");
            System.out.println("----------------------");
//            System.out.println("Available Coins: " + connect.creditCoins(2));
            start(connect.levelUpgrade(1),connect);
        }

    }

    public static boolean gameOver(dbConnect connect) throws Exception {
        if( connect.debitCoins(1) <= 0){
            System.out.println("Not enough Coins!\n GAME OVER!!!");
            System.out.println("----------------------");
            connect.resetPlayer(id);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        dbConnect connect = new dbConnect();
        connect.getConnection();
        start(1, connect);
    }
}
