package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(int ID, double price,
                        GuitarSpec spec) {
    Guitar guitar = new Guitar(ID, price, spec);
    guitars.add(guitar);
  }

  public Guitar getGuitar(int ID) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getID()==(ID)) {
        return guitar;
      }
    }
    return null;
  }

  public List search(GuitarSpec searchSpec) {
    List matchingGuitars = new LinkedList();
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      System.out.println(guitar.getSpec().getType());
      System.out.println(searchSpec.getType());
      if (guitar.getSpec().matches(searchSpec))
        matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }

public List<Guitar> getGuitars() {
	return guitars;
}

public void setGuitars(List<Guitar> guitars) {
	this.guitars = guitars;
}
  
}
