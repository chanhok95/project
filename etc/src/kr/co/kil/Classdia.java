package kr.co.kil;

public class Classdia {
	class Professor {
		private Student student;

		public Professor(Student student) {
			this.student = student;

		}

		public void advise() {
			
		student.advise("��� ����");
		}
	}

	class Student {
		private Professor professor; // Professor Ŭ���� ���ް� professor ������

		public Student(Professor professor) { 	// Student Ŭ���� ������(Professor professor) 
			this.professor = professor; 	// �������� professor ���� ����
		}

	public void advise(String msg) { // advise(String msg)
		System.out.println(msg);
	}
}
}
