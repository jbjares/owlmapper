package com.jbjares.owlmapper.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SpreadDeathTO implements Serializable{

	private static final long serialVersionUID = -6870253021538903902L;
		private String label;
		private String type;
		private String county;
		private String datePageCertified;
		private String datePageCertifiedAsTrueCopy;
		private String district;
		private String districtOfSuperintendantRegistrar;
		private String forenameOfRegistrarOnPage;
		private String forenameOfSuperintendantRegistrar;
		private String pageNumber;
		private String quarter;
		private String stampNumber;
		private String surnameOfRegistrarOnPage;
		private String surnameOfSuperintendantRegistrar;
		private String union;
		private String volume;
		private List<String> withRecord = new ArrayList<String>();
		private List<DeathTO> deaths = new ArrayList<DeathTO>();
		private String id;
		private String yearRegistered;
		
		
		public List<DeathTO> getDeaths() {
			return deaths;
		}
		public void setDeaths(List<DeathTO> deaths) {
			this.deaths = deaths;
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
		public String getCounty() {
			return county;
		}
		public void setCounty(String county) {
			this.county = county;
		}
		public String getDatePageCertified() {
			return datePageCertified;
		}
		public void setDatePageCertified(String datePageCertified) {
			this.datePageCertified = datePageCertified;
		}
		public String getDatePageCertifiedAsTrueCopy() {
			return datePageCertifiedAsTrueCopy;
		}
		public void setDatePageCertifiedAsTrueCopy(String datePageCertifiedAsTrueCopy) {
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
		public String getPageNumber() {
			return pageNumber;
		}
		public void setPageNumber(String pageNumber) {
			this.pageNumber = pageNumber;
		}
		public String getQuarter() {
			return quarter;
		}
		public void setQuarter(String quarter) {
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
		public String getVolume() {
			return volume;
		}
		public void setVolume(String volume) {
			this.volume = volume;
		}
		public List<String> getWithRecord() {
			return withRecord;
		}
		public void setWithRecord(List<String> withRecord) {
			this.withRecord = withRecord;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getYearRegistered() {
			return yearRegistered;
		}
		public void setYearRegistered(String yearRegistered) {
			this.yearRegistered = yearRegistered;
		}
		
				
		

}
