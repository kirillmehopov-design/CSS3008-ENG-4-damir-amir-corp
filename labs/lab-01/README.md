# Product

We built a bug tracking system. People track bug reports.

# Core item

`BugReport` is identified by `BugReportId` and moves through `BugReportStatus` values according to `BugReportPolicy`.

# Status table

| From | To | Result |
|---|---|---|
| OPEN | IN_PROGRESS | allowed |
| IN_PROGRESS | FIXED | allowed |
| OPEN | CLOSED | forbidden |
| CLOSED | OPEN | forbidden |

# Forbidden — why

`OPEN -> CLOSED` is forbidden because a bug cannot be closed before it is investigated and fixed.

`CLOSED -> OPEN` is forbidden because a closed bug report is final in this process.
