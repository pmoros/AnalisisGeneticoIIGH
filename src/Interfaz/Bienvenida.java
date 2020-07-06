package Interfaz;

import analisisgeneticoiigh.*;
import Business.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Bienvenida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;	
	public static Aplication app =  new Aplication();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bienvenida() {
		setTitle("An\u00E1lisis IIGH ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel.setBounds(168, 43, 116, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(109, 115, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(109, 140, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField.setBounds(218, 112, 128, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		passwordField.setBounds(218, 137, 128, 20);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CLIENT", "ADMIN", "WORKER"}));
		comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		comboBox.setBounds(10, 109, 60, 22);
		contentPane.add(comboBox);                
                
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro frame = new Registro();
		        frame.setVisible (true);		        
			}		
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(257, 193, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
                                    switch ((String) comboBox.getSelectedItem()) {
                                        case "ADMIN":
                                            Bienvenida.app.login(AutorizationLevel.ADMIN,textField.getText(),passwordField.getText());
                                            break;
                                        case "CLIENT":
                                            Bienvenida.app.login(AutorizationLevel.CLIENT,textField.getText(),passwordField.getText());
                                            break;
                                        case "WORKER":
                                            Bienvenida.app.login(AutorizationLevel.WORKER,textField.getText(),passwordField.getText());                                          
                                            break;
                                    }
					if(Bienvenida.app.current_user.getPrivileges().get_value()==3) {						
						Ventana_administrador frame = new Ventana_administrador();
				        frame.setVisible (true);
					}
					else if(Bienvenida.app.current_user.getPrivileges().get_value()==2) {
						Ventana_genetista frame = new Ventana_genetista();
				        frame.setVisible (true);
					}
					else if(Bienvenida.app.current_user.getPrivileges().get_value()==1) {
						Ventana_cliente frame = new Ventana_cliente();
				        frame.setVisible (true);
					}
					else {
						Ventana_capturista frame = new Ventana_capturista();
				        frame.setVisible (true);
					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Contrase�a incorrecta");
				}				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(119, 193, 89, 23);
		contentPane.add(btnNewButton);
	}
}
