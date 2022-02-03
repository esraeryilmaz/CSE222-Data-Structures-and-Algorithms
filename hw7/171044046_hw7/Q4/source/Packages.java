/**
 * Packages class
 * It keeps package name, quantity and price
 *
 * @author Esra Eryılmaz
 * @since 2020-06-04
 */


public class Packages implements Comparable<Packages>
{
	/**
	 * Name of the software package
	 */
	protected String name;
	/**
	 * Quantity of the software package
	 */
	protected int quantity;
	/**
	 * Price of the software package
	 */
	protected int price;



	/**
	 * @param target
	 * @param quantity
	 * @param price
	 */
	public Packages(String target, int quantity, int price) {
		this.name = target;
		this.quantity = quantity;
		this.price = price;
	}


	/**
	 * It prints the package with name,quantity and price
	 */
	public void print()
	{
		System.out.println(this.name + "  ,  " + this.quantity + "  ,  " + this.price);
	}


	/**
	 * It compares by software name.
	 */
	@Override
	public int compareTo(Packages o)
	{
		if(this.name.compareTo(o.name) == 0)
			return 0;

		else if(this.name.compareTo(o.name) < 0)
			return -1;

		else
			return 1;
	}

	/**
	 * It compares by software quantity.
	 */
	public int compareQuantity(Packages q)
	{
		if(this.quantity == q.quantity)
			return 0;

		else if(this.quantity < q.quantity)
			return -1;

		else
			return 1;
	}

	/**
	 * It compares by software price.
	 */
	public int comparePrice(Packages p)
	{
		if(this.price == p.price)
			return 0;

		else if(this.price < p.price)
			return -1;

		else
			return 1;
	}

}
