package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.loginDAO;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		int role = 0;
		if (("HocVien").equals(gender)) 
			role = 1;
		if (("GiaoVien").equals(gender))
			role = 2;
		if (("NhanVien").equals(gender))
			role = 3;
		if (("QuanTriVien").equals(gender))
			role = 4;
		
			
		if(username != null && password != null)
		{
			int kq = loginDAO.CheckLogin(username, password, role);	
			
			
			response.setContentType("application/json;charset=UTF-8");
		    request.setCharacterEncoding("utf-8");
		    PrintWriter out = response.getWriter();
			
			if(kq==0) {
				out.write("{\"role\":\"" + kq + "\"}");
			    out.flush();
			}
			else {
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
				
				String nameUser = loginDAO.LayTenNguoiDung(username, role);
				
				request.getSession().setAttribute("nameUser", nameUser); 
				
				out.write("{\"role\":\"" + kq + "\"}");
			    out.flush();
			}
		}
		
	}

}
