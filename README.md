# Cricbuzz-API-Java
You can use this API to retrieve Live Match Score, Scorecard, etc. from Cricbuzz API.

Use the following snippet to get started:
```
CricBuzzParser cbp = new CricBuzzParser("http://mapps.cricbuzz.com/cbzios/match/livematches");
cbp.RetrieveURL();
cbp.Parse();
```
Then you can use it's parameters to get details about curent matches, Scorecard, etc.

You can get all matches by using 
```
cbp.getMatches(); //returns ArrayList of Match class
```

Match Class has the following attributes:
```
	Venue venue;
	String bat_team_name;
	String bowl_team_name;
	String SeriesName;
	String MatchID;
	String SeriesID;
	String DataPath;
	String StartTime;
	String EndTime;
	String MatchDescription;
	String Type;
	String State;
	String StateTitle;
	String Toss;
	String Status;
	String scorecard;
	JSONObject mData;
	JSONObject header;
	Team Team1;
	Team Team2;
```

Inside Match Class, you can find other things like Venue details, Team details, team composition, etc. You can make use of all the details available. You can also modify the code as per your needs to analyse past data or such stuff.

Please star this repo so that you can get back here :)

You can now get the latest commentary of a Match by calling `getCommentary` function of the Match Class. It makes a network call so donot call it too many times or you would be blocked :P

You can run [Demo.java](https://github.com/yashrs/Cricbuzz-API-Java/blob/master/src/Demo.java) file to understand exactly how to use this Project and also modify it for your own needs. Thanks!
