package entity;

public class Guitar {
	  private int ID;
	  private double price;
	  GuitarSpec spec;

	  public Guitar(int ID, double price, GuitarSpec spec) {
	    this.ID = ID;
	    this.price = price;
	    this.spec = spec;
	  }

	  public int getID() {
	    return ID;
	  }

	  public double getPrice() {
	    return price;
	  }

	  public void setPrice(float newPrice) {
	    this.price = newPrice;
	  }

	  public GuitarSpec getSpec() {
	    return spec;
	  }
	}