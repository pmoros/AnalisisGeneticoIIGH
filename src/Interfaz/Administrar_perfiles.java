package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.AutorizationLevel;
import Business.EntityType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administrar_perfiles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrar_perfiles frame = new Administrar_perfiles();
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
	public Administrar_perfiles() {
		setTitle("Administrador de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrador de usuarios");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(42, 33, 224, 24);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField.setBounds(53, 133, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);		
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_2.setBounds(53, 85, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rol");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_3.setBounds(242, 85, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Genetista", "Capturista", "Administrador"}));
		comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		comboBox.setBounds(214, 132, 111, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_administrador frame = new Ventana_administrador();
		        frame.setVisible (true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(265, 205, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar");
                btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_2.setBounds(42, 205, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
				if("Administrador".equals((String) comboBox.getSelectedItem())) {					
                                    Bienvenida.app.delete_account(AutorizationLevel.ADMIN, textField.getText());
				}               
                                else if("Cliente".equals((String) comboBox.getSelectedItem())) {					
                                    Bienvenida.app.delete_account(AutorizationLevel.CLIENT, textField.getText());
				}      
                                else if("Genetista".equals((String) comboBox.getSelectedItem())) {					
                                    Bienvenida.app.delete_account(AutorizationLevel.WORKER, textField.getText());
				}                                 
				Bienvenida.app.save_changes();
				JOptionPane.showMessageDialog(null,"Usuario borrado");                                
                                
                            } catch (ClassNotFoundException ex) {
                                JOptionPane.showMessageDialog(null,"Error borrando usuario.");
                            }
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_3.setBounds(154, 205, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}