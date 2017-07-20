import java.awt.*;

public class Test
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setLayout(new GridLayout(4,2));
		f.setSize(500,200);
		f.setVisible(true);
		
		Panel p1 = new Panel();
		TextField tf1_1 = new TextField(3);
		TextField tf1_2 = new TextField(3);
		TextField tf1_3 = new TextField(3);
		Button b1 = new Button("=");
		Label lb1 = new Label("+");
		p1.add(tf1_1);
		p1.add(lb1);
		p1.add(tf1_2);
		p1.add(b1);
		p1.add(tf1_3);
		f.add(p1);
		
		Panel p2 = new Panel();
		TextField tf2_1 = new TextField(3);
		TextField tf2_2 = new TextField(3);
		TextField tf2_3 = new TextField(3);
		Button b2 = new Button("=");
		Label lb2 = new Label("-");
		p2.add(tf2_1);
		p2.add(lb2);
		p2.add(tf2_2);
		p2.add(b2);
		p2.add(tf2_3);
		f.add(p2);
		
		Panel p3 = new Panel();
		TextField tf3_1 = new TextField(3);
		TextField tf3_2 = new TextField(3);
		TextField tf3_3 = new TextField(3);
		Button b3 = new Button("=");
		Label lb3 = new Label("+");
		p3.add(tf3_1);
		p3.add(lb3);
		p3.add(tf3_2);
		p3.add(b3);
		p3.add(tf3_3);
		f.add(p3);
		
		Panel p4 = new Panel();
		TextField tf4_1 = new TextField(3);
		TextField tf4_2 = new TextField(3);
		TextField tf4_3 = new TextField(3);
		Button b4 = new Button("=");
		Label lb4 = new Label("-");
		p4.add(tf4_1);
		p4.add(lb4);
		p4.add(tf4_2);
		p4.add(b4);
		p4.add(tf4_3);
		f.add(p4);
		
		Panel p5 = new Panel();
		TextField tf5_1 = new TextField(3);
		TextField tf5_2 = new TextField(3);
		TextField tf5_3 = new TextField(3);
		Button b5 = new Button("=");
		Label lb5 = new Label("+");
		p5.add(tf5_1);
		p5.add(lb5);
		p5.add(tf5_2);
		p5.add(b5);
		p5.add(tf5_3);
		f.add(p5);
		
		Panel p6 = new Panel();
		TextField tf6_1 = new TextField(3);
		TextField tf6_2 = new TextField(3);
		TextField tf6_3 = new TextField(3);
		Button b6 = new Button("=");
		Label lb6 = new Label("-");
		p6.add(tf6_1);
		p6.add(lb6);
		p6.add(tf6_2);
		p6.add(b6);
		p6.add(tf6_3);
		f.add(p6);
		
		Button b7 = new Button("³öÌâ");
		Button b8 = new Button("´ð°¸");
		f.add(b7);
		f.add(b8);
	}
}