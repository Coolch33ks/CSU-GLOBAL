package CT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuExample extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

    public MenuExample() {
        //Sets up the frame
        setTitle("Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creates the text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        //Creates the menu bar
        JMenuBar menuBar = new JMenuBar();

        //Creates the menu
        JMenu menu = new JMenu("Options");

        //Creates menu items
        JMenuItem menuItem1 = new JMenuItem("Print Date and Time");
        JMenuItem menuItem2 = new JMenuItem("Save to File");
        JMenuItem menuItem3 = new JMenuItem("Change Background Color");
        JMenuItem menuItem4 = new JMenuItem("Exit");

        //Adds action listeners
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Adds menu items 
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);

        //Adds the menu 
        menuBar.add(menu);

        //Sets the menu bar 
        setJMenuBar(menuBar);
    }

    private void printDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        textArea.append(formatter.format(date) + "\n");
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(textArea.getText());
            textArea.append("Saved to log.txt\n");
        } catch (IOException e) {
            textArea.append("Error saving to file\n");
        }
    }

    private void changeBackgroundColor() {
        Random rand = new Random();
        float hue = rand.nextFloat() * (120 - 60) + 60;  // Random hue between 60 and 120 for green hues
        Color randomGreenColor = Color.getHSBColor(hue / 360, 1.0f, 1.0f);
        getContentPane().setBackground(randomGreenColor);
        textArea.append("Background color changed to hue: " + hue + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuExample().setVisible(true);
            }
        });
    }
}
