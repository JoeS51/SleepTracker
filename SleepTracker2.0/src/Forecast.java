
import java.util.HashMap;

import com.arcusweather.forecastio.ForecastIO;
import com.arcusweather.forecastio.ForecastIODataPoint;
import com.arcusweather.forecastio.ForecastIOResponse;

public class Forecast {
	private double lat;
	private double lon;
	private String currentSummary;
	private String timezone;
	private String currentTemperature;
	private String apparentTemperature;
	private String nearestStormDistance;
	private String humidity;
	private String windSpeed;
	private String firstDailyIcon;
	private String responseString;
	private ForecastIOResponse FIOR;
	private ForecastIO FIO;

	// SI units are as follows:

	// summary: Any summaries containing temperature or snow accumulation units will
	// have their values in degrees Celsius or in centimeters (respectively).
	// nearestStormDistance: Kilometers.
	// precipIntensity: Millimeters per hour.
	// precipIntensityMax: Millimeters per hour.
	// precipAccumulation: Centimeters.
	// temperature: Degrees Celsius.
	// temperatureMin: Degrees Celsius.
	// temperatureMax: Degrees Celsius.
	// apparentTemperature: Degrees Celsius.
	// dewPoint: Degrees Celsius.
	// windSpeed: Meters per second.
	// windGust: Meters per second.
	// pressure: Hectopascals.
	// visibility: Kilometers.

	public static void main(String[] args) {
		Forecast forecastTester = new Forecast(40,-70);
		System.out.println("summary " + forecastTester.getSummary());
		System.out.println("timezone " + forecastTester.getTimezone());
		System.out.println("temperature " + forecastTester.getTemperature() + " C");
		System.out.println("feels like " + forecastTester.getApparentTemperature() + " C");
		System.out.println("closest storm " + forecastTester.getStormDistance() + " Km");
		System.out.println("humidity " + forecastTester.getHumidity());
		System.out.println("wind speed " + forecastTester.getWindSpeed() + " m/s");
		System.out.println(forecastTester.getDailyIcon());
	}

	public Forecast(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
		if (lat == 0.0 && lon == 0.0) {
			this.lat = 47.5680;
			this.lon = -122.1722;
		}
		FIO = new ForecastIO("f873e84766d97a475f3a6b4b266ee396", this.lat, this.lon);

		this.callData();

		// The library provides an easy way to access values as strings and data points
		// as a list.
		currentSummary = FIOR.getValue("currently-summary");
		timezone = FIOR.getValue("timezone");
		currentTemperature = FIOR.getValue("currently-temperature");
		apparentTemperature = FIOR.getValue("currently-apparentTemperature");
		nearestStormDistance = FIOR.getValue("currently-nearestStormDistance");
		humidity = FIOR.getValue("currently-temperature");
		windSpeed = FIOR.getValue("currently-windSpeed");
		firstDailyIcon = FIOR.getValue("currently-icon");

		// //alerts defaults to first alert if not given an index. (Usually there is
		// only one alert).
		// String alertDescription = FIOR.getValue("alerts-description");

		// ForecastIODataPoint[] minutelyPoints = FIOR.getDataPoints("minutely");
		// //double thirtiethMinutePrecipitation =
		// minutelyPoints[29].getValueAsDouble("precipitationIntensity");

		// ForecastIODataPoint[] hourlyPoints = FIOR.getDataPoints("hourly");
		// ForecastIODataPoint[] dailyPoints = FIOR.getDataPoints("daily");

		// you can also do it the hard way
		// String currentSummary = FIOR.getCurrently().getValue("summary");
		// String firstDailyIcon = FIOR.getDaily().getData[0].getValue("icon");
	}
	public String getWeather() {
		return currentSummary;
	}
	private void callData() {
		// ability to set the units, exclude blocks, extend options and user agent for
		// the request. This is not required.
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("units", "si");
		// requestParams.put("userAgent", "Custom User Agent 1.0");
		// set params and make request
		FIO.setRequestParams(requestParams);
		FIO.makeRequest();

		// set up the response
		responseString = FIO.getResponseString();
		FIOR = new ForecastIOResponse(responseString);
	}

	public String getSummary() {
		return currentSummary;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getTemperature() {
		return currentTemperature;
	}

	public String getApparentTemperature() {
		return apparentTemperature;
	}

	public String getStormDistance() {
		return nearestStormDistance;
	}

	public String getHumidity() {
		return humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public String getDailyIcon() {
		return firstDailyIcon;
	}
}
