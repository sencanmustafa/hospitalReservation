import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame
{
    UserService userManager = new UserService();
    RepositoryBase repositoryBase = new RepositoryBase();
    private JButton girisYapButton;
    private JButton kayitOlButton;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JPanel panel;
    private JButton doktorLoginButton;
    private JLabel usernamelabel;
    private JLabel passwordLabel;
    private JLabel imageLabelLabel;
    private JPanel panel4;

    public LoginPage(RepositoryBase repositoryBase)
    {
        add(panel);
        setSize(1200, 1200);
        setTitle("Giris Ekrani");
        for (User user : repositoryBase.userListesi)
        {
            System.out.println("Login Page");
            System.out.println(user.firstName);
        }
        usernamelabel.setText("TC NO : ");
        passwordLabel.setText("PASSWORD : ");
        girisYapButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tcNo = usernameTextField.getText();
                String password = new String(passwordTextField.getPassword());
                if (userManager.userAuth(tcNo, password, repositoryBase) != null)
                {
                    setVisible(false);
                    User authUser = userManager.userAuth(tcNo, password, repositoryBase);
                    UserScreen userScreen = new UserScreen(repositoryBase,authUser);
                    userScreen.setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(panel,"YANLIS KULLANICI ADI");
                }

            };

        });
        kayitOlButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                SignUpPage signUpPage = new SignUpPage(repositoryBase);signUpPage.setVisible(true);
            }
        });
    ;
        doktorLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                DoctorLoginScreen doctorLoginScreen = new DoctorLoginScreen(repositoryBase);
                doctorLoginScreen.setVisible(true);
            }
        });
    }

    private void createUIComponents()
    {
        imageLabelLabel = new JLabel(new ImageIcon("hospital.jpeg"));
    }
}
