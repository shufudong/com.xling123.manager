package com.xling123.manager.util.misc;

import com.xling123.manager.util.agent.Agent;
import com.xling123.manager.util.agent.Browser;
import com.xling123.manager.util.agent.DeviceType;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @version 1.0.0
 * @ClassName UserAgentUtils
 * @category 用户代理字符串识别工具
 * @since 2016-5-19
 */
public class UserAgentUtils {

    /**
     * getUserAgent
     *
     * @param request
     * @return Agent
     * @category: 获取用户代理对象
     */
    public static Agent getUserAgent(HttpServletRequest request) {
        return Agent.parseUserAgentString(request.getHeader("User-Agent"));
    }

    /**
     * getDeviceType
     *
     * @param request
     * @return DeviceType
     * @category: 获取设备类型
     */
    public static DeviceType getDeviceType(HttpServletRequest request) {
        return getUserAgent(request).getOperatingSystem().getDeviceType();
    }

    /**
     * isComputer
     *
     * @param request
     * @return boolean
     * @category: 是否是PC
     */
    public static boolean isComputer(HttpServletRequest request) {
        return DeviceType.COMPUTER.equals(getDeviceType(request));
    }

    /**
     * isMobile
     *
     * @param request
     * @return boolean
     * @category: 是否是手机
     */
    public static boolean isMobile(HttpServletRequest request) {
        return DeviceType.MOBILE.equals(getDeviceType(request));
    }

    /**
     * isTablet
     *
     * @param request
     * @return boolean
     * @category: 是否是平板
     */
    public static boolean isTablet(HttpServletRequest request) {
        return DeviceType.TABLET.equals(getDeviceType(request));
    }

    /**
     * isMobileOrTablet
     *
     * @param request
     * @return boolean
     * @category: 是否是手机和平板
     */
    public static boolean isMobileOrTablet(HttpServletRequest request) {
        DeviceType deviceType = getDeviceType(request);
        return DeviceType.MOBILE.equals(deviceType) || DeviceType.TABLET.equals(deviceType);
    }

    /**
     * getBrowser
     *
     * @param request
     * @return Browser
     * @category: 获取浏览类型
     */
    public static Browser getBrowser(HttpServletRequest request) {
        return getUserAgent(request).getBrowser();
    }

    /**
     * isLteIE8
     *
     * @param request
     * @return boolean
     * @category: 是否IE版本是否小于等于IE8
     */
    public static boolean isLteIE8(HttpServletRequest request) {
        Browser browser = getBrowser(request);
        return Browser.IE5.equals(browser) || Browser.IE6.equals(browser)
                || Browser.IE7.equals(browser) || Browser.IE8.equals(browser);
    }
}
