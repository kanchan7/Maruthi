package com.koderunner.vo.restServiceVO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "SDState_details", schema = "marrygold")
@Access(AccessType.FIELD)
public class SDRestStateVO implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6120582509629055826L;
	@Id
    @Column(name = "STATE_ID")
    @GeneratedValue
	private String stateId;
    private String stateName;
    private String stateCode;
    @OneToMany(mappedBy="state", cascade = CascadeType.ALL)
    private Set<SDRestCityVO> cities = new HashSet<SDRestCityVO>();
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "countryId")
	private SDRestCountryVO country;
    
    
    public SDRestStateVO() {
		
	}
	public SDRestStateVO(String stateId, String stateName, String stateCode,
			Set<SDRestCityVO> cities) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.cities = cities;
	}
	
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	public Set<SDRestCityVO> getCities() {
		return cities;
	}
	public void setCities(Set<SDRestCityVO> cities) {
		this.cities = cities;
	}
	
	
    
    
}
