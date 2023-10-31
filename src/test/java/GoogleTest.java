import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.*;
import pageRepository.GoogleSearch;

public class GoogleTest {

	private static Page page;
	private static final Logger log = (Logger) LogManager.getLogger(GoogleTest.class);
	@BeforeSuite
	public void setUp() {
		log.info("Setting up Browser");
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		log.info("Browser started");
	}

	@AfterSuite
	public void tearDown(){
		page.close();
		log.info("Closing Browser");
	}

	@Test
	public void google() {
		GoogleSearch googleSearch = new GoogleSearch(page);

		page.navigate("https://www.google.co.in/");
		log.info("Navigated to Google search page");
		googleSearch.searchBox();
		log.info("Entered Mountains in search box");
		page.locator(".gLFyf").press("Enter");
		log.info("Clicking on enter to search");
	}
}