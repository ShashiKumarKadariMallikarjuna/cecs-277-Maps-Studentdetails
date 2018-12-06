package assignment5;

import java.util.Scanner;

/**displays the options that user can use and calls the methods accordingly
 * @author Shashi Kumar Kadari Mallikarjuna
 * @version Assignment 5
 * @since Due: 10/24/2018
 */
public class Usermenu {
	Scanner sc=new Scanner(System.in);
	User s=new User();
	/**it performs different tasks based on user input */
	public void menu() {
		int option=option();
		while(option!=5) {
			if(option==1) {
				s.add(s.getStudentmap(),s.getGrademap());
			}
			else if(option==2) {
				s.remove(s.getStudentmap(),s.getGrademap());
			}
			else if(option==3) {
				s.modify(s.getStudentmap(),s.getGrademap());
			}
			else if(option==4) {
				s.print(s.getGrademap());
			}
			option=option();
		}
	}
	/**method that displays the options and gets the valid input from the user
	 * @return option
	 */
	public int option() {
		System.out.println("Menu");
		System.out.println("1. Add a student");
		System.out.println("2. Remove a student");
		System.out.println("3. Modify a student's grade");
		System.out.println("4. Print the grades of all students");
		System.out.println("5. Exit");
		System.out.print("Enter your option:  ");
		int option=sc.nextInt();
		while(option<1 || option>5) {
			System.out.print("Invalid option! Enter your option again: ");
			option=sc.nextInt();
		}
		return option;
	}
}
