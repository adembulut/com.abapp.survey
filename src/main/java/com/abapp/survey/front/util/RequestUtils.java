package com.abapp.survey.front.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestUtils {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final static DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;

    private final static Logger LOG = LoggerFactory.getLogger(RequestUtils.class);
    private final static Gson gson = new Gson();

    public static int getInt(HttpServletRequest request, String paramName, int defaultValue) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            return Integer.parseInt(value);
        } catch (Exception e) {

        }

        return defaultValue;
    }

    public static long getLong(HttpServletRequest request, String paramName, long defaultValue) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            return Long.parseLong(value);
        } catch (Exception e) {

        }

        return defaultValue;
    }

    public static double getDouble(HttpServletRequest request, String paramName, double defaultValue) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            return Double.parseDouble(value);
        } catch (Exception e) {

        }

        return defaultValue;
    }

    public static LocalDate getDate(HttpServletRequest request, String paramname, LocalDate defaultValue) {

        String value = request.getParameter(paramname);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            LocalDate localDate = LocalDate.parse(value, formatter);
            return localDate;
        } catch (Exception e) {
            LOG.error("::getDate param:{} value:{} e:{}", paramname, value, e);
        }

        return defaultValue;
    }

    public static LocalDate getDate(HttpServletRequest request, String paramname, LocalDate defaultValue,
                                    String pattern) {

        String value = request.getParameter(paramname);

        if (value == null)
            return defaultValue;

        value = value.trim();
        if (value.isEmpty())
            return defaultValue;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate localDate = LocalDate.parse(value, formatter);
            return localDate;
        } catch (Exception e) {
            LOG.error("::getDate param:{} value:{} e:{}", paramname, value, e);
        }

        return defaultValue;
    }

    public static LocalTime getTime(HttpServletRequest request, String paramname, LocalTime defaultValue) {

        String value = request.getParameter(paramname);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            LocalTime localTime = LocalTime.parse(value, timeFormatter);
            return localTime;
        } catch (Exception e) {
            LOG.error("::getTime param:{} value:{} e:{}", paramname, value, e);
        }

        return defaultValue;
    }

    public static LocalDateTime getDateTime(HttpServletRequest request, String paramname, LocalDateTime defaultValue,
                                            String pattern) {

        String value = request.getParameter(paramname);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(pattern);
            LocalDateTime localDateTime = LocalDateTime.parse(value, timeFormatter);
            return localDateTime;
        } catch (Exception e) {
            LOG.error("::getTime param:{} value:{} e:{}", paramname, value, e);
        }

        return defaultValue;
    }

    public static LocalDateTime getDateTime(HttpServletRequest request, String date, String time,
                                            LocalDateTime defaultValue, String pattern) {

        String dateString = request.getParameter(date);
        String timeString = request.getParameter(time);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        if (timeString != null) {
            String[] parsedTime = timeString.split(":");
            for (int i = 0; i < parsedTime.length; i++) {
                if (parsedTime[i].length() == 1) {
                    parsedTime[i] = "0" + parsedTime[i];
                }
            }
            timeString = String.join(":", parsedTime);
        }

        if ((dateString == null || dateString.isEmpty()) && (timeString == null || timeString.isEmpty())) {
            return defaultValue;
        }

        try {
            if ((dateString == null || dateString.isEmpty()) && (timeString != null && !timeString.isEmpty())) {
                DateTimeFormatter Hm = DateTimeFormatter.ofPattern("H:m");
                LocalTime localDateTime = LocalTime.parse(timeString, Hm);
                return LocalDateTime.of(LocalDate.MIN, localDateTime);
            }
            if ((dateString != null && !dateString.isEmpty()) && (timeString == null || timeString.isEmpty())) {
                dateString = dateString + " 00:00";
                LocalDateTime localDateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
                return localDateTime;
            }
            LocalDateTime localDateTime = LocalDateTime.parse(dateString + " " + timeString, dateTimeFormatter);
            return localDateTime;
        } catch (Exception e) {
            LOG.error("::getDate param:{} value:{} e:{}", dateString + " " + timeString, dateString + " " + timeString,
                    e);
        }

        return defaultValue;
    }

    public static String getString(HttpServletRequest request, String paramname, String defaultValue) {

        String value = request.getParameter(paramname);

        if (value != null && !value.isEmpty())
            return value;

        String values[] = request.getParameterValues(paramname);

        if (values == null || values.length == 0)
            return defaultValue;

        for (String val : values) {
            if (val != null && !val.isEmpty())
                return val;
        }

        return defaultValue;
    }


    public static boolean getBoolean(HttpServletRequest request, String val, boolean defaultvalue) {

        String paramvalue = request.getParameter(val);

        if (paramvalue == null || paramvalue.isEmpty())
            return defaultvalue;

        return Boolean.valueOf(paramvalue);
    }

    public static Boolean getBooleanObject(HttpServletRequest request, String val, Boolean defaultvalue) {

        String paramvalue = request.getParameter(val);

        if (paramvalue == null || paramvalue.isEmpty())
            return defaultvalue;

        return Boolean.valueOf(paramvalue);
    }

    public static <T extends Enum<T>> T getAsEnum(HttpServletRequest request, String paramName, Class<T> type,
                                                  T defaultValue) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return defaultValue;

        T result = Enum.valueOf(type, value);

        return result;
    }

    public static List<Integer> getAsIntArray(HttpServletRequest request, String paramName,
                                              List<Integer> defaultValue) {

        String[] values = request.getParameterValues(paramName);

        if (values == null || values.length == 0)
            return defaultValue;

        List<Integer> intList = new ArrayList<Integer>();

        for (String s : values) {
            try {
                intList.add(Integer.valueOf(s));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return intList;
    }

    public static List<String> getAsStringList(HttpServletRequest request, String paramName,
                                               List<String> defaultValue) {

        String[] values = request.getParameterValues(paramName);

        if (values == null || values.length == 0)
            return defaultValue;

        List<String> paramList = new ArrayList<String>();

        for (String s : values) {
            try {
                paramList.add(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return paramList;
    }


    public static <T extends Enum<T>> List<T> getAsEnumList(HttpServletRequest request, String paramName, Class<T> type,
                                                            List<T> defaultValue) {

        String[] values = request.getParameterValues(paramName);

        if (values == null || values.length == 0)
            return defaultValue;

        List<T> result = new ArrayList<>();

        for (int i = 0; i < values.length; i++)
            result.add(Enum.valueOf(type, values[i]));

        return result;
    }

    public static BigDecimal getBigDecimal(HttpServletRequest request, String paramName) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return null;

        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            String pattern = "#,##0.0#";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
            decimalFormat.setParseBigDecimal(true);

            return (BigDecimal) decimalFormat.parse(value);
        } catch (NumberFormatException nfe) {
            value = cleanText(value);

            return new BigDecimal(value);
        } catch (Exception e) {
            LOG.error("::getBigDecimal({}) e:{} ", value, e.getMessage());
        }

        return null;
    }

    public static BigDecimal getBigDecimal(HttpServletRequest request, String paramName, BigDecimal defaultValue) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return defaultValue;

        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            String pattern = "#,##0.0#";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
            decimalFormat.setParseBigDecimal(true);

            return (BigDecimal) decimalFormat.parse(value);
        } catch (NumberFormatException nfe) {
            value = cleanText(value);

            return new BigDecimal(value);
        } catch (Exception e) {
            LOG.error("::getBigDecimal({}) e:{} ", value, e.getMessage());
        }

        return null;
    }

    public static BigDecimal getBigDecimal(HttpServletRequest request, String paramName, BigDecimal defaultValue,
                                           int scale) {

        String value = request.getParameter(paramName);

        if (value == null || value.isEmpty())
            return defaultValue != null ? defaultValue.setScale(scale, RoundingMode.HALF_UP) : null;

        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            String pattern = "#,##0.0#";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
            decimalFormat.setParseBigDecimal(true);

            return ((BigDecimal) decimalFormat.parse(value)).setScale(scale, RoundingMode.HALF_UP);
        } catch (NumberFormatException nfe) {
            value = cleanText(value);

            return new BigDecimal(value).setScale(scale, RoundingMode.HALF_UP);
        } catch (Exception e) {
            LOG.error("::getBigDecimal({},{},{}) e:{} ", value, defaultValue, scale, e.getMessage());
        }

        return null;
    }

    private static String cleanText(String text) {

        StringBuilder buf = new StringBuilder();
        char[] chars = text.toCharArray();

        for (char ch : chars) {
            if (Character.isDigit(ch) || '.' == ch) {
                buf.append(ch);
            }
        }

        return buf.toString();
    }

    public static String dateToString(LocalDate date) {

        if (date == null)
            return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = date.format(formatter);

        return text;
    }

    public static Object getObjectViaJson(String jsonStr, Type type) {

        Object object = new Object();

        if (jsonStr != null && !jsonStr.isEmpty()) {
            try {
                object = gson.fromJson(jsonStr, type);
            } catch (Exception e) {
                return null;
            }
        }

        return object;
    }

    public static boolean isPost(HttpServletRequest request) {
        return HttpMethod.POST.name().equals(request.getMethod());
    }

    public static boolean isGet(HttpServletRequest request) {
        return HttpMethod.GET.name().equals(request.getMethod());
    }

    public static String getMd5Encode(String paramname) throws UnsupportedEncodingException {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(paramname.getBytes("UTF-8"));

            //converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }

            digest = sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            LOG.error("::md%Code({}) e:{} ", paramname, ex.getMessage());
            throw new RuntimeException(ex);
        }
        return digest;
    }

    public static double convertToDouble(String input) {
        input = input.replace(',', '.');
        int decimalSeperator = input.lastIndexOf('.');

        if (decimalSeperator > -1) {
            input = input.substring(0, decimalSeperator).replace(".", "") + input.substring(decimalSeperator);
        }

        return Double.parseDouble(input);
    }

    public static String getRemoteAddr(HttpServletRequest request) {
        String IpAddress = null;

        IpAddress = (request.getHeader("X-Forwarded-For") != null) ? request.getHeader("X-Forwarded-For") : (request.getRemoteAddr() != null) ? request.getRemoteAddr() : "";
        IpAddress = replaceAll(IpAddress, "127.0.0.1, ", "");
        IpAddress = replaceAll(IpAddress, ", 10.0.0.2", "");
        IpAddress = replaceAll(IpAddress, "0:0:0:0:0:0:0:1", "");

        return IpAddress;
    }

    private static String replaceAll(String str, String replace, String replacement) {
        StringBuffer sb = new StringBuffer(str);
        int firstOccurrence = sb.toString().indexOf(replace);

        while (firstOccurrence != -1) {
            sb.replace(firstOccurrence, firstOccurrence + replace.length(), replacement);
            firstOccurrence = sb.toString().indexOf(replace);
        }

        return sb.toString();
    }
}
