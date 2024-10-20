@echo off
set path=C:\Users\Shady\.m2\repository\allure\allure-2.13.9\bin;C:\Program Files\Java\jdk-16\bin;%path%
allure serve allure-results
C:\Pentest\1-file-upload\test_files\allure-2.30.0\allure-2.30.0\bin\allure generate --single-file allure-results
pause
exit