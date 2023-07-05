package days23;

import java.time.Instant;
import java.util.Date;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 10:25:49
 * @subject
 * @content
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 * [ Instant 클래스 ]
		 * - 1970.1.1  00:00:00로부터 경과된 시간을 나노초 단위로 표현하는 클래스
		 *    (  에포크 타임  EPOCH TIME )
		 * */ 		
		 Instant now =   Instant.now();
		 System.out.println( now );                    // 2023-02-27T01:28:10.314788800Z
		 System.out.println( now.getNano() );  // 314788800  에포크타임
		 
		 
		 Date d = new Date();
		 Instant  n =  d.toInstant(); // Date -> Instant 변환   메서드 : toInstant()
		 

	} // main

} // class








