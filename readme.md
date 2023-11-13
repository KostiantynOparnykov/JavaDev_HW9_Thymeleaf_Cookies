### Module 9 homework "Servlets Cookies and templates"

This is homework for Module 8 of Java Developer (14) GoIt course

This homework extends java servlet from previous task.
* We have added `Thymeleaf` to our servlet to separate calculation of time in given timezone and time rendering in html template.

* `lastTimezone` Cookie contains last valid timezone achieved from user. If user request doesn't contains `timezone` parameter, we try to achieve `timezone` from Cookie. 
