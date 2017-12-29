package model;

public class TinTucModel {

	String maTinTuc, tieuDeTinTuc, tomTatTinTuc, ngayDangTinTuc, imageVideo, error;
	int tinhTrang, stt;
	
	public TinTucModel(String maTinTuc,String tieuDeTinTuc,String tomTatTinTuc,String ngayDangTinTuc,
			String imageVideo, int tinhTrang,int stt,String error) {
		this.maTinTuc=maTinTuc;
		this.tieuDeTinTuc=tieuDeTinTuc;
		this.tomTatTinTuc=tomTatTinTuc;
		this.ngayDangTinTuc=ngayDangTinTuc;
		this.imageVideo=imageVideo;
		this.tinhTrang=tinhTrang;
		this.stt=stt;
		this.error=error;
	}

	public String getMaTinTuc() {
		return maTinTuc;
	}

	public void setMaTinTuc(String maTinTuc) {
		this.maTinTuc = maTinTuc;
	}

	public String getTieuDeTinTuc() {
		return tieuDeTinTuc;
	}

	public void setTieuDeTinTuc(String tieuDeTinTuc) {
		this.tieuDeTinTuc = tieuDeTinTuc;
	}

	public String getTomTatTinTuc() {
		return tomTatTinTuc;
	}

	public void setTomTatTinTuc(String tomTatTinTuc) {
		this.tomTatTinTuc = tomTatTinTuc;
	}

	public String getNgayDangTinTuc() {
		return ngayDangTinTuc;
	}

	public void setNgayDangTinTuc(String ngayDangTinTuc) {
		this.ngayDangTinTuc = ngayDangTinTuc;
	}

	public String getImageVideo() {
		return imageVideo;
	}

	public void setImageVideo(String imageVideo) {
		this.imageVideo = imageVideo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

}
