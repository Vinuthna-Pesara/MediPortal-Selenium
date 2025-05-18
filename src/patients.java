import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class patients{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            long start = System.currentTimeMillis(); 

            // 1. PATIENT REGISTRATION
            driver.get("file:///C:/Users/personal/Downloads/SeleniumApplication/index.html");
            driver.findElement(By.id("name")).sendKeys("Vinuthna");
            Thread.sleep(500);
            driver.findElement(By.id("gender")).sendKeys("Female");
            Thread.sleep(500);
            driver.findElement(By.id("dob")).sendKeys("2000-04-13");
            Thread.sleep(500);
            driver.findElement(By.id("address")).sendKeys("Hyderabad");
            Thread.sleep(500);
            driver.findElement(By.id("contact")).sendKeys("9876543210");
            Thread.sleep(500);
            driver.findElement(By.id("bloodGroup")).sendKeys("O+");
            Thread.sleep(500);
            driver.findElement(By.id("history")).sendKeys("No known conditions");
            Thread.sleep(500);
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(1000);
            System.out.println("Patient registered.");

            // 2. PATIENT PORTAL LOGIN
            driver.get("file:///C:/Users/personal/Downloads/SeleniumApplication/portal.html");
            driver.findElement(By.id("idno")).sendKeys("270172");
            Thread.sleep(500);
            driver.findElement(By.id("name")).sendKeys("Vinuthna");
            Thread.sleep(500);
            driver.findElement(By.cssSelector("button[type='submit']")).click(); // if submit button exists
            Thread.sleep(1000);
            System.out.println("Patient accessed portal.");

            // 3. DOCTOR ASSIGNS MEDICINE
            driver.get("file:///C:/Users/personal/Downloads/SeleniumApplication/doctor.html");
            driver.findElement(By.id("idno")).sendKeys("270172");
            Thread.sleep(500);
            driver.findElement(By.id("name")).sendKeys("Vinuthna");
            Thread.sleep(500);
            driver.findElement(By.id("prescription")).sendKeys("Paracetamol 500mg");
            Thread.sleep(500);
            driver.findElement(By.id("viewOrdersBtn")).click();
            Thread.sleep(500);
            driver.findElement(By.id("approveBtn")).click();
            Thread.sleep(1000);
            System.out.println("Doctor assigned prescription.");

            // 4. PHARMACIST DISPENSES MEDICINE
           driver.get("file:///C:/Users/personal/Downloads/SeleniumApplication/pharmacist.html");

            driver.findElement(By.id("idno")).sendKeys("270172");
            Thread.sleep(500);

            driver.findElement(By.id("name")).sendKeys("Vinuthna");
            Thread.sleep(500);
            driver.findElement(By.id("medicine")).sendKeys("Paracetamol 500mg"); 
            Thread.sleep(500);

            driver.findElement(By.id("viewOrdersBtn")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//button[text()='Send to Doctor']")).click();
            Thread.sleep(500);

            driver.findElement(By.id("approveBtn")).click();
            Thread.sleep(1000);

            System.out.println("Pharmacist dispensed medicine.");

            long end = System.currentTimeMillis();
            System.out.println("Submitted Successfully.");
            System.out.println("Total Time taken: " + (end - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
