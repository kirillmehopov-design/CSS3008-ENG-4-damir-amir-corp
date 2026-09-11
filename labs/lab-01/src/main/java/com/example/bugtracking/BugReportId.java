package com.example.bugtracking;

public record BugReportId(String value) {
    public BugReportId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Bug report id must not be null or blank");
        }
    }
}
