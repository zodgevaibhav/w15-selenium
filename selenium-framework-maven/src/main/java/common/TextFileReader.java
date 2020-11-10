package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	public static void main(String[] args) throws IOException {
		String fileName = "/Users/vaibhavzodge/git/w1415-selenium/selenium-framework-maven/src/main/java/test/LoginData.csv";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;

		boolean isFileHaveData = true;
		
		String[][] loginData = new String[3][2];
		int index = 0;
		while (isFileHaveData) {
			line = br.readLine();
			if (line == null) {
				isFileHaveData = false;
			} else {
				loginData[index]=line.split(",");
				index = index+1;
			}
		}
		
		System.out.println(loginData);
	}

}
