package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.ResourceBundle;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.ManagedProperty;

@Named
@RequestScoped
public class CreditCalc implements Serializable{
	private Double value;
	private Integer months;
	private Integer procent;
	private Double result;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalc}")
	private ResourceBundle txtCalc;
	
	@Inject
	FacesContext ctx;
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getProcent() {
		return procent;
	}

	public void setProcent(Integer procent) {
		this.procent = procent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}


	public int String() {
		
			result = (value/months)*(1+(procent/100));

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, txtCalc.getString("result") + ": " + result, null));
			
			return 0;
			
	}

	public String info() {
		return "info";
	}
}
