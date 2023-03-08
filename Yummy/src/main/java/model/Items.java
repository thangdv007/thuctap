
package model;

/**
 * @author MyPC
 *
 */
public class Items {
	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(Products products) {
		this.products = products;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param products
	 * @param quantity
	 */
	public Items(Products products, int quantity) {
		super();
		this.products = products;
		this.quantity = quantity;
	}

	/**
	 * 
	 */
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Products products;
	private int quantity;

}
