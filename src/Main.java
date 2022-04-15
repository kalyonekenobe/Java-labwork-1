import utils.*;

/**
 * @author Oleksandr Igumnov
 * @author Kalynovskiy Mykyta
 * Labwork #1
 * Task: Simulate the work of the university
 * This is the Main class. There are general methods, which are responsible for interaction with the user through the console
 */
public class Main {

	/**
	 * The university we are working with
	 */
	private static final University university = new University();

	/**
	 * Method main
	 * @param args Input and output files
	 */
	public static void main(String[] args) {
		// Initialize our own alphabet. Redefine the order of characters in the alphabet to implement correct sorting
		Alphabet.initialize();
		universityManager();
	}

	/**
	 * University manager. Users can see available actions to do with the university
	 */
	private static void universityManager() {
		String message = "Меню університету:\n1. Вивести список факультетів\n2. Пошук студентів/викладачів\n3. Додати новий факультет\n4. Обрати факультет для виконання дій\n5. Вивести усіх студентів впорядкованих за курсами\nВаша відповідь: ";
		int choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 5);
		switch (choice) {
			case 1 -> System.out.print("\n" + university.printFaculties());
			case 2 -> {
				choice = Helper.askInteger("Оберіть кого бажаєте знайти:\n1. Студентів\n2. Викладачів\nВаша відповідь: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 2);
				String searchData = "";
				switch (choice) {
					case 1 -> {
						choice = Helper.askInteger("Оберіть за чим бажаєте знайти студентів:\n1. ПІБ\n2. Курс\n3. Група\nВаша відповідь: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 3);
						Student.Fields field = Student.Fields.AGE;
						int course, group;
						switch (choice) {
							case 1 -> {
								field = Student.Fields.FULL_NAME;
								searchData = Helper.askString("Введіть ПІБ студента (можна частково): ");
							}
							case 2 -> {
								field = Student.Fields.COURSE;
								course = Helper.askInteger("Введіть номер курсу (від 1 до 6): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
								searchData = Integer.toString(course);
							}
							case 3 -> {
								field = Student.Fields.GROUP;
								group = Helper.askInteger("Введіть номер групи, за якою бажаєте шукати студентів (від 1 до 5): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 5);
								searchData = Integer.toString(group);
							}
						}
						System.out.println(university.findStudents(searchData, field));
					}
					case 2 -> {
						Teacher.Fields field = Teacher.Fields.FULL_NAME;
						searchData = Helper.askString("Введіть ПІБ викладача (можна частково): ");
						System.out.println(university.findTeachers(searchData, field));
					}
				}
			}
			case 3 -> university.addFaculty(Faculty.create());
			case 4 -> {
				System.out.print("\n" + university.printFaculties());
				if (university.countFaculties() > 0) {
					int facultyId = Helper.askInteger("Оберіть порядковий номер факультету, з яким бажаєте працювати: ", Helper.DEFAULT_ERROR_MESSAGE, 1, university.countFaculties());
					facultyManager(facultyId - 1);
				}
			}
			case 5 -> {
				DynamicArray students = university.getStudents();
				students.sort(Student.Fields.COURSE.name());
				System.out.println(students.printItems());
			}
		}
		universityManager();
	}

	/**
	 * Faculty manager. Users can see available actions to do with selected faculty
	 * @param facultyId Ordinal number of selected faculty in faculties list
	 */
	private static void facultyManager(int facultyId) {
		Faculty faculty = university.getFaculties()[facultyId];
		String message = "Меню факультету " + faculty.getFacultyName() + ":\n1. Видалити факультет\n2. Додати нову спеціальність\n3. Вивести список спеціальностей\n4. Обрати спеціальність для виконання дій\n5. Вивести список студентів/викладачів факультету\n6. Повернутися назад\nВаша відповідь: ";
		int choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
		switch (choice) {
			case 1 -> {
				university.removeFaculty(facultyId);
				universityManager();
			}
			case 2 -> faculty.addSpecialty(Specialty.create());
			case 3 -> System.out.print("\n" + faculty.printSpecialities());
			case 4 -> {
				System.out.print("\n" + faculty.printSpecialities());
				if (faculty.countSpecialities() > 0) {
					int specialtyId = Helper.askInteger("Оберіть порядковий номер спеціальності, з якою бажаєте працювати: ", Helper.DEFAULT_ERROR_MESSAGE, 1, faculty.countSpecialities());
					specialtyManager(facultyId, specialtyId - 1);
				}
			}
			case 5 -> {
				choice = Helper.askInteger("Оберіть над ким хочете виконувати дії:\n1. Студенти\n2. Викладачі\nВаша відповідь: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 2);
				message = "Оберіть формат виводу списку:\n1. Не сортувати\n2. Сортувати за ПІБ (в алфавітному порядку)\n3. Сортувати за ПІБ (в оберненому алфавітному порядку)\nВаша відповідь: ";
				int sortingTypeChoice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 3);
				Sortable.SortingType sortingType = null;
				switch (sortingTypeChoice) {
					case 1 -> {}
					case 2 -> sortingType = Sortable.SortingType.ASCENDING;
					case 3 -> sortingType = Sortable.SortingType.DESCENDING;
				}
				DynamicArray array;
				switch (choice) {
					case 1 -> {
						array = faculty.getStudents();
						if (sortingType != null)
							array.sort(Student.Fields.FULL_NAME.name(), sortingType);
						System.out.println(array.printItems());
					}
					case 2 -> {
						array = faculty.getTeachers();
						if (sortingType != null)
							array.sort(Teacher.Fields.FULL_NAME.name(), sortingType);
						System.out.println(array.printItems());
					}
				}
			}
			case 6 -> universityManager();
		}
		facultyManager(facultyId);
	}

	/**
	 * Specialty manager. Users can see available actions to do with selected specialty
	 * @param facultyId Ordinal number of the faculty in faculties list, where the selected specialty is located
	 * @param specialtyId Ordinal number of selected specialty in specialties list
	 */
	private static void specialtyManager(int facultyId, int specialtyId) {
		Faculty faculty = university.getFaculties()[facultyId];
		Specialty specialty = faculty.getSpecialties()[specialtyId];
		String message = "Меню спеціальності " + specialty.getSpecialtyName() + ", факультету " + faculty.getFacultyName() + ":\n1. Видалити спеціальність\n2. Додати нового студента/викладача\n3. Вивести список студентів/викладачів\n4. Обрати студента/викладача для виконання дій\n5. Повернутися назад\nВаша відповідь: ";
		int choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 5);
		switch (choice) {
			case 1 -> {
				faculty.removeSpecialty(specialtyId);
				facultyManager(facultyId);
			}
			case 2 -> {
				choice = Helper.askInteger("Кого бажаєте додати?\n1. Студент\n2. Викладач\nВаша відповідь: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 2);
				switch (choice) {
					case 1 -> specialty.addStudent(Student.create());
					case 2 -> specialty.addTeacher(Teacher.create());
				}
			}
			case 3 -> {
				choice = Helper.askInteger("Який список бажаєте вивести?\n1. Студентів\n2. Викладачів\nВаша відповідь: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 2);
				DynamicArray array;
				switch (choice) {
					case 1 -> {
						message = "Оберіть формат виводу списку студентів:\n1. Не сортувати\n2. Сортувати за номером курсу (по зростанню)\n3. Сортувати за номером курсу (по спаданню)\n4. Сортувати за ПІБ (в алфавітному порядку)\n5. Сортувати за ПІБ (в оберненому алфавітному порядку)\n6. Вивести список студентів, які належать певному курсу (не сортувати)\n7. Вивести список студентів, які належать певному курсу (сортувати за ПІБ в алфавітному порядку)\n8. Вивести список студентів, які належать певному курсу (сортувати за ПІБ в оберненому алфавітному порядку)\n9. Повернутися назад\nВаша відповідь: ";
						choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 9);
						array = new DynamicArray(specialty.getStudents());
						int courseId;
						switch (choice) {
							case 1 -> System.out.println(array.printItems());
							case 2 -> {
								array.sort(Student.Fields.COURSE.name());
								System.out.println(array.printItems());
							}
							case 3 -> {
								array.sort(Student.Fields.COURSE.name(), Sortable.SortingType.DESCENDING);
								System.out.println(array.printItems());
							}
							case 4 -> {
								array.sort(Student.Fields.FULL_NAME.name());
								System.out.println(array.printItems());
							}
							case 5 -> {
								array.sort(Student.Fields.FULL_NAME.name(), Sortable.SortingType.DESCENDING);
								System.out.println(array.printItems());
							}
							case 6 -> {
								courseId = Helper.askInteger("Введіть номер курсу (від 1 до 6): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
								array = specialty.getStudentsByCourse(courseId);
								System.out.println(array.printItems());
							}
							case 7 -> {
								courseId = Helper.askInteger("Введіть номер курсу (від 1 до 6): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
								array = specialty.getStudentsByCourse(courseId);
								array.sort(Student.Fields.FULL_NAME.name());
								System.out.println(array.printItems());
							}
							case 8 -> {
								courseId = Helper.askInteger("Введіть номер курсу (від 1 до 6): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
								array = specialty.getStudentsByCourse(courseId);
								array.sort(Student.Fields.FULL_NAME.name(), Sortable.SortingType.DESCENDING);
								System.out.println(array.printItems());
							}
							case 9 -> specialtyManager(facultyId, specialtyId);
						}
					}
					case 2 -> {
						message = "Оберіть формат виводу списку студентів:\n1. Не сортувати\n2. Сортувати за ПІБ (в алфавітному порядку)\n3. Сортувати за ПІБ (в оберненому алфавітному порядку)\n4. Повернутися назад\nВаша відповідь: ";
						choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 4);
						array = new DynamicArray(specialty.getTeachers());
						switch (choice) {
							case 1 -> System.out.println(array.printItems());
							case 2 -> {
								array.sort(Teacher.Fields.FULL_NAME.name());
								System.out.println(array.printItems());
							}
							case 3 -> {
								array.sort(Teacher.Fields.FULL_NAME.name(), Sortable.SortingType.DESCENDING);
								System.out.println(array.printItems());
							}
							case 4 -> specialtyManager(facultyId, specialtyId);
						}
					}
				}
			}
			case 4 -> {
				choice = Helper.askInteger("Оберіть над ким хочете виконувати дії:\n1. Студенти\n2. Викладачі\nВаша відповідь: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 2);
				switch (choice) {
					case 1 -> {
						System.out.print("\n" + specialty.printStudents());
						if (specialty.countStudents() > 0) {
							choice = Helper.askInteger("Оберіть порядковий номер студента, над яким плануєте робити подальші дії: ", Helper.DEFAULT_ERROR_MESSAGE, 1,  specialty.countStudents());
							studentManager(facultyId, specialtyId, choice - 1);
						}
					}
					case 2 -> {
						System.out.print("\n" + specialty.printTeachers());
						if (specialty.countTeachers() > 0) {
							choice = Helper.askInteger("Оберіть порядковий номер викладача, над яким плануєте робити подальші дії: ", Helper.DEFAULT_ERROR_MESSAGE, 1, specialty.countTeachers());
							teacherManager(facultyId, specialtyId, choice - 1);
						}
					}
				}
			}
			case 5 -> facultyManager(facultyId);
		}
		specialtyManager(facultyId, specialtyId);
	}

	/**
	 * Student manager. Users can see available actions to do with the selected student
	 * @param facultyId Ordinal number of faculty in faculties list, where the selected specialty is located
	 * @param specialtyId Ordinal number of specialty in specialties list, where the selected student is located
	 * @param studentId Ordinal number of student in students list
	 */
	private static void studentManager(int facultyId, int specialtyId, int studentId) {
		Faculty faculty = university.getFaculties()[facultyId];
		Specialty specialty = faculty.getSpecialties()[specialtyId];
		Student student = specialty.getStudents()[studentId];
		String message = "Меню студента факультету " + faculty.getFacultyName() + ", спеціальності " + specialty.getSpecialtyName() + ":\n1. Видалити студента\n2. Редагувати інформацію\n3. Вивести інформацію про студента\n4. Повернутися назад\nВаша відповідь: ";
		int choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 4);
		switch (choice) {
			case 1 -> {
				specialty.removeStudent(studentId);
				specialtyManager(facultyId, specialtyId);
			}
			case 2 -> student.edit();
			case 3 -> System.out.println(student);
			case 4 -> specialtyManager(facultyId, specialtyId);
		}
		studentManager(facultyId, specialtyId, studentId);
	}

	/**
	 * Teacher manager. Users can see available actions to do with the selected teacher
	 * @param facultyId Ordinal number of faculty in faculties list, where the selected specialty is located
	 * @param specialtyId Ordinal number of specialty in specialties list, where the selected teacher is located
	 * @param teacherId Ordinal number of teacher in teachers list
	 */
	private static void teacherManager(int facultyId, int specialtyId, int teacherId) {
		Faculty faculty = university.getFaculties()[facultyId];
		Specialty specialty = faculty.getSpecialties()[specialtyId];
		Teacher teacher = specialty.getTeachers()[teacherId];
		String message = "Меню викладача факультету " + faculty.getFacultyName() + ", спеціальності " + specialty.getSpecialtyName() + ":\n1. Видалити викладача\n2. Редагувати інформацію\n3. Вивести інформацію про викладача\n4. Повернутися назад\nВаша відповідь: ";
		int choice = Helper.askInteger(message, Helper.DEFAULT_ERROR_MESSAGE, 1, 4);
		switch (choice) {
			case 1 -> {
				specialty.removeTeacher(teacherId);
				specialtyManager(facultyId, specialtyId);
			}
			case 2 -> teacher.edit();
			case 3 -> System.out.println(teacher);
			case 4 -> specialtyManager(facultyId, specialtyId);
		}
		teacherManager(facultyId, specialtyId, teacherId);
	}
}

 