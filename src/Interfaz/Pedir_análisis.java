package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.RequestPriority;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pedir_análisis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedir_análisis frame = new Pedir_análisis();
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
	public Pedir_análisis() {
		setTitle("Solicitar an\u00E1lisis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JLabel lblNewLabel = new JLabel("Solicitar an\u00E1lisis");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(41, 37, 148, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id del caballo");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(41, 90, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField.setBounds(142, 87, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(41, 125, 46, 24);
		contentPane.add(lblNewLabel_2);		
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblPrioridad.setBounds(41, 172, 72, 24);
		contentPane.add(lblPrioridad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gen\u00E9tico", "F\u00EDsico", "Salud"}));
		comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		comboBox.setBounds(142, 127, 127, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Com\u00FAn", "Importante", "Urgente"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		comboBox_1.setBounds(142, 174, 127, 22);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					if((String) comboBox_1.getSelectedItem()=="Com�n") {
						Bienvenida.app.send_request(RequestPriority.COMMON, "Realizar informe "+(String) comboBox.getSelectedItem()+" sobre el caballo con identificaci�n "+textField.getText());
						Bienvenida.app.save_changes();
					}
					else if((String) comboBox_1.getSelectedItem()=="Importante") {
						Bienvenida.app.send_request(RequestPriority.IMPORTANT, "Realizar informe "+(String) comboBox.getSelectedItem()+" sobre el caballo con identificaci�n "+textField.getText());
						Bienvenida.app.save_changes();
					}
					else {
						Bienvenida.app.send_request(RequestPriority.URGENT, "Realizar informe "+(String) comboBox.getSelectedItem()+" sobre el caballo con identificaci�n "+textField.getText());
						Bienvenida.app.save_changes();
					}
					JOptionPane.showMessageDialog(null,"Petici�n enviada");
				} catch (ClassNotFoundException e1) {					
					JOptionPane.showMessageDialog(null,"Error");
				}				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(51, 247, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_cliente frame = new Ventana_cliente();
		        frame.setVisible (true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(165, 247, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
