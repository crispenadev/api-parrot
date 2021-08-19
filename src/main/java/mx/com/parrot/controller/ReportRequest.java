package mx.com.parrot.controller;

import java.util.Date;

public class ReportRequest extends GeneralRequest{
	
	
private Date initDate;

private Date endDate;

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public Date getInitDate() {
	return initDate;
}

public void setInitDate(Date initDate) {
	this.initDate = initDate;
}

}
