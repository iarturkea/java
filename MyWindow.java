import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    MyWindow(){

        setVisible(true);
        setLocation(650, 650);
        setSize(500, 500);
        setTitle("Мое очень крутое окно!(%");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(1,2));

        JButton btn1 = new JButton("Выход");
        //add(btn1, BorderLayout.NORTH);
        panel.add(btn1);
        ActionListener actionListener = new CloseActionListener();
        btn1.addActionListener(actionListener);

        JButton btn2 = new JButton("not exit");
        //add(btn2, BorderLayout.SOUTH);

        panel.add(btn2);

        add(panel, BorderLayout.SOUTH);

    }

}
