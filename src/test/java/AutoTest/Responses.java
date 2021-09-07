package AutoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Responses {

    public WebDriver driver;
    public Responses(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"operations-rest-processor-getClientSex\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/pre/code/span[5]")
    private WebElement clientId;

    @FindBy(xpath = "//*[@id=\"operations-rest-processor-getClientSex\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/pre/code/span[10]")
    private WebElement sex;

    @FindBy(xpath = "//*[@id=\"operations-rest-processor-getClientSex\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/div[1]")
    private WebElement Download;

    public String getUserId() {
        String userId = clientId.getText();
        return userId; }

    public String getUserSex() {
        String userSex = sex.getText();
        return userSex; }

    public void getDownload() {
        Download.click(); }
}