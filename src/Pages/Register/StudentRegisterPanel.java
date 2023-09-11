package Pages.Register;

public class StudentRegisterPanel extends ManageRegisterPanel{
    public StudentRegisterPanel(String file) {
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
        studentBatchList=new String[]{"DBR2202","DBR2102","DBR2002","DBR1902"};

    }



}
