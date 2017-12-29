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

import model.LopHocModel;


public class WriteFileExcelLopHoc {

	public static boolean WriteFile(List<LopHocModel> students, String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return WriteFile(students, file);
		}

		return false;
	}

	public static boolean WriteFile(List<LopHocModel> lophoc, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				HSSFWorkbook workbook = new HSSFWorkbook();

				if (workbook != null) {

					// Create a new sheet
					HSSFSheet sheet = workbook.createSheet("DS LopHoc");

					if (sheet != null) {

						// Create header row
						Row header = sheet.createRow(0);

						// Mã Lớp học
						Cell cell = header.createCell(0);
						cell.setCellValue("Mã Lớp học");

						// Tên lớp
						cell = header.createCell(1);
						cell.setCellValue("Tên lớp");

						// Số HV dự kiến
						cell = header.createCell(2);
						cell.setCellValue("Số HV dự kiến");
						
						// Số buổi
						cell = header.createCell(3);
						cell.setCellValue("Số buổi");

						// Ngày bắt đầu
						cell = header.createCell(4);
						cell.setCellValue("Ngày bắt đầu");
						
						// Ngày kết thúc
						cell = header.createCell(5);
						cell.setCellValue("Ngày kết thúc");
						
						// GVGD
						cell = header.createCell(6);
						cell.setCellValue("Giáo viên giảng dạy");
						
						// Phòng học
						cell = header.createCell(7);
						cell.setCellValue("Phòng học");
						
						// Buổi học
						cell = header.createCell(8);
						cell.setCellValue("Buổi học");
						
						// Giờ học
						cell = header.createCell(9);
						cell.setCellValue("Giờ học");
						
						// Học phí
						cell = header.createCell(10);
						cell.setCellValue("Học phí");
						
						// Tình trạng
						cell = header.createCell(11);
						cell.setCellValue("Tình trang");

						// Create content rows
						int length = lophoc != null ? lophoc.size() : 0;
						for (int i = 0; i < length; i++) {

							LopHocModel lh = lophoc.get(i);

							if (lh != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);
								
								// Mã lớp
								cell = row.createCell(0);
								cell.setCellValue(lh.getMaLop());

								// Tên lớp
								cell = row.createCell(1);
								cell.setCellValue(lh.getTenLop());

								// Số HV dự kiến
								cell = row.createCell(2);
								cell.setCellValue(lh.getSoHV());
								
								// Số buổi
								cell = row.createCell(3);
								cell.setCellValue(lh.getSoBuoi());

								// Ngày bắt đầu
								cell = row.createCell(4);
								cell.setCellValue(lh.getNgayBatDau());
								
								// Ngày kết thúc
								cell = row.createCell(5);
								cell.setCellValue(lh.getNgayKetThuc());
								
								// GV giảng dạy
								cell = row.createCell(6);
								cell.setCellValue(lh.getGiaoVienGiangDay());
								
								// Phòng học
								cell = row.createCell(7);
								cell.setCellValue(lh.getSoPhong());
								
								// Buổi học
								cell = row.createCell(8);
								cell.setCellValue(lh.getBuoiHoc());
								
								// Giờ học
								cell = row.createCell(9);
								cell.setCellValue(lh.getGioHoc());
								
								// Học phí
								cell = row.createCell(10);
								cell.setCellValue(lh.getHocPhi());
								
								// Tình trạng
								cell = row.createCell(11);
								
								if(lh.getTinhTrang() == 0)
									cell.setCellValue("Đóng");
								if(lh.getTinhTrang() == 1)
									cell.setCellValue("Mở");
								if(lh.getTinhTrang() == 2)
									cell.setCellValue("Khóa");
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
