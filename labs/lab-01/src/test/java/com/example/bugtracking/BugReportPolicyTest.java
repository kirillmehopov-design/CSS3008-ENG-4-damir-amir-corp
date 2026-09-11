package com.example.bugtracking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BugReportPolicyTest {
    private final BugReportPolicy policy = new BugReportPolicy();

    @ParameterizedTest
    @CsvSource({
            "OPEN, IN_PROGRESS, allowed",
            "IN_PROGRESS, FIXED, allowed",
            "OPEN, CLOSED, forbidden",
            "CLOSED, OPEN, forbidden"
    })
    void statusChanges(BugReportStatus from, BugReportStatus to, String result) {
        if (result.equals("allowed")) {
            assertEquals(to, policy.move(from, to));
        } else {
            assertThrows(IllegalStateException.class, () -> policy.move(from, to));
        }
    }

    @Test
    void nullIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> new BugReportId(null));
    }

    @Test
    void blankIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> new BugReportId("   "));
    }
}
