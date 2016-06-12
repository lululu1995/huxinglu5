package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IGuitar;
import dao.dataAccess;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Inventory;

/**
 * Servlet implementation class AddGuitar
 */
@WebServlet("/AddGuitar")
public class AddGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dataAccess.createGuitarDao();
		GuitarSpec spec = new GuitarSpec(null, null, null, null);
		spec.setBuilder(request.getParameter("builder"));
		spec.setModel(request.getParameter("model"));
		spec.setWood(request.getParameter("wood"));
		spec.setType(request.getParameter("type"));
		int ID=Integer.parseInt(request.getParameter("ID").toString());
		double price= Double.valueOf(request.getParameter("price").toString());
		IGuitar i = dataAccess.createGuitarDao();
		i.addGuitar(ID, price, spec);		
 	 	request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
