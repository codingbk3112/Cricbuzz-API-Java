import java.net.*;
import java.util.logging.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;

public class CricBuzzParser 
{
	String url;

	public ArrayList<Match> getMatches() {
		return Matches;
	}

	String resp;
	ArrayList<Match> Matches;
	
	public static void main(String[] args) 
	{
		CricBuzzParser cbp = new CricBuzzParser("http://mapps.cricbuzz.com/cbzios/match/livematches");
		cbp.RetrieveURL();
		cbp.Parse();
	}
	public CricBuzzParser(String url) 
	{
		this.url = url;
		Matches = new ArrayList<>();
	}
	public void RetrieveURL()
	{
		try 
		{
			URL url = new URL(this.url);
			
			URLConnection urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder responseString  = new StringBuilder();
			String line;

			while((line = bufferedReader.readLine())!= null){
				responseString.append(line);
			}
			String responseJsonString = responseString.toString();
			
			resp = responseJsonString;
		}
		catch(Exception except)
		{
			except.printStackTrace();
		}
	}
	
	public void putResult(String result)
	{
		this.resp = result;
	}
	public Boolean Parse()
	{
		JSONObject jo;
	
		try 
		{
			jo = new JSONObject(resp);
			JSONArray MatchesList = jo.getJSONArray("matches");
			int i;
			int j = MatchesList.length();
			for(i=0; i< j;i++)
			{
				JSONObject individualMatch= MatchesList.getJSONObject(i);
				Match m = new Match(individualMatch);
				Matches.add(m);
				String scorecard = m.getScoreCard();
				System.out.println(scorecard);
			}
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
