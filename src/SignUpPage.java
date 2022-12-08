import DataAccess.RepositoryBase;
import Entities.Concrete.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Entities.Concrete.User.userCount;

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

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String isim = ISIMTextField.getText();
                String soyisim = SOYISIMTextField.getText();
                String tcNo = TCKIMLIKNOTextField.getText();
                String password = new String(PASSWORDPasswordField.getPassword());
                User authUser = new User(userCount,isim,soyisim,tcNo,password);
                repositoryBase.userListesi.add(authUser);
                setVisible(false);
                LoginPage loginPage = new LoginPage(repositoryBase);
                loginPage.setVisible(true);
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
