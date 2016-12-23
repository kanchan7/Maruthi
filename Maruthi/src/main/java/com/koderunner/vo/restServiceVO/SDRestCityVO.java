/**
 * 
 */
package com.koderunner.vo.restServiceVO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author GAS9
 *
 */
@Entity
@Table(name = "SDCity_details", schema = "marrygold")
public class SDRestCityVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6787705484226470800L;
	@Id
    @Column(name = "CITY_ID")
    @GeneratedValue
	private String cityId;
	private String cityName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "stateId")
	private SDRestStateVO state;
	
	public SDRestCityVO() {
	}


	public SDRestCityVO(String cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	
	public String getcityId() {
		return cityId;
	}


	public void setcityId(String cityId) {
		this.cityId = cityId;
	}

	@Column(name="CITY_NAME", length=100) 
	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}	
	
	
   
}
