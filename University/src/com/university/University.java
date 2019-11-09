package com.university;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class University {

	/**
	 * University class builder
	 */
	public University() {
	}

	/**
	 * method that returns the list with the Professor class information
	 * @param professorList
	 */
	protected static void printProfessorList(ArrayList<Professor> professorList) {
		Iterator<Professor> itrProfesor = professorList.iterator();
		while (itrProfesor.hasNext()) {
			System.out.println(itrProfesor.next().returnToStringList());
		}
	}
	
	/**
	 * method that returns the list with the Subject class information
	 * @param subjectList
	 */
	protected static void printSubjectList(ArrayList<Subject> subjectList) {
		Iterator<Subject> itrSubject = subjectList.iterator();
		while (itrSubject.hasNext()) {
			System.out.println(itrSubject.next().returnToStringList());
		}
	}
	
	/**
	 * method that returns the list with the Student class information
	 * @param studentList
	 */
	protected static void printStudentList(ArrayList<Student> studentList) {
		Iterator<Student> itrStudent = studentList.iterator();
		while (itrStudent.hasNext()) {
			System.out.println(itrStudent.next().returnToStringList());
		}
	}
	
	/**
	 * method that returns the list of each of the methods to the class to which it belongs
	 * @return
	 */
	public abstract String returnToStringList();
	
}
