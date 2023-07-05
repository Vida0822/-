package org.doit.ik.di4;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Component // 이 컴포넌트에 이름을 부여하지 않으면 클래스의 첫번째 글자만 소문자로 바뀌어서 명령빈객체로 만들어진다 
@Component
public class RecordViewImpl4 implements RecordView4 {
	
	
	@Autowired(required = false) 
	private RecordImpl4 record = null ; // 그래서 여기서 바로 객체 생성하지 않음 
	
	@Override
	public void input() {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("> kor, eng, mat, input  ?");
			
			int kor = scanner.nextInt(); 
			int eng = scanner.nextInt(); 
			int mat = scanner.nextInt(); 
			
			this.record.setEng(eng);
			this.record.setKor(kor);
			this.record.setMat(mat); 
		}catch (Exception e) {
			e.printStackTrace();
		} // trycatch 
	} // input

	@Override
	public void output() {
		System.out.printf("> kor = %d, eng = %d , mat = %d , tot = %d, avg = %.2f \n"
						, this.record.getKor() 
						, this.record.getEng() 
						, this.record.getMat() 
						, this.record.total()
						, this.record.avg()
			) ; // printf
	} // output
	
} // RecordViewImpl
