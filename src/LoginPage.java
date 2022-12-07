import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.User;

import javax.swing.*;
import java.awt.*;
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

    public LoginPage(RepositoryBase repositoryBase)
    {
        add(panel);
        setSize(400, 400);
        setTitle("Giris Ekrani");
        for (User user : repositoryBase.userListesi)
        {
            System.out.println("Login Page");
            System.out.println(user.firstName);
        }
        girisYapButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tcNo = usernameTextField.getText();
                String password = new String(passwordTextField.getPassword());
                if (userManager.userAuth(tcNo, password, repositoryBase) != null)
                {
                    User authUser = userManager.userAuth(tcNo, password, repositoryBase);
                    UserScreen userScreen = new UserScreen(repositoryBase,authUser);
                    userScreen.setVisible(true);

                };

            };

        });
        kayitOlButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SignUpPage signUpPage = new SignUpPage(repositoryBase);signUpPage.setVisible(true);
            }
        });
    ;}

}
