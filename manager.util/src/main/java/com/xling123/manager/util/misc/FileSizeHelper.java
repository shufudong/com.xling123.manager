/**
 * Copyright 2016 www.xling123.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xling123.manager.util.misc;

import java.text.DecimalFormat;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @ClassName FileSizeHelper
 * @category 文件大小工具类.
 * @since 2016-05-18
 */
public class FileSizeHelper {
    public static long ONE_KB = 1024;
    public static long ONE_MB = ONE_KB * 1024;
    public static long ONE_GB = ONE_MB * 1024;
    public static long ONE_TB = ONE_GB * (long) 1024;
    public static long ONE_PB = ONE_TB * (long) 1024;

    public static String getHumanReadableFileSize(Long fileSize) {
        if (fileSize == null) return null;
        return getHumanReadableFileSize(fileSize.longValue());
    }

    public static String getHumanReadableFileSize(long fileSize) {
        if (fileSize < 0) {
            return String.valueOf(fileSize);
        }
        String result = getHumanReadableFileSize(fileSize, ONE_PB, "PB");
        if (result != null) {
            return result;
        }

        result = getHumanReadableFileSize(fileSize, ONE_TB, "TB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_GB, "GB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_MB, "MB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_KB, "KB");
        if (result != null) {
            return result;
        }
        return String.valueOf(fileSize) + "B";
    }

    private static String getHumanReadableFileSize(long fileSize, long unit, String unitName) {
        if (fileSize == 0) return "0";

        if (fileSize / unit >= 1) {
            double value = fileSize / (double) unit;
            DecimalFormat df = new DecimalFormat("######.##" + unitName);
            return df.format(value);
        }
        return null;
    }
}
