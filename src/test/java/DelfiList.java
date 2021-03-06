import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class DelfiList {
    private final By ARTICLE_TITLE = By.xpath(".//a[@class ='top2012-title']");
    private final By ARTICLE_TITLE_MOBILE = By.xpath(".//a[@class ='md-scrollpos']");
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final String HOME_PAGE_MOBILE = "http://m.rus.delfi.lv/";
    WebDriver browser;
    @Test
    public void delfiFirstTitleTest() {
        List<WebElement> webArticles = new ArrayList<WebElement>();
        List<String> articles = new ArrayList<String>();
        articles.add("В Даугавпилсской думе фактически развалилась коалиция; \"Согласие\" возвращает влияние");
        articles.add("Троицкий: Латвия и Эстония ошиблись, обращаясь с русскоязычными жителями высокомерно");
        articles.add("Из первых уст: 8 наблюдений о разнице жизни в Риге и Санкт-Петербурге");
        articles.add("В расследовании убийства Бункуса Латвии помогут Польша, Германия и другие страны");
        articles.add("Латвийский фигурист Васильев стал победителем соревнований в Минске");

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        browser.get(HOME_PAGE);
        webArticles = browser.findElements(ARTICLE_TITLE);
        Assertions.assertFalse(webArticles.isEmpty(),"Wrong article title");

          for (int i = 0; i < 5; i++) {
              Assertions.assertEquals(webArticles.get(i).getText(), articles.get(i), "Error with cycle ");
          }
          browser.get(HOME_PAGE_MOBILE);
          webArticles = browser.findElements(ARTICLE_TITLE_MOBILE);
          Assertions.assertFalse(webArticles.isEmpty(), "Wrong article title in mobile version");

          for (int i = 0; i < 5; i++) {
              Assertions.assertEquals(webArticles.get(i).getText(), articles.get(i), "Error with cycle for mobile version ");
          }
        }
    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
