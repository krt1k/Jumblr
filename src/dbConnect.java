import java.sql.*;
import java.util.Scanner;

public class dbConnect {
    private static Connection con;
    static Scanner pk = new Scanner(System.in);
    public void getConnection() throws Exception{

//            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jumblr";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user, password);

    }

    public void createUser(String name, String id, String pass) throws SQLException {

        String query = "INSERT INTO login (id,name,pass) VALUES ('"+id+"','"+name+"','"+pass+"');";
        Statement st = con.createStatement();
        st.execute(query);
        System.out.println(id+" user created successfully!\nChoose Login menu and continue...");
        System.out.println("----------------------");

    }

    public boolean logUser(String id, String pass) throws SQLException {

        String query = "SELECT * FROM login WHERE id = '"+id+"' AND pass = '"+pass+"';";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);

        boolean b = resultSet.next();

        if(b) System.out.println("Welcome "+ id+"!");

        return b;

    }

    public int getPlayerLvl(String id) throws SQLException {
        String query = "SELECT levelNo FROM progress WHERE id = '"+id+"';";
        Statement stmt = con.createStatement();
        ResultSet ans = stmt.executeQuery(query);

        if(ans.next())
            return ans.getInt(1);
        return 0;
    }

    public boolean resetPlayer(String id) throws SQLException {
        System.out.println("Warning !!\n" +
                "Your previous levels and coins earned will be reseted.\n" +
                "Press y to Confirm or Press n to Go Back.");

        if(pk.nextLine().equals("n")) return false;

        String query = "UPDATE progress " +
                "SET levelNo = 1, coins = 100 " +
                "WHERE id = '"+id+"';";
        Statement stmt = con.createStatement();
        if(stmt.execute(query))
            System.out.println("Reseted Successfully!");
        System.out.println("----------------------");

        return true;
    }

    public String getWord(int level, int random) throws SQLException {
        String query = "SELECT word FROM words " +
                "WHERE levelNo = "+level+
                " LIMIT "+random+","+random+";";

        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        String str = "";
        while(resultSet.next())
            str = resultSet.getString(1);

        return str;

    }

    public int debitCoins(int count) throws SQLException {
        return debitCoins(count, Main.id);
    }
    public int debitCoins(int count, String id) throws SQLException {
        String query = "update progress set coins = coins - '"+count+"' where id = '"+id+"';";

        Statement statement = con.createStatement();
        statement.executeUpdate(query);

        return getCoins(id);
    }

    public int getCoins(String id) throws SQLException{
        String query = "SELECT coins FROM progress WHERE id = '"+id+"'";//"update progress set coins = coins - ? where id = '?;";

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        return resultSet.getInt(1);
    }

    public int creditCoins(int count) throws SQLException {
        return creditCoins(count, Main.id);
    }
    public int creditCoins(int count, String id) throws SQLException {
        String query = "update progress set coins = coins + '"+count+"' where id = '"+id+"';";

        Statement statement = con.createStatement();
        statement.executeUpdate(query);

        return getCoins(id);
    }

    public int levelUpgrade(int i) throws SQLException {
        return levelUpgrade(i,Main.id);
    }

    public int levelUpgrade(int count, String id) throws SQLException {
        String query = "update progress set levelNo = levelNo + '"+count+"' where id = '"+id+"';";

        Statement statement = con.createStatement();
        statement.executeUpdate(query);

        return getPlayerLvl(id);
    }

    public void displayLeaderBoard() throws SQLException {
        String query = "select login.name, progress.levelNo, progress.coins " +
                        "from login right join progress " +
                        "on login.id = progress.id " +
                        "order by progress.coins desc;";

        Statement statement = con.createStatement();
        ResultSet rs =  statement.executeQuery(query);

        /*System.out.println("Name\t| Level\t| Coins");
        System.out.println("-----------------------");

        while(rs.next()){
            System.out.println(rs.getString(1)+"\t| "+rs.getString(2)+"\t| "+rs.getString(3));
        }*/

        String topPlayersHeader = "+----------------------------------+\n" +
                "|            "+Color.GREEN_BRIGHT+"LEADERBOARD"+Color.RESET+"           |\n" +
                "+----------------------------------+\n";
        String topPlayersFooter = "+----------------------------------+\n";
        System.out.print(topPlayersHeader);
//        while (rs.next()) {
//            String playerName = rs.getString("name");
//            int playerCoins = rs.getInt("coins");
//            String playerLine = "| " + playerName + "" +
//                    ": " + playerCoins + " coins";
//            for (int i = playerLine.length(); i < 20; i++) {
//                playerLine += " ";
//            }
//            playerLine += "|\n";
//            System.out.print(playerLine);
//        }
        int i =1;
        System.out.printf("| %-6s  %-20s %6s |\n",Color.LIGHT_PINK+"S.No", "Name", "Coins"+Color.RESET);
        while(rs.next()){
            String playerName = rs.getString("name");
            int playerCoins = rs.getInt("coins");
            System.out.printf("| %-6d%-20s%6d |\n",i, playerName, playerCoins);
            i++;
        }
        System.out.print(topPlayersFooter);
    }

    public static void main(String[] args) throws Exception {
        dbConnect connect = new dbConnect();
        connect.getConnection();

        for(int i=0; i<50; i++) {
            int random = (int) (Math.random() * 20);

            while(random%20 == 0){
                if (random == 0) {
                    random++;
                } else if (random >= 20) {
                    random %= 20;
                }
            }

            System.out.println(connect.getWord(9, random));
        }
    }
}
