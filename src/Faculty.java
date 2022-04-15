import utils.*;

/**
 * The class of the faculty
 */
public class Faculty {

	/**
	 * The name of the faculty
	 */
	private final String facultyName;
	/**
	 * The dynamic array of specialities
	 */
	private final DynamicArray specialties = new DynamicArray();

	/**
	 * Constructor of the faculty
	 * @param facultyName The name of the faculty
	 */
	public Faculty(String facultyName) { this.facultyName = facultyName; }

	/**
	 * Add a specialty to the dynamic array of specialities
	 * @param specialty Specialty
	 */
	public void addSpecialty(Specialty specialty) {
		if (specialty == null) {
			System.out.println("Помилка додавання спеціальності!");
		} else {
			specialties.append(specialty);
			System.out.println("Спеціальність успішно додана!");
		}
	}

	/**
	 * Remove the specialty from the dynamic array of specialities by the index of the specialty
	 * @param index The index of the specialities
	 */
	public void removeSpecialty(int index) {
		if (specialties.length() == 0) {
			System.out.println("Список спеціальностей пустий!");
		} else {
			specialties.remove(index);
			System.out.println("Спеціальність успішно видалена!");
		}
	}

	/**
	 * Count the number of the specialities
	 * @return The value of Integer type
	 */
	public int countSpecialities() { return specialties.length(); }

	/**
	 * Get the name of the faculty
	 * @return The value of String type
	 */
	public String getFacultyName() { return facultyName; }

	/**
	 * Get the array of specialities
	 * @return The array of objects of Speciality class
	 */
	public Specialty[] getSpecialties() { return Specialty.cast(specialties.getItems()); }

	/**
	 * Get all students of the faculty
	 * @return The dynamic array of objects of Student class
	 */
	public DynamicArray getStudents() {
		DynamicArray students = new DynamicArray();
		Specialty[] specialtiesList = getSpecialties();
		if (specialtiesList != null) {
			for (Specialty specialty : specialtiesList) {
				Student[] studentsList = specialty.getStudents();
				students.append(studentsList);
			}
		}
		return students;
	}

	/**
	 * Get all teachers of the faculty
	 * @return The dynamic array of objects of Teacher class
	 */
	public DynamicArray getTeachers() {
		DynamicArray teachers = new DynamicArray();
		Specialty[] specialtiesList = getSpecialties();
		if (specialtiesList != null) {
			for (Specialty specialty : specialtiesList) {
				Teacher[] teachersList = specialty.getTeachers();
				teachers.append(teachersList);
			}
		}
		return teachers;
	}

	/**
	 * Print the list of specialities
	 * @return The value of String type
	 */
	public String printSpecialities() {
		String result = "Список спеціальностей факультету " + facultyName + ":\n";
		if (specialties.length() == 0) {
			result += "Список порожній...";
		} else {
			int index = 1;
			Specialty[] specialtiesList = Specialty.cast(specialties.getItems());
			for (Specialty specialty : specialtiesList) {
				result += (index++) + ". " + specialty.getSpecialtyName() + "\n";
			}
		}
		return result;
	}

	/**
	 * Check if the selected object of Faculty class is equal to another object of Faculty class
	 * @param object Object
	 * @return The value of Boolean type
	 */
	@Override
	public boolean equals(Object object) {

		if(this == object)
			return true;

		if (!(object instanceof Faculty faculty))
			return false;

		return this.facultyName.equals(faculty.facultyName);
	}

	/**
	 * Create a new faculty
	 * @return The object of Faculty class
	 */
	public static Faculty create() {
		String facultyName = Helper.askString("Введіть назву факультету: ");
		return new Faculty(facultyName);
	}

	/**
	 * Cast the object to the object of Faculty class
	 * @param object Object
	 * @return The object of Faculty class
	 */
	public static Faculty cast(Object object) {
		if (object instanceof Faculty)
			return (Faculty) object;
		return null;
	}

	/**
	 * Cast the array of objects to the array of objects of Faculty class
	 * @param objects The array of objects
	 * @return The array of objects of Faculty class
	 */
	public static Faculty[] cast(Object[] objects) {
		if (objects == null) return null;
		if (objects.length == 0) return new Faculty[0];
		Faculty[] faculties = new Faculty[objects.length];
		for (int i = 0; i < objects.length; i++) {
			faculties[i] = cast(objects[i]);
		}
		return faculties;
	}
}
