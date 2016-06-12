package test;
import java.util.Iterator;
import java.util.List;
import entity.*;



public class FindGuitarTest {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec test = 
      new GuitarSpec("b", "b", "b", "b");
    List matchingGuitars = inventory.search(test);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("�������----");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("��������������Ʒ��Ϊ" +spec.getBuilder() + "--�ͺ�Ϊ" + spec.getModel() + "--����Ϊ" +
          spec.getType() + "--����Ϊ" +spec.getWood() + "--�۸�Ϊ��" +
          guitar.getPrice()+"--IDΪ"+guitar.getID());
      }
    } else {
      System.out.println("Sorry, ����û����һ���.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar(001, 899, 
      new GuitarSpec("a", "a", "a", "a"));
    inventory.addGuitar(002, 550, 
      new GuitarSpec("b", "b", "b", "b"));
    inventory.addGuitar(003, 433, 
      new GuitarSpec("c", "c", "c","c"));

  }
}
