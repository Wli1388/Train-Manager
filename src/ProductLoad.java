/**
 * 
 * @author Name: Wen Feng Li ID: 115091650 Recitation Section 02
 *
 *         This class defines ProductLoad with a name, weight in tons, value in
 *         dollars, and if it's dangerous
 */
public class ProductLoad {
	private String name;
	private double tons;
	private double dollars;
	private boolean isDangerous;

	/**
	 * This is a constructor that creates a new ProductLoad object
	 * 
	 * @param name
	 *        The name of ProductLoad
	 * @param tons
	 *        The weight in tons of ProductLoad
	 * @param dollars
	 *        The value in dollars of ProductLoad
	 * @param isDangerous
	 *        Whether ProductLoad is dangerous or not
	 */
	public ProductLoad(String name, double tons, double dollars,
			boolean isDangerous) {
		this.name = name;
		this.tons = tons;
		this.dollars = dollars;
		this.isDangerous = isDangerous;
	}

	/**
	 * @return The name of ProductLoad
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *        Changes the name of ProductLoad
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The tons of ProductLoad
	 */
	public double getTons() {
		return tons;
	}

	/**
	 * @param tons
	 *        Changes the ton of ProductLoad
	 * @throws IllegalArgumentException
	 *         Throws exception when tons < 0
	 */
	public void setTons(double tons) throws IllegalArgumentException {
		if (tons < 0)
			throw new IllegalArgumentException();
		this.tons = tons;
	}

	/**
	 * @return The dollars of ProductLoad
	 */
	public double getDollars() {
		return dollars;
	}

	/**
	 * @param dollars
	 *        Changes the dollars of ProductLoad
	 * @throws IllegalArgumentException
	 *         Throws exception when dollars < 0
	 */
	public void setDollars(double dollars) throws IllegalArgumentException {
		if (dollars < 0)
			throw new IllegalArgumentException();
		this.dollars = dollars;
	}

	/**
	 * @return True if its dangerous, false otherwise
	 */
	public boolean isDangerous() {
		return isDangerous;
	}

	/**
	 * @param isDangerous
	 *        Changes the isDangerous of ProductLoad
	 */
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
}
