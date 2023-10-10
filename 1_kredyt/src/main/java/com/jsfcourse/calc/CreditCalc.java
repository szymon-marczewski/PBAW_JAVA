package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
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

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (count()) {
			return "showresult";
		}
		return null;
	}

//	// Put result in messages on AJAX call
//	public String calc_AJAX() {
//		if (count()) {
//			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
//		}
//		return null;
//	}

	public String info() {
		return "info";
	}
}
