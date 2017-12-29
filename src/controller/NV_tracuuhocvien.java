package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.NV_dangkykhoahocDAO;
import model.HocVienModel;

@WebServlet("/NV_tracuuhocvien")
public class NV_tracuuhocvien extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public NV_tracuuhocvien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTimKiem = request.getParameter("maTimKiem");
		
		HocVienModel hocVien=NV_dangkykhoahocDAO.TraCuuHocVien(maTimKiem);
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(hocVien == null || hocVien.getError() != null) {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		else {
			Gson gson = new Gson();
		    String objectToReturn = gson.toJson(hocVien);
		    out.write(objectToReturn); 
		    out.flush();
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
