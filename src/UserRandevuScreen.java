import DataAccess.RepositoryBase;
import Entities.Concrete.User;

import javax.swing.*;

public class UserRandevuScreen extends JFrame{
    private JPanel mainPanel;
    public UserRandevuScreen(RepositoryBase repositoryBase , User authUser)
    {
        add(mainPanel);
        setSize(900,900);
        setTitle("RANDEVU AL");
        setVisible(true);

    }
}
