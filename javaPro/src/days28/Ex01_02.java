package days28;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 9:32:43
 * @subject
 * @content
 */
public class Ex01_02 {

	public static void main(String[] args) throws IOException {
		int [] score = {
				// 번호 국  영  수
				1, 100, 90, 90,
				2, 70, 90, 100,
				3, 100, 100,100,
				4, 70, 60, 80,
				5, 70, 90, 100
		};

		// 성적 정보를 파일로 저장
		String name = ".\\src\\days28\\score.dat"; // data
		String mode = "rw";
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)) {

			for (int i = 0; i < score.length; i++) {
				System.out.printf("> 현재 FP : %d - %d\n", raf.getFilePointer(), score[i]);
				raf.writeInt(score[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("> 엔터 치면 진행합니다");
		System.in.read(); // 일시 정지
		System.in.skip(System.in.available()); // 13, 10 제거

		// [문제1]		
		// 모든 학생의 번호, 국어, 영어, 수학 성적 정보를 출력
		int no, kor, eng, mat;
		int tot;
		double avg;
		try (RandomAccessFile raf = new RandomAccessFile(name, "r")) {
			// 현재 FP : 0
			for (int i = 0; i < score.length/4; i++) {
				no = raf.readInt();
				kor = raf.readInt();
				eng = raf.readInt();
				mat = raf.readInt();
				tot = kor + eng + mat;
				avg = (double)tot/3;
				System.out.printf("번호:%d, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n", no, kor, eng, mat, tot, avg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("> 엔터 치면 진행합니다");
		System.in.read(); // 일시 정지
		System.in.skip(System.in.available()); // 13, 10 제거

		// [문제2]
		// 3번 학생의 수학 점수(100)를 20점으로 수정하는 코딩
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)) {
			int pos = (4+4+4+4)*2+4+4+4;
			raf.seek(pos);
			raf.writeInt(20);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("> 엔터 치면 진행합니다");
		System.in.read(); // 일시 정지
		System.in.skip(System.in.available()); // 13, 10 제거

		// [문제3]
		// 3번 학생의 번호, 국어, 영어, 수학 성적 정보를 출력
		System.out.println(">3번 학생 성적 정보<");
		try (RandomAccessFile raf = new RandomAccessFile(name, "r")) {
			int pos = (4+4+4+4)*2;
			raf.seek(pos);
			no = raf.readInt();
			kor = raf.readInt();
			eng = raf.readInt();
			mat = raf.readInt();
			tot = kor + eng + mat;
			avg = (double)tot/3;
			System.out.printf("번호:%d, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n", no, kor, eng, mat, tot, avg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main

}//class
