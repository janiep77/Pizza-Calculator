import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 */

/**
 * @author Janie
 *
 */
public class PizzaCalc {
	 private JTextField text1;
	 private JTextField text2;
	 private JTextField text3;
	 private JTextField text4;
	 private JLabel label1;
	 private JLabel label2;
	 private JLabel label3;
	 private JLabel label4;
	 private JPanel p; 
	 private JFrame frame;
	 
	 public void go() {
	        //found how to do all of this off of oracle's website about SpringLayout
		 
		 	label1 = new JLabel("Enter the Price: $");
	        label2 = new JLabel("Enter the Radius: ");
	        label3 = new JLabel("Enter the height: ");
	        label4 = new JLabel("The price/cubic inch is: $");
	        text1 = new JTextField(20);
	        text2 = new JTextField(20);
	        text3 = new JTextField(20);
	        text4 = new JTextField(20);
	        
			text4.setEnabled(false);

	        int numPairs = 5;
	 
	        
	        p = new JPanel(new SpringLayout());

			JButton btnCalculate	= new JButton("Calculate");
			JButton btnClear 		= new JButton("Clear");
			
			btnClear.addActionListener(new ClearActionListener());
			btnCalculate.addActionListener(new CalculateActionListener());
	        
	        p.add(label1);
	        p.add(text1);
	        p.add(label2);
	        p.add(text2);
	        p.add(label3);
	        p.add(text3);
	        p.add(label4);
	        p.add(text4);
			p.add(btnCalculate);
			p.add(btnClear);

		   //this isn't mine 
	        SpringUtilities.makeCompactGrid(p, numPairs, 2, 6, 6, 6, 6);       
	 
	 
	        frame = new JFrame("Pizza Calculator");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	        

		    
	        p.setOpaque(true); //this isn't mine
	        frame.setContentPane(p);
	 
	        frame.pack();
	        frame.setVisible(true);
	      
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        PizzaCalc p = new PizzaCalc();
        p.go();
	}
	public void calculate(){
        
		double sum = 0;
		double pi = 3.14;
		if (text1.getText().isEmpty()) {
			sum = 0;
		} else if (text2.getText().isEmpty()) {
			sum = 0;
		} else if(text3.getText().isEmpty()){
			sum = 0;
		} else {
			sum = Double.parseDouble(text1.getText()) 
					/((pi * Double.parseDouble(text2.getText()) 
					* Double.parseDouble(text2.getText()) 
					* Double.parseDouble(text3.getText())));
		}
		text4.setText(String.format("%.2f", sum));

	}

	class CalculateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calculate();
		}
	}
	class ClearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
		}
	}
}
