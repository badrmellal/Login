package workLoad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import java.sql.PreparedStatement;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class LoginPage extends JFrame {
    JFrame jFrame = new JFrame();
    JButton jButton = new JButton();
    
    JLabel nameLabel = new JLabel();
    JTextField nameTextField = new JTextField();
    
    JLabel ageLabel = new JLabel();
    JTextField ageTextField = new JTextField();
    
    JLabel emailLabel = new JLabel();
    JTextField emailTextField = new JTextField();

    public LoginPage() {
        setSize(600, 400);
        setTitle("Login-Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setVisible(true);
        
        nameTextField.setBounds(170, 20, 200, 30); // Adjust text field position and size
        add(nameTextField);
        ageTextField.setBounds(170, 50, 200, 30); // Adjust text field position and size
        add(ageTextField);
        emailTextField.setBounds(170, 80, 200, 30); // Adjust text field position and size
        add(emailTextField);

        
        nameLabel.setBounds(50, 20, 250, 30); // Adjust label position and size
        nameLabel.setText("Enter your name:");
        add(nameLabel);
        ageLabel.setBounds(50, 50, 250, 30); // Adjust label position and size
        ageLabel.setText("Enter your age:");
        add(ageLabel);
        emailLabel.setBounds(50, 80, 250, 30); // Adjust label position and size
        emailLabel.setText("Enter your email:");
        add(emailLabel);
        
        jButton.setBounds(200, 120, 150, 40);
        jButton.setText("Register");
        jButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        add(jButton);
        jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = nameTextField.getText();
					int age = Integer.parseInt(ageTextField.getText());
					String email = emailTextField.getText();
					
					//insertion login database connection
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
					String query = "INSERT INTO employee(name, age, email) VALUES(?, ?, ?)";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, age);
					preparedStatement.setString(3, email);
					preparedStatement.executeUpdate();
					
					System.out.println("Data updated succefully !");
					
					preparedStatement.close();
					connection.close();
					
				}
				catch (Exception e2) {
				
					e2.printStackTrace();
				}
			}
		});
        
        jButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

				jButton.setText("Register");
			    System.exit(0);

			}
			
			@Override
			public void mousePressed(MouseEvent e) {

		        jButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
		        jButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				jButton.setText("Register");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				jButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				jButton.setText("Done!");
				
			}
		});
        
    }
}