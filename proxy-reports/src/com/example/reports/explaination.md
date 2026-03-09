# Proxy Refactoring – Secure & Lazy Load Reports

## Overview
The CampusVault CLI tool originally allowed `ReportViewer` to access `ReportFile` directly.  
This caused several problems such as lack of access control, repeated expensive disk loading, and tight coupling between the client and the concrete implementation.

To solve these issues, the **Proxy Design Pattern** was applied.

---

# Problems in Original Design

1. **No Access Control**  
   Any user could open any report regardless of classification.

2. **No Lazy Loading**  
   Every call to `display()` loaded the report from disk.

3. **No Caching**  
   Opening the same report multiple times reloaded the file each time.

4. **Tight Coupling**  
   `ReportViewer` depended directly on `ReportFile`.

Example flow before refactor:
ReportViewer → ReportFile → loadFromDisk()

Every request triggered a disk load.

---

# Solution: Proxy Pattern

A proxy object was introduced between the client and the real report.


Client → ReportProxy → RealReportEvery request triggered a disk load.

---

# Solution: Proxy Pattern

A proxy object was introduced between the client and the real report.


Client → ReportProxy → RealReport

The proxy controls access and creates the real report only when needed.

---

# Changes Made

## 1. Introduced `Report` Interface

A new abstraction was created so that both the proxy and real report share the same contract.

```java
public interface Report {
    void display(User user);
}
Benefit

Decouples the client from concrete implementations.

2. Created RealReport (Real Subject)

RealReport contains the expensive disk loading logic that was previously inside ReportFile.

Responsibilities:

Load report content from disk

Display report details

Disk loading happens only when the real report object is created.

3. Implemented ReportProxy

A new proxy class was added to control access to reports.

Responsibilities:

Access Control

Checks whether the user has permission to open the report using AccessControl.

Lazy Loading

RealReport is created only when the report is accessed.

Caching

Once the real report is created, the same instance is reused for subsequent views.

Example behavior:

User requests report
        ↓
Proxy checks permission
        ↓
If allowed → create RealReport (if not already created)
        ↓
Forward request to RealReport
4. Updated ReportViewer

Before:

open(ReportFile report, User user)

After:

open(Report report, User user)

Now the viewer works with the Report abstraction instead of a concrete class.

5. Updated App

All reports are now created using the proxy instead of the real file loader.

Before:

ReportFile report = new ReportFile(...);

After:

Report report = new ReportProxy(...);

This ensures that every report request goes through the proxy.

Result

After refactoring:

Unauthorized users cannot access restricted reports

Reports load from disk only when access is granted

The same report is not reloaded multiple times

Client code is loosely coupled to the interface

Example output behavior:

Student opening faculty report → ACCESS DENIED
Admin opening admin report → [disk] loading report
Admin opening admin report again → no disk reload
Conclusion

By introducing the Proxy pattern, a control layer was added between the client and the real report object.
This allowed the system to implement access control, lazy loading, and caching while keeping the client code simple and flexible.