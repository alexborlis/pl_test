package org.playtech.test.view;

import org.apache.wicket.markup.html.WebPage;
import org.playtech.test.service.AnalyzeService;
import org.playtech.test.service.RealTimeAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alexander on 31.01.2016.
 */
public class HomePage extends WebPage {

    private AnalyzeService analyzeService;
    private RealTimeAnalyzeService realTimeAnalyzeService;


    @Autowired
    public void setAnalyzeService(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }

    @Autowired
    public void setRealTimeAnalyzeService(RealTimeAnalyzeService realTimeAnalyzeService) {
        this.realTimeAnalyzeService = realTimeAnalyzeService;
    }
}
