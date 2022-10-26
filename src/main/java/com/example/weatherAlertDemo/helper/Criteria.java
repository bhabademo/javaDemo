package com.example.weatherAlertDemo.helper;

public enum Criteria {
    GT("greater"),
    LT("lesser"),
    EQ("equal");

    private String value;
    Criteria(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
