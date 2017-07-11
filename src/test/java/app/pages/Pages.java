package app.pages;

import app.core.AppManager;
import lombok.Data;

@Data
public class Pages
{
    private AppManager app;
    public Pages(AppManager app)
    {
        this.app=app;
    }
    protected String url = "https://libertex-fxb3-test.web.test.fxclub.org";;
}
