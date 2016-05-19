package com.xling123.manager.util.misc;

import java.util.Calendar;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @version 1.0.0
 * @ClassName WorkDayUtil
 * @category
 * @since 2016-5-19
 */
public class WorkDayUtil {

    /**
     * getDaysBetween
     *
     * @param d1
     * @param d2
     * @return int
     * @category: 获取日期之间的天数
     */
    public int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(java.util.Calendar.DAY_OF_YEAR)
                - d1.get(java.util.Calendar.DAY_OF_YEAR);
        int y2 = d2.get(java.util.Calendar.YEAR);
        if (d1.get(java.util.Calendar.YEAR) != y2) {
            d1 = (java.util.Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
                d1.add(java.util.Calendar.YEAR, 1);
            } while (d1.get(java.util.Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * getWorkingDay
     *
     * @param d1
     * @param d2
     * @return int
     * @category: 获取工作日
     */
    public int getWorkingDay(java.util.Calendar d1, java.util.Calendar d2) {
        int result = -1;
        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int charge_start_date = 0;// 开始日期的日期偏移量
        int charge_end_date = 0;// 结束日期的日期偏移量
        // 日期不在同一个日期内
        int stmp;
        int etmp;
        stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
        etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);
        if (stmp != 0 && stmp != 6) {// 开始日期为星期六和星期日时偏移量为0
            charge_start_date = stmp - 1;
        }
        if (etmp != 0 && etmp != 6) {// 结束日期为星期六和星期日时偏移量为0
            charge_end_date = etmp - 1;
        }
        result = (getDaysBetween(this.getNextMonday(d1), this.getNextMonday(d2)) / 7)
                * 5 + charge_start_date - charge_end_date;
        return result;
    }

    /**
     * getChineseWeek
     *
     * @param date
     * @return java.lang.String
     * @category: 获取中文日期
     */
    public String getChineseWeek(Calendar date) {
        final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        return dayNames[dayOfWeek - 1];
    }

    /**
     * getNextMonday
     *
     * @param date
     * @return java.util.Calendar
     * @category: 获得日期的下一个星期一的日期
     */
    public Calendar getNextMonday(Calendar date) {
        Calendar result = null;
        result = date;
        do {
            result = (Calendar) result.clone();
            result.add(Calendar.DATE, 1);
        } while (result.get(Calendar.DAY_OF_WEEK) != 2);
        return result;
    }

    /**
     * getHolidays
     *
     * @param d1
     * @param d2
     * @return int
     * @category: 获取休息日
     */
    public int getHolidays(Calendar d1, Calendar d2) {
        return this.getDaysBetween(d1, d2) - this.getWorkingDay(d1, d2);
    }
}
