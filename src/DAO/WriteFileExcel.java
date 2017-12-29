package DAO;

import java.util.List;

import model.HocVienModel;


public class WriteFileExcel {

	public static boolean WriteFileExcelExport(List<HocVienModel> dsHocVien, String nameFile) {
		String outputFileName = "D:\\" + nameFile + ".xls";
		
		boolean isWrited = WriteFileExcelHocVien.WriteFile(dsHocVien, outputFileName);

		if (isWrited) {
			//System.out.println("Writing done");
			return true;
		} else {
			//System.out.println("Writing fail");
			return false;
		}
	}

}
