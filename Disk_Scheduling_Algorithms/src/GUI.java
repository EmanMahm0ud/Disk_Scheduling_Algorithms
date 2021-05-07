import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI implements ActionListener {
	int numOfRequests, initialNumber, requestNum = 0;
	Vector<Integer> request = new Vector<>();
	
	JFrame frame, startFrame, requestFrame;
	JButton FCFSbutton, SSTFbutton, SCANbutton, CSCANbutton, LOCKbutton, CLOCKbutton, OptimizedButton;
	JButton okButton = new JButton("OK"), addButton = new JButton("ADD");
	JTextField initialText = new JTextField(10);
	JTextField numberText = new JTextField(10);
	JTextField requestText = new JTextField(10);
	JPanel startPanel, requestPanel, panel;
	JLabel initialLabel = new JLabel("Initial start");
	JLabel numberLabel = new JLabel("Number of requests");
	JLabel requestLabel = new JLabel("Number of requests");
	
	DisplayNodes d;
	Algorithm algo;
	Vector<Integer> nodes;
	
	GUI(){
		//uncomment this for static input
		/*
		request.add(98);
		request.add(183);
		request.add(37);
		request.add(122);
		request.add(14);
		request.add(124);
		request.add(65);
		request.add(67);
		*/
		displayStartFrame();
	}
	
	//first frame
	//to take initial start and number of requests
	void displayStartFrame() {
		startFrame = new JFrame();
		startPanel = new JPanel();
		
		startFrame.setTitle("Disk scheduling");
		startFrame.setSize(300, 450);
		startFrame.setVisible(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setResizable(false);
		startFrame.setLocation(650, 200);
		
		startPanel.setVisible(true);
		startPanel.setLayout(null);
		startPanel.setBackground(Color.black);
		
		initialLabel.setBounds(40, 140, 100, 30);
		initialLabel.setFont (initialLabel.getFont ().deriveFont (15f));
		initialLabel.setForeground(Color.WHITE);
		
		initialText.setBounds(40, 170, 200, 30);
		
		numberLabel.setBounds(40, 200, 150, 30);
		numberLabel.setFont (numberLabel.getFont ().deriveFont (15f));
		numberLabel.setForeground(Color.WHITE);
		
		numberText.setBounds(40, 230, 200, 30);
		
		okButton.setBackground(new Color(204,0,0));
		okButton.setForeground(Color.WHITE);
		okButton.setBounds(85, 300, 100, 40);
		okButton.addActionListener(this);
		
		startFrame.add(startPanel);
		startPanel.add(initialText);
		startPanel.add(initialLabel);
		startPanel.add(numberText);
		startPanel.add(numberLabel);
		startPanel.add(okButton);
	}
	
	//second frame
	//to take queue of requests
	void displayRequestQueueFrame() {
		requestFrame = new JFrame();
		requestPanel = new JPanel();
		
		requestFrame.setTitle("Disk scheduling");
		requestFrame.setSize(300, 450);
		requestFrame.setVisible(true);
		requestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		requestFrame.setResizable(false);
		requestFrame.setLocation(650, 200);
		
		requestPanel.setVisible(true);
		requestPanel.setLayout(null);
		requestPanel.setBackground(Color.black);
		
		requestLabel = new JLabel("Request number " + Integer.toString(requestNum + 1));
		requestLabel.setBounds(40, 140, 150, 30);
		requestLabel.setFont (initialLabel.getFont ().deriveFont (15f));
		requestLabel.setForeground(Color.WHITE);
		
		requestText = new JTextField(10);
		requestText.setBounds(40, 170, 200, 30);
		
		addButton = new JButton("ADD");
		addButton.setBackground(new Color(204,0,0));
		addButton.setForeground(Color.WHITE);
		addButton.setBounds(85, 300, 100, 40);
		addButton.addActionListener(this);
		
		requestFrame.add(requestPanel);
		requestPanel.add(requestText);
		requestPanel.add(requestLabel);
		requestPanel.add(addButton);
	}
	
	//third frame
	//to display sequence of heads movements of each algorithm
	void displayAlgorithmFrame() {
		frame = new JFrame();
		frame.setTitle("Disk scheduling");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(250, 90, 1000, 700);
		frame.setBackground(Color.WHITE);
		
		FCFSbutton = new JButton("FCFS");
		SSTFbutton = new JButton("SSTF");
		SCANbutton = new JButton("SCAN");
		CSCANbutton = new JButton("CSCAN");
		LOCKbutton = new JButton("LOCK");
		CLOCKbutton = new JButton("CLOCK");
		OptimizedButton = new JButton("New Optimized");
		
		FCFSbutton.setBackground(new java.awt.Color(177, 5, 5));
		FCFSbutton.setForeground(Color.WHITE);

		SSTFbutton.setBackground(new java.awt.Color(177, 5, 5));
		SSTFbutton.setForeground(Color.WHITE);

		SCANbutton.setBackground(new java.awt.Color(177, 5, 5));
		SCANbutton.setForeground(Color.WHITE);
		
		CSCANbutton.setBackground(new java.awt.Color(177, 5, 5));
		CSCANbutton.setForeground(Color.WHITE);
		
		LOCKbutton.setBackground(new java.awt.Color(177, 5, 5));
		LOCKbutton.setForeground(Color.WHITE);
		
		CLOCKbutton.setBackground(new java.awt.Color(177, 5, 5));
		CLOCKbutton.setForeground(Color.WHITE);
		
		OptimizedButton.setBackground(new java.awt.Color(177, 5, 5));
		OptimizedButton.setForeground(Color.WHITE);
		
		d  = new DisplayNodes(nodes);
		d.setVisible(true);
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.BLACK);

		frame.add(panel, BorderLayout.PAGE_START);
		frame.add(d, BorderLayout.CENTER);
		panel.add(FCFSbutton);
		panel.add(SSTFbutton);
		panel.add(SCANbutton);
		panel.add(CSCANbutton);
		panel.add(LOCKbutton);
		panel.add(CLOCKbutton);
		panel.add(OptimizedButton);
		
		FCFSbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new FCFS(53, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
		SSTFbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new SSTF(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
		SCANbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new SCAN(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
		CSCANbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new C_SCAN(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
		LOCKbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new Look(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
		CLOCKbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new CLook(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
		OptimizedButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				algo = new NewOptimized(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				frame.dispose();
				displayAlgorithmFrame();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {
			String str = initialText.getText();
			initialNumber = Integer.parseInt(str);
			str = numberText.getText();
			numOfRequests = Integer.parseInt(str);
			
			startFrame.dispose();
			if (numOfRequests == 0) {
				algo = new FCFS(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				displayAlgorithmFrame();
			} else {
				displayRequestQueueFrame();
			}
		}
		if (e.getSource() == addButton) {
			//check to add number to vector
			if (requestNum++ < numOfRequests) {
				String str = requestText.getText();
				if (!str.contentEquals("")) {
					int num = Integer.parseInt(str);
					request.add(num);
				}
			}
			//check to display second frame again or third one after incrementing requestNum
			if (requestNum < numOfRequests) {
				requestFrame.dispose();
				displayRequestQueueFrame();
			} else {
				requestFrame.dispose();
				algo = new FCFS(initialNumber, request);
				algo.runAlgorithm();
				nodes = algo.getSequence();
				
				displayAlgorithmFrame();
			}
		}
	}
	
	/*--------------------------------------------------------------------------*/
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
	
}
