package com.java.hexter.internetweather;

public class InternetWeather {

    public static void main(String[] args) {
        CurrentConditions mCurrentConditions;
        WeatherData mWeatherData;

        // 公告板
        mCurrentConditions = new CurrentConditions();
        // 公告板传入接口
        mWeatherData = new WeatherData(mCurrentConditions);

        // 模拟气象站数据
        mWeatherData.setData(30, 150, 40);
    }

}
