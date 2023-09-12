package src;

public class RowInfoHolder {
    public String id, firstName, lastName, year, month, day, gender, department, email, phoneNo;

    // Constructor that initializes the fields
    public RowInfoHolder(String id, String firstName, String lastName, String year, String month, String day, String gender, String department, String email, String phoneNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
        this.department = department;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void display() {
        System.out.println(id);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(gender);
        System.out.println(department);
        System.out.println(email);
        System.out.println(phoneNo);
    }
}
