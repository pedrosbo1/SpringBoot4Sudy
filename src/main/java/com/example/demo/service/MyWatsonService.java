package com.example.demo.service;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import org.springframework.stereotype.Component;

@Component
public class MyWatsonService {

    public String callWatson(String text){
        String text2 = text;
        IamOptions options = new IamOptions.Builder()
                .apiKey("uyHj0mhgrFXcZKZsWlKEQtBE01sWXLdZN5rCSlI0cFcl")
                .build();
        ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2019-01-09", options);

        toneAnalyzer.setEndPoint("https://gateway.watsonplatform.net/tone-analyzer/api");


        System.out.println("chegou aqui!");

       /* String text = "Team, I know that times are tough! Product "
                + "sales have been disappointing for the past three "
                + "quarters. We have a competitive product, but we "
                + "need to do a better job of selling it!";*/
        //String text = "Eu estou muito feliz de conseguir realizar essa chamada na api";


        ToneOptions toneOptions = new ToneOptions.Builder()
                .text(text)
                .build();

        ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();
        System.out.println(toneAnalysis);
        return toneAnalysis.toString();
    }
}
