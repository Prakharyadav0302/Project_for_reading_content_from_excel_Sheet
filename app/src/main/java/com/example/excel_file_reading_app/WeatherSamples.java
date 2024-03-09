package com.example.excel_file_reading_app;

public class WeatherSamples{
    String month;
    int rainfall;
    int sun;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getRainfall() {
        return rainfall;
    }

    public void setRainfall(int rainfall) {
        this.rainfall = rainfall;
    }

    @Override
    public String toString() {
        return "WeatherSamples{" +
                "month='" + month + '\'' +
                ", rainfall='" + rainfall + '\'' +
                ", sun='" + sun + '\'' +
                '}';
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }
}
