package com.xling123.manager.util.agent;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @version 1.0.0
 * @ClassName ApplicationType
 * @category
 * @since 2016-5-19
 */
public enum ApplicationType {
    WEBMAIL("Webmail client"),
    UNKNOWN("unknown");

    private String name;

    private ApplicationType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
