import utils.*;

/**
 * This is the class of teacher
 */
public class Teacher implements Sortable{

	/**
	 * There are the names of the class fields
	 */
	public enum Fields { FULL_NAME }

	/**
	 * Teacher's full name
	 */
	private String fullName;

	/**
	 * Teacher's constructor
	 * @param fullName Teacher's full name
	 */
	public Teacher(String fullName) { this.fullName = fullName; }

	/**
	 * Teacher's copy constructor
	 * @param teacher Teacher
	 */
	public Teacher(Teacher teacher) {this.fullName = teacher.fullName; }

	/**
	 * Get the full name of the teacher
	 * @return The full name of String type
	 */
	public String getFullName() { return fullName; }

	/**
	 * Compares two objects of Teacher class by their field name
	 * @param teacherA Teacher A
	 * @param teacherB Teacher B
	 * @param field The name of the field
	 * @return The value of Boolean type
	 */
	public boolean comparator(Teacher teacherA, Teacher teacherB, Teacher.Fields field) {
		return switch (field) {
			case FULL_NAME -> StringHandler.compareStrings(teacherA.getFullName(), teacherB.getFullName()) == 1;
		};
	}

	/**
	 * Edit the information about the teacher
	 */
	public void edit() {
		boolean choice;
		choice = Helper.askBoolean("Чи бажаєте змінити ПІБ викладача? [1 - Так, 0 - Ні]: ", Helper.DEFAULT_ERROR_MESSAGE, 1, 0);
		if (choice)
			this.fullName = Helper.askString("Введіть нове ПІБ викладача: ");
	}

	/**
	 * Compare the selected object of Teacher class with another object of Teacher class by the field name and the type of sorting
	 * @param object Another object, which is compared to selected object
	 * @param fieldName Field name of two objects, which is compared
	 * @param sortingType Type of sorting
	 * @return The value of Boolean type
	 */
	@Override
	public boolean compare(Object object, String fieldName, SortingType sortingType) {
		if (!(object instanceof Teacher teacher)) return false;
		return switch (sortingType) {
			case ASCENDING -> comparator(this, teacher, Teacher.Fields.valueOf(fieldName));
			case DESCENDING -> comparator(teacher, this, Teacher.Fields.valueOf(fieldName));
		};
	}

	/**
	 * Check if the selected object of Teacher class is equal to another object of Teacher class
	 * @param object Another object
	 * @return The value of Boolean type
	 */
	@Override
	public boolean equals(Object object) {

		if (object == this)
			return true;

		if (!(object instanceof Teacher teacher))
			return false;

		return this.fullName.equals(teacher.fullName);
	}

	/**
	 * Get the information about the teacher
	 * @return The value of String type
	 */
	@Override
	public String toString() { return "Викладач: " + fullName; }

	/**
	 * Create new object of Teacher class
	 * @return New object of Teacher class
	 */
	public static Teacher create() {
		String fullName = Helper.askString("Введіть ПІБ викладача: ");
		return new Teacher(fullName);
	}

	/**
	 * Cast object to Teacher class object
	 * @param object Object
	 * @return The object of Teacher class
	 */
	public static Teacher cast(Object object) {
		if (object instanceof Teacher)
			return (Teacher) object;
		return null;
	}

	/**
	 * Cast the array of objects to the array of objects of Teacher class
	 * @param objects The array of objects
	 * @return The array of objects of Teacher class
	 */
	public static Teacher[] cast(Object[] objects) {
		if (objects == null) return null;
		if (objects.length == 0) return new Teacher[0];
		Teacher[] teachers = new Teacher[objects.length];
		for (int i = 0; i < objects.length; i++) {
			teachers[i] = cast(objects[i]);
		}
		return teachers;
	}
}
