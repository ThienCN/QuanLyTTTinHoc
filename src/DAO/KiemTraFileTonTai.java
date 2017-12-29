package DAO;

import java.io.*;

public class KiemTraFileTonTai {

	public static boolean KiemTraFileDaTonTaiChua(String pathFile) {
		
		File f = new File(pathFile);
		if (f.exists()) {
		  //System.out.println("File đã tồn tại");
			return true;
		} 
		//System.out.println("Chưa có file!");
		return false;
	}
}
