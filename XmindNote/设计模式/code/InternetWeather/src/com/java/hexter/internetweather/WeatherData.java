package com.java.hexter.internetweather;

// 提供接口
// 一般为独立的进程，一直保持运行
public class WeatherData {

    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;
    // 添加公告板成员，允许第三方公告板接入
    private CurrentConditions mCurrentConditions;

    // 获取传入的第三方公告板
    public WeatherData(CurrentConditions mCurrentConditions) {
        this.mCurrentConditions = mCurrentConditions;
    }

    public float getTemperature() {
        return mTemperatrue;

    }

    public float getPressure() {
        return mPressure;

    }

    public float getHumidity() {
        return mHumidity;

    }

    // 接口数据改变时更新公告板数据
    // 存在变化性，也要抽象成接口和类的实现
    public void dataChange() {
        mCurrentConditions.update(getTemperature(), getPressure(), getHumidity());
    }

    // 在set中表明数据发生改变，主动调用更新并通知公告板
    public void setData(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperatrue = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }

}
