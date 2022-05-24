import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    @Test
    public void testMenuStartTitle() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id ='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));

        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testReadTheTitleInTheUpperRightCorner() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement h1 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1")
        );
        h1.click();

        String actualResult = h1.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testMenuSubmitNewLanguageTitle() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement menuSubmitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        String actualResult = menuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void testReadTheTitleOfTheSubtitleOfTheLastMenuItem() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement menuSubmitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

        menuSubmitNewLanguage.click();

        WebElement menuSubmitNewLanguageSubtitle = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a"));

        String actualResult = menuSubmitNewLanguageSubtitle.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testTheFirstiItemOfTheSubmenu() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement submenu09 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));

        String actualResult = submenu09.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testTheNamesOfTheCreators() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement theTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        theTeam.click();

        WebElement theTeamOliverSchade = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3"));

        WebElement theTeamGregorScheithauer = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[text()='Gregor Scheithauer']"));

        WebElement theTeamStefanScheler = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[text()='Stefan Scheler']"));

        String actualResult = theTeamOliverSchade.getText();
        String actualResult2 = theTeamGregorScheithauer.getText();
        String actualResult3 = theTeamStefanScheler.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    @Test
    public void testClickButtonSubmitLanguageError() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement clickSubmitLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']//input[@class='button']"));

        clickSubmitLanguage.click();

        WebElement uError = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        String actualResult = uError.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testTextImportant() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), " +
                "the easier it will be for us and the faster your language will show up on this page. " +
                "We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement TextImportant = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li"));

        String actualResult = TextImportant.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testMenuBrowseLanguages() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Language";
        String expectedResult2 = "Author";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement ClickBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul/li/a[@href='/abc.html']"));

        ClickBrowseLanguages.click();

        WebElement ColumnLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table/tbody/tr/th[@style='width: 40%;']"));

        WebElement ColumnAuthor = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table/tbody/tr/th[@style='width: 30%;']"));

        String actualResult = ColumnLanguage.getText();
        String actualResult2 = ColumnAuthor.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    @Test
    public void testTopListNewCommentsNoComments() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "New Comments";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement TopList = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul/li/a[@href='/toplist.html']"));

        TopList.click();

        WebElement NewComments = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul/li/a[@href='./newcomments.html']"));

        NewComments.click();

        WebElement NoComments = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));

        String actualResult = NoComments.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testImportantWhiteLettersBoldFontRedBackgroundAllLettersCapital() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html ";
        String expectedResult = "IMPORTANT:";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement Span = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span/b"));

        String actualResult = Span.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
