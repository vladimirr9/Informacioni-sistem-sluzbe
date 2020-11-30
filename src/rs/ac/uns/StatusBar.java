package rs.ac.uns;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class StatusBar extends JPanel {
	private final String appName = "Studentska služba";
	private String time;
	JLabel appNameLabel = new JLabel(appName);
	JLabel timeLabel = new JLabel();
	DateFormat timeFormat = new SimpleDateFormat("HH:mm  dd.MM.yyyy. ");
	public StatusBar()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0)));
		
		TimeListener tl = new TimeListener();
		Timer timer = new Timer(1*1000, tl);		// proverava svaki sekund
		timer.setInitialDelay(0);
		timer.start();
		
		this.add(appNameLabel, BorderLayout.WEST);
		this.add(timeLabel, BorderLayout.EAST);
		
	}
	
	private class TimeListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			Date now = new Date();
			time = timeFormat.format(now);
			timeLabel.setText(time);
			
			
		}
		
	}

}
