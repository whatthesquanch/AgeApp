import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JPanel panel;
	private final JButton calculateButton;
	
	public AgeApp() {
		setTitle("Age Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel birthDateLabel = new JLabel("Enter your birth date (YYYY-MM-DD): ");
		JTextField birthDateField = new JTextField(10);
		calculateButton = new JButton("Calculate Age");
		JLabel ageLabel = new JLabel("Your age is: ");
		
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String birthDateString = birthDateField.getText();
				LocalDate birthDate = LocalDate.parse(birthDateString);
				LocalDate currentDate = LocalDate.now();
				int age = Period.between(birthDate, currentDate).getYears();
				
				SwingUtilities.invokeLater(() -> {
				ageLabel.setText("Your age is: " + age);
			});
	
			}
	});
		
			panel.add(birthDateLabel);
			panel.add(birthDateField);
			panel.add(calculateButton);
			panel.add(ageLabel);
			
			add(panel);
			pack();
			setLocationRelativeTo(null);
			
			setSize(400, 150);
			setVisible(true);
	}
		

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AgeApp());

	}

}
