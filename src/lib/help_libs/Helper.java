package lib.help_libs;

import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by daniil.ryabov on 10.07.2017.
 */
public class Helper {
    public static StringBuilder RandStr()
    {
        String symbols = "qwertyabcdefgj";
        StringBuilder randString = new StringBuilder();
        Random rnd = new Random();
        int count = rnd.nextInt(10)+10;
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString;
    }
    public static boolean isDisplayed(WebElement input)
    {
        try
        {
            input.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }
        return true;
    }
}
