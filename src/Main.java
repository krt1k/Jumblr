import java.util.Scanner;

public class Main{
    static dbConnect connect = new dbConnect();
    static String id, name, pass;
    static Scanner pk = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //Need to provide db connection...
        connect.getConnection();
        welcome();
    }

    //Welcome Screen
    public static void welcome() throws Exception {

        System.out.println("Welcome to JUMBLR!");
        System.out.println("Press the number to continue..");
        System.out.println("1. Login\n2. SignUp");
        int choice = pk.nextInt(); pk.nextLine();
        if(choice == 2){
            signup();

        } else{
            login();
            }

        }

    private static void login() throws Exception{
        System.out.println("Enter Nickname: ");
        id = inputStr();
        System.out.println("Enter Password: ");
        pass = inputStr();

        if(!connect.logUser(id,pass)){
            System.out.println("Invalid Password or NickName!");
            welcome();
        } else{
            int playerLvl = connect.getPlayerLvl(id);

            // continue or new game
            if(playerLvl != 1){
                System.out.println("Enter the choice:\n1. Continue\n" +
                        "2. New Game\n3.Logout");

                if (pk.nextInt() == 2) {
                    pk.nextLine();
                    if (!connect.resetPlayer(id)) welcome();
                } else if (pk.nextInt() == 3) {
                    pk.nextLine();
                    logout();
                }
            } else {
                do {
                    System.out.println("Enter the choice:\n1. New Game");
                }while(pk.nextInt()!=1);
            }

            Game.start(playerLvl,connect);
    }

}

    private static void signup() throws Exception {
        System.out.println("Enter your Full Name: ");
        name = inputStr();
        System.out.println("Enter your Nickname: ");
        id = inputStr();

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

                if (pk.next().equals("n")) {
                    welcome();
//                    pk.nextLine();
                }
            }
        }while(!pass.equals(cPass));

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