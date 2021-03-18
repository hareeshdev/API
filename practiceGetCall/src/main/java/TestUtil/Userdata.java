package TestUtil;

public class Userdata {
String name;
String job;
String id;
String createdAt;

public Userdata(String name, String job, String id, String createdAt) {
	super();
	this.name = name;
	this.job = job;
	this.id = id;
	this.createdAt = createdAt;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}

}
