package com.xling123.manager.util.agent;

import java.io.Serializable;

public class Agent implements Serializable {
    private static final long serialVersionUID = 7025462762784240212L;
    private OperatingSystem operatingSystem = OperatingSystem.UNKNOWN;
    private Browser browser = Browser.UNKNOWN;
    private int id;
    private String userAgentString;

    public Agent(OperatingSystem operatingSystem, Browser browser) {
        this.operatingSystem = operatingSystem;
        this.browser = browser;
        this.id = ((operatingSystem.getId() << 16) + browser.getId());
    }

    public Agent(String userAgentString) {
        Browser browser = Browser.parseUserAgentString(userAgentString);

        OperatingSystem operatingSystem = OperatingSystem.UNKNOWN;

        if (browser != Browser.BOT) {
            operatingSystem = OperatingSystem.parseUserAgentString(userAgentString);
        }
        this.operatingSystem = operatingSystem;
        this.browser = browser;
        this.id = ((operatingSystem.getId() << 16) + browser.getId());
        this.userAgentString = userAgentString;
    }

    public static Agent parseUserAgentString(String userAgentString) {
        return new Agent(userAgentString);
    }

    public Version getBrowserVersion() {
        return this.browser.getVersion(this.userAgentString);
    }

    public OperatingSystem getOperatingSystem() {
        return this.operatingSystem;
    }

    public Browser getBrowser() {
        return this.browser;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return this.operatingSystem.toString() + "-" + this.browser.toString();
    }

    public static Agent valueOf(int id) {
        OperatingSystem operatingSystem = OperatingSystem.valueOf((short) (id >> 16));
        Browser browser = Browser.valueOf((short) (id & 0xFFFF));
        return new Agent(operatingSystem, browser);
    }

    public static Agent valueOf(String name) {
        if (name == null) {
            throw new NullPointerException("Name is null");
        }
        String[] elements = name.split("-");

        if (elements.length == 2) {
            OperatingSystem operatingSystem = OperatingSystem.valueOf(elements[0]);
            Browser browser = Browser.valueOf(elements[1]);
            return new Agent(operatingSystem, browser);
        }

        throw new IllegalArgumentException(
                "Invalid string for userAgent " + name);
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.browser == null ? 0 : this.browser.hashCode());
        result = 31 * result + this.id;
        result = 31 * result + (
                this.operatingSystem == null ? 0 : this.operatingSystem.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agent other = (Agent) obj;
        if (this.browser == null) {
            if (other.browser != null)
                return false;
        } else if (!this.browser.equals(other.browser))
            return false;
        if (this.id != other.id)
            return false;
        if (this.operatingSystem == null) {
            if (other.operatingSystem != null)
                return false;
        } else if (!this.operatingSystem.equals(other.operatingSystem))
            return false;
        return true;
    }
}
