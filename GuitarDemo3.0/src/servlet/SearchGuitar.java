package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IGuitar;
import dao.dataAccess;
import entity.GuitarSpec;

/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
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
			// 新建一个guitar List 用来存储匹配到的guitars
			List matchingGuitars = new LinkedList();
			IGuitar i = dataAccess.createGuitarDao();
			matchingGuitars = i.Inventory().search(spec);					
			System.out.println(matchingGuitars);			
			request.setAttribute("res", matchingGuitars);
			if (!matchingGuitars.isEmpty()) {
		        request.getRequestDispatcher("/result.jsp").forward(request,response);
		      } else {
		        System.out.println("对不起，暂无此商品。");
		      }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
