package gm;

/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - GoogleApp
 * */
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

public class GoogleApp {

	public static void main(String[] args) {
		
		GoogleFrame gf = new GoogleFrame();
		
		gf.setTitle("Google Map");
		gf.setVisible(true);
		gf.setSize(new Dimension(1024, 768));
		gf.setResizable(false);
		gf.setLocationRelativeTo(null);
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
}