package net.smartrss.admin.view;

import net.smartrss.admin.service.AnalyzeService;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alexander on 31.01.2016.
 */
public class AnalyzerPage extends WebPage {

    private AnalyzeService analyzeService;


    @Autowired
    public void setAnalyzeService(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }

}
