package com.university;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Subject class that inherits the attributes of the university class
 * 
 * @author gloria.rodriguez
 *
 */
public class Subject extends University {

	/**
	 * declaration of class attributes
	 */
	private int idSubject;
	private int classRoom;
	private int classStudent;
	private String nameSubject;
	private String assignedProfessor;
	private String selectClass;
	private String subjectStudent;
	private Scanner myInput;
	protected static ArrayList<Subject> listSubject;
	protected static ArrayList<String> listProfessorStudent;
	private ArrayList<String> listStudents;
	protected ArrayList<String> listFullSubject;

	/**
	 * Subject class builder
	 */
	public Subject() {
		this.myInput = new Scanner(System.in);
		listSubject = new ArrayList<>();
		listProfessorStudent = new ArrayList<>();
		listStudents = new ArrayList<>();
		listFullSubject = new ArrayList<>();
	}

	/**
	 * Subject class builder with parameters
	 * 
	 * @param idSubject:   save the subject code
	 * @param nameSubject: save the subject name
	 * @param classRoom:   save the number of class room
	 */
	public Subject(int idSubject, String nameSubject, int classRoom) {
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.classRoom = classRoom;
	}

	/**
	 * method that initializes the list of subjects if it is empty or has only one
	 * record and according to the condition it performs console printing
	 * 
	 * @return
	 */
	public static ArrayList<Subject> subjectListInitial() {
		if (listSubject.size() <= 1) {
			initialSubject();
			printSubjectList(listSubject);
		} else {
			printSubjectList(listSubject);
		}
		return listSubject;
	}

	/**
	 * method that initializes the list of subjects
	 * 
	 * @return
	 */
	public static ArrayList<Subject> initialSubject() {
		listSubject.add(new Subject(1, "Cálculo I", 200));
		listSubject.add(new Subject(2, "Física I", 201));
		listSubject.add(new Subject(3, "Programación I", 300));
		listSubject.add(new Subject(4, "Lógica matemática", 301));
		return listSubject;
	}

	/**
	 * method that implements the method of the parent class (university) to return
	 * the data that should be printed on the console each time this method is used.
	 */
	@Override
	public String returnToStringList() {
		return ("--------Código de la clase: " + this.getIdSubject() + "\n " + "|Nombre de la clase| : "
				+ this.getNameSubject() + "\n " + "|Salon de Clases| : " + this.getClassRoom());
	}

	/**
	 * method that requests the information to add a new subject to the list.
	 */
	public void requestSubject() {
		System.out.print("Ingrese el código de la clase: ");
		int idCourse = Integer.parseInt(myInput.nextLine());
		myInput.nextLine();
		this.setIdSubject(idCourse);
		System.out.print("Ingrese el nombre de la clase: ");
		this.nameSubject = myInput.nextLine();
		this.setNameSubject(this.nameSubject);
		System.out.print("Ingrese el salón de clases: ");
		this.classRoom = myInput.nextInt();
		this.setClassRoom(this.classRoom);

		listSubject.add(new Subject(this.idSubject, this.nameSubject, this.classRoom));
	}

	/**
	 * method that validates if the subjects list has records
	 */
	public void validateListAssignedProfessor() {
		if (listSubject.size() <= 0 || Professor.listProfessor.size() <= 0) {
			initialSubject();
			Student.initialStudent();
			Professor.initialProfessor();
			selectedProfessor();
		} else {
			selectedProfessor();
		}
	}

	/**
	 * method that validates if the list that has the information that contains
	 * (class, professor, students) has records.
	 */
	public void validateListFullSubject() {
		if (listProfessorStudent.size() <= 0 && Student.listStudent.size() <= 0) {
			initialSubject();
			Professor.initialProfessor();
			Student.initialStudent();
			System.out.println(
					"Por favor asigne primero un profesor a una clase (opción 5) antes de asignar estudiantes a la clase, Gracias.");
		} else {
			insertStudent();
		}
	}

	/**
	 * method that validates if the class have assigned Students.
	 */
	public void validateStudentClass() {
		if (listFullSubject.size() <= 0) {
			System.out.println("Por favor asigne primero un estudiante a una clase (opción 8), Gracias.");
		} else {
			menuSubjectStudents();
		}
	}

	/**
	 * method that validates if the Student have assigned Classes for the search
	 */
	public void validateSearchStudent() {
		if (listFullSubject.size() <= 0) {
			System.out.println("Por favor asigne primero un estudiante a una clase (opción 8), Gracias.");
		} else {
			searchStudent();
		}
	}

	/**
	 * method that return the name of the class and the assigned teacher
	 * 
	 * @param nameSubject        : save the Subject name
	 * @param assignedProfessor: save the assigned professor
	 * @return
	 */
	public String asignedProfessor(String nameSubject, String assignedProfessor) {
		return (nameSubject + " " + assignedProfessor);
	}

	/**
	 * method that return the name of the class, the Student code and the Student
	 * full name
	 * 
	 * @param selectClass      : save the assignment made between the class and the
	 *                         teacher
	 * @param idStudent:       save the Student code
	 * @param fullNameStudent: save the Student full name
	 * @return
	 */
	public String fullClass(String selectClass, int idStudent, String fullNameStudent) {
		return (selectClass + " " + idStudent + " " + fullNameStudent + "\n");
	}

	/**
	 * method in which the user can assign a class by selecting a class and a
	 * professor
	 */
	public void selectedProfessor() {

		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------Clases registradas---------------------");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("\n");
		int aux = (listSubject.size());
		for (int i = 0; i < aux; i++) {
			System.out.println((i + 1) + " --- " + "Clase: " + listSubject.get(i).getNameSubject());
		}
		
//		int j=0;
//		for(Subject list:listSubject) {
//			System.out.println((j + 1) + " --- " + "Clase: " + Subject.listSubject.get(j).getNameSubject());
//			j++;
//		}
		
		System.out.println("\nIngrese el ID de la clase: ");
		int opcion = myInput.nextInt();
		opcion = opcion - 1;
		this.setNameSubject(listSubject.get(opcion).getNameSubject());

		System.out.println("-------------------------------------------------------");
		System.out.println("----------------Profesores registrados--------------------");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("\n");
		for (int i = 0; i < Professor.listProfessor.size(); i++) {
			System.out.println((i + 1) + " --- " + "Professor: " + Professor.listProfessor.get(i).getNameProfessor());
		}
		System.out.println("\nIngrese un número para asignar el profesor a la clase: ");
		int opcion2 = myInput.nextInt();
		opcion2 = opcion2 - 1;
		this.setAssignedProfessor(Professor.listProfessor.get(opcion2).getNameProfessor());

		listProfessorStudent.add(asignedProfessor(this.getNameSubject(), this.getAssignedProfessor()));
		System.out.println("Clase asignada exitosamente....");
		//listProfessorStudent
	}

	/**
	 * method that assigns a class associated with a teacher a student
	 */
	public void insertStudent() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("------------Lista de clases con profesor asociado----------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("\n");
		for (int i = 0; i < Subject.listProfessorStudent.size(); i++) {
			System.out.println((i + 1) + " --- " + "Clases: " + listProfessorStudent.get(i));
		}
		System.out.println("\nIngrese una opción:\n");
		int subjectOpt = myInput.nextInt();
		subjectOpt = subjectOpt - 1;
		this.setSelectClass(listProfessorStudent.get(subjectOpt).toString());

		System.out.println("\nIngrese el codigo de un estudiante:");
		int studentId = myInput.nextInt();
		int sizeList = Student.listStudent.size() - 1;
		while (sizeList >= 0) {
			if (Student.listStudent.get(sizeList).getIdStudent() == studentId) {
				listFullSubject.add(fullClass(this.getSelectClass(), Student.listStudent.get(sizeList).getIdStudent(),
						Student.listStudent.get(sizeList).getFullNameStudent()));
			}

			sizeList--;

		}
		System.out.println("Estudiante asociado exitosamente......");
		//System.out.println(listFullSubject);

	}

	/**
	 * method that returns the information of a class
	 */
	public void menuSubjectStudents() {

		System.out.println("Seleccione la clase:");
		subjectListInitial();
		System.out.println("\nIngrese una opción para ver la información de la clase: \n");
		int option = myInput.nextInt();
		myInput.nextLine();
		option = option - 1;
		int longListFullSubject = listFullSubject.size() - 1;
		if (longListFullSubject > -1  && option <= longListFullSubject) {

		this.subjectStudent = Subject.listSubject.get(option).getNameSubject();
			System.out.println("-------clase: " + subjectStudent + "\n");
			while (longListFullSubject >= 0) {
				if (listFullSubject.get(longListFullSubject).contains(subjectStudent)) {
					System.out.println(listFullSubject.get(longListFullSubject));
				}
				longListFullSubject--;
				if (longListFullSubject < -1)
					System.out.println("La clase seleccionada no tiene estudiantes asignados. \n"
							+ "Para realizar una asignación, seleccione (Opcion 8");
				}
		}else {
			
				System.out.println("El código de la clase que ingreso no esta asignado en el momento,"
						+ "\nintente de nuevo o asigne un estudiante a una clase en la (Opcion 8).");
				System.out.println("¿Desea intentar de nuevo?" + 
						"\n1----Si" +
						"\n2----No");
				System.out.println("Ingrese una opciòn:");
				int optionValue = myInput.nextInt();
				if(optionValue == 1) {
					menuSubjectStudents();
				}
				else {
					System.out.println("Regresando al menu principal....");
				}
			}	
	}

	/**
	 * method that returns the information about the student class
	 */
	public void searchStudent() {
		
		System.out.println("Estudiantes: \n");
		Student.studentListInitial();
		System.out.println("\nIngrese el código de un estudiante para visualizar las clases asignadas:\n");
		int option = myInput.nextInt();
		option = option - 1;

		int longListFullSubject = listFullSubject.size() - 1;
		if (longListFullSubject > -1  && option <= longListFullSubject) {
		classStudent = Student.listStudent.get(option).getIdStudent();
		System.out.println("Código del estudiante: " + classStudent + "\n");
		String code = Integer.toString(classStudent);
		while (longListFullSubject >= 0) {
			if (listFullSubject.get(longListFullSubject).contains(code)) {
				System.out.println(listFullSubject.get(longListFullSubject));
			}
			longListFullSubject--;
			if (longListFullSubject < -1)
				System.out.println("El estudiante seleccionado no tiene clases asignadas. \n"
						+ "Para realizar una asignación, seleccione (Opcion 8");
			}
	}else {
		
			System.out.println("El código del estudiante que ingreso no es válido o no tiene asignaciones en el momento,"
					+ "\nintente de nuevo o asigne un estudiante a una clase en la (Opcion 8).");
			System.out.println("¿Desea intentar de nuevo?" + 
					"\n1----Si" +
					"\n2----No");
			System.out.println("Ingrese una opciòn:");
			int optionValue = myInput.nextInt();
			if(optionValue == 1) {
				searchStudent();
			}
			else {
				System.out.println("Regresando al menu principal....");
			}
		}
		
	}

	/**
	 * list of class getters and setters
	 * 
	 * @return
	 */
	public int getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public String getAssignedProfessor() {
		return assignedProfessor;
	}

	public void setAssignedProfessor(String assignedProfessor) {
		this.assignedProfessor = assignedProfessor;
	}

	public String getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}

	public ArrayList<String> getListFullSubject() {
		return listFullSubject;
	}

	public void setListFullSubject(ArrayList<String> listFullSubject) {
		this.listFullSubject = listFullSubject;
	}

	public ArrayList<String> getListStudents() {
		return listStudents;
	}

	public void setListStudents(ArrayList<String> listStudents) {
		this.listStudents = listStudents;
	}

}
