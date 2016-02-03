package net.smartrss.admin.view.app;

import net.smartrss.admin.view.home.HomePage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by Alexander on 28.01.2016.
 */
public class AnalyzerWebApplication extends WebApplication {


    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

}
