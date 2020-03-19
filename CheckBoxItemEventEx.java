import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame{
	private JCheckBox [] fruits = new JCheckBox [3];
	private String [] names = {"apple","pear","cherry"};

	private JLabel sumLabel;

	public CheckBoxItemEventEx(){
		setTitle("CheckBox and ItemEvent Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("apple 100, pear 500, cherry 20000"));

		MyItemListener listener = new MyItemListener();
		for(int i=0; i<fruits.length; i++){
			fruits[i] =new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}

		sumLabel = new JLabel("now 0");
		c.add(sumLabel);

		setSize(250,200);
		setVisible(true);
	}

	class MyItemListener implements ItemListener{
		private int sum=0;

		public void itemStateChanged(ItemEvent e){
			if(e.getStateChange()==ItemEvent.SELECTED){
				if(e.getItem()==fruits[0])
					sum +=100;
				else if(e.getItem()==fruits[1])
					sum +=500;
				else 
					sum +=20000;
			}
			else{
				if(e.getItem()==fruits[0])
					sum -=100;
				else if(e.getItem()==fruits[1])
					sum -=500;
				else
					sum -=20000;
			}
			sumLabel.setText("now"+sum+"won");
		}
	}
	public static void main(String [] args){
		new CheckBoxItemEventEx();
	}
}


