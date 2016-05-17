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

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @ClassName SystemPath
 * @category 得到当前应用的系统路径
 * @since 2016-05-18
 */
public class SystemPath {

    public static String getSysPath() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        String temp = path.replaceFirst("file:/", "").replaceFirst(
                "WEB-INF/classes/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        String temp = path.replaceFirst("file:/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    public static String getSystempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getSeparator() {
        return System.getProperty("file.separator");
    }

    public static void main(String[] args) {
        System.out.println(getSysPath());
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(getSeparator());
        System.out.println(getClassPath());
    }
}
