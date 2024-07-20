package InsertSales;

public class SalesPojo {
private String spname;
private int target;
private int units;
private String status;
public SalesPojo(String spname, int target, int units, String status) {
	super();
	this.spname = spname;
	this.target = target;
	this.units = units;
	this.status = status;
}
public String getSpname() {
	return spname;
}
public void setSpname(String spname) {
	this.spname = spname;
}
public int getTarget() {
	return target;
}
public void setTarget(int target) {
	this.target = target;
}
public int getUnits() {
	return units;
}
public void setUnits(int units) {
	this.units = units;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
