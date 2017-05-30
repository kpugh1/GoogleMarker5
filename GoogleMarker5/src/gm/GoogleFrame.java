package gm;
/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - GoogleFrame
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.*;


public class GoogleFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	Image mapImage;
	GoogleMap googleMap;
	ImageIcon mapIcon;
	JLabel centerLabel;
	
	

	public GoogleFrame() {

		try {
			URL url = new URL("http://stargate.ncc.edu/~steve/kitty.jpg");
			System.out.println(url);
			mapImage = ImageIO.read(url);// read the image data store it
		}
		catch (IOException ie) {
			System.out.println("Error" + ie.getMessage());
		}

		// make map icon which will be used later in label to display picture
		mapIcon= new ImageIcon(mapImage); 

		//Create a new Google Map
		googleMap = new GoogleMap();
		
		//Create a mainPanel 
		JPanel mainPanel = new JPanel();

		//Create a topPanel
		JPanel topPanel = new JPanel();

		// make a label
		JLabel label = new JLabel("Select A Category", JLabel.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Serif", Font.BOLD,18));
		label.setOpaque(true);
		
		//Add label to top panel
		topPanel.add(label);
		
		//Create a List of categories
		String [] categoryName = {"Museum", "Amusement", "Restaurant", "Gas", "Movie"};
		
		//Create a dropbox of the list of categories
		JComboBox selection = new JComboBox(categoryName);
		
		//Add the dropbox to the panel
		topPanel.add(selection);

		//Create a button
		JButton generate = new JButton("Generate Map");
		
		//Add an action listener to the button
		generate.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						try{
							//Create map Icon based on the selected Item in the drop box
							mapIcon = new ImageIcon(googleMap.getMap((String)selection.getSelectedItem()));
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
						
						//Set the icon to the centerLabel
						centerLabel.setIcon(mapIcon);
					}
				});
		
		//Add button to top panel
		topPanel.add(generate);
		

		// add the top panel to the main panel
		mainPanel.add(topPanel,BorderLayout.NORTH);

		//Add the map Icon to the Cener label
		centerLabel = new JLabel(mapIcon);

		//Add the center Label to the boder layout soth
		mainPanel.add(centerLabel, BorderLayout.SOUTH);
	
		//add the main panel to the frame
		add(mainPanel);



	}

	

}