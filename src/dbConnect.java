import java.sql.*;
import java.util.Scanner;

public class dbConnect {
    private static Connection con;
    static Scanner pk = new Scanner(System.in);
    public void getConnection(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jumblr";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createUser(String name, String id, String pass) throws SQLException {

        String query = "INSERT INTO login (id,name,pass) VALUES ('"+id+"','"+name+"','"+pass+"');";
        Statement st = con.createStatement();
        if(st.execute(query))
            System.out.println(id+" user created successfully!\nChoose Login menu and continue...");

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
                "Your previous levels and coins earned will be resetted.\n" +
                "Press y to Confirm or Press n to Go Back.");

        if(pk.next().equals("n")) return false;

        String query = "UPDATE progress" +
                "SET level = 1, coins = 100" +
                "WHERE id = '"+id+"';";
        Statement stmt = con.createStatement();
        if(stmt.execute(query))
            System.out.println("Resetted Successfully!");

        return true;
    }

    public String getWord(int level, int random) throws SQLException {
        String query = "SELECT word FROM words " +
                "WHERE levelNo = "+level+
                " LIMIT "+random+","+random+";";

        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);

        resultSet.next();

        return resultSet.getString(1);
    }

    public void failed(){

    }
}
