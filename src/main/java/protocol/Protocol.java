package protocol;

public class Protocol {
    public static final String CREATE_PATIENT = "CREATE PATIENT";
    public static final String GET_PATIENT = "GET PATIENT";
    public static final String UPDATE_PATIENT = "UPDATE PATIENT";
    public static final String DELETE_PATIENT = "DELETE PATIENT";

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String DISEASE_DETECTED = "DISEASE_DETECTED";

    public static final String FIELD_SEPARATOR = "|";
    public static final String END_MESSAGE = "<END>";

    public static String formatMessage(String command, String... data) {
        StringBuilder message = new StringBuilder(command);
        for (String field : data) {
            message.append(FIELD_SEPARATOR).append(field);
        }
        message.append("\n").append(END_MESSAGE).append("\n");
        return message.toString();
    }
}

