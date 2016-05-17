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

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassName BaseException
 * @category 关于异常的工具类.
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @since 2016-05-18
 * @version
 */
public class BaseException {

        /**
         * 将CheckedException转换为UncheckedException.
         */
        public static RuntimeException unchecked(Exception e) {
            if (e instanceof RuntimeException) {
                return (RuntimeException) e;
            } else {
                return new RuntimeException(e);
            }
        }

        /**
         * 将ErrorStack转化为String.
         */
        public static String getStackTraceAsString(Throwable e) {
            if (e == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        /**
         * 判断异常是否由某些底层的异常引起.
         */
        public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
            Throwable cause = ex.getCause();
            while (cause != null) {
                for (Class<? extends Exception> causeClass : causeExceptionClasses) {
                    if (causeClass.isInstance(cause)) {
                        return true;
                    }
                }
                cause = cause.getCause();
            }
            return false;
        }

        /**
         * 在request中获取异常类
         *
         * @param request
         * @return
         */
        public static Throwable getThrowable(HttpServletRequest request) {
            Throwable ex = null;
            if (request.getAttribute("exception") != null) {
                ex = (Throwable) request.getAttribute("exception");
            } else if (request.getAttribute("javax.servlet.error.exception") != null) {
                ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
            }
            return ex;
        }
}
