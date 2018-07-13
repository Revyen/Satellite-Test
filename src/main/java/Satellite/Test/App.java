package Satellite.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        Thread t = new Thread(new Runnable() {
        	AnomalieSearcher a = new AnomalieSearcher(20);
			public void run() {
				
				try {
					while(!Thread.interrupted())
					{
						List<Telemetrie> response = getTelemetrie();
						a.setPrediction(response);
						Thread.sleep(10*1000);
					}
				} catch (InterruptedException e) {
					System.out.println("Thread beendet");
					e.printStackTrace();
				}
			}
		});
		t.run();
    }
    
    public static List<Telemetrie> getTelemetrie()
    {
    	List<Telemetrie> ret = new ArrayList<Telemetrie>();
    	try {
			HttpResponse<JsonNode> response = Unirest.get("https://www.n2yo.com/rest/v1/satellite/positions/25544/51.5/7.4/0/20/&apiKey=JNXVPL-WT665E-2YWXC2-3THL").asJson();
			JSONObject obj = response.getBody().getObject();
			JSONArray Jpos = obj.getJSONArray("positions");
			for(int i = 0; i < Jpos.length();i++)
			{
				Telemetrie t = new Telemetrie((float)Jpos.getJSONObject(i).optDouble("satlatitude"),(float)Jpos.getJSONObject(i).optDouble("satlongitude"), (float)Jpos.getJSONObject(i).optDouble("sataltitude"), Jpos.getJSONObject(i).optInt("timestamp"));
				ret.add(t);
			}
			
		} catch (UnirestException e) {
			System.out.println("Fehler im Netzwerk");
		}
    	return ret;
    }
}

