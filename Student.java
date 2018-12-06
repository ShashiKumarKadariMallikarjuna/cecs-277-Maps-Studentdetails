package assignment5;
import java.util.HashMap;
import java.util.Map;
/**it contains the student details
 * @author Shashi Kumar Kadari Mallikarjuna
 * @version Assignment 5
 * @since Due: 10/24/2018
 */
public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private int ID;
	/**constructor that initializes the values */
	public Student(){
		ID=0;
		lastName=" ";
		firstName=" ";
	}
	/**overloaded constructor
	 * @param ln last name
	 * @param fn first name
	 * @param ID Student ID
	 */
	public Student(String fn,String ln,int ID) {
		this.ID=ID;
		lastName=ln;
		firstName=fn;
	}
	/**replaces the first name with a new value
	 * @param fn first name
	 */
	public void setfn(String fn) {
		firstName=fn;
	}
	/**replaces the last name with a new value
	 * @param ln last name
	 */
	public void setln(String ln) {
		lastName=ln;
	}
	/**replaces the ID with a new value
	 * @param ID Student ID
	 */
	public void setID(int ID) {
		this.ID=ID;
	}
	/**method to get the first name
	 * @return first name
	 */
	public String getfn() {
		return firstName;
	}
	/**method to get the last name
	 * @return last name
	 */
	public String getln() {
		return lastName;
	}
	/**method to get the student ID
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	/**method to convert the values to string */
	public String toString() {
		return String.format("\n%-7s%-15s%-15s", Integer.toString(ID),firstName,lastName);
	}
	/**Overridden compareTo method*/
	public int compareTo(Student obj) {
		if(lastName.compareTo(obj.lastName)==0) {
			if(firstName.compareTo(obj.lastName)==0) {
				return ID-obj.ID;
			}
			return firstName.compareTo(obj.firstName);
		}
		return lastName.compareTo(obj.lastName);
	}
	/**Overridden equals method*/
	public boolean equals(Student obj) {
		if(lastName.equals(obj.lastName) && firstName.equals(obj.lastName) && ID==obj.ID) {
			return true;
		}
		return false;
	}
	/**calculates a hash code by combining the hash codes of the instance variables
	 * @return a hash code dependent on the instance variables
	 */
	public int hashCode() {
		final int HASH_MULTIPLIER=29;
		int h=HASH_MULTIPLIER *firstName.hashCode()+lastName.hashCode();
		h=HASH_MULTIPLIER*h+((Integer)ID).hashCode();
		return h;
	}
}
