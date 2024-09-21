package testplaywright;

import com.microsoft.playwright.*;

public class PlaywrightTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/v1/");
            System.out.println(page.title());
            browser.close();
        }
    }
}

