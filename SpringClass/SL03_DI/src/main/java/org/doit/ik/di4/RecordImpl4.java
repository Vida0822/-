package org.doit.ik.di4;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RecordImpl4 implements Record4{ // 성적처리하는 객체 

	private int kor ; 
	private int eng ;
	private int mat ;
	
	@Override
	public int total() {		
		return kor+eng+mat;
	} // total

	@Override
	public double avg() {
		return total() / 3.0 ;
	} //  avg

} // RecordImpl
