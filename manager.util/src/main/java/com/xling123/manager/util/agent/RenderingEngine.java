package com.xling123.manager.util.agent;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @version 1.0.0
 * @ClassName RenderingEngine
 * @category
 * @since 2016-5-19
 */
public enum RenderingEngine {
    TRIDENT("Trident"),

    WORD("Microsoft Office Word"),

    GECKO("Gecko"),

    WEBKIT("WebKit"),

    PRESTO("Presto"),

    MOZILLA("Mozilla"),

    KHTML("KHTML"),

    OTHER("Other");

    String name;

    private RenderingEngine(String name) {
        this.name = name;
    }
}
