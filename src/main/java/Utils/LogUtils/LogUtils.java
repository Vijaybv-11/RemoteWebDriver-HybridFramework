package Utils.LogUtils;

import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class LogUtils {

    public static void logPass(String message) {
        logToReportPortal(message, LogLevel.INFO.name());
    }

    public static void logInfo(String message) {
        logToReportPortal(message, LogLevel.INFO.name());
    }

    public static void logStart(String message) {
        logToReportPortal(message, LogLevel.INFO.name());
    }

    public static void logWarning(String message) {
        logToReportPortal(message, LogLevel.WARN.name());
    }

    public static void logFail(String message) {
        logToReportPortal(message, LogLevel.ERROR.name());
    }

    public static void logSkip(String message) {
        logToReportPortal(message, LogLevel.WARN.name());
    }

    public static void logException(Throwable e) {
        StringBuilder exceptionLog = new StringBuilder("Exception: ").append(e.getMessage()).append("\nStackTrace: ");
        for (StackTraceElement element : e.getStackTrace()) {
            exceptionLog.append(element.toString()).append("\n");
        }
        logToReportPortal(exceptionLog.toString(), LogLevel.ERROR.name());
    }

    public static void logJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        String prettyJson = jsonObject.toString(4); // Pretty print JSON with an indentation of 4 spaces
        logToReportPortal("JSON Response:\n" + prettyJson, LogLevel.INFO.name());
    }

    public static void logFailedJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        String prettyJson = jsonObject.toString(4); // Pretty print JSON with an indentation of 4 spaces
        logToReportPortal("Failed JSON Response:\n" + prettyJson, LogLevel.ERROR.name());
    }

    public static void logListAsTable(String tableName, String[] headers, List<Object>... dataLists) {
        StringBuilder tableLog = new StringBuilder();
        tableLog.append("**").append(tableName).append("**\n\n");
        tableLog.append("| ");
        for (String header : headers) {
            tableLog.append(header).append(" | ");
        }
        tableLog.append("\n|");
        for (int i = 0; i < headers.length; i++) {
            tableLog.append("--- |");
        }
        tableLog.append("\n");
        int maxRows = 0;
        for (List<Object> dataList : dataLists) {
            if (dataList.size() > maxRows) {
                maxRows = dataList.size();
            }
        }
        for (int i = 0; i < maxRows; i++) {
            tableLog.append("| ");
            for (List<Object> dataList : dataLists) {
                if (i < dataList.size()) {
                    tableLog.append(dataList.get(i)).append(" | ");
                } else {
                    tableLog.append("null | ");
                }
            }
            tableLog.append("\n");
        }
        logToReportPortal(tableLog.toString(), LogLevel.INFO.name());
    }

    public static void logTable(String[] headers, List<?>... data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1'>");
        sb.append("<tr>");
        for (String header : headers) {
            sb.append("<th>").append(header).append("</th>");
        }
        sb.append("</tr>");
        int rows = data[0].size();
        for (int i = 0; i < rows; i++) {
            sb.append("<tr>");
            for (List<?> datum : data) {
                sb.append("<td>").append(datum.get(i)).append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        logToReportPortal(sb.toString(), LogLevel.INFO.name());
    }

    public static <T> void logTable(String[] headers, String[] subHeaders, Map<String, T>... maps) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1'>");
        sb.append("<tr>");
        for (String header : headers) {
            sb.append("<th>").append(header).append("</th>");
        }
        sb.append("</tr>");
        sb.append("<tr>");
        for (String subHeader : subHeaders) {
            sb.append("<th>").append(subHeader).append("</th>");
        }
        sb.append("</tr>");
        for (Map<String, T> map : maps) {
            for (String key : map.keySet()) {
                sb.append("<tr>");
                sb.append("<td>").append(key).append("</td>");
                sb.append("<td>").append(map.get(key)).append("</td>");
            }
        }
        sb.append("</table>");
        logToReportPortal(sb.toString(), LogLevel.INFO.name());
    }

    public static void logTable(String[] headers, Object[][] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table style='width:100%; border:1px solid black; border-collapse: collapse;'>");
        sb.append("<thead><tr>");
        for (String header : headers) {
            sb.append("<th style='border:1px solid black; padding: 5px; text-align: left;'>").append(header).append("</th>");
        }
        sb.append("</tr></thead><tbody>");
        for (Object[] row : data) {
            sb.append("<tr>");
            for (Object cell : row) {
                sb.append("<td style='border:1px solid black; padding: 5px; text-align: left;'>").append(cell).append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</tbody></table>");
        logToReportPortal(sb.toString(), LogLevel.INFO.name());
    }

    public static void logSpacer() {
        logToReportPortal("------------------------------------------------", LogLevel.INFO.name());
    }

    private static void logToReportPortal(String message, String level) {
        ReportPortal.emitLog(message, level, Calendar.getInstance().getTime());
    }
}
