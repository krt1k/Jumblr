import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Game extends Main{
    static Scanner pk = new Scanner(System.in);
    public static void start(int level) throws Exception {
        int random = (int) (Math.random() * 20);

        while(random%20 == 0){
            if (random == 0) {
                random++;
            } else if (random >= 20) {
                random %= 20;
            }
        }

        String question = connect.getWord(level,random);
//        String question = pk.next();
        System.out.println("----------------------");
        System.out.println(Color.YELLOW_BRIGHT+"JUMBLED WORDS:"+Color.RESET);
        System.out.println("Level: "+Color.LIGHT_PINK+level+Color.RESET);

        LinkedList<Character> quest = new LinkedList<>();
        for (int i=0; i<question.length(); i++) {
            quest.add(question.charAt(i));
        }

        StringBuilder shuffled;
        do {
            shuffled = new StringBuilder();
            Collections.shuffle(quest);
            for (Character i : quest) shuffled.append(i);
        }while(shuffled.toString().equals(question));

        System.out.println("Available Coins: "+Color.LIGHT_PINK+ connect.getCoins(id)+ Color.RESET);
        System.out.println("3 attempts left.");
        System.out.println("----------------------");
        System.out.println("Jumbled word: "+Color.CYAN_BOLD+shuffled+Color.RESET);
        System.out.println("Type your guessed word: ");
        String answer = pk.nextLine();

        if(!answer.equals(question)) {

            int attempt = 2;

            while ((!answer.equals(question)) && (attempt != 0)) {
                System.out.println(Color.RED+"Retry. Wrong answer!");
                System.out.println("3 Coins Debited.."+Color.RESET);
                System.out.println("----------------------");

                connect.debitCoins(3);
                System.out.println("Available Coins: " +Color.LIGHT_PINK+ connect.getCoins(id)+Color.RESET);
                System.out.println(attempt + " attempts left.");
                if (gameOver(connect)) {
                    start(connect.getPlayerLvl(id));
                }

                System.out.println("----------------------");
                System.out.println("Jumbled word: "+Color.CYAN_BOLD+shuffled+Color.RESET);
                System.out.println("Type your guessed word: ");
                answer = pk.nextLine();
                if(answer.equals(question)) correctAnswer(connect);

                attempt--;
            }

            if (attempt <= 0) {
                System.out.println("----------------------");
                System.out.println(Color.RED_BRIGHT+"No attempts remaining!");
                System.out.println("5 Coins Debited.."+Color.RESET);
                System.out.println("Available Coins: " +Color.LIGHT_PINK+ connect.debitCoins(5)+ Color.RESET);
                
                //retry to be implemented
                System.out.println("Press y to Retry or n to exit..");
                
                String tempChoice = pk.next(); pk.nextLine();
                if(tempChoice.equals("y")){
                    start(connect.getPlayerLvl(id));
                } else {
                    loggedIn();
                }
            }
        } else{
            correctAnswer(connect);
        }

    }

    public static void correctAnswer(dbConnect connect) throws Exception {
        System.out.println(Color.GREEN_BRIGHT+"Correct answer!!\n2 Coins Credited.."+Color.RESET);
//            System.out.println("----------------------");
        connect.creditCoins(2);
        start(connect.levelUpgrade(1));
    }

    public static boolean gameOver(dbConnect connect) throws Exception {
        if( connect.getCoins(id) <= 0){
            System.out.println(Color.RED+"Not enough Coins!\n GAME OVER!!!"+Color.RESET);
            System.out.println("----------------------");
            connect.resetPlayer(id);
            return true;
        }
        return false;
    }
}