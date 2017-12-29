package model;

public class KhoaHocModel {
	String maKhoaHoc, ngayKhaiGiang, error;
	Integer soLopHoc, tinhTrang;
	
	public KhoaHocModel(String maKhoaHoc,String ngayKhaiGiang,Integer soLopHoc, Integer tinhTrang,String error) {
		this.maKhoaHoc=maKhoaHoc;
		this.ngayKhaiGiang=ngayKhaiGiang;
		this.soLopHoc=soLopHoc;
		this.tinhTrang=tinhTrang;
		this.error=error;
	}

	public Integer getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Integer tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public void setMaKhoaHoc(String maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}

	public String getNgayKhaiGiang() {
		return ngayKhaiGiang;
	}

	public void setNgayKhaiGiang(String ngayKhaiGiang) {
		this.ngayKhaiGiang = ngayKhaiGiang;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getSoLopHoc() {
		return soLopHoc;
	}

	public void setSoLopHoc(Integer soLopHoc) {
		this.soLopHoc = soLopHoc;
	}
	
	
}
