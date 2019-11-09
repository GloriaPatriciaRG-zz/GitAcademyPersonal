package com.university;
//
//import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	/**
	 * @author gloria.rodriguez
	 */
	
	/**
	 * declaration of class attributes
	 */
	private int opcion;
	private boolean salir = false;
	private Scanner lecturaOpcion = new Scanner(System.in);
	
	/**
	 * declaration of class objects
	 */
	protected Professor pro = new Professor();
	protected Subject sub =  new Subject();
	protected Student stu = new Student();
	
	/**
	 * start of the application menu
	 */
	public void menuUniversity() {
		
		while (!salir) {
			/**
			 * application menu
			 */
	    	System.out.println("------------------------------------GLOBANT / UNIVERSITY------------------------------\n");
	        System.out.println("1. Agregar un nuevo Profesor");
	        System.out.println("2. Lista de profesores");
	        System.out.println("3. Agregar una nueva Clase");
	        System.out.println("4. Lista de clases");
	        System.out.println("5. Asignación de Clases");
	        System.out.println("6. Agregar un nuevo Estudiante");
	        System.out.println("7. Lista de estudiantes");
	        System.out.println("8. Asignación de Estudiantes a una Clase");
	        System.out.println("9. Información de Clases");
	        System.out.println("10. Búsqueda de Estudiante");
	        System.out.println("11. Salir");
	        System.out.println("--------------------------------------------------------------------------------------\n");

	        try {

	        	/**
	        	 * execution of the option that the user enters
	        	 */
	            System.out.println("\nDigite una opcion:");
	            opcion = lecturaOpcion.nextInt();

	            switch (opcion) {
	                case 1:
	                	System.out.println("\n-----------------------AGREGAR PROFESORES------------------------------\n");
	                	pro.requestTeacher();
	                	System.out.println("\n");
	                    break;
	                case 2:
	                    System.out.println("\n-----------------------LISTA DE PROFESORES------------------------------\n");
	                    Professor.professorListInitial();
	                    //pro.returnToStringList();
	                    System.out.println("\n");
	                    break;
	                case 3:
	                	System.out.println("\n-------------------------AGREGAR CLASES---------------------------------\n");	
	                	sub.requestSubject();
	                    System.out.println("\n");
	                    break;
	                case 4:
	                	System.out.println("\n-------------------------LISTA DE CLASES--------------------------------\n");
	                	Subject.subjectListInitial();
	                	System.out.println("\n");
	                    break;
	                case 5:
	                	System.out.println("\n-----------------------ASIGNACIÓN DE CLASES--------------------------------\n");
	                	sub.validateListAssignedProfessor();
	                	System.out.println("\n");
	                    break;
	                case 6:
	                	System.out.println("\n------------------------AGREGAR ESTUDIANTES-----------------------------\n");	
	                	stu.requestStudent();
	                    System.out.println("\n");
	                    break;
	                case 7:
	                	System.out.println("\n------------------------LISTA DE ESTUDIANTE-----------------------------\n");
	                	Student.studentListInitial();
	                	System.out.println("\n");
	                    break;
	                case 8:
	                	System.out.println("\n-------------------ASIGNACIÓN DE ESTUDIANTES A LA CLASE-------------------\n");
	                	sub.validateListFullSubject();
	                	System.out.println("\n");
	                    break;
	                case 9:
	                	System.out.println("\n-------------------INFORMACIÓN DE LAS CLASES-------------------\n");
	                	sub.validateStudentClass();
	                	System.out.println("\n");
	                    break;
	                case 10:
	                	System.out.println("\n-------------------BUSQUEDA DE ESTUDIANTES-------------------\n");
	                	sub.validateSearchStudent();
	                	System.out.println("\n");
	                    break;
	                case 11:
	                	salir = true;
	                	System.out.println("\n--------GRACIAS POR PREFERIRNOS, VUELVA PRONTO.-------GPRG-------\n");
	                    break;
	                default:
	                    System.out.println("Solo números entre 1 al 11");
	            }
	          /**
	           * exception when the user enters an option not allowed  
	           */
	        } catch (InputMismatchException e) {
	            System.out.println("Ingrese una opción válida por favor." );
	            lecturaOpcion.next();
	        }
	}
		
	}
}
