package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GV_DAO;

@WebServlet("/GV_xoatailieu")
public class GV_xoatailieu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GV_xoatailieu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaTLMoi = request.getParameter("MaTLMoi");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(GV_DAO.XoaTaiLieu(MaTLMoi) > 0) {
			out.write("{\"MaTLMoi\":\"yes\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
