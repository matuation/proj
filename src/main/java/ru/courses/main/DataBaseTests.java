package ru.courses.main;

import java.sql.*;

public class DataBaseTests {
    String url = "jdbc:h2:C:/Users/supercomp_123456/Documents/reclass/Office (2)/Office/Office";

    public void connection() {

        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("conn");
            } else {
                System.out.println("no conn");
            }
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rsOne = statement.executeQuery("select name from employee where name = 'Ann'");
            if (rsOne.next()) {
                if (!rsOne.next()) {
                    statement.executeUpdate("UPDATE employee SET departmentid = 2 WHERE name = 'Ann'");
                }
                String nameFromDb = "";
                String changedName = "";
                int rowsUpdated = 0;
                ResultSet rsTwo = statement.executeQuery("select name from employee");
                if (rsTwo.next()) {
                    nameFromDb = rsTwo.getString("name");
                    if ((nameFromDb.charAt(0) >= 'a') && (nameFromDb.charAt(0) <= 'z')) {
                        changedName = nameFromDb.substring(0, 1).toUpperCase() + nameFromDb.substring(1);
                        String sqlUpdate = "UPDATE employee SET name = ? WHERE name = ?";
                        PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
                        pstmt.setString(1, changedName);
                        pstmt.setString(2, nameFromDb);
                        rowsUpdated = pstmt.executeUpdate();
                    }
                }
                System.out.println("Обновлено строк: " + rowsUpdated);
            }
            ResultSet rsThree = statement.executeQuery("select name from employee where departmentid = 2");
            int count = 0;
            while (rsThree.next()) {
                count++;
            }
            System.out.println("Найдено сотрудников в IT-отделе: " + count);
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }

}
