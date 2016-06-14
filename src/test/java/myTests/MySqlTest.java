package myTests;

import jdbc.StatementExecute;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTest {

    public final String CONNECTION = "jdbc:mysql://localhost:3306/sakila?&useSSL=false";
    public final String USERNAME = "root";
    public final String PASSWORD = "1234";

    @Ignore
    @Test
    public void mySqlBasicTest() throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
        StatementExecute executor = new StatementExecute(connection);

        List <String> columns = new ArrayList<>();
        columns.add("actor_id");
        columns.add("first_name");
        columns.add("last_name");

        List <String> values = new ArrayList<>();
        values.add("201");
        values.add("Nimrod");
        values.add("Golan");

        executor.insertNewRecordWithParameters("actor", columns, values);

        List<String> updateColumns = new ArrayList<>();
        updateColumns.add("first_name='Justin'");
        updateColumns.add("last_name='Biber'");
        executor.updateRecord("actor", updateColumns, "actor_id='201'");

        executor.deleteRecord("actor", "actor_id", "201");


    }

}
