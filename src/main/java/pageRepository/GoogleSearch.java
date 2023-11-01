package pageRepository;

import com.microsoft.playwright.*;
import credentials.credentials;
import objectRepository.GoogleSearchObjects;
import urls.url;

public class GoogleSearch {
	private final Page page;

	public GoogleSearch(Page page) {
		this.page = page;
	}

	public void navigation(){
		page.navigate(url.searchPage);
	}

	public void searchBox(){
		page.locator(GoogleSearchObjects.searchBox).fill(credentials.searchText);
	}

	public void searchBox2(){
		page.locator(GoogleSearchObjects.searchBox).fill(credentials.searchText2);
	}

	public void searchBoxEnter(){
		page.locator(GoogleSearchObjects.searchBox).press(credentials.enterKey);
	}
}