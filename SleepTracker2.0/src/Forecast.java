
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
		Forecast forecast = new Forecast(0.0, 0.0);
		System.out.println("summary " + forecast.getSummary());
		System.out.println("timezone " + forecast.getTimezone());
		System.out.println("temperature " + forecast.getTemperature() + " C");
		System.out.println("feels like " + forecast.getApparentTemperature() + " C");
		System.out.println("closest storm " + forecast.getStormDistance() + " Km");
		System.out.println("humidity " + forecast.getHumidity());
		System.out.println("wind speed " + forecast.getWindSpeed() + " m/s");
		System.out.println(forecast.getDailyIcon());
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

	private String getSummary() {
		return currentSummary;
	}

	private String getTimezone() {
		return timezone;
	}

	private String getTemperature() {
		return currentTemperature;
	}

	private String getApparentTemperature() {
		return apparentTemperature;
	}

	private String getStormDistance() {
		return nearestStormDistance;
	}

	private String getHumidity() {
		return humidity;
	}

	private String getWindSpeed() {
		return windSpeed;
	}

	private String getDailyIcon() {
		return firstDailyIcon;
	}
}
