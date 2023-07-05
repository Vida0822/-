package org.doit.ik.di;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 얘로 인해 생성자 new RecordViewImpl(RecordImpl record) 만들어짐 
@NoArgsConstructor
public class RecordViewImpl implements RecordView {
	
// 	private RecordImpl record = new RecordImpl();  // 결합력이 높은 코딩 (좋은 코딩 x) 
	private RecordImpl record = null ; // 그래서 여기서 바로 객체 생성하지 않음 
	
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
