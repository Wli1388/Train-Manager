/**
 * 
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 *
 *         This class defines TrainCarNode with a next TrainCarNode, previous
 *         TrainCarNode, and TrainCar data
 * 
 */
public class TrainCarNode {
	private TrainCarNode next;
	private TrainCarNode prev;
	private TrainCar data;

	/**
	 * This is a constructor that creates a new TrainCarNode object
	 * 
	 * @param data
	 *        The TrainCar data for the node
	 */
	public TrainCarNode(TrainCar data) {
		next = null;
		prev = null;
		this.data = data;
	}

	/**
	 * @return The next link of the TrainCarNode
	 */
	public TrainCarNode getNext() {
		return next;
	}

	/**
	 * @param next
	 *        Changes the next link
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}

	/**
	 * @return The previous link of the TrainCarNode
	 */
	public TrainCarNode getPrev() {
		return prev;
	}

	/**
	 * @param prev
	 *        Changes the previous link
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}

	/**
	 * @return The data of the node
	 */
	public TrainCar getData() {
		return data;
	}

	/**
	 * @param data
	 *        Changes the data of the node
	 */
	public void setData(TrainCar data) {
		this.data = data;
	}
}
