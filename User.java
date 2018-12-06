package assignment5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**it has the methods to perform various tasks displayed in the menu
 * @author Shashi Kumar Kadari Mallikarjuna
 * @version Assignment 5
 * @since Due: 10/24/2018
 */
public class User {
	Scanner sc=new Scanner(System.in);
	private Map<Integer, Student> student;
	private Map<Student,String> grade;
	/**constructor which initializes the maps*/
	public User() {
		student=new HashMap<Integer, Student>();
		grade=new HashMap<Student,String>();
	}
	/**overloaded constructor
	 * @param s1 student map which has Integer type key and Student type values
	 * @param g1 grade map which has Student type keys and String type values
	 */
	public User(Map<Integer, Student> s1,Map<Student,String>g1) {
		student =s1;
		grade=g1;
	}
	/**method used to get the student map
	 * @return student map 
	 */
	public Map<Integer, Student> getStudentmap(){
		return student;
	}
	/**method used to get the grade map
	 * @return grade map
	 */
	public Map<Student,String> getGrademap(){
		return grade;
	}
	/**method that adds a new student
	 * @param student student map
	 * @param grade grade map
	 */
	public void add(Map<Integer, Student> student,Map<Student,String> grade) {
		System.out.println("Adding a student!");
		System.out.print("Enter the first name:  ");
		String fn=sc.next();
		System.out.print("Enter the last name:  ");
		String ln=sc.next();
		System.out.print("Enter the Student ID:  ");
		int id=sc.nextInt();
		System.out.print("Enter the grade recieved by the Student:  ");
		String Grade=sc.next();
		while(student.containsKey(id)) {
			System.out.println("Invalid!! The Student ID number already exists. Try Again:\nEnter the Student ID number");
			id=sc.nextInt();
		}
		Student stu=new Student(fn,ln,id);
		student.put(stu.getID(), stu);
		grade.put(stu, Grade);
	}
	/**method that removes a student
	 * @param student student map
	 * @param grade grade map
	 */
	public void remove(Map<Integer, Student> student,Map<Student,String> grade) {
		System.out.println("Removing a student! ");
		System.out.print("Enter the ID number of the student whom you want to remove:  ");
		int id=sc.nextInt();
		if(!student.containsKey(id)) {
			System.out.print("The ID number doesn't exist.  ");
		}
		else {
		grade.remove(student.get(id));
		student.remove(id);
		}
	}
	/**method that modifies the grade of a student
	 * @param student student map
	 * @param grade grade map
	 */
	public void modify(Map<Integer, Student> student,Map<Student,String> grade) {
		System.out.println("Modifying a Student's grade! ");
		System.out.print("Enter the ID number of the student whose grade must be modified:  ");
		int id=sc.nextInt();
		if(!student.containsKey(id)) {
			System.out.print("The ID number doesn't exist ");
		}
		else {
		System.out.print("Enter the new grade:  ");
		String Grade=sc.next();
		grade.put(student.get(id), Grade);
		}
	}
	/**method to print the grades of all the students
	 * @param grade grade map
	 */
	public void print(Map <Student,String> grade) {
		if(grade.isEmpty()) {
			System.out.println("There is no student records!");
		}
		List<Student> student=new ArrayList<Student>(grade.keySet());
		Collections.sort(student);
		System.out.printf("\n%-7s%-15s%-15s%-10s","ID","Last Name","First Name","Grade");
		System.out.println("\n------------------------------------------------");
		Iterator<Student> itr=student.iterator();
		while(itr.hasNext()) {
			Student st=(Student)itr.next();
			System.out.println(st.toString()+" "+grade.get(st));
		}
	}
}
