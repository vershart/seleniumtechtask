Technical task:

Create a maven project that contains one test. Test should be executed by `'mvn clean test'` command.

Test should do following:

1. Log in to `https://ctco.lv/en` page
2. Open Careers menu
3. Click Vacancies from the list.
4. Open vacancie with title "Test Automation Engineer"
5. Verify that paragraph under Professional skills and qualification: contains exactly 5 skills. (skills are separated by `<br>` tag)