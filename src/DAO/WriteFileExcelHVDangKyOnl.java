package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.HVDKyOnlineModel;


public class WriteFileExcelHVDangKyOnl {

	public static boolean WriteFile(List<HVDKyOnlineModel> students, String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return WriteFile(students, file);
		}

		return false;
	}

	public static boolean WriteFile(List<HVDKyOnlineModel> hocvien, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				HSSFWorkbook workbook = new HSSFWorkbook();

				if (workbook != null) {

					// Create a new sheet
					HSSFSheet sheet = workbook.createSheet("DSDK Online");

					if (sheet != null) {

						// Create header row
						Row header = sheet.createRow(0);

						// MÃ ĐKOL
						Cell cell = header.createCell(0);
						cell.setCellValue("Mã ĐKOL");

						// Họ tên
						cell = header.createCell(1);
						cell.setCellValue("Họ tên");

						// Ngày sinh
						cell = header.createCell(2);
						cell.setCellValue("Ngày sinh");

						// Địa chỉ
						cell = header.createCell(3);
						cell.setCellValue("Địa chỉ");
						
						// SDT
						cell = header.createCell(4);
						cell.setCellValue("SĐT");
						
						// Email
						cell = header.createCell(5);
						cell.setCellValue("Email");

						// Create content rows
						int length = hocvien != null ? hocvien.size() : 0;
						for (int i = 0; i < length; i++) {

							HVDKyOnlineModel hv = hocvien.get(i);

							if (hv != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);
								
								// MÃ ĐKOL
								cell = row.createCell(0);
								cell.setCellValue(hv.getMaDkyOnl());

								// Họ tên
								cell = row.createCell(1);
								cell.setCellValue(hv.getHoTen());

								// Ngày sinh
								cell = row.createCell(2);
								cell.setCellValue(hv.getNgaySinh());

								// Địa chỉ
								cell = row.createCell(3);
								cell.setCellValue(hv.getDiaChi());
								
								// SDT
								cell = row.createCell(4);
								cell.setCellValue(hv.getSDT());
								
								// Email
								cell = row.createCell(5);
								cell.setCellValue(hv.getEmail());
							}
						}
					}

					FileOutputStream fileOutputStream = new FileOutputStream(file);

					workbook.write(fileOutputStream);

					workbook.close();

					return true;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return false;
	}


}
