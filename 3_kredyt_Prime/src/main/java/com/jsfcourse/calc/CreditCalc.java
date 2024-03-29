package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class CreditCalc {
	private String value;
	private String months;
	private String procent;
	private Double result;

	@Inject
	FacesContext ctx;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getProcent() {
		return procent;
	}

	public void setProcent(String procent) {
		this.procent = procent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}


	public boolean count() {
		try {
			double value = Double.parseDouble(this.value);
			double months = Double.parseDouble(this.months);
			double procent = Double.parseDouble(this.procent);
			
			result = (value/months)*(1+(procent/100));

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Calculated", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter the correct values", null));
			return false;
		}
	}

	public String calc() {
		if (count()) {
			return "showresult";
		}
		return null;
	}


	public String info() {
		return "info";
	}
}
