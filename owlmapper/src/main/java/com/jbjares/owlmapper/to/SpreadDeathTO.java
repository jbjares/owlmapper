package com.jbjares.owlmapper.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SpreadDeathTO implements Serializable{

	private static final long serialVersionUID = -6870253021538903902L;
		private String label;
		private String type;
		private String county;
		private Date datePageCertified;
		private Date datePageCertifiedAsTrueCopy;
		private String district;
		private String districtOfSuperintendantRegistrar;
		private String forenameOfRegistrarOnPage;
		private String forenameOfSuperintendantRegistrar;
		private Integer pageNumber;
		private Integer quarter;
		private String stampNumber;
		private String surnameOfRegistrarOnPage;
		private String surnameOfSuperintendantRegistrar;
		private String union;
		private Integer volume;
		private List<DeathTO> withRecord;
		private Integer id;
		private Date yearRegistered;
		
		
		
		
		
		public Date getYearRegistered() {
			return yearRegistered;
		}
		public void setYearRegistered(Date yearRegistered) {
			this.yearRegistered = yearRegistered;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		public String getCounty() {
			return county;
		}
		public void setCounty(String county) {
			this.county = county;
		}
		public Date getDatePageCertified() {
			return datePageCertified;
		}
		public void setDatePageCertified(Date datePageCertified) {
			this.datePageCertified = datePageCertified;
		}
		public Date getDatePageCertifiedAsTrueCopy() {
			return datePageCertifiedAsTrueCopy;
		}
		public void setDatePageCertifiedAsTrueCopy(Date datePageCertifiedAsTrueCopy) {
			this.datePageCertifiedAsTrueCopy = datePageCertifiedAsTrueCopy;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getDistrictOfSuperintendantRegistrar() {
			return districtOfSuperintendantRegistrar;
		}
		public void setDistrictOfSuperintendantRegistrar(
				String districtOfSuperintendantRegistrar) {
			this.districtOfSuperintendantRegistrar = districtOfSuperintendantRegistrar;
		}
		public String getForenameOfRegistrarOnPage() {
			return forenameOfRegistrarOnPage;
		}
		public void setForenameOfRegistrarOnPage(String forenameOfRegistrarOnPage) {
			this.forenameOfRegistrarOnPage = forenameOfRegistrarOnPage;
		}
		public String getForenameOfSuperintendantRegistrar() {
			return forenameOfSuperintendantRegistrar;
		}
		public void setForenameOfSuperintendantRegistrar(
				String forenameOfSuperintendantRegistrar) {
			this.forenameOfSuperintendantRegistrar = forenameOfSuperintendantRegistrar;
		}
		public Integer getPageNumber() {
			return pageNumber;
		}
		public void setPageNumber(Integer pageNumber) {
			this.pageNumber = pageNumber;
		}
		public Integer getQuarter() {
			return quarter;
		}
		public void setQuarter(Integer quarter) {
			this.quarter = quarter;
		}
		public String getStampNumber() {
			return stampNumber;
		}
		public void setStampNumber(String stampNumber) {
			this.stampNumber = stampNumber;
		}
		public String getSurnameOfRegistrarOnPage() {
			return surnameOfRegistrarOnPage;
		}
		public void setSurnameOfRegistrarOnPage(String surnameOfRegistrarOnPage) {
			this.surnameOfRegistrarOnPage = surnameOfRegistrarOnPage;
		}
		public String getSurnameOfSuperintendantRegistrar() {
			return surnameOfSuperintendantRegistrar;
		}
		public void setSurnameOfSuperintendantRegistrar(
				String surnameOfSuperintendantRegistrar) {
			this.surnameOfSuperintendantRegistrar = surnameOfSuperintendantRegistrar;
		}
		public String getUnion() {
			return union;
		}
		public void setUnion(String union) {
			this.union = union;
		}
		public Integer getVolume() {
			return volume;
		}
		public void setVolume(Integer volume) {
			this.volume = volume;
		}
		public List<DeathTO> getWithRecord() {
			return withRecord;
		}
		public void setWithRecord(List<DeathTO> withRecord) {
			this.withRecord = withRecord;
		}
		
		

}
