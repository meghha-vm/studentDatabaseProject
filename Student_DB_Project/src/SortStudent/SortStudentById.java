package SortStudent;

import java.util.Comparator;

import com.ty.studentdb.Student;

public class SortStudentById implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getId().compareTo(y.getId());
	}

}
