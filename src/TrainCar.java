/**
 * 
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 *
 *         This class defines TrainCar with a length in meters, weight in tons,
 *         and the productLoad it holds
 */
public class TrainCar {
	private double meters;
	private double tons;
	private ProductLoad productLoad;

	/**
	 * This is a Constructor that creates a new TrainCar object
	 * 
	 * @param meters
	 *        The length in meters of the TrainCar
	 * @param tons
	 *        The weight in tons of the TrainCar
	 * @param productLoad
	 *        The productLoad that the TrainCar holds
	 */
	public TrainCar(double meters, double tons, ProductLoad productLoad) {
		this.meters = meters;
		this.tons = tons;
		this.productLoad = productLoad;
	}

	/**
	 * @return The meters of the TrainCar
	 */
	public double getMeters() {
		return meters;
	}

	/**
	 * @return The tons of the TrainCar
	 */
	public double getTons() {
		return tons;
	}

	/**
	 * @return The productLoad of the TrainCar
	 */
	public ProductLoad getProductLoad() {
		return productLoad;
	}

	/**
	 * @param productLoad
	 *        Changes the productLoad of the TrainCar
	 */
	public void setProductLoad(ProductLoad productLoad) {
		this.productLoad = productLoad;
	}

	/**
	 * Checks whether the TrainCar has a productLoad in it or not
	 * 
	 * @return True if TrainCar does not have productLoad, false otherwise
	 */
	public boolean isEmpty() {
		return (productLoad == null);
	}
}
