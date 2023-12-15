package productsHierarchy;

import java.util.Objects;

public class Decor extends Product {

	private String material;

	public Decor(String name, float price, String material , int stock) {
		super(name, price, stock);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(material);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Decor other = (Decor) obj;
		return Objects.equals(material, other.material);
	}

	@Override
	public String toString() {
		return "Decor [type=" + material + ", name=" + name + ", price=" + price + ", id=" + id + "]";
	}
}
