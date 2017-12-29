package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/giaovien")
public class giaovien extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public giaovien() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("nameUser") != null)
			request.getRequestDispatcher("/WEB-INF/giaovien.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
