import java.util.HashMap;

import com.arcusweather.forecastio.ForecastIO;
import com.arcusweather.forecastio.ForecastIODataPoint;
import com.arcusweather.forecastio.ForecastIOResponse;

public class Forecast {
	 ForecastIO FIO = new ForecastIO("0", 0.0, 0.0);  
		
//		//ability to set the units, exclude blocks, extend options and user agent for the request. This is not required.
//		HashMap<String, String> requestParam = new HashMap<String, String>();
//		requestParams.put("units", "us");
//		requestParams.put("userAgent", "Custom User Agent 1.0");
//		FIO.setRequestParams(requestParams);
//	    FIO.makeRequest();
//
//	    String responseString = FIO.getResponseString();  
//	    ForecastIOResponse FIOR = new ForecastIOResponse(responseString);  
//
//	    //The library provides an easy way to access values as strings and data points as a list.
//	    String currentSummary = FIOR.getValue("current-summary");
//	    String thirdHourlyTemperature = FIOR.getValue("hourly-2-temperature");
//	    String firstDailyIcon = FIOR.getValue("daily-0-icon");
//		
//		//alerts defaults to first alert if not given an index. (Usually there is only one alert).
//	    String alertDescription = FIOR.getValue("alerts-description"); 
//
//	    ForecastIODataPoint[] minutelyPoints = FIOR.getDataPoints("minutely");
//	    double thirtiethMinutePrecipitation = minutelyPoints[29].getValueAsDouble("precipitationIntensity");
//
//	    ForecastIODataPoint[] hourlyPoints = FIOR.getDataPoints("hourly");
//	    ForecastIODataPoint[] dailyPoints = FIOR.getDataPoints("daily");
//
//	    //you can also do it the hard way
//	  //  String currentSummary = FIOR.getCurrently().getValue("summary");
//	    //String firstDailyIcon = FIOR.getDaily().getData[0].getValue("icon");
}
