import DataAccess.RepositoryBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage {
    private JButton registerButton;
    private JTextField ISIMTextField;
    private JTextField SOYISIMTextField;
    private JTextField TCKIMLIKNOTextField;
    private JPasswordField PASSWORDPasswordField;

    public SignUpPage()
    {
        RepositoryBase repositoryBase = new RepositoryBase();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String isim = ISIMTextField.getText();
                String password = new String(SOYISIMTextField.getText());
            }
        });
    }
}
