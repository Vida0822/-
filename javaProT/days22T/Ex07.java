package days22;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 3:52:46
 * @subject
 * @content
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		/*
		 *   Date ( jdk 1.0 ) , Calendar( jdk 1.1 ) 클래스
		 *   형식화 클래스 4가지 .
		 *   [  jdk 1.8 새로 추가된 날짜.시간 클래스  - ( java.time 패키지 )   ]
		 *   4:10 수업 시작~ 
		 * */
		
		/*
		 *    Date, Calendar( 스레드에 안전 X ) 불편한점(단점 ) - 날짜 + 시간
		 *  
		 *    1. 
		 *    java.time 패키지 + 하위 4개 패키지. 구성 - 날짜,시간을 다루는 핵샘 클래스 제공.
		 *       ㄴj.t.chrono :  표준(ISO)이 아닌 달력 시스템을 위한 클래스 제공.
		 *       ㄴj.t.format :   날짜,시간의 형식화, 파싱 클래스 제공
		 *       ㄴj.t.temporal (시간의) :  날짜,시간의 필드(field)와 단위(unit) 클래스  제공
		 *       ㄴj.t.zone :    시간대(time-zone) 클래스 제공
		 *       
		 *    2.  j.t 패키지의 핵심 클래스 
		 *      - 날짜와 시간을 다루는 클래스를 분리(구별)  
		 *      1) 날짜 -  LocalDate 클래스
		 *      2) 시간 - LocalTime 클래스
		 *      3) 날짜 + 시간  - LocalDateTime 클래스
		 *      4) 날짜  + 시간 + 시간대 -  ZonedDateTime 클래스
		 *      
		 *          - new 연산자로 객체 생성 X
		 *          - now()   현재 시스템의 ...
		 *             of()
		 *             메서드 
		 *             
		 *          - 특정 필드(년,월,일,시,분,초,밀세,요 등등) 가져올 때  : get(필드),  get필드() 
		 *                                                                                                               getYear(), getMonth() 등등
		 *                                                                                                               getHour()
		 *                                                                                            get( TemporalField )
		 *                                                                                            get( ChronoField.YEAR )
		 *               
		 *         
		 *      
		 *    3. 날짜와  날짜 사이의 간격 : Period     클래스
		 *         시간과 시간 사이의 간격 :  Duration 클래스  
		 *    
		 *    4. j.t 핵심클래스 ( LocalDate,  LocalTime,    LocalDateTime,  ZonedDateTime ) 는 
		 *       모두  Temporal, TemporalAccessor, TomporalAdjuster 라는 인터페이스를 구현한 클래스이다.
		 *       
		 *    5. 날짜, 시간의 간격 클래스 (    Period,  Duration ) 클래스는 
		 *        TemporalAmount 인터페이스를 구현한 클래스이다. 
		 *     
		 *     6.   날짜와 시간의 단위를 정의해 놓은 것
		 *            :  TemporalUnit 인터페이스 -> 구현한 클래스(열거형) ChronoUnit 이다.   
		 *           
		 *     7. 년, 월, 일 등의 날짜와 시간의 필드를 정의해 놓은 것      
		 *          : TemporalField 인터페이스  -> 구현한 클래스(열거형)  ChronoField 이다. 
		 *          
		 *      8. 예제) 
		 *          Ex08.java    
		 * */

	} // main

} // class






