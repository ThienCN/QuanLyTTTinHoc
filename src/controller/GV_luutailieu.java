package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.GV_DAO;
import DAO.KiemTraFileTonTai;

@WebServlet("/GV_luutailieu")
public class GV_luutailieu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GV_luutailieu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		String NoiDungTaiLieu = request.getParameter("NoiDungTaiLieu");
		String TenTaiLieu = request.getParameter("TenTaiLieu");
		String LoaiTaiLieu = request.getParameter("LoaiTaiLieu");
		String MaLop = (String)request.getServletContext().getAttribute("MaLop");
		String LinkTaiLieu;
		if("doc".equals(LoaiTaiLieu) || "docx".equals(LoaiTaiLieu) || "pdf".equals(LoaiTaiLieu) || "pptx".equals(LoaiTaiLieu)
					|| "xlsx".equals(LoaiTaiLieu) || "rar".equals(LoaiTaiLieu) || "txt".equals(LoaiTaiLieu) || "PPT".equals(LoaiTaiLieu))
		{
			LinkTaiLieu = "File/" + request.getParameter("NoiDungTaiLieu");
		}
		else {
			LinkTaiLieu = "Video/" + request.getParameter("NoiDungTaiLieu");
		}
		
		String root = getServletContext().getRealPath("/");
//		System.out.println(root);
		
		if(KiemTraFileTonTai.KiemTraFileDaTonTaiChua(root+LinkTaiLieu)) {
			out.write("{\"file\":\"fail\"}");
		    out.flush();
		    return;
		}
		
		String MaTLMoi = GV_DAO.ThemTaiLieuMoi(TenTaiLieu, NoiDungTaiLieu, MaLop, LinkTaiLieu);
		
		if(MaTLMoi != null) {
			out.write("{\"MaTLMoi\":\""+ MaTLMoi +"\"}");
		    out.flush();
		    return;
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		    return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String UPLOAD_DIRECTORY = "E:\\LapTrinhWeb\\Eclipse\\QuanLyTTTinHoc\\WebContent\\File";
		
				// Check that we have a file upload request
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				
				//Lấy đường dẫn của file vừa chọn
				//File directory = new File("");
				//System.out.println("path source web: " + directory.getAbsolutePath());
				
				//Đường dẫn chứa source web trên host (khi đẩy web lên host thì phải sửa lại link)
				//String root = getServletContext().getRealPath("/");
				//System.out.println("root: " + root );
				
				response.setContentType("application/json;charset=UTF-8");
			    request.setCharacterEncoding("utf-8");
			    PrintWriter out = response.getWriter();
			    
				if (isMultipart) {
					// Create a factory for disk-based file items
					FileItemFactory factory = new DiskFileItemFactory();
					// Create a new file upload handler
					ServletFileUpload upload = new ServletFileUpload(factory);
					try {
						List<FileItem> fileItems = upload.parseRequest(request);
						String pathFile = "";
		                // loop for multi file
						for (FileItem item : fileItems) {
							if (!item.isFormField()) {
								// xử lý file
								String nameimg = item.getName();
								if (!nameimg.equals("")) {
									String dirUrl = request.getServletContext().getRealPath("") + File.separator + "File";
									// Tạo thư mục nếu nó không tồn tại.
									File dir = new File(dirUrl);
									if (!dir.exists()) {
										dir.mkdir();
									}
									String fileImg = dirUrl + File.separator + nameimg;
									File file = new File(fileImg);
									
									item.write(file);
									out.write("{\"check\":\"ok\"}");
								    out.flush();
								    
									//System.out.println("UPLOAD THÀNH CÔNG...!");
									//System.out.println("ĐƯỜNG DẪN KIỂM TRA UPLOAD FILE : \n" + dirUrl);
								}
							}
//							if (!item.isFormField()) {
//								//pathFile = UPLOAD_DIRECTORY + File.separator + item.getName();
//								//pathFile = UPLOAD_DIRECTORY + item.getName();
//								//pathFile = UPLOAD_DIRECTORY + "\\" + item.getName();
//								
//								pathFile = root + "File\\" + item.getName();
		//
//								item.write(new File(pathFile));
//								
//								out.write("{\"check\":\"ok\"}");
//							    out.flush();
//							}
						}
		 
					} catch (Exception e) {
						out.write("{\"check\":\"fail\"}");
					    out.flush();
					}
				}
	}

}
