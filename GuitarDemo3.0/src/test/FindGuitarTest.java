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
      System.out.println("搜索结果----");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("你搜索的这款吉他：品牌为" +spec.getBuilder() + "--型号为" + spec.getModel() + "--类型为" +
          spec.getType() + "--材质为" +spec.getWood() + "--价格为￥" +
          guitar.getPrice()+"--ID为"+guitar.getID());
      }
    } else {
      System.out.println("Sorry, 我们没有这一款吉他.");
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
