package com.fit.se.ChuyenBayService.model;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "chuyenbay")
@Getter
@Setter
public class ChuyenBay implements Serializable {
	@Id
	@Column(name="maCB", columnDefinition = "varchar(5)")
	private String maCB;

	@Column(name="gadi", columnDefinition = "varchar(50)")
	private String gaDi;

	@Column(name="gaden", columnDefinition = "varchar(50)")
	private String gaDen;

	@Column(name="dodai")
	private int doDai;

	@Column(name="giodi")
	private Date gioDi;

	@Column(name="gioden")
	private Date gioDen;

	@Column(name="chiphi")
	private int chiPhi;

	public ChuyenBay() {
	}

	public ChuyenBay(String gaDi, String gaDen, int doDai, Date gioDi, Date gioDen, int chiPhi) {
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.doDai = doDai;
		this.gioDi = gioDi;
		this.gioDen = gioDen;
		this.chiPhi = chiPhi;
	}

	public ChuyenBay(String macb, String gaDi, String gaDen, int doDai, Date gioDi, Date gioDen, int chiPhi) {
		this.maCB = macb;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.doDai = doDai;
		this.gioDi = gioDi;
		this.gioDen = gioDen;
		this.chiPhi = chiPhi;
	}

	public String getMaCB() {
		return maCB;
	}

	public void setMaCB(String maCB) {
		this.maCB = maCB;
	}

	public String getGaDi() {
		return gaDi;
	}

	public void setGaDi(String gaDi) {
		this.gaDi = gaDi;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public int getDoDai() {
		return doDai;
	}

	public void setDoDai(int doDai) {
		this.doDai = doDai;
	}

	public Date getGioDi() {
		return gioDi;
	}

	public void setGioDi(Date gioDi) {
		this.gioDi = gioDi;
	}

	public Date getGioDen() {
		return gioDen;
	}

	public void setGioDen(Date gioDen) {
		this.gioDen = gioDen;
	}

	public int getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(int chiPhi) {
		this.chiPhi = chiPhi;
	}


}