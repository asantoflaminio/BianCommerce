package Model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePrice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public ChangePrice(Product p) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIngreseNuevoPrecio = new JTextPane();
		txtpnIngreseNuevoPrecio.setText("Ingrese nuevo precio");
		txtpnIngreseNuevoPrecio.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnIngreseNuevoPrecio.setEditable(false);
		txtpnIngreseNuevoPrecio.setBounds(98, 70, 242, 30);
		contentPane.add(txtpnIngreseNuevoPrecio);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 112, 159, 42);
		contentPane.add(textField);
		
		
		JButton button = new JButton("Confimar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pr = textField.getText();
				if(!pr.matches("\\d+\\.\\d+")) {
					JOptionPane.showMessageDialog(new JFrame(), "Precio solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					p.setPrice(Double.parseDouble(pr));
					JOptionPane.showMessageDialog(new JFrame(), "Precio actualizado", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
				}
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(123, 185, 183, 36);
		contentPane.add(button);
	}

}
