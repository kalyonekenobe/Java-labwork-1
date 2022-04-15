package utils;

/**
 * This class is intended to make the work with arrays easier
 * Allows creating dynamic arrays, which contain objects of different types
 */
public class DynamicArray{

    /**
     * The items of the dynamic array
     */
    private Object[] items;

    /**
     * Empty constructor
     */
    public DynamicArray() { }

    /**
     * Constructor with the predetermined size of the dynamic array
     * @param size Items number
     */
    public DynamicArray(int size) { items = new Object[size]; }

    /**
     * Constructor with the array of objects, are supposed to be in the dynamic array, when it is initialized
     * @param objects The array of objects
     */
    public DynamicArray(Object[] objects) { items = objects; }

    /**
     * Constructor with the dynamic array items, are supposed to be in the new dynamic array, when it is initialized
     * @param dynamicArray The object of DynamicArray class (Dynamic array)
     */
    public DynamicArray(DynamicArray dynamicArray) { items = dynamicArray.getItems(); }

    /**
     * Append a single object to the dynamic array
     * @param object Item
     */
    public void append(Object object) {
        Object[] temporaryList = new Object[(items == null) ? 1 : items.length + 1];
        for (int i = 0; i < temporaryList.length - 1; i++)
            temporaryList[i] = items[i];
        temporaryList[temporaryList.length - 1] = object;
        items = temporaryList;
    }

    /**
     * Append the array of objects to the dynamic array
     * @param objects The array of objects
     */
    public void append(Object[] objects) {
        if (objects == null) return;
        Object[] temporaryList = new Object[(items == null) ? objects.length : items.length + objects.length];
        for (int i = 0; i < temporaryList.length - objects.length; i++)
            temporaryList[i] = items[i];
        for (int i = 0; i < objects.length; i++)
            temporaryList[temporaryList.length - objects.length + i] = objects[i];
        items = temporaryList;
    }

    /**
     * Remove the item of dynamic array by its index
     * @param index The index of item in dynamic array
     */
    public void remove(int index) {
        if (items == null) return;
        if (index < 0 || index > items.length - 1) return;
        int counter = 0;
        Object[] temporaryList = new Object[items.length];
        for (int i = 0; i < items.length; i++) {
            if (i != index) temporaryList[counter++] = items[i];
        }
        if (counter != items.length) {
            items = new Object[counter];
            for (int i = 0; i < counter; i++) {
                items[i] = temporaryList[i];
            }
        }
    }

    /**
     * Remove the item from dynamic array by its prototype
     * @param object Item prototype
     */
    public void remove(Object object) {
        int position = this.find(object);
        while (position != -1) {
            this.remove(position);
            position = this.find(object);
        }
    }

    /**
     * Set the item in the cell with selected index
     * @param index Index of cell
     * @param object Item
     */
    public void set(int index, Object object) {
        if (items == null) return;
        if (index > -1 && index < items.length) {
            items[index] = object;
        }
    }

    /**
     * Swap the items in the dynamic array by their indexes
     * @param indexA The index of the item A
     * @param indexB The index of the item B
     */
    public void swap(int indexA, int indexB) {
        if (indexA < 0 || indexA > length() - 1 || indexB < 0 || indexB > length() - 1 || indexA == indexB) return;
        Object temp = items[indexA];
        items[indexA] = items[indexB];
        items[indexB] = temp;
    }

    /**
     * Remove the first item from the dynamic array
     */
    public void removeFirst() { remove(0); }

    /**
     * Remove the last item from the dynamic array
     */
    public void removeLast() { remove(length() - 1); }

    /**
     * Delete all items from the dynamic array. Make it empty
     */
    public void clear() { items = new Object[0]; }

    /**
     * Sort the dynamic array by the name of field
     * @param fieldName The name of field
     */
    public void sort(String fieldName) { sort(fieldName, Sortable.SortingType.ASCENDING); }

    /**
     * Sort the dynamic array by the name of field and the type of sorting
     * @param fieldName The name of field
     * @param sortingType The type of sorting
     */
    public void sort(String fieldName, Sortable.SortingType sortingType) { sort(0, length() - 1, fieldName, sortingType); }

    /**
     * Sort the dynamic array in the certain range by the field name and the type of sorting
     * @param l Left array border
     * @param r Right array border
     * @param fieldName The name of field
     * @param sortingType The type of sorting
     */
    public void sort(int l, int r, String fieldName, Sortable.SortingType sortingType) {
        if (l > r) return;
        int leftIndex = l, rightIndex = r;
        boolean reverse = false;
        while (leftIndex < rightIndex) {
            if ((items[leftIndex] instanceof Sortable) && (items[rightIndex] instanceof Sortable)) {
                if (!((Sortable) items[leftIndex]).compare(items[rightIndex], fieldName, sortingType)) {
                    swap(leftIndex, rightIndex);
                    reverse = !reverse;
                }
            }
            if (reverse) leftIndex++;
            else rightIndex--;
        }
        sort(l, leftIndex - 1, fieldName, sortingType);
        sort(leftIndex + 1, r, fieldName, sortingType);
    }

    /**
     * Get the item in the cell with selected index
     * @param index The index of cell, from which we are getting item
     * @return Item of Object class
     */
    public Object get(int index) {
        if (items == null) return null;
        if (index < 0 || index > items.length - 1) return null;
        return items[index];
    }

    /**
     * Find the index of item in the dynamic array
     * @param object Item prototype
     * @return The index of item of Integer type
     */
    public int find(Object object) {
        if (items == null) return -1;
        if (items.length == 0) return -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                if (object == null) return i;
            } else if (items[i].equals(object))
                return i;
        }
        return -1;
    }

    /**
     * Get the number of items of the dynamic array
     * @return The number of items of Integer type
     */
    public int length() { return items == null ? 0 : items.length; }

    /**
     * Check if the dynamic array is empty
     * @return The value of Boolean type
     */
    public boolean empty() { return length() == 0; }

    /**
     * Get all items from the dynamic array as an array of items of Object class
     * @return The array of items of Object class
     */
    public Object[] getItems() { return items; }

    /**
     * Print in the console the list of items
     * @return The value of String type
     */
    public String printItems() {
        String result = "";
        if (items != null) {
            for (Object item : items) {
                result += item.toString() + "\n";
            }
        }
        if (result.equals("")) result = "Список порожній...\n";
        return result;
    }

    /**
     * Print the dynamic array information
     * @return The value of String type
     */
    @Override
    public String toString() {
        if (items == null) return "Список порожній";
        if (items.length == 0) return "Список порожній";
        String result = "<DynamicArray>["+ items.length +"] = {\n";
        for (Object item : items) {
            result += item + "\n";
        }
        return result + "}";
    }
}
