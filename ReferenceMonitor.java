import java.util.*;

class ReferenceMonitor {

    private static final Set<String> restrictedOperations = Set.of("create", "append", "delete");

    String securityKey;
    String operationAttempted;
    int securityLevelGranted;
    boolean hasPermission = false;

    public ReferenceMonitor(final String key, final String operation) {
        securityKey = key;
        operationAttempted = operation;
        securityLevelGranted = grantSecurityLevel(key);

        if (!isRestricted(operation)) {
            hasPermission = true;
            return;
        }

        if(getRequiredSecurityLevel(operation) <= securityLevelGranted) {
            hasPermission = true;
        }
    }

    static Boolean isRestricted(final String operation) {
        if (restrictedOperations.contains(operation)) {
            return true;
        }

        return false;
    }

    static int grantSecurityLevel(String key) {
        switch (key) {
            case "A000":
                return 0;
            case "B001":
                return 1;
            case "200D":
                return 2;
            case "300C":
                return 3;
            default:
                return 0;
        }
    }

    static int getRequiredSecurityLevel(String operation) {
        switch (operation) {
            case "create":
                return 1;
            case "append":
                return 2;
            case "delete":
                return 3;
            default:
                return 3;
        }
    }

}