import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.util.Random;

public class Yahtzee// extends JFrame
{
    JButton b = new JButton("Roll");
    JButton bu = new JButton("Stop");
    Random rand = new Random();
    Dice[] d = new Dice[5];	
    JLabel l, la, lab, labe, label, labels;
    JFrame frame = new JFrame("Yahtzee!");
    Image one, two, three, four, five, six;
    ImageIcon icon, ic, ico, iconn, iccon, i;
    boolean roll = true;

    public static void main(String[] args)
    {
	Yahtzee y = new Yahtzee();	
    }

    public Yahtzee()
    {
	frame.setSize(450, 450);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new FlowLayout());

	frame.add(b);

	set_images();
	set_icons();

	l = new JLabel(icon);
	la = new JLabel(ic);
	lab = new JLabel(ico);
	labe = new JLabel(iconn);
	label = new JLabel(iccon);
	labels = new JLabel(i);
	
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		    frame.remove(b);
		    frame.add(bu);
		    int[] numbers = new int[5];
	
		    for(int i = 0; i < 5; i++)
			while(roll == true)
			    {
				numbers[i] = rand.nextInt((6-1)+1)+1;
				if(numbers[i] == 1)
				    frame.add(l);
				if(numbers[i] == 2)
				    frame.add(la);
				if(numbers[i] == 3)
				    frame.add(lab);
				if(numbers[i] == 4)
				    frame.add(labe);
				if(numbers[i] == 5)
				    frame.add(label);
				if(numbers[i] == 6)
				    frame.add(labels);
				bu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
					    roll = true;
					    frame.remove(bu);
					    frame.add(b);
					}					    
				    });//bu
				roll = false;
			
		   		
			    }//while
		}
	    });//b
	    


	frame.setVisible(true);

	Thread[] t = new Thread[5];

	for (int i = 0; i < 5; i++)
	    {
		t[i] = new Thread(d[i]);
		t[i].start();
		try
		    {
			Thread.sleep(1000);
		    }
		catch(InterruptedException e)
		    {
			;
		    }
	    }



    }


    public void set_icons()
    {
	icon = new ImageIcon(one);
	ic = new ImageIcon(two);
	ico = new ImageIcon(three);
	iconn = new ImageIcon(four);
	iccon = new ImageIcon(five);
	i = new ImageIcon(six);
    }



    public void set_images()
    {
	try
	    {		
		Toolkit t = Toolkit.getDefaultToolkit();
		URL imgurl = getClass().getResource("/images/one_side.png");
		one = t.getImage(imgurl);
		one = one.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
	    }
	catch(Exception e) {;}


	try
	    {		
		Toolkit t = Toolkit.getDefaultToolkit();
		URL imgurl = getClass().getResource("/images/two_side.png");
		two = t.getImage(imgurl);
		two = two.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
	    }
	catch(Exception e) {;}

	try
	    {		
		Toolkit t = Toolkit.getDefaultToolkit();
		URL imgurl = getClass().getResource("/images/three_side.png");
		three = t.getImage(imgurl);
		three = three.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
	    }
	catch(Exception e) {;}

	try
	    {		
		Toolkit t = Toolkit.getDefaultToolkit();
		URL imgurl = getClass().getResource("/images/four_side.png");
		four = t.getImage(imgurl);
		four = four.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
	    }
	catch(Exception e) {;}
	
	try
	    {		
		Toolkit t = Toolkit.getDefaultToolkit();
		URL imgurl = getClass().getResource("/images/five_side.png");
		five = t.getImage(imgurl);
		five = five.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
	    }
	catch(Exception e) {;}

	try
	    {		
		Toolkit t = Toolkit.getDefaultToolkit();
		URL imgurl = getClass().getResource("/images/six_side.png");
		six = t.getImage(imgurl);
		six = six.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
	    }
	catch(Exception e) {;}


    }




    
}
    
    



class Dice implements Runnable
{
    private JLabel label;
    Random rand = new Random();
    
    public Dice(JLabel l)
    {
	label = l;
    }
    
    public void run()
    {
	for(int i = 6; i >= 0; i--)
	    label.setText(String.format("%d", (rand.nextInt(6-1)+1)+1));
	try
	    {
		Thread.sleep(3000);
	    }
	catch(InterruptedException ex)
	    {
		;
	    }


    }
    
    
}



