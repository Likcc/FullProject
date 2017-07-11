package app.core;

import app.pages.Pages;
import org.testng.annotations.BeforeSuite;

/**
 * Created by daniil.ryabov on 11.07.2017.
 */
public class TestBase extends Pages {

    public TestBase(AppManager app) {
        super(app);
    }

    @BeforeSuite
    private void init(){
    }
}
