package Satellite.Test;

import java.util.Date;

public class VisualPass {
	private String Satname;
	private int SatID;
	private Date Starttime;
	private float Mag;
	private long duration;
	
	public VisualPass()
	{
		
	}
	
	
	public String getSatname() {
		return Satname;
	}
	public void setSatname(String satname) {
		Satname = satname;
	}
	public int getSatID() {
		return SatID;
	}
	public void setSatID(int satID) {
		SatID = satID;
	}
	public Date getStarttime() {
		return Starttime;
	}
	public void setStarttime(long time) {
		this.Starttime = new java.util.Date((long)time*1000);
	}
	public float getMag() {
		return Mag;
	}
	public void setMag(float mag) {
		Mag = mag;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return String.format(
				"SatID: %d\n"
				+ "SatName: %s\n"
				+ "StartTime: %s\n"
				+ "Magnitude: %.2f\n"
				+ "Duration: %d"
				,this.SatID,this.Satname,this.Starttime,this.Mag,this.duration).toString();
		
	}

}
