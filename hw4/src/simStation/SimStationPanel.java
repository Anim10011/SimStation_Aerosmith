package simStation;

import java.awt.*;

import javax.swing.*;

import mvc.*;
import prisoner.*;

/*
 * Edit History
 * 
 * 4/5 - Created SimStationPanel.
 * 
 * 4/11 - Added main() to test Prisoner's Dilemma Simulation.
 */

public class SimStationPanel extends AppPanel {
	
	public SimStationPanel(AppFactory factory) {
		super(factory);
		
		SimStationFactory simFactory = (SimStationFactory)this.factory;  
		View view = simFactory.makeView(model);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1));
		
		JButton b = new JButton("Start");
		b.addActionListener(this);
		JPanel p = new JPanel();
		p.add(b);
		buttonPanel.add(p);
		
		b = new JButton("Suspend");
		b.addActionListener(this);
		p = new JPanel();
		p.add(b);
		buttonPanel.add(p);
		
		b = new JButton("Resume");
		b.addActionListener(this);
		p = new JPanel();
		p.add(b);
		buttonPanel.add(p);
		
		b = new JButton("Stop");
		b.addActionListener(this);
		p = new JPanel();
		p.add(b);
		buttonPanel.add(p);
		
		b = new JButton("Stats");
		b.addActionListener(this);
		p = new JPanel();
		p.add(b);
		buttonPanel.add(p);
		
		this.setLayout(new GridLayout(1, 2));
		this.add(buttonPanel);
		this.add(view);
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimStationPanel(new PrisonersDilemmaFactory());
		panel.display();
	}
}
