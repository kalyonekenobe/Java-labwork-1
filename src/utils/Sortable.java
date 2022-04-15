package utils;

/**
 * This is the interface, which is intended for providing additional methods for different objects, that are supposed to be sortable
 */
public interface Sortable {

    /**
     * The type of sorting.
     */
    enum SortingType { ASCENDING, DESCENDING }

    /**
     * Compares the object to another object, using one of their field name and the type of sorting
     * @param object Another object, which is compared to selected object
     * @param fieldName Field name of two objects, which is compared
     * @param sortingType Type of sorting
     * @return The value of Boolean type
     */
    boolean compare(Object object, String fieldName, SortingType sortingType);

    /**
     * Checks if selected object is equal to another object
     * @param object Another object
     * @return The value of Boolean type
     */
    boolean equals(Object object);
}
