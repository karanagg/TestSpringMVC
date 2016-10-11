/*
 * Copyright (c) 2011 by Cochlear Limited
 * This work is copyright. With the exception of use permitted by law (under
 * the Copyright Act 1968), no part of this work may be reproduced without the
 * express written permission of Cochlear Limited.  Requests for
 * reproduction should be directed to: the Intellectual Property Manager,
 * Cochlear Limited, PO BOX 1444, Macquarie Centre NSW 2113, AUSTRALIA or
 * email: IPInstructor@cochlear.com.
 */

package com.karan.util;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;


public enum Language {

    
    DEFAULT("", ""),
    DUTCH("nl", ""),
    DUTCH_BELGIUM("nl_BE", "language.belgium"),
    DUTCH_NETHERLANDS("nl_NL", "language.holland"),
    ENGLISH("en", ""),
    ENGLISH_AUSTRALIA("en_AU", "language.australia"),
    ENGLISH_CANADA("en_CA", "language.ca"),
    ENGLISH_UNITED_KINGDOM("en_GB", "language.uk"),
    ENGLISH_UNITED_STATES("en_US", "language.us"),
    KOREAN("ko", ""),
    KOREAN_SOUTH_KOREA("ko_KR", "language.korea"),
    GERMAN("de", ""),
    GERMAN_GERMANY("de_DE", "language.german"),
    FRENCH("fr", ""),
    FRENCH_FRANCE("fr_FR", "language.french"),
	FRENCH_CANADA("fr_CA", "language.french_canada"),
    ITALIAN("it", ""),
    ITALIAN_ITALY("it_IT", "language.italy"),
    SWEDISH("sv", ""),
    SWEDISH_SWEDEN("sv_SE", "language.sweden"),
    TURKISH("tr", ""),
    TURKISH_TURKEY("tr_TR", "language.turkey"),
    JAPANESE("ja", ""),
    JAPANESE_JAPAN("ja_JP", "language.japan"),
    CHINESE("zh", ""),
    CHINESE_CHINA("zh_CN", "language.chinese"),
    CHINESE_TAIWAN("zh_TW", "language.chinese_taiwan"),
    ARABIC_SOUTH_ARABIA("ar_SA","language.arabic"),
    RUSSIAN_RUSSIAN("ru_RU","language.russian");

    private static final Map<String, Language> all = new HashMap<String, Language>();

    static {
        for (Language language : EnumSet.allOf(Language.class)) {
            all.put(language.getCode(), language);
        }
        System.out.println("Static executed"); 
    }

    public static Language fromCode(final String code) {
        Assert.notNull(code, "String code is null");
        if (!all.containsKey(code)) {
            throw new IllegalArgumentException("Not a valid Language code: " + code);
        }
        return all.get(code);
    }

    public static List<Language> listAll() {
        Map<String, Language> map = removeUnused();
        return new ArrayList<Language>(map.values());
    }

    private static Map<String, Language> removeUnused() {
        Map<String, Language> map = new HashMap<String, Language>(all);
        map.remove(""); // remove DEFAULT
        map.remove("nl");
        map.remove("en");
        map.remove("ko");
        map.remove("de");
        map.remove("fr");
        map.remove("it");
        map.remove("sv");
        map.remove("tr");
        map.remove("ja");
        map.remove("zh");
        return map;
    }

    private String code;
    private String name;
    private String translation;

    private Language(final String code, final String name) {
        this.code = code;
        this.name = name;
    }


    public String getCode() {
        return code;
    }

  
    public String getName() {
        return name;
    }


    public String getTranslation() {
        return translation;
    }


    public void setTranslation(final String translation) {
        this.translation = translation;
    }

}
