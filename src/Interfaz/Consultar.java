package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Business.*;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Consultar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar frame = new Consultar();
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
	public Consultar() {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel.setBounds(42, 33, 115, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(42, 136, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField.setBounds(175, 133, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);		
		
		lblNewLabel_2 = new JLabel("Caballo ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(42, 95, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 177, 414, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 325, 414, 14);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Caracteristica");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(42, 214, 115, 24);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "C\u00F3digo padre", "C\u00F3digo madre"}));
		comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		comboBox.setBounds(42, 270, 115, 22);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		textField_1.setBounds(175, 271, 103, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(175, 369, 89, 23);
		contentPane.add(btnNewButton_1);		
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textArea.setBounds(483, 83, 414, 309);
		contentPane.add(textArea);		
		
		/*JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
		contentPane.add(sp);*/
		
		JLabel lblNewLabel_4 = new JLabel("Resultados");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(483, 33, 89, 30);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Entity en=Bienvenida.app.find_animal(EntityType.HORSE,Long.parseLong(textField.getText()));
					HorseSpec hs=(HorseSpec) en.get_specs();	
					textArea.append(hs.name+"\n");
					
					//JOptionPane.showMessageDialog(null,"Caballo encontrado");
				} catch (NumberFormatException e1) {					
					JOptionPane.showMessageDialog(null,"Error al ingresar los datos.");

				} catch (ClassNotFoundException e1) {					
					JOptionPane.showMessageDialog(null,"Caballo no encontrado.");

				}  catch (Exception e1) {					
					JOptionPane.showMessageDialog(null,"Caballo no encontrado.");

				} 
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(319, 132, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HorseSpec hs = new HorseSpec();	
				Entity[] en;
				if((String) comboBox.getSelectedItem()=="Nombre") {
					
					hs.name=textField_1.getText();
				}
				else if((String) comboBox.getSelectedItem()=="C\u00F3digo padre") {
									
					hs.register_father=Long.parseLong(textField_1.getText());
				}
				else {
					
					hs.register_mother=Long.parseLong(textField_1.getText());
				}
				try {
					en=Bienvenida.app.matches(EntityType.HORSE, hs);					
					for (int i=0; i<en.length; i++) {
						HorseSpec hsa=(HorseSpec) en[i].get_specs();
						textArea.append(hsa.register+"   "+hsa.name+"\n");
						//en[i].get_specs().show_attributes();						
					}					
				} catch (ClassNotFoundException e1) {					
					e1.printStackTrace();
				}				
			}
		});
		button.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		button.setBounds(319, 270, 89, 23);
		contentPane.add(button);			
	}
}
