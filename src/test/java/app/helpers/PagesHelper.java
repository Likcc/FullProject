package app.helpers;

import app.core.AppManager;
import app.pages.RegPage;

public class PagesHelper {
    private AppManager app;
    public PagesHelper(AppManager app)
    {
        this.app=app;
    }
    private RegPage regPage;
    public RegPage regPage(){
        if(regPage == null){
            regPage = new RegPage(app);
        }
        return regPage;
    }
}
