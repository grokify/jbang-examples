///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS mysql:mysql-connector-java:8.0.16

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

class mysql_example { 
    public static void main(String[] args) {
        if (args.length<5) {
            System.out.println("usage is: mysql_example.java host port database user password");
            return;
        }
        System.out.println("Starting MySQL Petstore insert example.");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ps.printf("jdbc:mysql://%s:%s/%s?user=%s&password=%s", args[0], args[1], args[2], args[3], args[4]);
        String jdbcdsn = baos.toString();

        // Connection conn = null;
        try {
            Connection conn = DriverManager.getConnection(jdbcdsn);

            String query = "INSERT INTO pet (name, status, creation_time, update_time)"
                + " VALUES (?, ?, ?, ?)";

            Calendar calendar = Calendar.getInstance();
            Date startDate = new Date(calendar.getTime().getTime());
            Timestamp startTime = new Timestamp(calendar.getTime().getTime());

            PreparedStatement preparedStmt = conn.prepareStatement(query);

            for (int i = 0; i < 5; i++) {
                preparedStmt.setString (1, "Java A" + String.valueOf(i));
                preparedStmt.setString (2, "Available");
                preparedStmt.setTimestamp (3, startTime);
                preparedStmt.setDate (4, startDate);
                preparedStmt.execute();
            }
      
            conn.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}