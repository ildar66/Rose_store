package com.overstar.ildar.ibank.servlets.util;

import javax.servlet.http.*;

/** Cookie that persists 1 year. Default Cookie doesn't
 *  persist past current session.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2000 Marty Hall; may be freely used or adapted.
 */

public class LongLivedCookie extends javax.servlet.http.Cookie {
    public static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;
    /**
     * LongLivedCookie constructor comment.
     * @param name java.lang.String
     * @param value java.lang.String
     */
    public LongLivedCookie(String name, String value) {
        super(name, value);
        setMaxAge(SECONDS_PER_YEAR);
    }
}
