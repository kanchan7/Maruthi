package com.koderunner.vo.restServiceVO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SDCountry_details", schema = "marrygold")
public class SDRestCountryVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7365336666440294943L;
	@Id
    @Column(name = "COUNTRY_ID")
    @GeneratedValue
	private String countryId;
    private String countryName;
    private String countryCode;
    private String languageCode;
    private String currencyCode;
    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private Set<SDRestStateVO> states = new HashSet<SDRestStateVO>();
    
    
    public SDRestCountryVO() {
		
	}
    
	public SDRestCountryVO(String countryId, String countryName,
			String countryCode, String languageCode, String currencyCode,
			Set<SDRestStateVO> states) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.languageCode = languageCode;
		this.currencyCode = currencyCode;
		this.states = states;
	}
	
	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@Column(name="COUNTRY_NAME", length=100)
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Column(name="COUNTRY_CODE", length=100)
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Column(name="LANGUAGE_CODE", length=100)
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	@Column(name="CURRENCY_CODE", length=100)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public Set<SDRestStateVO> getStates() {
		return states;
	}

	public void setStates(Set<SDRestStateVO> states) {
		this.states = states;
	}
    
    
}
