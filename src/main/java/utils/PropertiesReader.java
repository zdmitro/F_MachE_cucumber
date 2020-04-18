package utils;

import java.util.ResourceBundle;

public class PropertiesReader {

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public String getUrl() {
        return this.resourceBundle.getString("url");
    }

    public String getUrlAuth() {
        return this.resourceBundle.getString("urlAuth");
    }

    public String getUrlYourDetails() {
        return this.resourceBundle.getString("urlYourDetails");
    }

    public String getModuleBy() {
        return this.resourceBundle.getString("moduleBy");
    }

    public String getPageModel() {
        return this.resourceBundle.getString("pageModel");
    }

    public String getChromeDriverPass() {
        return resourceBundle.getString("chromedriver_pass");
    }

    public String getRegFilePath() {
        return this.resourceBundle.getString("regFilePath");
    }

}
