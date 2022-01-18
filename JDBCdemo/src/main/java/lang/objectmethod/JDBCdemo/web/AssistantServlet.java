package lang.objectmethod.JDBCdemo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lang.objectmethod.JDBCdemo.dao.AssistantDAO;
import lang.objectmethod.JDBCdemo.model.Assistant;

/**
 * Servlet implementation class AssistantServlet
 */
@WebServlet("/assistants")
public class AssistantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssistantDAO assistantDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssistantServlet() {
		this.assistantDAO = new AssistantDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Assistant> listAssistant = assistantDAO.selectAllAssistant();
		request.setAttribute("listAssistant", listAssistant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assistant-list.jsp");
		dispatcher.forward(request, response);
	}
}




