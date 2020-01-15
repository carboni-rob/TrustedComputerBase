import java.util.ArrayList;
import java.util.Arrays;

public class TestReferenceMonitor {

    public static void main(String[] args) {
        
        ReferenceMonitor rm1 = new ReferenceMonitor("A000", "create");
        ReferenceMonitor rm2 = new ReferenceMonitor("A000", "read");
        ReferenceMonitor rm3 = new ReferenceMonitor("A000", "append");
        ReferenceMonitor rm4 = new ReferenceMonitor("A000", "close");
        ReferenceMonitor rm5 = new ReferenceMonitor("A000", "delete");

        ReferenceMonitor rm6 = new ReferenceMonitor("B001", "create");
        ReferenceMonitor rm7 = new ReferenceMonitor("B001", "read");
        ReferenceMonitor rm8 = new ReferenceMonitor("B001", "append");
        ReferenceMonitor rm9 = new ReferenceMonitor("B001", "close");
        ReferenceMonitor rm10 = new ReferenceMonitor("B001", "delete");

        ReferenceMonitor rm11 = new ReferenceMonitor("200D", "create");
        ReferenceMonitor rm12 = new ReferenceMonitor("200D", "read");
        ReferenceMonitor rm13 = new ReferenceMonitor("200D", "append");
        ReferenceMonitor rm14 = new ReferenceMonitor("200D", "close");
        ReferenceMonitor rm15 = new ReferenceMonitor("200D", "delete");

        ReferenceMonitor rm16 = new ReferenceMonitor("300C", "create");
        ReferenceMonitor rm17 = new ReferenceMonitor("300C", "read");
        ReferenceMonitor rm18 = new ReferenceMonitor("300C", "append");
        ReferenceMonitor rm19 = new ReferenceMonitor("300C", "close");
        ReferenceMonitor rm20 = new ReferenceMonitor("300C", "delete");

        ReferenceMonitor rm21 = new ReferenceMonitor("XXXX", "create");
        ReferenceMonitor rm22 = new ReferenceMonitor("XXXX", "read");
        ReferenceMonitor rm23 = new ReferenceMonitor("XXXX", "append");
        ReferenceMonitor rm24 = new ReferenceMonitor("XXXX", "close");
        ReferenceMonitor rm25 = new ReferenceMonitor("XXXX", "delete");

        ArrayList<ReferenceMonitor> untrustedProcesses =
            new ArrayList<ReferenceMonitor>(Arrays.asList(rm1, rm2, rm3, rm4, rm5, rm6, rm7, rm8, rm9, rm10,
                                            rm11, rm12, rm13, rm14, rm15, rm16, rm17, rm18, rm19, rm20, rm21, rm22, rm23, rm24, rm25));
        untrustedProcesses.forEach(process ->
            System.out.println("Untrusted process with access key " + process.securityKey
            + " is granted a Security Level of " + process.securityLevelGranted + " therefore " + booleanToString(process.hasPermission)
            + " access to " + process.operationAttempted + " operations on the protected object.")
        );
        
    }

    static String booleanToString(boolean hasPermission) {
        if(hasPermission) {
            return "has";
        }

        return "doesn't have";
    }
}