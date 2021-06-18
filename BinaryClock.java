//Importing
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BinaryClock extends JPanel
{
    //Declaring private instance variables for hours, minutes, and seconds 
    private int h, m, s;
    //Binary clock constructor, taking a color as a parameter for the background
    public BinaryClock(Color c)
    {
       setBackground(c);
    }

    public void paint(Graphics g)
    {
      GregorianCalendar cal = new GregorianCalendar();
      //Getting hours, minutes, and seconds
      h = cal.get(Calendar.HOUR_OF_DAY);
      m = cal.get(Calendar.MINUTE);
      s = cal.get(Calendar.SECOND); 
        
      //Creating custom colors   
      Color pink = new Color(245, 76, 125);
      Color navy = new Color(51, 58, 69);
      Color gray = new Color(147, 158, 173);
       
      //Creating custom fonts 
      Font big = new Font ("Courier New", Font.BOLD, 45);
      Font tiny = new Font("Courier New", Font.PLAIN, 12);
      Font font = new Font("Courier New", Font.BOLD, 20);
      Font notBold = new Font("Courier New", Font.PLAIN, 45);
      
      //Make strings to print minutes and seconds 
      String MString = m + ""; 
      String SString = s + ""; 
      /*Adds a 0 in front of the minute/second values if they are 
      single digits*/
      if(m < 10)
      {
          MString = "0" + m; 
      }
      
      if(s < 10) 
      { 
          SString = "0" + s; 
      }
      //Drawing time in decimal from GCal 
      g.setColor(gray); 
      g.setFont(big);
      g.drawString(h + ":" + MString + ":" + SString,600,150);
      
      /*Create an array filled with 1s and 0s that represents the binary
      number that corresponds to the current seconds value (because the
      value can be at most 60, only 6 binary digits are necessary).*/ 
      int[] binaryS = new int[6]; 
      /*Fill the array with 1s or 0s 'backwards' in each index to 
      create the proper binary number*/
      int indexS = 5;
      while (s > 0) {
         binaryS[indexS] = s % 2;
         s /= 2;
         indexS--;
      }
      /*For every digit in the binary number, if it is a 1, fill an oval
      at the corresponding location on the screen (the x-coordinate is
      a multiple of the index variable)*/
      for(int i = 5; i >= 0; i--)
      {
         g.setColor(gray); 
          g.drawOval(100*(i+1),400,50,50);
         if(binaryS[i] == 1) 
         {
             g.setColor(pink);
             g.fillOval(100*(i+1),400,50,50); 
         }
      }
       
      //Repeat for minutes
      int[] binaryM = new int[6]; 
      int indexM = 5; 
      while(m > 0)
      {
        binaryM[indexM] = m % 2; 
        m /= 2; 
        indexM--; 
      }
        
      for(int i = 5; i >= 0; i--)
      {
        g.setColor(gray); 
        g.drawOval(100*(i+1),300,50,50); 
        if(binaryM[i] == 1)
        {
          g.setColor(pink);
          g.fillOval(100*(i+1),300,50,50); 
        }
      }
      
      //Repeat for hours 
      int[] binH = new int[6]; 
      int indexH = 5; 
      while(h > 0) 
      {
        binH[indexH] = h % 2; 
        h /= 2; 
        indexH--; 
      }
      
      for(int i = 5; i >= 0; i--)
      {
        g.setColor(gray); 
        g.drawOval(100*(i+1),200,50,50);
        if(binH[i] == 1)
        {
            g.setColor(pink);
            g.fillOval(100*(i+1),200,50,50);   
        }
       }
       
      //Setting font for numbers 
      g.setFont(font);
      /*Looping through the necessary binary numbers and printing them
      at the correct locations on the screen.*/
      int binDigit = 32; 
      for(int i = 115; i <= 615; i += 100)
      {
        g.drawString(binDigit + "",i,500);
        binDigit /= 2; 
      }
       
      //Drawing 'monkeyclock' text 
      g.setFont(big);
      g.setColor(pink); 
      g.drawString("monkeyclock",100,150);
       
      //Drawing 'monkeysee' text
      g.setFont(tiny);
      g.setColor(gray);
      g.drawString("monkey see",100,122);
      
      //Drawing hours, minutes, and seconds on the side 
      g.setFont(font); 
      g.setColor(gray);
      g.drawString("Hours",700,227);
      g.drawString("Minutes",700,327);
      g.drawString("Seconds",700,427); 

    }
}
