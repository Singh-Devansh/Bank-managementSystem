// java databse connectivity consist of 5 steps
//1. Regester the Driver.
// 2. Create connection.
//3. Create statement.
//4. Execute Query
//5. Close Connection.

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        // as it is external entity it can have error in run time so we are using the
        // try and catch block
        try {
             //Class.forName(com.mysql.cj.jdbc.Driver);// step 1
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "babuaanjee@9");// step2
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
