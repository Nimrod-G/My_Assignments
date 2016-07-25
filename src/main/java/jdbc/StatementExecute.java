package jdbc;

import logs.AutomationLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StatementExecute {

    private Connection connection;
    private Statement statement;

    public StatementExecute(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    public void deleteRecord(String tableName, String conditionalRecordName, String conditionalRecordValue) throws SQLException {
        String sql = "delete from " + tableName + " where " + conditionalRecordName + " = " + conditionalRecordValue;
        executeUpdate(sql);
    }

    public void insertNewRecordWithParameters(String tableName, List<String> columnsNames, List<String> values) throws SQLException {
        // Create the columns string
        String columnsStr = "";

        for (int i=0; i < columnsNames.size(); i++) {
            columnsStr+= columnsNames.get(i);
            if (i < columnsNames.size()-1) {
                columnsStr+= ", ";
            }
        }

        // Create the values string
        String valuesStr = "";

        for (int i=0; i < values.size(); i++) {
            valuesStr+= "'" + values.get(i) + "'";
            if (i < values.size()-1) {
                valuesStr+= ", ";
            }
        }

        String sql = "insert into " + tableName +" (" + columnsStr + ")" + " values " + "(" + valuesStr + ")";
        executeUpdate(sql);
    }

    public void updateRecord(String tableName, List<String> columnsNamesAndValues, String conditionalRecordNameAndValue) throws SQLException {
        String columns = "";

        for (int i=0; i < columnsNamesAndValues.size(); i++) {
            columns+= columnsNamesAndValues.get(i);
            if (i < columnsNamesAndValues.size()-1) {
                columns+= ", ";
            }
        }

        String sql = "update " + tableName + " set " + columns + " where " + conditionalRecordNameAndValue;
        executeUpdate(sql);
    }

    private void executeUpdate(String sqlStatement) throws SQLException {
        AutomationLogger.getLog().info("Executing statement update: " + sqlStatement);
        statement.executeUpdate(sqlStatement);
    }
}
