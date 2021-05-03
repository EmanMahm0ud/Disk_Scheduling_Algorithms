import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DisplayNodes extends JPanel implements ActionListener {
	
	Vector<Integer> nodes;
	int y;
	int i;
	Timer timer = new Timer(500, this);
	
	DisplayNodes(){
		
	}
	
	DisplayNodes(Vector<Integer> nodes){
		this.nodes = nodes;
		i = 0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		y = 50;
		for (int j = 0 ; j <= i && !nodes.isEmpty() ; j++) {
			g.setColor(Color.BLACK);
			g.fillOval((nodes.get(j) + 100) * 2, y, 30, 30);
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(nodes.get(j)), (nodes.get(j) + 100) * 2 + 10 - Integer.toString(nodes.get(j)).length(), y + 20);
			g.setColor(Color.DARK_GRAY);
			if (j != 0)
				g.drawLine((nodes.get(j - 1) + 100) * 2 + 20, y - 35, (nodes.get(j) + 100) * 2 + 20, y + 15);
			
			y += 50;
		}
		this.setBackground(Color.white);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (i < nodes.size() - 1) {
			i++;
			repaint();
		} else if (i == nodes.size() - 1) {
			timer.stop();
		}
	}
}
