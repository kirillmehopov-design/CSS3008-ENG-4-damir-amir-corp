package com.example.bugtracking;

public class BugReportPolicy {
    public BugReportStatus move(BugReportStatus from, BugReportStatus to) {
        if ((from == BugReportStatus.OPEN && to == BugReportStatus.IN_PROGRESS)
                || (from == BugReportStatus.IN_PROGRESS && to == BugReportStatus.FIXED)) {
            return to;
        }

        throw new IllegalStateException("Status change is forbidden: " + from + " -> " + to);
    }
}
