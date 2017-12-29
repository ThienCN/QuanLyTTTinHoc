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

import model.GiaoVienModel;


public class WriteFileExcelGiaoVien {

	public static boolean WriteFile(List<GiaoVienModel> students, String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return WriteFile(students, file);
		}

		return false;
	}

	public static boolean WriteFile(List<GiaoVienModel> giaovien, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				HSSFWorkbook workbook = new HSSFWorkbook();

				if (workbook != null) {

					// Create a new sheet
					HSSFSheet sheet = workbook.createSheet("DS GiaoVien");

					if (sheet != null) {

						// Create header row
						Row header = sheet.createRow(0);

						// MÃ Giáo viên
						Cell cell = header.createCell(0);
						cell.setCellValue("Mã Giáo viên");

						// Họ tên
						cell = header.createCell(1);
						cell.setCellValue("Họ tên");

						// Ngày sinh
						cell = header.createCell(2);
						cell.setCellValue("Ngày sinh");
						
						// CMND
						cell = header.createCell(3);
						cell.setCellValue("CMND");

						// Địa chỉ
						cell = header.createCell(4);
						cell.setCellValue("Địa chỉ");
						
						// Giới tính
						cell = header.createCell(5);
						cell.setCellValue("Giới tính");
						
						// SDT
						cell = header.createCell(6);
						cell.setCellValue("SĐT");
						
						// Trình độ học vấn
						cell = header.createCell(7);
						cell.setCellValue("Trình độ học vấn");
						
						// Email
						cell = header.createCell(8);
						cell.setCellValue("Email");

						// Create content rows
						int length = giaovien != null ? giaovien.size() : 0;
						for (int i = 0; i < length; i++) {

							GiaoVienModel gv = giaovien.get(i);

							if (gv != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);
								
								// Mã giáo viên
								cell = row.createCell(0);
								cell.setCellValue(gv.getMaGV());

								// Họ tên
								cell = row.createCell(1);
								cell.setCellValue(gv.getHoTenGV());

								// Ngày sinh
								cell = row.createCell(2);
								cell.setCellValue(gv.getNgaySinh());
								
								// Địa chỉ
								cell = row.createCell(3);
								cell.setCellValue(gv.getCMND());

								// Địa chỉ
								cell = row.createCell(4);
								cell.setCellValue(gv.getDiaChi());
								
								// Giới tính
								cell = row.createCell(5);
								if(gv.isGioiTinh())
									cell.setCellValue("Nữ");
								else
									cell.setCellValue("Nam");
								
								// SDT
								cell = row.createCell(6);
								cell.setCellValue(gv.getDienThoai());
								
								// Trình độ học vấn
								cell = row.createCell(7);
								cell.setCellValue(gv.getTenTrinhDoHV());
								
								// Email
								cell = row.createCell(8);
								cell.setCellValue(gv.getEmailGV());
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
