import DataAccess.RepositoryBase;
import Entities.Concrete.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JFrame
{
    private JButton registerButton;
    private JTextField ISIMTextField;
    private JTextField SOYISIMTextField;
    private JTextField TCKIMLIKNOTextField;
    private JPasswordField PASSWORDPasswordField;
    private JPanel panel2;
    private JLabel tcKimlikLabel;
    private JPanel sifreLabel;
    private JLabel isimLabel;
    private JLabel soyisiLabel;
    private JPanel panel1;
    private JButton GERIDONButton;

    public SignUpPage(RepositoryBase repositoryBase)
    {
        add(panel2);
        setSize(400,400);
        setTitle("Kayit Ol");
        final int[] userId = {1};
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String isim = ISIMTextField.getText();
                String soyisim = SOYISIMTextField.getText();
                String tcNo = TCKIMLIKNOTextField.getText();
                String password = new String(PASSWORDPasswordField.getPassword());
                User authUser = new User(userId[0],isim,soyisim,tcNo,password);
                repositoryBase.userListesi.add(authUser);
                userId[0] +=1;
                SignUpPage signUpPage = new SignUpPage(repositoryBase);
                signUpPage.setVisible(false);
                LoginPage loginPage = new LoginPage(repositoryBase);
                loginPage.setVisible(true);
                for (User user : repositoryBase.userListesi)
                {
                    System.out.println(user.firstName);
                }


            }
        });

        GERIDONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                LoginPage loginPage = new LoginPage(repositoryBase);
                loginPage.setVisible(true);

            }
        });
    }
}
