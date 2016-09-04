package pakega;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Base extends Applet
implements ActionListener
{
	TextField a,b,c,x1,x2;
	Button Ready, Clear;
	String A,B,C,xx1,xx2,aa,bb,cc;
	Font Big, Classic,Big2,lol;
	Checkbox box;
	
	public void init()
	{
		A = "";
		B = "";
		C = "";
		xx1 = "x1";
		xx2 = "x2";
		aa = "a";
		bb = "b";
		cc = "c";
		
		lol = new Font("Book Antiqua",Font.PLAIN, 37);
		Big = new Font("Book Antiqua", Font.PLAIN,  20);
		Big2 = new Font("Book Antiqua", Font.PLAIN,  14);
		Classic = new Font("Book Antiqua",Font.PLAIN,16);
		
		box = new Checkbox("Pictures");
		box.setBounds(75, 170, 75, 20);
		
		setLayout(null);
		Ready = new Button("=");
		Ready.addActionListener( this );
		Ready.setBounds(28, 86, 65, 20 );
		Clear = new Button("Clear");
		Clear.addActionListener( this );
		Clear.setBounds(115, 86, 65, 20 );
		
		a=new TextField ("");
		a.addActionListener( this );
		a.setBounds(20, 5, 175, 20 );
		b=new TextField ("");
		b.addActionListener( this );
		b.setBounds(20, 30, 175, 20 );
		c=new TextField ("");
		c.addActionListener( this );
		c.setBounds(20, 55, 175, 20 );
		x1=new TextField ("");
		x1.addActionListener( this );
		x1.setBounds(20, 115, 175, 20 );
		x2=new TextField ("");
		x2.addActionListener( this );
		x2.setBounds(20, 140, 175, 20 );
		
		add(Ready);
		add(Clear);
		add(a);
		add(b);
		add(c);
		add(x1);
		add(x2);
		add(box);
	}

	
	public void actionPerformed( ActionEvent e)
	{
		if(e.getSource()==Clear){
			x1.setText("x1");
			x2.setText("x2");
			a.setText("");
			b.setText("");
			c.setText("");
			xx1 = "x1";
			xx2 = "x2";
			aa = "a";
			bb = "b";
			cc= "c";
			repaint();
		}
		else
		{
		
		double Aq, Bq, Cq, Dis, X1,X2;
		A = a.getText();
		B = b.getText();
		C = c.getText();
		Aq = Double.parseDouble(A);
		Bq = Double.parseDouble(B);
		Cq = Double.parseDouble(C);
		
		Dis=Bq*Bq-4*Aq*Cq;
		if(Dis==0)
		{
			X1 = -Bq/(2*Aq);
			
			xx1 = String.format("%.2f", X1);
			x1.setText(Double.toString(X1));
			x2.setText("Niks");
		}
		else
		{
			if(Dis<0)
			{
				x1.setText("Niks");
				x2.setText("Niks");
			}
			else
			{
				X1 = (-Bq-Math.sqrt(Dis))/(2*Aq);
				X2 = (-Bq+Math.sqrt(Dis))/(2*Aq);
				
				
				xx1 = String.format("%.2f", X1);
				x1.setText(Double.toString(X1));
				xx2 = String.format("%.2f", X2);
				x2.setText(Double.toString(X2));
			}
		}
		}
		if(box.getState()==true&&e.getSource()!=Clear){
		aa = a.getText();
		bb = b.getText();
		cc = c.getText();
		if(x1.getText()=="niks"){
			xx1 = "x1";
		}
		
		if(x2.getText()=="niks"){
			xx2 = "x2";
		}
		
		repaint();
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.setFont(Big);
		g.drawString("a", 5, 20);
		g.drawString("b", 5, 45);
		g.drawString("c", 5, 70);
		g.setFont(Big2);
		g.drawString("x1", 5, 130);
		g.drawString("x2", 5, 155);

		//abc formule1 drawen...
		g.setFont(Classic);
		FontMetrics classicMetrics = getFontMetrics(Classic);
		FontMetrics lolMetrics = getFontMetrics(lol);
		int xStart = 250;
		g.setFont(Classic);
		g.setColor(Color.red);
		String xStr = xx1+" = ";
		g.drawString(xStr, xStart, 55);
		int width0 = classicMetrics.charsWidth(xStr.toCharArray(), 0, xStr.length());
		g.setColor(Color.black);
		g.setColor(Color.blue);
		String bStr = "-"+bb+"  -";
		g.drawString("-"+bb+"  -", xStart+width0, 45);
		int width = classicMetrics.charsWidth(bStr.toCharArray(), 0, bStr.length());
		g.setFont(lol);
		g.drawString("√", xStart+width0+width, 45);
		String VStr = "√";
		int width2 = lolMetrics.charsWidth(VStr.toCharArray(), 0, VStr.length());
		g.setFont(Classic);
		String cStr = bb+"² - 4"+aa+cc;
		g.drawString(cStr, xStart+width0+width+width2, 45);
		int width3 = classicMetrics.charsWidth(cStr.toCharArray(), 0, cStr.length());
		g.setColor(Color.black);
		g.drawLine(xStart+width0, 50, xStart+width0+width+width2+width3, 50);
		g.setColor(Color.red);
		g.drawString("2"+aa, xStart+width0+(width+width2+width3)/2, 65);
		//===================formule2drawn======================\\
		g.setFont(Classic);
		g.setColor(Color.red);
		 xStr = xx2+" = ";
		g.drawString(xStr, xStart, 155);
		 width0 = classicMetrics.charsWidth(xStr.toCharArray(), 0, xStr.length());
		g.setColor(Color.black);
		g.setColor(Color.blue);
		 bStr = "-"+bb+"  +";
		g.drawString(bStr, xStart+width0, 145);
		 width = classicMetrics.charsWidth(bStr.toCharArray(), 0, bStr.length());
		g.setFont(lol);
		g.drawString("√", xStart+width0+width, 145);
		 VStr = "√";
		 width2 = lolMetrics.charsWidth(VStr.toCharArray(), 0, VStr.length());
		g.setFont(Classic);
		 cStr = bb+"² - 4"+aa+cc;
		g.drawString(cStr, xStart+width0+width+width2, 145);
		 width3 = classicMetrics.charsWidth(cStr.toCharArray(), 0, cStr.length());
		g.setColor(Color.black);
		g.drawLine(xStart+width0, 150, xStart+width0+width+width2+width3, 150);
		g.setColor(Color.red);
		g.drawString("2"+aa, xStart+width0+(width+width2+width3)/2, 165);
		
		
		
		/*
		//formule2 drawen
		g.drawString("=", 476, 55);
		g.setColor(Color.black);
		g.drawLine(250+width0, 50, 250+width0+width+width2+width3, 50);
		//g.drawLine(330+200, 30, 336+200, 45);
		//g.drawLine(336+200, 45, 350+200, 20);
		//g.drawLine(350+200, 20, 405+200, 20);
		g.setColor(Color.blue);
		g.drawString("-"+bb+" +", 305+200, 45);
		g.drawString(bb+"² - 4"+aa+cc, 353+200, 45);
		g.drawString("2"+aa, 345+200, 65);
		*/
	}
}
