package domain;
//모델, 인스턴스, dto
public class Weather {
	private String region;
	private int wind;
	private int temp;
	private int rain;
	
	//source -> 아래에서 세번째
	
	// --- 명시적 생성자
	public Weather(String region, int wind, int temp, int rain) {
		super();
		this.region = region;
		this.wind = wind;
		this.temp = temp;
		this.rain = rain;
	}
	
	
	// --- 기본 생성자
	public Weather() {}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public int getWind() {
		return wind;
	}


	public void setWind(int wind) {
		this.wind = wind;
	}


	public int getTemp() {
		return temp;
	}


	public void setTemp(int temp) {
		this.temp = temp;
	}


	public int getRain() {
		return rain;
	}


	public void setRain(int rain) {
		this.rain = rain;
	}


	@Override
	public String toString() {
		return "Weather [region=" + region + ", wind=" + wind + ", temp=" + temp + ", rain=" + rain + "]";
	}
	
	
}
