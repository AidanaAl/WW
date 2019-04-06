package ww.tests.Vlad;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ww.pages.WwPage;

import java.util.ArrayList;
import java.util.List;

import static ww.utilities.Driver.getDriver;

public class WW {

    @Test
    public static void test1() throws InterruptedException {
        //    1. Navigate to https://www.weightwatchers.com/us/
        WwPage wwPage = new WwPage();
        wwPage.openUrl();
        //    2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
        Assert.assertTrue(getDriver().getTitle().equals("WW (Weight Watchers): Weight Loss & Wellness Help"));
//    3. On the right corner of the page, click on “Find a Studio”
        wwPage.findAStudio.click();

//    4. Verify loaded page title contains "Find a Studio & Meeting Near You | WW USA"
        System.out.println(getDriver().getTitle());
       // Assert.assertTrue(Driver.getDriver().getTitle().contains("Find a Studio & Meeting Near You | WW USA"));

//    5. In the search field, search for studios for zip code: 10011
        wwPage.searhBox.sendKeys("10011");
        wwPage.searchButton.click();
//    6. Print the title of the first result and the distance
        System.out.println("Title of the first result: "+wwPage.firstResult.getText());
        System.out.println("Distance of the first result: "+wwPage.firstDistance.getText());
//    7. Click on the first search result and you should see names of the person conducting
//        the meeting on the scheduled time right under time for each day.
//        Create a method that would take a weekday as parameter e.g.
//        Sun, Mon, Tue....Sat and the method should print out the names(s) and the number of times each person(s) is
//         conducting the meeting that particular day.
        wwPage.firstResult.click();
        Thread.sleep(3000);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        getScheduleSummary("Sat");


   }
   public static void getScheduleSummary(String day){
        List<String> list = new ArrayList<>();
       int count=1;
       switch (day){
           case "Sun":
               for(int i=1; i<=2; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }
           case "Mon":
               for(int i=3; i<=5; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }
           case "Tue":
               for(int i=6; i<=9; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }
           case "Wed":
               for(int i=10; i<=12; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }
           case "Thu":
               for(int i=13; i<=17; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }
           case "Fri":
               for(int i=18; i<=19; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }
           case "Sat":
               for(int i=20; i<=22; i++){
                   list.add(getDriver().findElement(By.xpath("(//div[@class='schedule-detailed-day-meetings-item-leader'])["+i+"]")).getAttribute("innerHTML"));
               }

       }
       for(String name: list){
           for(int i=1; i<=list.size()-1; i++){
               if(name.equalsIgnoreCase(list.get(i))){
                   count++;
               }
           }
           System.out.println("Name: "+name+ " Total: "+ count+" times");
           count=0;
       }

   }




}
