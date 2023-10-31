package pageRepository;

import com.microsoft.playwright.*;
import objectRepository.GoogleSearchObjects;

public class GoogleSearch {
	private final Page page;

	public GoogleSearch(Page page) {
		this.page = page;
	}

	public void searchBox(){
		page.locator(GoogleSearchObjects.searchBox).fill("Mountains");
	}
}