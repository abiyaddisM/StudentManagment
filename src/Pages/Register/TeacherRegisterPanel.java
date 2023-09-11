package Pages.Register;

public class TeacherRegisterPanel extends ManageRegisterPanel{
    public TeacherRegisterPanel(String file) {
        super(file);
        initializeList();
        initializeComboBox();
        addComponents();
    }

    @Override
    void addComponents() {
        addMain(exitButton);
        addMain(firstNameTextBox);
        addMain(lastNameTextBox);
        addMain(emailTextBox);
        addMain(monthComboBox);
        addMain(dayComboBox);
        addMain(yearComboBox);
        addMain(phoneNoTextBox);
        addMain(studentBatchComboBox);
        addMain(genderComboBox);
        addMain(studentIdLabel);
        addMain(refreshButton);
        addMain(clearButton);
        addMain(saveButton);
    }

    @Override
    void initializeList(){
      super.initializeList();
        studentBatchList=new String[]{"Computer Science","Software Engineer","Political Science","Art"};
    }

}
