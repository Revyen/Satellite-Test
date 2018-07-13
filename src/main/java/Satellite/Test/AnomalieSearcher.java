package Satellite.Test;

import java.util.ArrayList;
import java.util.List;

public class AnomalieSearcher {

	static int counter = 0;
	private List<Telemetrie> past;
	private List<Telemetrie> future;
	private int size;
	private List<List<Telemetrie>> Anomalies;
	
	
	public AnomalieSearcher(int size)
	{
		this.size = size;
		past = new ArrayList<Telemetrie>();
		future = new ArrayList<Telemetrie>();
		Anomalies = new ArrayList<List<Telemetrie>>();
	}
	
	public void setPrediction(List<Telemetrie> data)
	{
		if(data.size() != size)
		{
			System.out.println("Liste muss gleiche größe besitzen!");
			return;
		}
		past = new ArrayList<Telemetrie>(future);
		future = new ArrayList<Telemetrie>(data);
		if(!past.isEmpty())
		{
			Analyze();
		}
		if(counter%10 == 0)
		{
			System.out.println("Anomalien " + Anomalies.size());
		}
		counter++;
		System.out.println("Request bearbeitet: "+counter);
		
		
	}
	
	private void Analyze()
	{
		List<Telemetrie> tmp = new ArrayList<Telemetrie>();
		for(Telemetrie t_p : past)
		{
			for(Telemetrie t_f : future)
			{
				if(t_p.getTime().getTime() == t_f.getTime().getTime())
				{
					if(!t_p.check(t_f))
					{
						tmp.add(t_p);
						tmp.add(t_f);
						System.out.println("\nANOMALY:");
						System.out.println(t_p.toString());
						System.out.println(t_f.toString());
						Anomalies.add(tmp);
					}
				}
			}
		}
	}

}
