/**
 * 
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 *
 *         This class defines TrainLinkedList with a head, tail, cursor, size,
 *         length, value, weight, and whether it holds dangerous cars
 * 
 */
public class TrainLinkedList {
	private TrainCarNode head;
	private TrainCarNode tail;
	private TrainCarNode cursor;
	private int size;
	private double length;
	private double value;
	private double weight;
	private boolean isDangerous;

	/**
	 * This constructs an instance of the TrainLinkedList with no TrainCar
	 * objects in it
	 * 
	 * @custom.Postconditions: This TrainLinkedList has been initialized to an
	 *                         empty linked list. Head, tail, and cursor are
	 *                         all set to null
	 */
	public TrainLinkedList() {
		head = null;
		tail = null;
		cursor = null;
	}

	/**
	 * Returns a reference to the TrainCar at the node currently referenced by
	 * the data
	 * 
	 * @custom.Preconditions: The list is not empty
	 * @return The reference to the TrainCar at the node currently reference by
	 *         the cursor
	 */
	public TrainCar getCursorData() {
		return cursor.getData();
	}

	/**
	 * Places car in the node currently referenced by the cursor.
	 * 
	 * @param car
	 *        The TrainCar that the cursor's data is being set to
	 * @custom.Preconditions: The list is not empty
	 * @custom.Postconditions: The cursor node now contains a reference to car
	 *                         as its data
	 */
	public void setCursorData(TrainCar car) {
		cursor.setData(car);
	}

	/**
	 * Moves the cursor to point at the next TrainCarNode
	 * 
	 * @custom.Preconditions: The list is not empty and the cursor does not
	 *                        currently reference the tail of the list
	 * @custom.Postconditions: The cursor has been advanced to the next
	 *                         TrainCarNode, or has remained at the tail of the
	 *                         list
	 * @throws NullPointerException
	 *         Throws when list is empty or cursor == tail
	 * 
	 */
	public void cursorForward() throws NullPointerException {
		if (cursor == null || cursor == tail)
			throw new NullPointerException();
		cursor = cursor.getNext();
	}

	/**
	 * Moves the cursor to point at the previous TrainCarNode
	 * 
	 * @custom.Preconditions: The list is not empty and the cursor does not
	 *                        currently reference the head of the list
	 * @custom.Postconditions: The cursor has been moved back to the previous
	 *                         TrainCarNode, or has remained at the head of the
	 *                         list
	 * @throws NullPointerException
	 *         Throws when list is empty or cursor == head
	 */
	public void cursorBackward() {
		if (cursor == null || cursor == head)
			throw new NullPointerException();
		cursor = cursor.getPrev();
	}

	/**
	 * Inserts a car into the train after the cursor position
	 * 
	 * @param newCar
	 *        the new TrainCar to be inserted into the train
	 * @custom.Preconditions: This TrainCar object has been instantiated
	 * @custom.Postconditions: The new TrainCar has been inserted into the
	 *                         train after the position of the cursor. All
	 *                         TrainCar objects previously on the train are
	 *                         still on the train, and their order has been
	 *                         preserved. The cursor now points to the inserted
	 *                         car.
	 * @throws IllegalArgumentException
	 *         Throws when newCar is null
	 */
	public void insertAfterCursor(TrainCar newCar)
			throws IllegalArgumentException {
		if (newCar == null)
			throw new IllegalArgumentException();
		TrainCarNode newNode = new TrainCarNode(newCar);
		if (cursor == null) { // When the list is empty
			head = newNode;
			tail = newNode;
			cursor = newNode;
		} else {
			newNode.setNext(cursor.getNext());
			newNode.setPrev(cursor);
			if (cursor.getNext() != null) // When there is TrainCars after
											// cursor
				cursor.getNext().setPrev(newNode);
			else
				tail = newNode;
			cursor.setNext(newNode);
			cursor = newNode;
		}
		size++;
		length += cursor.getData().getMeters();
		weight += cursor.getData().getTons();
	}

	public void setProductLoad(ProductLoad product) {
		cursor.getData().setProductLoad(product);
		value += cursor.getData().getProductLoad().getDollars();
		weight += cursor.getData().getProductLoad().getTons();
		if (cursor.getData().getProductLoad().isDangerous())
			isDangerous = true;
	}

	/**
	 * Removes the TrainCarNode referenced by the cursor
	 * 
	 * @custom.Preconditions: The cursor is not null
	 * @custom.Postconditions: The TrainCarNode referenced by the cursor has
	 *                         been removed from the train. The cursor now
	 *                         references the next node, or the previous node
	 *                         if no next node exists.
	 * @return The TrainCar contained within the node
	 * @throws NullPointerException
	 *         Throws when cursor is null
	 */
	public TrainCar removeCursor() throws NullPointerException {
		if (cursor == null) {
			throw new NullPointerException();
		}
		TrainCar trainCar = cursor.getData();
		size--;
		length -= trainCar.getMeters();
		weight -= trainCar.getTons();
		if (cursor.getData().getProductLoad() != null) {
			value -= trainCar.getProductLoad().getDollars();
			weight -= trainCar.getProductLoad().getTons();
		}

		if (cursor != head && cursor != tail) {
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
			if (cursor.getNext() == null)
				tail = cursor;
		} else if (cursor == head && cursor != tail) { // If the cursor is the
														// head, then simply
														// set cursor to the
														// next one
			cursor = cursor.getNext();
			cursor.setPrev(null);
			head = cursor;
			if (cursor.getNext() == null)
				tail = cursor;
		} else if (cursor != head && cursor == tail) {
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			tail = cursor;
			if (cursor.getPrev() == null)
				head = cursor;
		} else {// When cursor is both head and tail
			cursor = null;
			head = null;
			tail = null;
		}
		TrainCarNode newCursor = head;
		isDangerous = false;
		// Goes through list to make sure if any traincar holds dangerous loads
		while (newCursor != null) {
			if (newCursor.getData().getProductLoad() != null)
				if (newCursor.getData().getProductLoad().isDangerous()) {
					isDangerous = true;
					break;
				}
			newCursor = newCursor.getNext();
		}
		return trainCar;
	}

	/**
	 * Determines the number of TrainCar objects currently on the train
	 * 
	 * @return The number of TrainCar objects on this train
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the total length of the train in meters.
	 * 
	 * @return The sum of the lengths of each TrainCar in the train.
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Returns the total value of product carried by the train.
	 * 
	 * @return The sum of the values of each TrainCar in the train.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Returns the total weight in tons of the train.
	 * 
	 * @return The sum of the weight of each TrainCar plus the sum of the
	 *         ProductLoad carried by that car.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Whether or not there is a dangerous product on one of the TrainCar
	 * objects on the train.
	 * 
	 * @return Returns true if the train contains at least one TrainCar
	 *         carrying a dangerous ProductLoad, false otherwise
	 */
	public boolean isDangerous() {
		return isDangerous;
	}

	/**
	 * Searches the list for all ProductLoad objects with the indicated name
	 * and sums together their weight and value (Also keeps track of whether
	 * the product is dangerous or not), then prints a single ProductLoad
	 * record to the console.
	 * 
	 * @param name
	 *        the name of the ProductLoad to find on the train
	 */
	public void findProduct(String name) {
		double weight = 0;
		double value = 0;
		String isDangerous = "NO";
		int cars = 0;
		TrainCarNode newCursor = head;
		while (newCursor != null) {
			if (newCursor.getData().getProductLoad() != null && newCursor
					.getData().getProductLoad().getName().equals(name)) {
				cars++;
				weight += newCursor.getData().getProductLoad().getTons();
				value += newCursor.getData().getProductLoad().getDollars();
				if (newCursor.getData().getProductLoad().isDangerous())
					isDangerous = "YES";
			}
			newCursor = newCursor.getNext();
		}
		if (cars == 0)
			System.out.println("No record of " + name + " on board train.");
		else {
			System.out.println(
					"The following products were found on " + cars + " cars:");
			loadHeader();
			System.out.println();
			System.out.println(
					"================================================");
			System.out.printf("%7s%13.1f%12.2f%15s", name, weight, value,
					isDangerous);
		}
	}

	/**
	 * This shows the heading labels of a car data
	 */
	public void carHeader() {
		System.out.printf("%-5s%-7s%-12s%-14s", "", "Num", "Length(m)",
				"Weight(t)");
	}

	/**
	 * This shows the heading labels of a product load data
	 */
	public void loadHeader() {
		System.out.printf("%-12s%-12s%-14s%-12s", "Name", "Weight(t)",
				"Value($)", "Dangerous");
	}

	/**
	 * Prints a neatly formatted table of the car number, car length, car
	 * weight, load name, load weight, load value, and load dangerousness for
	 * all of the car on the train.
	 */
	public void printManifest() {
		System.out.printf("%-3s%-34s%-5s%n", "", "CAR:", "LOAD:");
		carHeader();
		System.out.printf("%-5s", "|");
		loadHeader();
		System.out.println();
		System.out.println(
				"======================================+==============="
						+ "=====================================");
		TrainCarNode newCursor = head;
		int num = 1;
		while (newCursor != null) {
			String arrow = "";
			if (newCursor == cursor)
				arrow = "->";
			System.out.printf("%-5s%-7d%-12s%-14s", arrow, num,
					newCursor.getData().getMeters(),
					newCursor.getData().getTons());
			System.out.printf("%-5s", "|");
			if (newCursor.getData().getProductLoad() != null) {
				String dangerous = "NO";
				if (newCursor.getData().getProductLoad().isDangerous())
					dangerous = "YES";
				System.out.printf("%-12s%-12s%-14s%9s%n",
						newCursor.getData().getProductLoad().getName(),
						newCursor.getData().getProductLoad().getTons(),
						newCursor.getData().getProductLoad().getDollars(),
						dangerous);
			} else
				System.out.printf("%-12s%-12s%-14s%9s%n", "Empty", 0, 0, "NO");
			num++;
			newCursor = newCursor.getNext();
		}
	}

	/**
	 * Prints out the load name, load value, load weight, and load
	 * dangerousness for a car
	 * 
	 * @param car
	 *        The train car that will be printed out
	 */
	public void printCar(TrainCar car) {
		this.loadHeader();
		System.out.println();
		System.out.println("================================================");
		if (car.getProductLoad() != null)
			System.out.printf("%-12s%-12s%-14s%9s%n",
					car.getProductLoad().getName(),
					car.getProductLoad().getTons(),
					car.getProductLoad().getDollars(),
					car.getProductLoad().isDangerous());
		else
			System.out.printf("%-12s%-12s%-14s%9s%n", "Empty", 0, 0, "NO");

	}

	/**
	 * Removes all dangerous cars from the train, maintaining the order of the
	 * cars in the train.
	 * 
	 * @custom.Postconditions All dangerous cars have been removed from this
	 *                        train. The order of all non-dangerous cars must
	 *                        be maintained upon the completion of this method.
	 * 
	 */
	public void removeDangerousCars() {
		cursor = head;
		while (cursor != null) {
			if (cursor.getData().getProductLoad() != null
					&& cursor.getData().getProductLoad().isDangerous()) {
				removeCursor();
			}
			cursor = cursor.getNext();
		}
		cursor = head;
	}

	/**
	 * Returns a neatly formatted String representation of the train.
	 * 
	 * @return A neatly formatted string containing information about the
	 *         train, including it's size (number of cars), length in meters,
	 *         weight in tons, value in dollars, and whether it is dangerous or
	 *         not.
	 */
	public String toString() {
		String representation = "Train: " + this.size() + " cars, "
				+ this.getLength() + " meters, " + this.getWeight()
				+ " tons, $" + this.getValue() + ",";
		if (this.isDangerous())
			representation += " is dangerous";
		else
			representation += " not dangerous";
		return representation;
	}

	public void showCursors() {
		for (int i = 0; i < size; i++) {
			TrainCarNode newCursor = head;
			System.out.println(newCursor);
			newCursor = newCursor.getNext();
		}
	}
}
