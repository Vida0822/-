package days20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오전 9:05:41
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
	     String path = "C:\\SS18Class5\\JavaClass\\javaPro\\src\\days20\\SS18교육생명단.txt";
	     String fileName;
	     String extender;
	     
	     int idx1, idx2;
	     idx1 = path.lastIndexOf("\\");
	     idx2 = path.lastIndexOf(".");
	     
	     fileName = path.substring(idx1+1,idx2); // beginIndex, endIndex
	     System.out.println(fileName);
	     
	     extender = path.substring(idx2); // beginIndex ~ 끝까지
	     System.out.println(extender);
	     
	     
	}//main

}//class
