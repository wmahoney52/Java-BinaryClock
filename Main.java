//Importing
import javax.swing.*;
import java.awt.*;
public class Main
{
    //Creating new JFrame and panel 
    static JFrame GUI = new JFrame("Binary Clock");
    static BinaryClock panel = new BinaryClock(new Color(51, 58, 69));
    public static void main(String[] args)
    {
        //Setting window size, making window visible, etc. 
        GUI.setSize(900,700);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.add(panel);
        GUI.setVisible(true);
        while(true)
        {
            panel.repaint();

            try
            {
                Thread.sleep(6);
            }
            catch(Exception e){}
        }
    }
}
