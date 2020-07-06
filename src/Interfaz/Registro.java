package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import Business.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nom;
	private JTextField textField_3_ap;
	private JTextField textField_2_mail;
	private JTextField textField_4_us;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("An\u00E1lisis IIGH ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel.setBounds(68, 139, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(68, 164, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectrnico.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblCorreoElectrnico.setBounds(68, 191, 109, 14);
		contentPane.add(lblCorreoElectrnico);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblContrasea.setBounds(68, 237, 109, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblUsuario.setBounds(68, 215, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Registro");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(47, 47, 109, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_nom = new JTextField();
		textField_nom.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_nom.setBounds(204, 136, 139, 20);
		contentPane.add(textField_nom);
		textField_nom.setColumns(10);
		
		textField_3_ap = new JTextField();
		textField_3_ap.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_3_ap.setColumns(10);
		textField_3_ap.setBounds(204, 161, 139, 20);
		contentPane.add(textField_3_ap);
		
		textField_2_mail = new JTextField();
		textField_2_mail.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_2_mail.setColumns(10);
		textField_2_mail.setBounds(204, 185, 139, 20);
		contentPane.add(textField_2_mail);
		
		textField_4_us = new JTextField();
		textField_4_us.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_4_us.setBounds(204, 209, 139, 20);
		contentPane.add(textField_4_us);
		textField_4_us.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		passwordField.setBounds(204, 234, 139, 20);
		contentPane.add(passwordField);	
		
		JButton btnNewButton = new JButton("Validar");
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {                                
                               Bienvenida.app.sign_up(AutorizationLevel.CLIENT, textField_4_us.getText(), passwordField.getText(), textField_nom.getText(), textField_3_ap.getText(), textField_2_mail.getText());
				Bienvenida.app.save_changes();
				JOptionPane.showMessageDialog(null,"Usuario registrado");	
				
                            } catch (ClassNotFoundException ex) {
                                JOptionPane.showMessageDialog(null,"El usuario ya existe");					
                            }				
				
				//}
				//catch(ClassNotFoundException e1) {
//					JOptionPane.showMessageDialog(null,"El usuario ya existe");					
//				}								
			}
		});
		btnNewButton.setBounds(79, 305, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bienvenida frame = new Bienvenida();
		        frame.setVisible (true);		        
			}			
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(217, 305, 89, 23);
		contentPane.add(btnNewButton_1);		
	}

}
