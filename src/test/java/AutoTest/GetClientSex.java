package AutoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GetClientSex {

    public WebDriver driver;
    public GetClientSex(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"operations-rest-processor-getClientSex\"]/div[2]/div/div[1]/div[2]/div/table/tbody/tr/td[2]/input")
    private WebElement strClientId;

    @FindBy(xpath = "//*[@id=\"operations-rest-processor-getClientSex\"]/div[2]/div/div[2]/button")
    private WebElement Execute;

    @FindBy(xpath = "//*[@id=\"operations-rest-processor-getClientSex\"]/div[2]/div/div[1]/div[1]/div[2]/button")
    private WebElement tryItOut;

    public void inputClientId(String id) {
        strClientId.sendKeys(id); }

    public void clickExecute() {
        Execute.click(); }

    public void clickTryItOut() {
        tryItOut.click(); }
}
