package org.playtech.test;

import org.apache.wicket.protocol.http.WebApplication;
import org.playtech.test.view.HomePage;

/**
 * Created by Alexander on 28.01.2016.
 */
public class AnalyzerWebApplication extends WebApplication {


    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

}
