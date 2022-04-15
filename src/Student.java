import utils.*;

/**
 * The class of the student
 */
public class Student implements Sortable{

	/**
	 * The names of fields of the Student class
	 */
	enum Fields { FULL_NAME, AGE, COURSE, GROUP, AVERAGE_GRADE }

	/**
	 * The full name of the student
	 */
	private String fullName;
	/**
	 * The age of the student
	 */
	private int age;
	/**
	 * The course of the student
	 */
	private int course;
	/**
	 * The group of the student
	 */
	private int group;
	/**
	 * The average grade of the student
	 */
	private float averageGrade;

	/**
	 * Constructor of the student
	 * @param fullName The full name of the student
	 * @param age The age of the student
	 * @param course The course of the student
	 * @param group The group of the student
	 * @param averageGrade The average grade of the student
	 */
	public Student(String fullName, int age, int course, int group, float averageGrade) {
		this.fullName = fullName;
		this.age = age;
		this.course = course;
		this.group = group;
		this.averageGrade = averageGrade;
	}

	/**
	 * Constructor copy of the student
	 * @param student Student
	 */
	public Student(Student student) {
		this.fullName = student.fullName;
		this.age = student.age;
		this.course = student.course;
		this.group = student.group;
		this.averageGrade = student.averageGrade;
	}

	/**
	 * Get the full name of the student
	 * @return The full name of String type
	 */
	public String getFullName() { return fullName; }

	/**
	 * Get the age of the student
	 * @return The value of Integer type
	 */
	public int getAge() { return age; }

	/**
	 * Get the course of the student
	 * @return The value of Integer type
	 */
	public int getCourse() { return course; }

	/**
	 * Get the group of the student
	 * @return The value of Integer type
	 */
	public int getGroup() { return group; }

	/**
	 * Get the average grade of the student
	 * @return The value of Float type
	 */
	public float getAverageGrade() { return averageGrade; }

	/**
	 * Compare two students by the name of their field
	 * @param studentA Student A
	 * @param studentB Student B
	 * @param field The name of the field
	 * @return The value of Boolean type
	 */
	private static boolean comparator(Student studentA, Student studentB, Fields field){
		int comparisonResult;
		switch(field){
			case FULL_NAME:
				comparisonResult = StringHandler.compareStrings(studentA.getFullName(), studentB.getFullName());
				if(comparisonResult != -1)
					return comparisonResult == 1;
				if(studentA.getCourse() != studentB.getCourse())
					return studentA.getCourse() < studentB.getCourse();
				if(studentA.getAverageGrade() != studentB.getAverageGrade())
					return studentA.getAverageGrade() != studentB.getAverageGrade();
				if(studentA.getGroup() != studentB.getGroup())
					return studentA.getGroup() < studentB.getGroup();
				if(studentA.getAge() != studentB.getAge())
					return studentA.getAge() < studentB.getAge();
				break;
			case AGE:
				if(studentA.getAge() != studentB.getAge())
					return studentA.getAge() < studentB.getAge();
				comparisonResult = StringHandler.compareStrings(studentA.getFullName(), studentB.getFullName());
				if(comparisonResult != -1)
					return comparisonResult == 1;
				if(studentA.getCourse() != studentB.getCourse())
					return studentA.getCourse() < studentB.getCourse();
				if(studentA.getAverageGrade() != studentB.getAverageGrade())
					return studentA.getAverageGrade() != studentB.getAverageGrade();
				if(studentA.getGroup() != studentB.getGroup())
					return studentA.getGroup() < studentB.getGroup();
				break;
			case COURSE:
				if(studentA.getCourse() != studentB.getCourse())
					return studentA.getCourse() < studentB.getCourse();
				comparisonResult = StringHandler.compareStrings(studentA.getFullName(), studentB.getFullName());
				if(comparisonResult != -1)
					return comparisonResult == 1;
				if(studentA.getAverageGrade() != studentB.getAverageGrade())
					return studentA.getAverageGrade() != studentB.getAverageGrade();
				if(studentA.getGroup() != studentB.getGroup())
					return studentA.getGroup() < studentB.getGroup();
				if(studentA.getAge() != studentB.getAge())
					return studentA.getAge() < studentB.getAge();
				break;
			case GROUP:
				if(studentA.getGroup() != studentB.getGroup())
					return studentA.getGroup() < studentB.getGroup();
				comparisonResult = StringHandler.compareStrings(studentA.getFullName(), studentB.getFullName());
				if(comparisonResult != -1)
					return comparisonResult == 1;
				if(studentA.getCourse() != studentB.getCourse())
					return studentA.getCourse() < studentB.getCourse();
				if(studentA.getAverageGrade() != studentB.getAverageGrade())
					return studentA.getAverageGrade() != studentB.getAverageGrade();
				if(studentA.getAge() != studentB.getAge())
					return studentA.getAge() < studentB.getAge();
				break;
			case AVERAGE_GRADE:
				if(studentA.getAverageGrade() != studentB.getAverageGrade())
					return studentA.getAverageGrade() != studentB.getAverageGrade();
				comparisonResult = StringHandler.compareStrings(studentA.getFullName(), studentB.getFullName());
				if(comparisonResult != -1)
					return comparisonResult == 1;
				if(studentA.getCourse() != studentB.getCourse())
					return studentA.getCourse() < studentB.getCourse();
				if(studentA.getGroup() != studentB.getGroup())
					return studentA.getGroup() < studentB.getGroup();
				if(studentA.getAge() != studentB.getAge())
					return studentA.getAge() < studentB.getAge();
				break;
		}
		return StringHandler.compareStrings(studentA.getFullName(), studentB.getFullName()) == 1;
	}

	/**
	 * Compare the selected object of Student class to another object of Student class
	 * @param object Another object, which is compared to selected object
	 * @param fieldName Field name of two objects, which is compared
	 * @param sortingType Type of sorting
	 * @return The value of Boolean type
	 */
	@Override
	public boolean compare(Object object, String fieldName, SortingType sortingType) {
		if (!(object instanceof Student student)) return false;
		return switch (sortingType) {
			case ASCENDING -> comparator(this, student, Fields.valueOf(fieldName));
			case DESCENDING -> comparator(student, this, Fields.valueOf(fieldName));
		};
	}

	/**
	 * Check if the selected object of Student class is equal to another object of Student class
	 * @param object Another object
	 * @return The value of Boolean type
	 */
	@Override
	public boolean equals(Object object) {

		if (object == this)
			return true;

		if (!(object instanceof Student student))
			return false;

		return this.fullName.equals(student.fullName) && this.age == student.age && this.course == student.course &&
			   this.group == student.group && (Math.abs(this.averageGrade - student.averageGrade) < 0.000000001f);
	}

	/**
	 * Get the information about the student
	 * @return The value of String type
	 */
	@Override
	public String toString() {
		return "Студент: " + fullName + ", Вік: " + age + ", Курс: " + course + ", Група: " + group + ", Середній бал: " + averageGrade;
	}

	/**
	 * Edit the information about the student
	 */
	public void edit() {
		boolean choice;
		choice = Helper.askBoolean("Чи бажаєте змінити ПІБ студента? [1 - Так, 0 - Ні]: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 0);
		if (choice)
			this.fullName = Helper.askString("Введіть нове ПІБ студента: ");
		choice = Helper.askBoolean("Чи бажаєте змінити вік студента? [1 - Так, 0 - Ні]: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 0);
		if (choice)
			this.age = Helper.askInteger("Введіть новий вік студента: ", Helper.DEFAULT_ERROR_MESSAGE, 15, 30);
		choice = Helper.askBoolean("Чи бажаєте змінити номер курсу студента? [1 - Так, 0 - Ні]: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 0);
		if (choice)
			this.course = Helper.askInteger("Введіть новий номер крусу студента: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
		choice = Helper.askBoolean("Чи бажаєте змінити номер групи студента? [1 - Так, 0 - Ні]: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 0);
		if (choice)
			this.group = Helper.askInteger("Введіть новий номер групи студента: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 5);
		choice = Helper.askBoolean("Чи бажаєте змінити середній бал студента? [1 - Так, 0 - Ні]: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 0);
		if (choice)
			this.averageGrade = Helper.askFloat("Введіть новий середній бал студента: ", Helper.DEFAULT_ERROR_MESSAGE, 0, 100);
	}

	/**
	 * Crate a new student
	 * @return The object of Student class
	 */
	public static Student create() {
		String fullName = Helper.askString("Введіть ПІБ студента: ");
		int age = Helper.askInteger("Введіть вік студента (від 15 до 30): ", Helper.DEFAULT_ERROR_MESSAGE, 15, 30);
		int course = Helper.askInteger("Введіть номер курсу (від 1 до 6): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 6);
		int group = Helper.askInteger("Введіть номер групи, за якою бажаєте шукати студентів (від 1 до 5): ", Helper.DEFAULT_ERROR_MESSAGE, 1, 5);
		float averageGrade = Helper.askFloat("Введіть середній бал (від 0 до 100): ", Helper.DEFAULT_ERROR_MESSAGE, 0, 100);
		return new Student(fullName, age, course, group, averageGrade);
	}

	/**
	 * Cast the object to the object of Student class
	 * @param object Object
	 * @return The object of Student class
	 */
	public static Student cast(Object object) {
		if (object instanceof Student)
			return (Student) object;
		return null;
	}

	/**
	 * Cast the array of objects to the array of objects of Student class
	 * @param objects The array of objects
	 * @return The array of objects of Student class
	 */
	public static Student[] cast(Object[] objects) {
		if (objects == null) return null;
		if (objects.length == 0) return new Student[0];
		Student[] students = new Student[objects.length];
		for (int i = 0; i < objects.length; i++) {
			students[i] = cast(objects[i]);
		}
		return students;
	}
}
