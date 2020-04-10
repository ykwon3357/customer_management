import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Customer_Management_Program {

	private JFrame frame;
	private JTextField numField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField telField;
	private JTable table;
	private JPanel contentPane = null;
	private JScrollPane infoScrollPane;
	private JTable searchResultTable;
	private DefaultTableModel tableModel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Management_Program window = new Customer_Management_Program();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_Management_Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Object[][] data = {
				{"강지아","jeea@mem.com","1111","30"},
				{"이장미","rose@mem.com","2222","20"},
				{"김백합","lily@mem.com","3333","10"}
		};
		String[] colums = {"성명","이메일","전화번호","나이"};
		tableModel=new DefaultTableModel(data, colums);
		searchResultTable = new JTable(tableModel);
		infoScrollPane = new JScrollPane(searchResultTable);
		tableModel.setRowCount(20);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 585, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("번 호");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 13, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("이 름");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBounds(12, 48, 57, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("이 메 일");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("굴림", Font.BOLD, 12));
		label_1.setBounds(12, 86, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("전화번호");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("굴림", Font.BOLD, 12));
		label_2.setBounds(12, 125, 57, 15);
		panel.add(label_2);
		
		numField = new JTextField();
		numField.setBounds(73, 10, 116, 21);
		panel.add(numField);
		numField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(73, 45, 116, 21);
		panel.add(nameField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(73, 83, 116, 21);
		panel.add(emailField);
		
		telField = new JTextField();
		telField.setColumns(10);
		telField.setBounds(73, 122, 116, 21);
		panel.add(telField);
		
		table = searchResultTable;
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				System.out.println(Arrays.toString(data[row]));
			}
		});
//		table = new JTable();
		table.setBounds(199, 10, 374, 212);
		panel.add(infoScrollPane);
		panel.add(table);
		
		JButton button = new JButton("전체보기");
		button.setBounds(73, 232, 81, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("추  가");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[4];
				
				inputStr[0] = numField.getText();
				inputStr[1] = nameField.getText();
				inputStr[2] = emailField.getText();
				inputStr[3] = telField.getText();
				tableModel.addRow(inputStr);
				
				numField.setText("");
				nameField.setText("");
				emailField.setText("");
				telField.setText("");
			}
		});
		button_1.setBounds(166, 232, 81, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("삭  제");
		button_2.setBounds(259, 232, 81, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("검  색");
		button_3.setBounds(352, 232, 81, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("취  소");
		button_4.setBounds(445, 232, 81, 23);
		panel.add(button_4);
	}
}
