import DataAccess.RepositoryBase;
import Entities.Concrete.User;

import javax.swing.*;
import java.awt.*;

public class UserCancelScreen extends JFrame
{
    public UserCancelScreen(RepositoryBase repositoryBase, User authUser)
    {
        JFrame frame = new JFrame("Tablo ve Butonlar");
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        String[] columnNames = {"Ad", "Soyad", "TCNO",""};
        Object[][] data = {{"Ahmet", "Yılmaz", "1234567890"}, {"Mehmet", "Öztürk", "9876543210"}, {"Ayşe", "Kaya", "1239874563"}};
        JTable table = new JTable(data, columnNames);
        panel.add(table, BorderLayout.CENTER);

        JButton button1 = new JButton("Buton 1");
        panel.add(button1, BorderLayout.SOUTH);

        JButton button2 = new JButton("Buton 2");
        panel.add(button2, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
