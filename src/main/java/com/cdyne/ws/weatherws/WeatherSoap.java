package com.cdyne.ws.weatherws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.8.redhat-7
 * 2014-06-03T19:25:29.143-05:00
 * Generated source version: 2.6.8.redhat-7
 * 
 */
@WebService(targetNamespace = "http://ws.cdyne.com/WeatherWS/", name = "WeatherSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface WeatherSoap {

    /**
     * Allows you to get your City's Weather, which is updated hourly. U.S. Only
     */
    @WebResult(name = "GetCityWeatherByZIPResult", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
    @RequestWrapper(localName = "GetCityWeatherByZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "com.cdyne.ws.weatherws.GetCityWeatherByZIP")
    @WebMethod(operationName = "GetCityWeatherByZIP", action = "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP")
    @ResponseWrapper(localName = "GetCityWeatherByZIPResponse", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "com.cdyne.ws.weatherws.GetCityWeatherByZIPResponse")
    public com.cdyne.ws.weatherws.WeatherReturn getCityWeatherByZIP(
        @WebParam(name = "ZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
        java.lang.String zip
    );

    /**
     * Gets Information for each WeatherID
     */
    @WebResult(name = "GetWeatherInformationResult", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
    @RequestWrapper(localName = "GetWeatherInformation", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "com.cdyne.ws.weatherws.GetWeatherInformation")
    @WebMethod(operationName = "GetWeatherInformation", action = "http://ws.cdyne.com/WeatherWS/GetWeatherInformation")
    @ResponseWrapper(localName = "GetWeatherInformationResponse", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "com.cdyne.ws.weatherws.GetWeatherInformationResponse")
    public com.cdyne.ws.weatherws.ArrayOfWeatherDescription getWeatherInformation();

    /**
     * Allows you to get your City Forecast Over the Next 7 Days, which is updated hourly. U.S. Only
     */
    @WebResult(name = "GetCityForecastByZIPResult", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
    @RequestWrapper(localName = "GetCityForecastByZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "com.cdyne.ws.weatherws.GetCityForecastByZIP")
    @WebMethod(operationName = "GetCityForecastByZIP", action = "http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP")
    @ResponseWrapper(localName = "GetCityForecastByZIPResponse", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "com.cdyne.ws.weatherws.GetCityForecastByZIPResponse")
    public com.cdyne.ws.weatherws.ForecastReturn getCityForecastByZIP(
        @WebParam(name = "ZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
        java.lang.String zip
    );
}
