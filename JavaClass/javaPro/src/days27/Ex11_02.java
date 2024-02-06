package days27;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 4:38:06
 * @subject
 * @content
 */
public class Ex11_02 {

	public static void main(String[] args) throws IOException {
		String fileName1 = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2_1.hwp";
		String fileName2 = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2_2.hwp";
		String fileName3 = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2_3.hwp";
		String fileName4 = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2_4.hwp";
		
		FileInputStream fis1 = new FileInputStream(fileName1);
		FileInputStream fis2 = new FileInputStream(fileName2);
		FileInputStream fis3 = new FileInputStream(fileName3);
		FileInputStream fis4 = new FileInputStream(fileName4);
		
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(fis1);
		v.add(fis2);
		v.add(fis3);
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		
		String fileName = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2.hwp";
		FileOutputStream fos = new FileOutputStream(fileName);
		int b;
		while ((b = sis.read()) != -1) {
			fos.write(b);
		}
		fos.close();
		
		System.out.println("파일 4개를 합쳐서 1개의 파일로 생성 완료");

	}//main

}//class
