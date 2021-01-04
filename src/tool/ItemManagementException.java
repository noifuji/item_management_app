package ao.app.productmaster.tool;

public class ItemManagementException extends Exception {

    public ItemManagementException(String message) {
        super(message);
    }
    
    public ItemManagementException(String message, Throwable cause) {
        super(message, cause);
    }
}