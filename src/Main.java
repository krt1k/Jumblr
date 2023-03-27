import java.util.Scanner;

public class Main{
    static dbConnect connect = new dbConnect();
    static String id, name, pass;
    static Scanner pk = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //Need to provide db connection...
//        dbConnect.getConnection();
        welcome();
    }

    //Welcome Screen
    public static void welcome() throws Exception {

        System.out.println("\n" +Color.YELLOW+
                "░░█ █░█ █▀▄▀█ █▄▄ █░░ █▀█\n" +
                "█▄█ █▄█ █░▀░█ █▄█ █▄▄ █▀▄");
        System.out.println();
        System.out.println(Color.RESET+"Welcome to JUMBLR!");
        System.out.println("Press the number to continue..");
        System.out.println(Color.LIGHT_BLUE+"1. Login\n2. SignUp\n3. LeaderBoard"+Color.RESET);
        int choice = pk.nextInt(); pk.nextLine();
        if(choice == 2){
            signup();

        } else if(choice == 3){
            connect.displayLeaderBoard();
            System.out.println("Press b to go back..");
            if(pk.next().equals("b"))
                welcome();
        } else{
            login();
            }

        }

    private static void login() throws Exception{
        System.out.println("Enter Nickname: ");
        id = inputStr();
        System.out.println("Enter Password: ");
        pass = inputStr();
        System.out.println("----------------------");

        loggedIn();
    }

    public static void loggedIn() throws Exception {
        if (!connect.logUser(id, pass)) {
            System.out.println(Color.RED+"Invalid Password or NickName!"+Color.RESET);
            welcome();
        } else {
            int playerLvl = connect.getPlayerLvl(id);

            // continue or new game
            if (playerLvl != 1) {
                System.out.println("Enter the choice:\n"+Color.LIGHT_BLUE+"1. Continue\n" +
                        "2. New Game\n3. LeaderBoard\n4. Logout"+Color.RESET);
                System.out.println("----------------------");

                int c = pk.nextInt();
                if(c == 1){
                    Game.start(connect.getPlayerLvl(id));

                } else if (c == 2) {
                    if (!connect.resetPlayer(id)) welcome();
                    else Game.start(connect.getPlayerLvl(id));

                } else if(c == 3){
                    connect.displayLeaderBoard();
                    System.out.println("Press b to go back..");
                    if(pk.next().equals("b"))
                        loggedIn();

                } else if (c == 4) {
                    logout();
                }


            } else {

                System.out.println(Color.LIGHT_BLUE+"Enter the choice:\n1. New Game\n2. LeaderBoard\n3. Logout"+Color.RESET);
                System.out.println("----------------------");

                int cc = pk.nextInt();

                if(cc == 1)
                    Game.start(connect.getPlayerLvl(id));
                else if (cc == 2) {
                    connect.displayLeaderBoard();
                    System.out.println("Press b to go back..");
                    if(pk.next().equals("b"))
                        loggedIn();

                } else if (cc==3)
                    logout();
        }

        }
    }

    private static void signup() throws Exception {
        System.out.println("Enter your Full Name: ");
        name = inputStr();

        do {
            System.out.println("Enter your Nickname: ");
            id = inputStr();
        } while(connect.ifUserExist(id));


        String cPass;
        do {
            System.out.println("Enter Password: ");
            pass = inputStr();

            System.out.println("Confirm Password: ");
            cPass = inputStr();

            //Check if pass & cPass matches.
            if(!pass.equals(cPass)) {
                System.out.println("Passwords mismatch.. " +
                        "Press y to Re-enter your Password!\n " +
                        "or Press n to exit.");

                if (pk.nextLine().equals("n")) {
                    welcome();
//                    pk.nextLine();
                }
            }
        }while(!pass.equals(cPass));

        System.out.println("----------------------");
        connect.createUser(name,id,pass);
        welcome();
    }


    public static String inputStr(){
        return pk.nextLine();
    }

    public static void logout() throws Exception {
        welcome();
    }
}