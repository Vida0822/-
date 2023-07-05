package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RecordViewImpl3 implements RecordView3 {
	
// 	private RecordImpl record = new RecordImpl();  // 결합력이 높은 코딩 (좋은 코딩 x) 
	
	// @Setter()
	// @Autowired(required = false) 
	// 이 객체가 생성된게 있으면 자동으로 주입해라 ??? 
	// (required = false) : 없으면 삽입하지마라
	// @Resource(name="record1") // 이거 오류! 얜 jdk 9 에서부턴 사용할 수 없기 때문! 
	@Inject
	@Named(value="record2")
	private RecordImpl3 record = null ; // 그래서 여기서 바로 객체 생성하지 않음 
	
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
