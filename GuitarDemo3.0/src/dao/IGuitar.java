package dao;

import java.util.List;
import entity.*;

public interface IGuitar {
	public List<Guitar> getAllGuitars();
	public Inventory Inventory();
	public void addGuitar(int ID, double price, GuitarSpec spec) ;
	public void deleteGuitar(int ID) ;

}
