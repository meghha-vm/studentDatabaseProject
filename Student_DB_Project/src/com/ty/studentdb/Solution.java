package com.ty.studentdb;

import java.util.Scanner;

import Exception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Student Database Management System");
		System.out.println("-----------------------------------------------------------");
		Scanner scanner=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		while(true) {
			System.out.println("1:Add student \n2:display student");
			System.out.println("3:Display all student \n4:Remove student");
			System.out.println("5:remove all student \n6:Update student");
			System.out.println("7:Count student \n8:Sort student");
			System.out.println("9:Get student with highest marks");
			System.out.println("10:Get student with lowest marks");
			System.out.println("11:Exit \n Enter choice");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateSudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getSudentWithHighestMark();
				break;
			case 10:
				sms.getSudentWithLowestMark();
				break;
			case 11:
				System.out.println("Thank You");
				System.exit(0);
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

}
