package com.university;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student class that inherits the attributes of the university class
 * @author gloria.rodriguez
 *
 */
public class Student extends University {

	/**
	 * declaration of class attributes
	 */
	private int idStudent;
	private int age;
	private int documentStudent;
	private String fullNameStudent;
	private Scanner myInput;
	protected static ArrayList<Student> listStudent = new ArrayList<>();

	/**
	 * Student class builder
	 */
	public Student() {
		myInput = new Scanner(System.in);
		listStudent = new ArrayList<>();
	}
	
	/**
	 * Student class builder with parameters
	 * @param id: save the student code
	 * @param fullNameStudent : save the student full name
	 * @param age: save the student age
	 * @param documentStudent : save the student identification
	 */
	public Student(int id, String fullNameStudent, int age, int documentStudent) {
		this.setIdStudent(id);
		this.setFullNameStudent(fullNameStudent);
		this.setAge(age);
		this.setDocumentStudent(documentStudent);
	}
	
	/**
	 * method that initializes the list of students if it is empty or has only one record and according to the condition it performs console printing
	 * @return
	 */
	public static ArrayList<Student> studentListInitial (){
		if (listStudent.size() <= 1) {
			initialStudent();
			printStudentList(listStudent);
		}
		else {
			printStudentList(listStudent);
		}
		return listStudent;
	}
	
	/**
	 * method that initializes the list of students
	 * @return
	 */
	public static ArrayList<Student> initialStudent(){
		listStudent.add(new Student(1, "Juan Martinez", 21, 2019001));
		listStudent.add(new Student(2, "Charlotte Levo", 20, 2019002));
		listStudent.add(new Student(3, "Mariane Ruiz", 24, 2019003));
		listStudent.add(new Student(4, "Charls Marx", 22, 2019004));
		return listStudent;
	}
	
	/**
	 *  method that implements the method of the parent class (university) to return the data that should be printed on the console each time this method is used.
	 */
	@Override
	public String returnToStringList() {
		return ("Código del Estudiante: " + + this.getIdStudent() + "\n " 
	            + "|Nombre del Estudiante| : " + this.getFullNameStudent() + "\n " 
				+ "|Edad| : " + this.getAge() + " " + "|Documento de identificación| : " + this.getDocumentStudent());
	}
	
	/**
	 * method that requests the information to add a new student to the list.
	 */
	public void requestStudent() {
		System.out.print("Ingrese el código del estudiante: ");
		myInput.nextLine();
		int identificator = myInput.nextInt();
		this.setIdStudent(identificator);
		
		System.out.print("Ingrese nombre y apellido del estudiante: ");
		myInput.nextLine();
		String fullName = myInput.nextLine();
		this.setFullNameStudent(fullName);
		
		System.out.print("Ingrese la edad del estudiante: ");
		myInput.nextInt();
		int ageStudent = myInput.nextInt();
		this.setAge(ageStudent);
		
		System.out.print("Ingrese el número de identificación del estudiante (CC# , TI#): ");
		myInput.nextInt();
		int code = myInput.nextInt();
		this.setDocumentStudent(code);
		
		listStudent.add(new Student(this.idStudent, this.fullNameStudent, this.age, this.documentStudent));
	}
	
	/**
	 * list of class getters and setters
	 * @return
	 */
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getFullNameStudent() {
		return fullNameStudent;
	}
	public void setFullNameStudent(String fullNameStudent) {
		this.fullNameStudent = fullNameStudent;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDocumentStudent() {
		return documentStudent;
	}
	public void setDocumentStudent(int documentStudent) {
		this.documentStudent = documentStudent;
	}
}
