package thanhnv.validator;

import java.util.regex.Pattern;

/**
 * Command validator
 *
 */
public class CommandValidator {
    private final String CREATE_CANVAS_COMMAND_REGEX = "C \\d+ \\d+";
    private final String ADD_LINE_COMMAND_REGEX = "L \\d+ \\d+ \\d+ \\d+";
    private final String ADD_RECTANGLE_COMMAND_REGEX = "R \\d+ \\d+ \\d+ \\d+";
    private final String BUCKET_FILL_COMMAND_REGEX = "B \\d+ \\d+ \\w";

    /**
     * Validate by CREATE_CANVAS_COMMAND_REGEX constant
     * @param command
     * @return isValid command
     */
    public boolean validateCreateCanvasCommand(String command) {
        return checkValidString(CREATE_CANVAS_COMMAND_REGEX, command);
    }

    /**
     * Validate by ADD_LINE_COMMAND_REGEX constant
     * @param command
     * @return isValid command
     */
    public boolean validateAddLineCommand(String command) {
        return checkValidString(ADD_LINE_COMMAND_REGEX, command);
    }

    /**
     * Validate by ADD_RECTANGLE_COMMAND_REGEX constant
     * @param command
     * @return isValid command
     */
    public boolean validateAddRectangleCommand(String command) {
        return checkValidString(ADD_RECTANGLE_COMMAND_REGEX, command);
    }

    /**
     * Validate by BUCKET_FILL_COMMAND_REGEX constant
     * @param command
     * @return isValid command
     */
    public boolean validateBucketFillCommand(String command) {
        return checkValidString(BUCKET_FILL_COMMAND_REGEX, command);
    }

    /**
     * Validate by regex
     * @param regex, inputString
     * @return isValid command
     */
    private boolean checkValidString(String regex, String inputString) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(inputString.trim()).matches();
    }
}
