
import java.util.HashMap;

import com.arcusweather.forecastio.ForecastIO;
import com.arcusweather.forecastio.ForecastIODataPoint;
import com.arcusweather.forecastio.ForecastIOResponse;

public class Forecast {
	private double lat;
	private double lon;
	private String currentSummary;
	private String currentTemperature;
	private String firstDailyIcon;
	private String responseString;
	private ForecastIOResponse FIOR;
	private ForecastIO FIO;
	
	public static void main(String[] args) {
		Forecast forecast = new Forecast(0.0, 0.0);
		System.out.println(forecast.getSummary());
		System.out.println(forecast.getTemperature());
		System.out.println(forecast.getDailyIcon());
	}
	
	public Forecast(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
		if(lat == 0.0 && lon == 0.0) {
			lat = 47.5680;
			lon = -122.1722;
		}
		FIO = new ForecastIO("f873e84766d97a475f3a6b4b266ee396", this.lat, this.lon);  
		
		this.callData();

	    //The library provides an easy way to access values as strings and data points as a list.
	    currentSummary = FIOR.getValue("currently-summary");
	    currentTemperature = FIOR.getCurrently().getValue("temperature");
	    firstDailyIcon = FIOR.getValue("currently-icon");
		
		//alerts defaults to first alert if not given an index. (Usually there is only one alert).
	    String alertDescription = FIOR.getValue("alerts-description"); 

	    ForecastIODataPoint[] minutelyPoints = FIOR.getDataPoints("minutely");
	    //double thirtiethMinutePrecipitation = minutelyPoints[29].getValueAsDouble("precipitationIntensity");

	    ForecastIODataPoint[] hourlyPoints = FIOR.getDataPoints("hourly");
	    ForecastIODataPoint[] dailyPoints = FIOR.getDataPoints("daily");

	    //you can also do it the hard way
	  //  String currentSummary = FIOR.getCurrently().getValue("summary");
	    //String firstDailyIcon = FIOR.getDaily().getData[0].getValue("icon");
	}
	
	private void callData() {
		//ability to set the units, exclude blocks, extend options and user agent for the request. This is not required.
	 	HashMap<String, String> requestParams = new HashMap<String, String>();
	 	requestParams.put("units", "si");
	 	//requestParams.put("userAgent", "Custom User Agent 1.0");
		FIO.setRequestParams(requestParams);
	    FIO.makeRequest();
	    
		responseString = FIO.getResponseString();  
	    FIOR = new ForecastIOResponse(responseString); 
	}
	private String getSummary() {
		return currentSummary;
	}
	
	private String getTemperature() {
		return currentTemperature;
	}
	
	private String getDailyIcon() {
		return firstDailyIcon;
	}
}
