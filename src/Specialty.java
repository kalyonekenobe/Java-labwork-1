import utils.*;

/**
 * The class of the specialty
 */
public class Specialty {

	/**
	 * The name of the specialty
	 */
	private final String specialtyName;

	/**
	 * The dynamic array of students of the specialty
	 */
	private final DynamicArray students = new DynamicArray();
	/**
	 * The dynamic array of teachers of the specialty
	 */
	private final DynamicArray teachers = new DynamicArray();

	/**
	 * Constructor of the specialty
	 * @param specialtyName The name of the specialty
	 */
	public Specialty(String specialtyName) { this.specialtyName = specialtyName; }

	/**
	 * Add a student to the dynamic array of students of the specialty
	 * @param student Student
	 */
	public void addStudent(Student student) {
		if (student != null) {
			students.append(student);
			System.out.println("Студента успішно додано!");
		} else {
			System.out.println("Помилка додавання студента!");
		}
	}

	/**
	 * Add a teacher to the dynamic array of teachers of the specialty
	 * @param teacher Teacher
	 */
	public void addTeacher(Teacher teacher) {
		if (teacher != null) {
			teachers.append(teacher);
			System.out.println("Викладача успішно додано!");
		} else {
			System.out.println("Помилка додавання викладача!");
		}
	}

	/**
	 * Remove the student from the dynamic array of students of the specialty by the index of the student
	 * @param index The index of the student
	 */
	public void removeStudent(int index) {
		if (students.length() == 0) {
			System.out.println("Список студентів пустий.");
		} else {
			students.remove(index);
			System.out.println("Студента успішно видалено!");
		}
	}

	/**
	 * Remove the teacher from the dynamic array of teachers of the specialty by the index of the teacher
	 * @param index The index of the teacher
	 */
	public void removeTeacher(int index) {
		if (teachers.length() == 0) {
			System.out.println("Список викладачів пустий.");
		} else {
			teachers.remove(index);
			System.out.println("Викладача успішно видалено!");
		}
	}

	/**
	 * Count the number of students of the specialty
	 * @return The value of Integer type
	 */
	public int countStudents() { return students.length(); }

	/**
	 * Count the number of teachers of the specialty
	 * @return The value of Integer type
	 */
	public int countTeachers() { return teachers.length(); }

	/**
	 * Get the name of the specialty
	 * @return The value of String type
	 */
	public String getSpecialtyName() { return specialtyName; }

	/**
	 * Print the list of students of the specialty
	 * @return The value of String type
	 */
	public String printStudents() {
		String result = "Список студентів спеціальності " + specialtyName + ":\n";
		if (students.length() == 0) {
			result += "Студенти поки що відсутні...";
		} else {
			Student[] studentsList = Student.cast(students.getItems());
			int index = 1;
			for (Student student : studentsList) {
				result += (index++) + ". " + student + "\n";
			}
		}
		return result;
	}

	/**
	 * Print the list of teachers of the specialty
	 * @return The value of String type
	 */
	public String printTeachers() {
		String result = "Список викладачів спеціальності " + specialtyName + ":\n";
		if (teachers.length() == 0) {
			result += "Студенти поки що відсутні...";
		} else {
			Teacher[] studentsList = Teacher.cast(teachers.getItems());
			int index = 1;
			for (Teacher teacher : studentsList) {
				result += (index++) + ". " + teacher + "\n";
			}
		}
		return result;
	}

	/**
	 * Get the array of students
	 * @return The array of students
	 */
	public Student[] getStudents() { return Student.cast(students.getItems()); }

	/**
	 * Get the array of teachers
	 * @return The array of teachers
	 */
	public Teacher[] getTeachers() { return Teacher.cast(teachers.getItems()); }

	/**
	 * Get the dynamic array of students by their course
	 * @param course Course
	 * @return The dynamic array of objects of Student class
	 */
	public DynamicArray getStudentsByCourse(int course) {
		DynamicArray array = new DynamicArray();
		Student[] studentsList = Student.cast(students.getItems());
		if (students.length() > 0) {
			for (Student student : studentsList) {
				if (student.getCourse() == course)
					array.append(student);
			}
		}
		return array;
	}

	/**
	 * Get the specialty information
	 * @return The value of String type
	 */
	@Override 
	public String toString() { return printStudents() + printTeachers(); }

	/**
	 * Check if the selected object of Specialty class is equal to the another object of Specialty class
	 * @param object Object
	 * @return The value of Boolean type
	 */
	@Override
	public boolean equals(Object object) {

		if(this == object)
			return true;

		if (!(object instanceof Specialty specialty))
			return false;

		return this.specialtyName.equals(specialty.specialtyName);
	}

	/**
	 * Create a new specialty
	 * @return The object of Specialty class
	 */
	public static Specialty create() {
		String specialtyName = Helper.askString("Введіть назву спеціальності: ");
		return new Specialty(specialtyName);
	}

	/**
	 * Cast the object to the object of Specialty class
	 * @param object Object
	 * @return The object of Specialty class
	 */
	public static Specialty cast(Object object) {
		if (object instanceof Specialty)
			return (Specialty) object;
		return null;
	}

	/**
	 * Cast the array of objects to the array of objects of Specialty class
	 * @param objects The array of objects
	 * @return The array of objects of Specialty class
	 */
	public static Specialty[] cast(Object[] objects) {
		if (objects == null) return null;
		if (objects.length == 0) return new Specialty[0];
		Specialty[] specialties = new Specialty[objects.length];
		for (int i = 0; i < objects.length; i++) {
			specialties[i] = cast(objects[i]);
		}
		return specialties;
	}
}
