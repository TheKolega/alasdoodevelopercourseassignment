package utils;

public enum BrowsersEnum {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    IEXPLORER("iexplorer"),
    OPERA("opera"),
    SAFARI("safari"),
    APPIUM("appium"),
    PHANTOMJS("phantomjs"),
    CHROME_IN_DOCKER("chrome-in-docker"),
    FIREFOX_IN_DOCKER("firefox-in-docker"),
    OPERA_IN_DOCKER("opera-in-docker"),
    ANDROID("android");

    private String stringValue;

    BrowsersEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

}
