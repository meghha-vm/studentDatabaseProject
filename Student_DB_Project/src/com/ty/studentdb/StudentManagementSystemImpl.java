package com.ty.studentdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Exception.InvalidChoiceException;
import Exception.StudentNotFoundException;
import SortStudent.SortStudentByAge;
import SortStudent.SortStudentById;
import SortStudent.SortStudentByMarks;
import SortStudent.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem{
	Scanner sc=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent() {
		System.out.println("Enter the name :");
		String name=sc.next();
	    System.out.println("enter your age :");
		int age=sc.nextInt();
		System.out.println("enter the students marks : ");
		int marks = sc.nextInt();
		Student student = new Student( name, age,marks);
		db.put(student.getId(), student);
		System.out.println("Student record inserted succesfully");
		System.out.println("Student Id is"+student.getId());
	}
	
	@Override
	public void displayStudent() {
		System.out.println("enter the student Id ");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student student=db.get(id);
			System.out.println("Id: "+student.getId());
			System.out.println("Name: "+student.getName());
			System.out.println("Age: "+student.getAge());
			System.out.println("Marks: "+student.getMarks());
		}
	
		else {
			try {
				String message = "Student with the id" +id+"is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudent() {
		if(db.size() !=0) {
			System.out.println("Student details are follows");
			System.out.println("--------------------------------------------");
			Set<String> keys =db.keySet();
			for(String std:keys) {
				Student student=db.get(std);
				System.out.println(student);
			}
		}
		else {
			String message="Student DataBase is empty: Nothing to Display";
			try {
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	@Override
	public void removeStudent() {
		System.out.println("Enter id of student :");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student record avilable");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("student record deleted");
		}
		else {
			try {
			    String message="Student with the id"+id+"is not found";
			    throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
			
		
		
	}
	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student details are follows");
			db.clear();
			System.out.println("All student record deleted successfully");
			System.out.println("student records avilable"+db.size());
		}
		else {
			String message="Student DataBase is empty: Nothing to Display";
			try {
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		}
		
	}
	@Override
	public void updateSudent() {
		System.out.println("Enter id of student :");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Age\n2: Update Name\n3:UpdateMarks");
			System.out.println("Enter your Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter age");
				int age=sc.nextInt();
				std.setAge(age);
				break;
			case 2:
				System.out.println("Enter name ");
				String name=sc.next();
				std.setName(name);
				break;
			case 3:
				System.out.println("Enter marks");
				int marks=sc.nextInt();
				std.setMarks(marks);
				break;
			default:
				String message ="Invalid choice,kindly enter valid choice";
				try {
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			
			
		}
		
		
	}
	@Override
	public void countStudent() {
		System.out.println("No:of Student record"+db.size());
		
		
	}
	@Override
	public void sortStudent() {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
			
		}
		System.out.println("1: Sort by id\n2:Sort by age");
		System.out.println("3:sort by name \n4:sort by Marks");
		System.out.println("Enter Choice");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:Collections.sort(list,new SortStudentById());
			display(list);
			break;
		case 2:Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		case 3:Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 4:Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;
		default:
			String message ="Invalid choice,kindly enter valid choice";
			try {
				throw new InvalidChoiceException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void display(List<Student> list) {
		for(Student student: list) {
			System.out.println(student);
		}
	}
	
	
	@Override
	public void getSudentWithHighestMark() {
		Set<String> keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
			
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
	}
	@Override
	public void getSudentWithLowestMark() {
		
		Set<String> keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
			
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
	}
	

	
}



	