package kr.co.kil;

public class Classdia {
	class Professor {
		private Student student;

		public Professor(Student student) {
			this.student = student;

		}

		public void advise() {
			
		student.advise("상담 내용");
		}
	}

	class Student {
		private Professor professor; // Professor 클래스 값받고 professor 재정의

		public Student(Professor professor) { 	// Student 클래스 생성자(Professor professor) 
			this.professor = professor; 	// 전역변수 professor 값에 대입
		}

	public void advise(String msg) { // advise(String msg)
		System.out.println(msg);
	}
}
}
