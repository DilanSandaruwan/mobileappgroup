package com.example.databasewithapi1;

public class WeatherDetail {
    private String CITY_str ;
    private String LOCT_str ;
    private Double TEMP_str ;
    private Double WIND_str ;
    private String COND_str ;

//    public WeatherDetail(String x1,String x2,Double x3,Double x4,String x5){
//        this.CITY_str=x1;
//        this.LOCT_str=x2;
//        this.TEMP_str=x3;
//        this.WIND_str=x4;
//        this.COND_str=x5;
//    }

    public String getCITY_str() {
        return CITY_str;
    }

    public void setCITY_str(String CITY_str) {
        this.CITY_str = CITY_str;
    }

    public String getLOCT_str() {
        return LOCT_str;
    }

    public void setLOCT_str(String LOCT_str) {
        this.LOCT_str = LOCT_str;
    }

    public Double getTEMP_str() {
        return TEMP_str;
    }

    public void setTEMP_str(Double TEMP_str) {
        this.TEMP_str = TEMP_str;
    }

    public Double getWIND_str() {
        return WIND_str;
    }

    public void setWIND_str(Double WIND_str) {
        this.WIND_str = WIND_str;
    }

    public String getCOND_str() {
        return COND_str;
    }

    public void setCOND_str(String COND_str) {
        this.COND_str = COND_str;
    }
}
