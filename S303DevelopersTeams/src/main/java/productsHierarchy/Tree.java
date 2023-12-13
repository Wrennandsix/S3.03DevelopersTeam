package productsHierarchy;

public class Tree extends Product {

	private float height;

	public Tree(String name, float price, float height,int stock) {
		super(name, price, stock);
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tree [height=" + height + ", name=" + name + ", price=" + price + ", id=" + id + "]";
	}

}
 