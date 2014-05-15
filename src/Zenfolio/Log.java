package Zenfolio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	
	public static void print(String text) {
		try {
			FileWriter outFile = new FileWriter("C:/temp/text.txt", true);
			PrintWriter out = new PrintWriter(outFile);
						
			out.println(text);
			
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void NTraffic(String text) {
		try {
			FileWriter outFile = new FileWriter("C:/temp/NTraffic.txt", true);
			PrintWriter out = new PrintWriter(outFile);
						
			out.println(text);
			
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
