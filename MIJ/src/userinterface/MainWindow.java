package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import repository.Repository;

import java.awt.BorderLayout;

import domein.*;

public class MainWindow {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Category c = new Category("Creational");
		Repository.getInstance().addCategory(c, null);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 200, 200);
		
		JMenu mnNewMenu = new JMenu("Patterns");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Pattern");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(panel);
				panel = new AddPattern();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
	}

}
