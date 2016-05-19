package com.xling123.manager.util.agent;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @version 1.0.0
 * @ClassName DeviceType
 * @category
 * @since 2016-5-19
 */
public enum DeviceType {
    COMPUTER("Computer"),

    MOBILE("Mobile"),

    TABLET("Tablet"),

    GAME_CONSOLE("Game console"),

    DMR("Digital media receiver"),

    UNKNOWN("Unknown");

    String name;

    private DeviceType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
