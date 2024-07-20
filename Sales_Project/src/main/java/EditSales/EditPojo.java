package EditSales;

public class EditPojo {
private int id;
private String salespname;
private int target;
private int unitssold;
private String status;
public EditPojo(int id, String salespname, int target, int unitssold, String status) {
	super();
	this.id = id;
	this.salespname = salespname;
	this.target = target;
	this.unitssold = unitssold;
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSalespname() {
	return salespname;
}
public void setSalespname(String salespname) {
	this.salespname = salespname;
}
public int getTarget() {
	return target;
}
public void setTarget(int target) {
	this.target = target;
}
public int getUnitssold() {
	return unitssold;
}
public void setUnitssold(int unitssold) {
	this.unitssold = unitssold;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
