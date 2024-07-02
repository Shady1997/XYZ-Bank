package testWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumSpeedSetter {
    private Duration originalSpeed;
    private WebDriver driver; // Assuming you have initialized your WebDriver instance

    // Method to set Selenium speed
    public Duration setSeleniumSpeed(Duration value) {
        // Store the original speed
        originalSpeed = getSeleniumSpeed();

        // Set the new speed
        _setSeleniumSpeed(value);

        // Return the original speed
        return originalSpeed;
    }

    // Method to get the current Selenium speed
    public Duration getSeleniumSpeed() {
        // Return the original speed if it's available
        if (originalSpeed != null) {
            return originalSpeed;
        } else {
            // Return a default speed value if original speed is not set
            return Duration.ofSeconds(1); // Assuming default speed is 1 second
        }
    }

    // Internal method to actually set the speed
    private void _setSeleniumSpeed(Duration value) {
        // Convert duration to milliseconds
        long milliseconds = value.toMillis();

        // Apply the speed to the WebDriver instance
        // Below is an example of applying implicit wait time, you might need to adjust based on your needs
        driver.manage().timeouts().implicitlyWait(milliseconds, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    // Example usage
    public static void main(String[] args) {
        SeleniumSpeedSetter speedSetter = new SeleniumSpeedSetter();
        Duration newSpeed = Duration.ofSeconds(2); // Example: setting speed to 2 seconds
        Duration oldSpeed = speedSetter.setSeleniumSpeed(newSpeed);
        System.out.println("Previous Selenium Speed: " + oldSpeed);
    }
}
