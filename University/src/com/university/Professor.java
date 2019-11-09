package com.university;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Professor class that inherits the attributes of the university class
 * @author gloria.rodriguez
 *
 */
public class Professor extends University {

	/**
	 * declaration of class attributes
	 */
	private int idProfessor;
	private int baseSalary;
	private float yearsExperience;
	private float activeHours;
	private double finalSalary;
	private String nameProfessor;
	private String professorType;
	private Scanner myInput;
	protected static ArrayList<Professor> listProfessor;

	/**
	 * Professor class builder
	 */
	public Professor() {
		this.myInput = new Scanner(System.in);
		this.baseSalary = 600000;
		listProfessor = new ArrayList<>();
	}
	
	/**
	 * Professor class builder with parameters
	 * @param idProfessor: save the student code information 
	 * @param nameProfessor: save the student full name
	 * @param professorType: save the professor type (full-time or part-time)
	 * @param finalSalary: saves the result of the salary calculation and assigns it as the final salary to the professor
	 */
	public Professor(int idProfessor, String nameProfessor, String professorType, double finalSalary) {
		this.setIdProfessor(idProfessor);
		this.setNameProfessor(nameProfessor);
		this.setProfessorType(professorType);
		this.setFinalSalary(finalSalary);
	}
	
	/**
	 *method that initializes the list of professors if it is empty or has only one record and according to the condition it performs console printing
	 * @return
	 */
	public static ArrayList<Professor> professorListInitial() {
		if (listProfessor.size() <= 1) {
			initialProfessor();
			printProfessorList(listProfessor);
		}
		else {
			printProfessorList(listProfessor);
		}
		return listProfessor;
	}
	
	/**
	 * method that initializes the list of professors
	 * @return
	 */
	public static ArrayList<Professor> initialProfessor() {
		listProfessor.add(new Professor(1234567890, "Gloria Rodriguez", "Tiempo completo", 4800000));
		listProfessor.add(new Professor(1098234576, "Wilmer Poveda", "Tiempo completo", 3800000));
		listProfessor.add(new Professor(1230495867, "Carlos Martinez", "Tiempo completo", 2800000));
		listProfessor.add(new Professor(1002338373, "Maria Ruiz", "Tiempo completo", 2300000));
		return listProfessor;
	}
	
	/**
	 * method that implements the method of the parent class (university) to return the data that should be printed on the console each time this method is used.
	 */
	@Override
	public String returnToStringList() {
		return ("NOMBRE DEL PROFESOR: " + this.getNameProfessor() + "\n |Número de identificación|: "
				+ this.getIdProfessor() + " |Tipo de Contrato|: " + this.getProfessorType() + "\n |Salario|: "
				+ this.getFinalSalary());
	}

	/**
	 * method that returns the code of the student and his name from the list of professors.
	 * @return
	 */
	public String returnListPro() {
		return ("Id del professor: " + this.getIdProfessor() + "Nombre del maestro" + getNameProfessor());
	}
	
	/**
	 * method that requests the information to add a new professor to the list of professors.
	 */
	public void requestTeacher() {
		System.out.print("Ingrese número de identificación (CC#): ");
		this.idProfessor = myInput.nextInt();
		myInput.nextLine();
		this.setIdProfessor(this.idProfessor);
		
		System.out.print("Ingrese el nombre completo del profesor: ");
		this.nameProfessor = myInput.nextLine();
		this.setNameProfessor(this.nameProfessor);

		System.out.println("Ingrese una opción de contrato:");
		System.out.println("1- Tiempo Completo.");
		System.out.println("2- Tiempo Parcial");
		System.out.print("Opcion: ");
		this.professorType = myInput.nextLine();
		this.setProfessorType(this.professorType);
		if (this.professorType.equals("1") || this.professorType.equals("2")) {
			calculateSalary(this.professorType);
//			System.out.print("Ingrese número de identificación (CC#): ");
//			this.idProfessor = myInput.nextInt();
//			myInput.nextLine();
//			this.setIdProfessor(this.idProfessor);

			listProfessor.add(new Professor(this.idProfessor, this.nameProfessor, this.professorType, this.finalSalary));
			
		}
		else {
			System.out.println("Por favor ingrese una opción válida, 1 o 2.");
			requestTeacher();
		}
	}

	/**
	 * method that returns the calculation of the teacher's salary whether it is full-time or part-time
	 * @param salary
	 */
	public void calculateSalary(String salary) {
		if (salary.equalsIgnoreCase("1")) {
			System.out.print("Ingrese sus años de experiencia laboral: ");
			this.professorType = "Tiempo Completo";
			this.yearsExperience = myInput.nextFloat();
			this.finalSalary = this.baseSalary * (this.yearsExperience * 1.1);
		} else if (salary.equalsIgnoreCase("2")) {
			System.out.print("Ingrese la cantidad de horas activas en la semana: ");
			this.professorType = "Tiempo Parcial";
			this.activeHours = myInput.nextFloat();
			this.finalSalary = this.baseSalary + (this.baseSalary * (this.activeHours));
		}
	}
	
	
	/**
	 * list of class getters and setters
	 * @return
	 */
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getNameProfessor() {
		return nameProfessor;
	}
	public void setNameProfessor(String nameProfessor) {
		this.nameProfessor = nameProfessor;
	}
	public String getProfessorType() {
		return professorType;
	}
	public void setProfessorType(String professorType) {
		this.professorType = professorType;
	}
	public double getFinalSalary() {
		return finalSalary;
	}
	public void setFinalSalary(double finalSalary) {
		this.finalSalary = finalSalary;
	}

}
