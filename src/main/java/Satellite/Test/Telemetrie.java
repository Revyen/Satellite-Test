/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Satellite.Test;
import java.util.Date;

/**
 *
 * @author Leo
 */
public class Telemetrie {
    private float latitude;
    private float longitude;
    private float dec;
    private Date time;
    
    Telemetrie(float lat,float lon,float dec, int time)
    {
        this.latitude = lat;
        this.longitude = lon;
        this.dec = dec;
        this.time = new java.util.Date((long)time*1000);
    }
    
    public float getLatitude(){return this.latitude;}
    public float getLongitude(){return this.longitude;}
    public float getDec(){return this.dec;}
    public Date getTime(){return this.time;}
    
    public void setLatitude(float latitude){this.latitude = latitude;}
    public void setLongitude(float longitude){this.longitude = longitude;}
    public void setDec(float dec){this.dec = dec;}
    public void setTime(Date time){this.time = time;}
    
    public String toString()
    {
        return "Lat:"+this.latitude+"\nLong:"+longitude+"\nDec:"+this.dec+"\nTime"+this.time.toString()+"\n";
    }
    
    public Boolean check(Telemetrie t)
    {
    	if(t.dec == this.dec && t.latitude == this.latitude && t.longitude == this.longitude)
    	{
    		return true;
    	}
    		
    	else { return false;}
    }
}


