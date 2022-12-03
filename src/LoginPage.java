import Business.Concrete.UserService;
import DataAccess.RepositoryBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class LoginPage
{
    UserService userManager = new UserService();
    RepositoryBase repositoryBase = new RepositoryBase();
    private JButton girisYapButton;
    private JButton kayitOlButton;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;

    public LoginPage()
    {
        girisYapButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tcNo = usernameTextField.getText();
                String password = new String(passwordTextField.getPassword());
                userManager.userAuth(tcNo,password,repositoryBase);
            }
        });

        kayitOlButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }
}
