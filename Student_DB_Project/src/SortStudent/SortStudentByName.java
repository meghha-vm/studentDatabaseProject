package SortStudent;

import java.util.Comparator;

import com.ty.studentdb.Student;

public class SortStudentByName implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		
		return x.getName().compareTo(y.getName());
	}
	

}
