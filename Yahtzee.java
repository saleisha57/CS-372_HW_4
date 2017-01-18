import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.util.Random;

public class Yahtzee extends JFrame
{
    public static void main(String[] args)
    {
	Yahtzee y = new Yahtzee();	
    }

    public Yahtzee()
    {
	setSize(450, 450);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	
	Dice[] d = new Dice[5];
	for(int i = 0; i < 5; i ++)
	    {
		JLabel l = new JLabel();
		d[i] = new Dice(l);
		this.add(l);
	    }

	this.setVisible(true);

	Thread[] t = new Thread[5];

	for (int i = 0; i < 5; i++)
	    {
		t[i] = new Thread(d[i]);
		t[i].start();
		try
		    {
			Thread.sleep(3000);
		    }
		catch(InterruptedException e)
		    {
			;
		    }
	    }



	
    }
    
}
    
    



class Dice implements Runnable
{
    private JLabel label;
    
    public Dice(JLabel l)
    {
	label = l;
    }
    
    public void run()
    {
	for(int i = 6; i >= 0; i--)
	    label.setText(String.format("%d", i));
	try
	    {
		Thread.sleep(1000);
	    }
	catch(InterruptedException ex)
	    {
		;
	    }


    }
    
    
}



