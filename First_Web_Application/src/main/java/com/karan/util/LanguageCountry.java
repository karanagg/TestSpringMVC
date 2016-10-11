package com.karan.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LanguageCountry {

	private Map<Language, List<String>> languageListMap;

    private Map<String, List<Language>> countryLanguagesMap;

    public void setLanguageListMap(Map<Language, List<String>> languageListMap) {
        this.languageListMap = languageListMap;
    }

    public List<Language> getLanguages(String countryCode) {
    	  System.out.println();
    			  
        List<Language> languages = new ArrayList<Language>();
        System.out.println("Inside Get languages"+countryCode);
        System.out.println("Inside Get lanuguages andlanguageListMap"+languageListMap);
        System.out.println("Language"+languages);
        
        if (languageListMap == null || languageListMap.isEmpty() || countryCode == null || countryCode.isEmpty()) {
            return languages;
        }

        if(countryLanguagesMap == null || countryLanguagesMap.size() == 0){
        	System.out.println("initn invoked");
            initCountryLanguagesMap();
        }
        System.out.println("Coutnry code"+countryLanguagesMap.get(countryCode));
        return countryLanguagesMap.get(countryCode);
    }


    private void initCountryLanguagesMap(){
        countryLanguagesMap = new HashMap<String, List<Language>>();
        for(Language language : languageListMap.keySet()){
            List<String> countryList = languageListMap.get(language);
            System.out.println("countryList"+countryList);
            for(String countryCode : countryList){
                if(!countryLanguagesMap.containsKey(countryCode)){
                    countryLanguagesMap.put(countryCode, new ArrayList<Language>());
                }
              //   System.out.println("countryLanguageMap"+countryLanguagesMap);
                 
                List<Language> languages = countryLanguagesMap.get(countryCode);

                if(!languages.contains(language)){
                    languages.add(language);
                }
            }
        }
    }
	
	
}
