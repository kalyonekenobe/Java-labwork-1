import utils.DynamicArray;

/**
 * This is the class of the university
 */
public class University {

	/**
	 * The dynamic array of faculties
	 */
	private final DynamicArray faculties = new DynamicArray();

	/**
	 * Add a new faculty to the dynamic array of university faculties
	 * @param faculty Faculty
	 */
	public void addFaculty(Faculty faculty) {
		if (faculty == null) {
			System.out.println("Помилка додавання факультету!");
		} else {
			faculties.append(faculty);
			System.out.println("Факультет успішно доданий!");
		}
	}

	/**
	 * Remove the faculty from the dynamic array of university faculties by the index of the faculty
	 * @param index The index of the faculty
	 */
	public void removeFaculty(int index) {
		if (faculties.length() == 0) {
			System.out.println("Список факультетів пустий!");
		} else {
			faculties.remove(index);
			System.out.println("Факультет успішно видалено!");
		}
	}

	/**
	 * Count the number of university faculties
	 * @return The value of Integer type
	 */
	public int countFaculties() { return faculties.length(); }

	/**
	 * Get the array of faculties
	 * @return The array of faculties
	 */
	public Faculty[] getFaculties() { return Faculty.cast(faculties.getItems()); }

	/**
	 * Get all students of the current faculty
	 * @return The dynamic array of objects of Student class
	 */
	public DynamicArray getStudents() {
		DynamicArray students = new DynamicArray();
		Faculty[] facultiesList = Faculty.cast(faculties.getItems());
		if (faculties.length() > 0) {
			for (Faculty faculty : facultiesList) {
				Specialty[] specialtiesList = faculty.getSpecialties();
				if (specialtiesList != null) {
					for (Specialty specialty : specialtiesList) {
						Student[] studentsList = specialty.getStudents();
						students.append(studentsList);
					}
				}
			}
		}
		return students;
	}

	/**
	 * Print the list of university faculties
	 * @return The value of String type
	 */
	public String printFaculties() {
		String result = "Список факультетів університету:\n";
		if (faculties.length() == 0) {
			result += "Список порожній...";
		} else {
			int index = 1;
			Faculty[] facultiesList = Faculty.cast(faculties.getItems());
			for (Faculty faculty : facultiesList) {
				result += (index++) + ". " + faculty.getFacultyName() + "\n";
			}
		}
		return result;
	}

	/**
	 * Find all students of the current faculty by the search data and the name of Student class field
	 * @param searchData The search data
	 * @param field The name of field
	 * @return The value of String type
	 */
	public String findStudents(String searchData, Student.Fields field) {
		String fullName = "";
		int course = 0, group = 0;
		switch (field) {
			case FULL_NAME -> fullName = searchData;
			case COURSE -> course = Integer.parseInt(searchData);
			case GROUP -> group = Integer.parseInt(searchData);
		}
		String searchResult = "";
		Faculty[] facultiesList = getFaculties();
		if (facultiesList != null) {
			for (Faculty faculty : facultiesList) {
				Specialty[] specialtiesList = faculty.getSpecialties();
				String specialtyStringList = "";
				if (specialtiesList != null) {
					for (Specialty specialty : specialtiesList) {
						Student[] studentsList = specialty.getStudents();
						String studentsStringList = "";
						if (studentsList != null) {
							for (Student student : studentsList) {
								boolean matches = true;
								switch (field) {
									case FULL_NAME -> {
										if (fullName.length() <= student.getFullName().length()) {
											for (int i = 0; i < fullName.length(); i++) {
												if (fullName.charAt(i) != student.getFullName().charAt(i)) {
													matches = false;
													break;
												}
											}
										} else {
											matches = false;
										}
									}
									case COURSE -> matches = (student.getCourse() == course);
									case GROUP -> matches = (student.getGroup() == group);
								}
								if (matches) studentsStringList += "\t\t" + student + "\n";
							}
							if (studentsStringList.length() > 0)
								specialtyStringList += "\tСпеціальність '" + specialty.getSpecialtyName() + "':\n" + studentsStringList;
						}
					}
					if (specialtyStringList.length() > 0)
						searchResult += "Факультет '" + faculty.getFacultyName() + "':\n" + specialtyStringList;
				}
			}
		}
		if (searchResult.equals("")) searchResult = "Пошук не дав результатів";
		return searchResult;
	}

	/**
	 * Find all teachers of the current faculty by the search data and the name of Teacher class field
	 * @param searchData The search data
	 * @param field The name of field
	 * @return The value of String type
	 */
	public String findTeachers(String searchData, Teacher.Fields field) {
		String fullName = "";
		switch (field) {
			case FULL_NAME -> fullName = searchData;
		}
		String searchResult = "";
		Faculty[] facultiesList = getFaculties();
		if (facultiesList != null) {
			for (Faculty faculty : facultiesList) {
				Specialty[] specialtiesList = faculty.getSpecialties();
				String specialtyStringList = "";
				if (specialtiesList != null) {
					for (Specialty specialty : specialtiesList) {
						Teacher[] teachersList = specialty.getTeachers();
						String teachersStringList = "";
						if (teachersList != null) {
							for (Teacher teacher : teachersList) {
								boolean matches = true;
								switch (field) {
									case FULL_NAME -> {
										if (fullName.length() <= teacher.getFullName().length()) {
											for (int i = 0; i < fullName.length(); i++) {
												if (fullName.charAt(i) != teacher.getFullName().charAt(i)) {
													matches = false;
													break;
												}
											}
										} else {
											matches = false;
										}
									}
								}
								if (matches) teachersStringList += "\t\t" + teacher + "\n";
							}
						}
						if (teachersStringList.length() > 0)
							specialtyStringList += "\tСпеціальність '" + specialty.getSpecialtyName() + "':\n" + teachersStringList;
					}
				}
				if (specialtyStringList.length() > 0)
					searchResult += "Факультет '" + faculty.getFacultyName() + "':\n" + specialtyStringList;
			}
		}
		if (searchResult.equals("")) searchResult = "Пошук не дав результатів";
		return searchResult;
	}
}