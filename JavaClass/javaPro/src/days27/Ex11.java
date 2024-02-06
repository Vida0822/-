package days27;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 4:25:54
 * @subject Sequence[InputStream]
 * @content 순차적인
 * 			- 여러 개의 입력 스트림을 연속적으로 연결해서 하나의 스트림으로 데이터를 처리할 수 있는 바이트 스트림
 * 			예) 하나의 용량이 큰 파일을 여러 개의 작은 파일로 생성
 * 			-> 하나의 스트림
 */
public class Ex11 {

	public static void main(String[] args) throws IOException {
		byte [] n = {1,2,3};
		byte [] m = {4,5,6};
		byte [] k = {7,8,9};
		
		// byte [] -> 메모리 스트림 변환
		ByteArrayInputStream bais1 = new ByteArrayInputStream(n);
		ByteArrayInputStream bais2 = new ByteArrayInputStream(m);
		ByteArrayInputStream bais3 = new ByteArrayInputStream(k);
		
		// 위의 3개의 바이트스트림 -> 하나의 바이트 스트림 생성 -> 처리
		/*
		SequenceInputStream sis = new SequenceInputStream(bais1, bais2);
		SequenceInputStream sis2 = new SequenceInputStream(sis, bais3);
		*/
		
		// SequenceInputStream sis = new SequenceInputStream(Enumeration<? extends InputStream> e);
		
		Vector<ByteArrayInputStream> v = new Vector<ByteArrayInputStream>();
		v.add(bais1);
		v.add(bais2);
		v.add(bais3);
		Enumeration<ByteArrayInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		
		int b;
		while ((b = sis.read()) != -1) {
			System.out.println(b);
		}//while
		
	}//main

}//class
