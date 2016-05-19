package com.xling123.manager.util.agent;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @version 1.0.0
 * @ClassName BrowserType
 * @category
 * @since 2016-5-19
 */

public enum BrowserType {
    WEB_BROWSER("Browser"),

    MOBILE_BROWSER("Browser (mobile)"),

    TEXT_BROWSER("Browser (text only)"),

    EMAIL_CLIENT("Email Client"),

    ROBOT("Robot"),

    TOOL("Downloading tool"),

    APP("Application"),
    UNKNOWN("unknown");

    private String name;

    private BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
