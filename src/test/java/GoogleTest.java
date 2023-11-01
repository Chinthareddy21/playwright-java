import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.*;
import pageRepository.*;

public class GoogleTest {

	private static Page page;
	private static final Logger log = (Logger) LogManager.getLogger(GoogleTest.class);
	@BeforeSuite
	public void setUp() {
		log.info("Setting up Browser");
		Browser browser =
				Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		log.info("Browser started");
	}

	@AfterSuite
	public void tearDown(){
		page.close();
		log.info("Closing Browser");
	}

	@Test(priority = 1)
	public void google() {
		GoogleSearch googleSearch = new GoogleSearch(page);

		googleSearch.navigation();
		log.info("Navigated to Google search page");
		googleSearch.searchBox();
		log.info("Entered Mountains in search box");
		googleSearch.searchBoxEnter();
		log.info("Clicking on enter to search");
	}

	@Test(priority = 2)
	public void google2() {
		GoogleSearch googleSearch = new GoogleSearch(page);

		page.goBack();
		log.info("Navigated to Google search page");
		googleSearch.searchBox();
		log.info("Entered Mountains in search box");
		googleSearch.searchBoxEnter();
		log.info("Clicking on enter to search");
	}


}