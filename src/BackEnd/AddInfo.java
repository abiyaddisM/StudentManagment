package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class AddInfo {
    RowInfoHolder infoHolder;
    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";

    public AddInfo(RowInfoHolder infoHolder){
        this.infoHolder = infoHolder;
    }

    public void addStudent(){
        int validationCounter = 0;
       /* if (validateFirstName()){
            validationCounter++;
        }
        if (validateLastName()){
            validationCounter++;
        }
        if (validateYear()){
            validationCounter++;
        }
        if (validateMonth()){
            validationCounter++;
        }
        if (validateDay()){
            validationCounter++;
        }
        if (validateGender()){
            validationCounter++;
        }*/

        if (true){
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

                // Insert date of birth into the database
                String insertSql = "INSERT INTO student (FirstName, LastName) VALUES (?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);

                String dob = infoHolder.year + "-" + infoHolder.month + "-" + infoHolder.day;
                // Set the DOB value in the prepared statement
                insertStatement.setString(1, infoHolder.firstName);
                insertStatement.setString(2, infoHolder.lastName);
              /*  insertStatement.setString(3, dob);
                insertStatement.setString(4, infoHolder.gender);
                insertStatement.setString(5, infoHolder.phoneNo);
                insertStatement.setString(6, infoHolder.email);
                insertStatement.setString(7, infoHolder.department);*/


                int rowsInserted = insertStatement.executeUpdate();

                insertStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    public boolean validateFirstName(){
        for (char c : infoHolder.firstName.toCharArray()) {
            // Check if the character is not an English letter (either uppercase or lowercase)
            if (((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return true; // If a non-letter character is found, return false
            }
        }
        return false;
    }

    public boolean validateLastName(){
        for (char c : infoHolder.lastName.toCharArray()) {
            // Check if the character is not an English letter (either uppercase or lowercase)
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return false; // If a non-letter character is found, return false
            }
        }
        return true;
    }
    public boolean validateYear(){
        if (Integer.parseInt(infoHolder.year) >= 1900 && Integer.parseInt(infoHolder.year) <= 2023){
            return true;
        }
        else{
            System.out.println("Invalid year");
            return false;
        }
    }
    public boolean validateMonth(){
        if (convertMonthStringToInt(infoHolder.month) >= 1 && convertMonthStringToInt(infoHolder.month) <= 12){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean validateDay(){
        int month = convertMonthStringToInt(infoHolder.month);
        if (Integer.parseInt(infoHolder.day) >= 1 && Integer.parseInt(infoHolder.day) <= 31){
            switch (month){
                case 1:
                    return true;
                case 2:
                    if(Integer.parseInt(infoHolder.day) > 28){
                        return false;
                    }
                    else {
                        return true;
                    }
                case 3:
                    return true;
                case 4, 6, 9, 11:
                    if(Integer.parseInt(infoHolder.day) > 30){
                        return false;
                    }
                    else {
                        return true;
                    }
                case 5:
                    return true;
                case 7:
                    return true;
                case 8:
                    return true;
                case 10:
                    return true;
                case 12:
                    return true;
                default:
                    throw new IllegalArgumentException("Invalid day: " + infoHolder.day);
            }
        }
        else {
            return false;
        }
    }

    public boolean validateGender(){
        if (infoHolder.gender.toLowerCase().equals("male") || infoHolder.gender.toLowerCase().equals("female") || infoHolder.gender.toLowerCase().equals("none-binary")){
            return true;
        }
        else {
            return false;
        }
    }

    public int convertMonthStringToInt(String monthString) {
        switch (monthString.toLowerCase()) {
            case "january":
                return 1;
            case "february":
                return 2;
            case "march":
                return 3;
            case "april":
                return 4;
            case "may":
                return 5;
            case "june":
                return 6;
            case "july":
                return 7;
            case "august":
                return 8;
            case "september":
                return 9;
            case "october":
                return 10;
            case "november":
                return 11;
            case "december":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month: " + monthString);
        }
    }

    public static String generateID (Connection connection) {
        final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Letters to choose from
        final int NUMBERS_MIN = 1000; // Minimum number value (inclusive)
        final int NUMBERS_MAX = 9999; // Maximum number value (inclusive)

        // Generate two random letters
        Random random = new Random();
        char letter1 = LETTERS.charAt(random.nextInt(LETTERS.length()));
        char letter2 = LETTERS.charAt(random.nextInt(LETTERS.length()));

        // Generate a random 4-digit number
        int randomNumber = random.nextInt(NUMBERS_MAX - NUMBERS_MIN + 1) + NUMBERS_MIN;

        // Combine the letters and number to create the ID
        String id = String.format("%c%c%04d", letter1, letter2, randomNumber);

        return id;
    }

}
