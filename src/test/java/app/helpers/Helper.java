package app.helpers;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by daniil.ryabov on 10.07.2017.
 */
public class Helper {
    public static String randStr()
    {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randString = new StringBuilder();
        Random rnd = new Random();
        int count = rnd.nextInt(10)+10;
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString+"";
    }

    public static String randStr(int length)
    {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randString = new StringBuilder();
        for(int i=0;i<length;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString+"";
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

    public static boolean isDisplayed(ArrayList<WebElement> input)
    {
        boolean result = false;
        for(int i=0; i<input.size();i++)
        {
            try
            {
                input.get(i).isDisplayed();
            }
            catch (org.openqa.selenium.NoSuchElementException e)
            {
                result = result || false;
                continue;
            }
            result = result || true;
            break;
        }
        return result;
    }


}
