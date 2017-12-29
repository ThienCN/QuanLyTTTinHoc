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

import model.HocVienModel;



public class WriteFileExcelHocVien {

	public static boolean WriteFile(List<HocVienModel> students, String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return WriteFile(students, file);
		}

		return false;
	}

	public static boolean WriteFile(List<HocVienModel> hocvien, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				HSSFWorkbook workbook = new HSSFWorkbook();

				if (workbook != null) {

					// Create a new sheet
					HSSFSheet sheet = workbook.createSheet("HocVien");

					if (sheet != null) {

						// Create header row
						Row header = sheet.createRow(0);

						// MÃ HV
						Cell cell = header.createCell(0);
						cell.setCellValue("Mã học viên");

						// Họ tên
						cell = header.createCell(1);
						cell.setCellValue("Họ tên");

						// Giới tính
						cell = header.createCell(2);
						cell.setCellValue("Giới tính");

						// Ngày sinh
						cell = header.createCell(3);
						cell.setCellValue("Ngày sinh");

						// Địa chỉ
						cell = header.createCell(4);
						cell.setCellValue("Địa chỉ");
						
						// SDT
						cell = header.createCell(5);
						cell.setCellValue("SĐT");
						
						// CMND
						cell = header.createCell(6);
						cell.setCellValue("CMND");
						
						// Email
						cell = header.createCell(7);
						cell.setCellValue("Email");

						// Create content rows
						int length = hocvien != null ? hocvien.size() : 0;
						for (int i = 0; i < length; i++) {

							HocVienModel hv = hocvien.get(i);

							if (hv != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);
								
								// MÃ HV
								cell = row.createCell(0);
								cell.setCellValue(hv.getMaHV());

								// Họ tên
								cell = row.createCell(1);
								cell.setCellValue(hv.getHoTenHV());

								// Giới tính
								cell = row.createCell(2);
								if(hv.getGioiTinh())
									cell.setCellValue("Nữ");
								else
									cell.setCellValue("Nam");

								// Ngày sinh
								cell = row.createCell(3);
								cell.setCellValue(hv.getNgaySinh());

								// Địa chỉ
								cell = row.createCell(4);
								cell.setCellValue(hv.getDiaChi());
								
								// SDT
								cell = row.createCell(5);
								cell.setCellValue(hv.getSDT());
								
								// CMND
								cell = row.createCell(6);
								cell.setCellValue(hv.getCMND());
								
								// Email
								cell = row.createCell(7);
								cell.setCellValue(hv.getEmailHV());
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
