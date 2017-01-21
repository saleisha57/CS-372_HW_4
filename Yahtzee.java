import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.util.Random;

public class Yahtzee// extends JFrame
{
    JButton b = new JButton("Roll");
    JFrame frame = new JFrame("Yahtzee!");
    Random rand = new Random();
    JLabel[] l = new JLabel[6];
    ImageIcon[] icons;
    Dice[] d = new Dice[6];
    Thread[] t = new Thread[5];
   
    public static void main(String[] args)
    {
	Yahtzee y = new Yahtzee();	
    }

    public Yahtzee()
    {
	int i;
	frame.setSize(450, 450);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new FlowLayout());

	frame.add(b);

	set_icons();	


	
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		    for(int i = 0; i < 6; i ++)
			d[i] = new Dice(l[rand.nextInt(6)]);
		    for(int i = 0; i < 5; i++)
			{
			    t[i] = new Thread(d[i]);
			    try{
			    	Thread.sleep(100);
			    }
			    catch(InterruptedException ie) {;}
			    //try{
			    //	t[i].join();
			    //}
			    // catch(InterruptedException ex) {;}
			}		   
		    for(int i = 0; i < 5; i ++)
		    	t[i].start();
		    
		    for(int i = 0; i < 5; i++)	
			{
			    frame.add(d[i].label);
			}
		    
		}
	    });
	
	
	frame.setVisible(true);	
	
    }


    
    public void set_icons()
    {
	try
	    {
		Toolkit t = Toolkit.getDefaultToolkit();
        	URL[] imgurl = new URL[6];
        	imgurl[0] = getClass().getResource("/images/one_side.png");
        	imgurl[1] = getClass().getResource("/images/two_side.png");
		imgurl[2] = getClass().getResource("/images/three_side.png");
		imgurl[3] = getClass().getResource("/images/four_side.png");
		imgurl[4] = getClass().getResource("/images/five_side.png");
		imgurl[5] = getClass().getResource("/images/six_side.png");
		Image[] img = new Image[6];
		img[0] = t.getImage(imgurl[0]);
		img[1] = t.getImage(imgurl[1]);
		img[2] = t.getImage(imgurl[2]);
		img[3] = t.getImage(imgurl[3]);
		img[4] = t.getImage(imgurl[4]);
		img[5] = t.getImage(imgurl[5]);
		
		icons = new ImageIcon[6];
		
		for(int i = 0; i < 6; i++)
		    {
			img[i] = img[i].getScaledInstance(80, 80, Image.SCALE_DEFAULT);
			icons[i] = new ImageIcon(img[i]);
			l[i] = new JLabel(icons[i]);		
		    }//for
	    }
	catch(Exception ex)
	    {
		;
	    }
	
	

    }//set_icons  
    
    
}   //end class 



class Dice implements Runnable
{
    JLabel label;
    Random rand = new Random();
    
    public Dice(JLabel l)
    {
	label = l;
    }

    public void run()
    {

	//	for(int i = 5; i >= 0; i--)
	    // label.setText(String.format("%d", (rand.nextInt(6-1)+1)+1));
		

	try
	    {
		Thread.sleep(100);
	    }
	catch(InterruptedException ex)
	    {
		;
	    }


    }

 
    
    
}



