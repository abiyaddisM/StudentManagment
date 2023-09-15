package BackEnd;

import Pages.HomePanel;
import Pages.ManagePage.ManageOptionPanel;
import Pages.ManagePage.ManagePanel;
import com.sun.security.jgss.GSSUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
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

        if (validateFirstName()){
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
        }
        if  (validateDepartment()){//validate department
            validationCounter++;
        }
        if(validateEmail()){
            validationCounter++;
        }
        if (validatePhoneNumber()){
            validationCounter++;
        }

        if (validationCounter == 9){
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

                // Insert date of birth into the database
                String insertSql = "INSERT INTO student (display_id, first_name, last_name, date_of_birth, gender, department_id) VALUES (?,?,?,?,?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);

                //String dob = infoHolder.year + "-" + infoHolder.month + "-" + infoHolder.day;
                int year = Integer.parseInt(infoHolder.year);
                int month = convertMonthStringToInt(infoHolder.month);
                int day = Integer.parseInt(infoHolder.day);
                LocalDate date = LocalDate.of(year, month, day);

                Date dob = Date.valueOf(date);
                // Set the DOB value in the prepared statement
                String displayID = infoHolder.id;
                insertStatement.setString(1, displayID );
                insertStatement.setString(2, infoHolder.firstName);
                insertStatement.setString(3, infoHolder.lastName);
                insertStatement.setDate(4, dob);
                insertStatement.setString(5, infoHolder.gender);
                insertStatement.setInt(6, getDepartmentID());

               insertStatement.executeUpdate();

                insertStatement.close();

                String selectQuery = "SELECT student_id FROM student WHERE display_id = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, displayID);
                ResultSet resultSet = selectStatement.executeQuery();
                int ID = 0;
                if(resultSet.next()) {
                    ID = resultSet.getInt("student_id");
                }

                String insertSql2 = "INSERT INTO student_phone_number(student_id, phone_number) VALUES (?,?)";
                PreparedStatement insertPhoneNumber = connection.prepareStatement(insertSql2);

                insertPhoneNumber.setInt(1, ID);
                insertPhoneNumber.setString(2, infoHolder.phoneNo);
                insertPhoneNumber.executeUpdate();
                insertPhoneNumber.close();

                String insertSql3 = "INSERT INTO student_email(student_id, email) VALUES (?,?)";
                PreparedStatement insertEmail = connection.prepareStatement(insertSql3);
                insertEmail.setInt(1, ID);
                insertEmail.setString(2, infoHolder.email);
                insertEmail.executeUpdate();
                insertEmail.close();

                connection.close();
                ManagePanel.studentListPanel.addRow(infoHolder);
                ManagePanel.backToOptionPanel();
                HomePanel.setNumberInfo();
                ManageOptionPanel.setNumberInfo();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void addTeacher(){
        int validationCounter = 0;
        if (validateFirstName()){
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
        }
        if  (validateDepartment()){//validate department
            validationCounter++;
        }
        if(validateEmail()){
            validationCounter++;
        }
        if (validatePhoneNumber()){
            validationCounter++;
        }

        if (validationCounter == 9){

            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
                // Insert date of birth into the database
                String insertSql = "INSERT INTO teacher (display_id, first_name, last_name, date_of_birth, gender, department_id) VALUES (?,?,?,?,?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);

                //String dob = infoHolder.year + "-" + infoHolder.month + "-" + infoHolder.day;
                int year = Integer.parseInt(infoHolder.year);
                int month = convertMonthStringToInt(infoHolder.month);
                String monthString = String.format("%02d", month);
                int day = Integer.parseInt(infoHolder.day);
                String dobString = year + "-" + month + "-" + day;
                LocalDate date = LocalDate.of(year, month, day);

                Date dob = Date.valueOf(date);
                // Set the DOB value in the prepared statement
                String displayID = generateID();
                insertStatement.setString(1, displayID );
                insertStatement.setString(2, infoHolder.firstName);
                insertStatement.setString(3, infoHolder.lastName);
                insertStatement.setDate(4, dob);
                insertStatement.setString(5, infoHolder.gender);
                insertStatement.setInt(6, getDepartmentID());

                int rowsInserted = insertStatement.executeUpdate();

                insertStatement.close();

                String selectQuery = "SELECT teacher_id FROM teacher WHERE display_id = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, displayID);
                ResultSet resultSet = selectStatement.executeQuery();
                int ID = 0;
                if(resultSet.next()) {
                    ID = resultSet.getInt("teacher_id");
                }

                String insertSql2 = "INSERT INTO teacher_phone_number(teacher_id, phone_number) VALUES (?,?)";
                PreparedStatement insertPhoneNumber = connection.prepareStatement(insertSql2);

                insertPhoneNumber.setInt(1, ID);
                insertPhoneNumber.setString(2, infoHolder.phoneNo);
                insertPhoneNumber.executeUpdate();
                insertPhoneNumber.close();

                String insertSql3 = "INSERT INTO teacher_email(teacher_id, email) VALUES (?,?)";
                PreparedStatement insertEmail = connection.prepareStatement(insertSql3);
                insertEmail.setInt(1, ID);
                insertEmail.setString(2, infoHolder.email);
                insertEmail.executeUpdate();
                insertEmail.close();

                connection.close();
                ManagePanel.teacherListPanel.addRow(infoHolder);
                ManagePanel.backToOptionPanel();
                HomePanel.setNumberInfo();
                ManageOptionPanel.setNumberInfo();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addStaff() {

        int validationCounter = 0;
        if (validateFirstName()) {
            validationCounter++;
        }
        if (validateLastName()) {
            validationCounter++;
        }
        if (validateYear()) {
            validationCounter++;
        }
        if (validateMonth()) {
            validationCounter++;
        }
        if (validateDay()) {
            validationCounter++;
        }
        if (validateGender()) {
            validationCounter++;
        }
        if (true) {//validate position
            validationCounter++;
        }
        if (validateEmail()) {
            validationCounter++;
        }
        if (validatePhoneNumber()) {
            validationCounter++;
        }

        if (validationCounter == 9) {

            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

                // Insert date of birth into the database
                String insertSql = "INSERT INTO staff (display_id, first_name, last_name, date_of_birth, gender, position_id) VALUES (?,?,?,?,?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);

                //String dob = infoHolder.year + "-" + infoHolder.month + "-" + infoHolder.day;
                int year = Integer.parseInt(infoHolder.year);
                int month = convertMonthStringToInt(infoHolder.month);
                String monthString = String.format("%02d", month);
                int day = Integer.parseInt(infoHolder.day);
                String dobString = year + "-" + month + "-" + day;
                LocalDate date = LocalDate.of(year, month, day);

                Date dob = Date.valueOf(date);
                // Set the DOB value in the prepared statement
                String displayID = generateID();
                insertStatement.setString(1, displayID);
                insertStatement.setString(2, infoHolder.firstName);
                insertStatement.setString(3, infoHolder.lastName);
                insertStatement.setDate(4, dob);
                insertStatement.setString(5, infoHolder.gender);
                insertStatement.setInt(6, 1);

                int rowsInserted = insertStatement.executeUpdate();

                insertStatement.close();

                String selectQuery = "SELECT staff_id FROM staff WHERE display_id = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, displayID);
                ResultSet resultSet = selectStatement.executeQuery();
                int ID = 0;
                if (resultSet.next()) {
                    ID = resultSet.getInt("staff_id");
                }

                String insertSql2 = "INSERT INTO staff_phone_number(staff_id, phone_number) VALUES (?,?)";
                PreparedStatement insertPhoneNumber = connection.prepareStatement(insertSql2);

                insertPhoneNumber.setInt(1, ID);
                insertPhoneNumber.setString(2, infoHolder.phoneNo);
                insertPhoneNumber.executeUpdate();
                insertPhoneNumber.close();

                String insertSql3 = "INSERT INTO staff_email(staff_id, email) VALUES (?,?)";
                PreparedStatement insertEmail = connection.prepareStatement(insertSql3);
                insertEmail.setInt(1, ID);
                insertEmail.setString(2, infoHolder.email);
                insertEmail.executeUpdate();
                insertEmail.close();

                connection.close();
                ManagePanel.staffListPanel.addRow(infoHolder);
                ManagePanel.backToOptionPanel();
                HomePanel.setNumberInfo();
                ManageOptionPanel.setNumberInfo();
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
        System.out.println("Invalid first name");
        return false;
    }

    public boolean validateLastName(){
        for (char c : infoHolder.lastName.toCharArray()) {
            // Check if the character is not an English letter (either uppercase or lowercase)
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                System.out.println("Invalid last name");
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
            System.out.println("Invalid Month");
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
                        System.out.println("Invalid date");
                        return false;
                    }
                    else {
                        return true;
                    }
                case 3:
                    return true;
                case 4, 6, 9, 11:
                    if(Integer.parseInt(infoHolder.day) > 30){
                        System.out.println("Invalid date");
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
            System.out.println("Invalid date");
            return false;
        }
    }

    public boolean validateGender(){
        if (infoHolder.gender.toLowerCase().equals("male") || infoHolder.gender.toLowerCase().equals("female") || infoHolder.gender.toLowerCase().equals("none-binary")){
            return true;
        }
        else {
            System.out.println("Invalid gender");
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
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "11":
                return 11;
            case "12":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month: " + monthString);
        }
    }

    public boolean validateEmail(){
        if (infoHolder.email.length() > 0 && infoHolder.email.length() <= 320){
            if (infoHolder.email.indexOf('a') != -1){
                return true;
            }
            else{
                System.out.println("Invalid email");
                return false;
            }
        }
        else {
            System.out.println("Invalid email");
            return false;
        }
    }

    public boolean validatePhoneNumber(){
        if (infoHolder.phoneNo.matches("[0-9]+")) {
            return true;
        } else {
            System.out.println("Invalid phone number");
            return false;
        }
    }
    public boolean validateDepartment(){
        if (infoHolder.department.toLowerCase().equals("software engineer") || infoHolder.department.toLowerCase().equals("computer science") || infoHolder.department.toLowerCase().equals("data science") || infoHolder.department.toLowerCase().equals("Artificial Intelligence")){
            return true;
        }
        else{
            return false;
        }
    }
    public static String generateID () {
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

    public int getDepartmentID(){
        if (infoHolder.department.toLowerCase().equals("software engineer")){
            return 1;
        }
        else if(infoHolder.department.toLowerCase().equals("computer science")){
            return 2;
        }
        else if(infoHolder.department.toLowerCase().equals("data science")){
            return 3;
        }
        else if(infoHolder.department.toLowerCase().equals("Artificial Intelligence")){
            return 4;
        }
        return 0;
    }

}
