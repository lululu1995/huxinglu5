package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.IGuitar;
import entity.*;
import mysqlDao.DBUtil;

public class GuitarImpl implements IGuitar {
	
	@Override
	public  Inventory Inventory()
	{
		Inventory inventory = new Inventory();
		Connection connection = DBUtil.getConnection();
		PreparedStatement pstat;
		ResultSet rs;
		try {
			pstat = connection.prepareStatement("select * from guitar");
			rs = pstat.executeQuery();
			while (rs.next()) {
				GuitarSpec guitarspec = new GuitarSpec( null, null, null, null);
				guitarspec.setBuilder(rs.getString("builder"));
				guitarspec.setModel(rs.getString("model"));
				guitarspec.setType(rs.getString("type"));
				guitarspec.setWood(rs.getString("wood"));
				inventory.addGuitar(rs.getInt("ID"), rs.getDouble("price"), guitarspec);
			}
		} catch(Exception e){
		    e.printStackTrace();	
		}
		return inventory;
	}
	
	
	public List<Guitar> getAllGuitars(){
		Connection Conn = DBUtil.getConnection();
		String sql = "select * from guitar";
		List<Guitar> inventory = new ArrayList<Guitar>();
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GuitarSpec spec = new GuitarSpec(null, null, null,null);
				spec.setBuilder(rs.getString("builder"));
				spec.setModel(rs.getString("model"));
				spec.setType(rs.getString("type"));
				spec.setWood(rs.getString("wood"));			
				Guitar guitar = new Guitar(rs.getInt("ID"),rs.getDouble("price"),spec);
				inventory.add(guitar);				
			}			
			rs.close();
			pstmt.close();
			Conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e){
		    e.printStackTrace();	
		}finally{
			try{
		         if(Conn!=null)
		        	 Conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		return inventory;
	}


	public void addGuitar(int ID, double price,
            GuitarSpec spec) {
		String sql="insert into guitar(ID,builder,model,type,wood,price) values(?,?,?,?,?,?)";
		Connection conn=DBUtil.getConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, ID);
			ps.setString(2, spec.getBuilder());
			ps.setString(3,spec.getModel());			
			ps.setString(4, spec.getType());
		    ps.setString(5, spec.getWood());
			ps.setDouble(6, price);			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
	
	 public void deleteGuitar(int ID) {
			// TODO Auto-generated method stub
			String sql="delete from guitar where ID=?";
			Connection conn=DBUtil.getConnection();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, ID);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}


}

	
