package parking;

import java.sql.Timestamp;

public class GetterSetter {
	
	private String name;
	private String vehicleNum;
	private int mobnum;
	private String pwd;
	private String UserName;
	private String Passowrd;
	private int regID;
	private double Amount;
	private long userRequestMinute;
	private double hrsrequest;
	private Timestamp parkingEndTime;
	private Timestamp starttime;
	private String session;
//	private java.sql.Date ticketdate;
	
	
	public long getUserRequestMinute() {
		
		return userRequestMinute;
	}
	public void setUserRequestMinute(long userRequestMinute) {
		this.userRequestMinute = userRequestMinute;
			
	}
	
			
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Timestamp getParkingEndTime() {
		return parkingEndTime;
	}
	public void setParkingEndTime(Timestamp parkingEndTime) {
		this.parkingEndTime = parkingEndTime;
	}
	public double getHrsrequest() {
		
		System.out.println("Hours requested from getter Setter"+hrsrequest);
		return hrsrequest;
		
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public void setHrsrequest(double hrsrequest) {
		
		this.hrsrequest = hrsrequest;
		
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public int getRegID() {
		return regID;
	}
	public void setRegID(int regID) {
		this.regID = regID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassowrd() {
		return Passowrd;
	}
	public void setPassowrd(String passowrd) {
		Passowrd = passowrd;
	}
			
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public int getMobnum() {
		return mobnum;
	}
	public void setMobnum(int mobnum) {
		this.mobnum = mobnum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
