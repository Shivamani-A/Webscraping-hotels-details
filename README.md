**About the project**

This project is a Java-based web scraper that automates the process of collecting hotel details (such as name, price, rating, etc.) from a hotel booking website using Selenium WebDriver.

**Features**

Extracts hotel information such as:
Hotel name
Price per night
Ratings and reviews
Available amenities
Automatically scrolls through the webpage to load more hotel listings.
Exports scraped data into a structured format (JSON).
Configurable for different hotel booking websites by modifying locators and scripts.


**Technologies Used**

Java: Programming language for writing the scraper.
Selenium WebDriver: Tool for automating web browser interactions.
Maven: Dependency management and build automation tool.
Apache POI/CSV Library: For exporting scraped data (optional, depending on output format).


**Prerequisites**

Java 8+ installed on your system. Download Java
Maven for dependency management. Install Maven
Selenium WebDriver and browser driver (e.g., ChromeDriver or GeckoDriver) installed.
(Optional) IDE like IntelliJ IDEA or Eclipse for easy project management.



**Getting Started**

Clone the Repository
bash
Copy code
git clone https://github.com/yourusername/hotel-web-scraper.git
cd hotel-web-scraper
Set Up the Project
Install Dependencies: Make sure all required dependencies (such as Selenium) are included in your pom.xml. If not, add the following dependencies:
Download WebDriver: Download the appropriate WebDriver for your browser (e.g., ChromeDriver for Chrome). Place the WebDriver executable in a known location and update the path in your project.



**Run the Scraper**
Modify the URL in the HotelScraper.java file to the hotel booking website you wish to scrape.
Adjust the locators in the code to match the HTML structure of the website (e.g., XPath, CSS selectors).
Run the scraper via your IDE 
