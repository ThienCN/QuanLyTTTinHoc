package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HV_downloadtailieu")
public class HV_downloadtailieu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HV_downloadtailieu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TenTaiLieu = (String)request.getParameter("TenTaiLieu");
		if(TenTaiLieu.contains("mp4") || TenTaiLieu.contains("mpeg") || TenTaiLieu.contains("mov") || TenTaiLieu.contains("wmv")){
			String root=getServletContext().getRealPath("/");
			response.setContentType("application/octet-stream");
			//response.setContentType("image/png"); //set ContentType là image
			response.setHeader("Content-Disposition", "attachment;filename="+TenTaiLieu);
//			response.setHeader("Content-Disposition", "inline;filename=Google-Chrome.png");
								//Content-Disposition: xđ tên file thật
								//Attachment: download ngay thay vì hiển thị image rồi mới click chọn download
								//filename=Google-Chrome.png  tên file đúng
			
			//Đọc image từ đĩa
			FileInputStream in = new FileInputStream(root+"Video\\"+TenTaiLieu); //Tạo đường dẫn tới Video
			OutputStream out = response.getOutputStream(); //Ghi file đọc được từ buffer vào trong response
			byte[] buffer = new byte[2048]; //Tạo 1 mảng byte có chiều dài 2KB
			int bytesRead; //Biến bytesRead
			while((bytesRead=in.read(buffer))>0) { //Nếu bytesRead>0 thì sẽ ghi file đọc được từ buffer vào trong response
				//Ghi image vào trong response
				out.write(buffer,0,bytesRead); //Bắt đầu đọc từ vị trí 0 và số lượng byte thực sự đọc từ file
			}
			in.close(); //Đóng inputstream
		}
		else {
			String root=getServletContext().getRealPath("/");
			response.setContentType("application/octet-stream");
			//response.setContentType("image/png"); //set ContentType là image
			response.setHeader("Content-Disposition", "attachment;filename="+TenTaiLieu);
//			response.setHeader("Content-Disposition", "inline;filename=Google-Chrome.png");
								//Content-Disposition: xđ tên file thật
								//Attachment: download ngay thay vì hiển thị image rồi mới click chọn download
								//filename=Google-Chrome.png  tên file đúng
			
			//Đọc image từ đĩa
			FileInputStream in = new FileInputStream(root+"File\\"+TenTaiLieu); //Tạo đường dẫn tới image
			OutputStream out = response.getOutputStream(); //Ghi file đọc được từ buffer vào trong response
			byte[] buffer = new byte[2048]; //Tạo 1 mảng byte có chiều dài 2KB
			int bytesRead; //Biến bytesRead
			while((bytesRead=in.read(buffer))>0) { //Nếu bytesRead>0 thì sẽ ghi file đọc được từ buffer vào trong response
				//Ghi image vào trong response
				out.write(buffer,0,bytesRead); //Bắt đầu đọc từ vị trí 0 và số lượng byte thực sự đọc từ file
			}
			in.close(); //Đóng inputstream
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
