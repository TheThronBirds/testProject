package only.luzejin.webservice.weather;

/**
 * 包名称only.luzejin.webservice.weather
 * 类名称testWeather
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/8/1 0:06
 **/
public class testWeather {

    public static void main(String[] args) {
        testWeather.getWeatherCities();
    }

    public static void getWeatherCities(){

        WeatherWebService weatherWebService = new WeatherWebService();
        WeatherWebServiceSoap soap = weatherWebService.getWeatherWebServiceSoap();
        ArrayOfString weatherCities = soap.getWeatherbyCityName("武汉");

        for(String city:weatherCities.getString()){
            System.out.println(city);
        }

    }
}
