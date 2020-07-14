# Cucumber-Java-Maven
#### with Cucumber-java, Page Object Model, and webdriver manager (Selenium WebDriver) for:
* ##### chrome
* ##### firefox
* ##### chrome headless

### Prerequisites
* Maven
* Cucumber for Java plugin for IntelliJ
* Gherkin for IntelliJ
* chromedriver.exe (driver folder (under resources))- chrome is set as default browser
* geckodriver.exe (driver folder (under resources))

### Initial
* clone repository

### Customise Cucumber tests
* add your .feature files with scenarios
* create custom steps class / steps classes  for page objects class / classes
* generate steps- in .feature file press 'alt+enter' shortcut and choose 'Create step definition' option then choose if you want to create the steps in existing file or new file
* create custom page objects classes under PageObjects package
* Create the method under modules pacakeg.
* delete example .feature files, steps classes, page objects classes and modules classes

### How to run tests:
#### With Maven command:

###### To run Cucumber tests with default browser, type:
```
 mvn clean test 
```

###### To run Cucumber with chosen browser, type:
``` 
 mvn clean test -Dbrowser=chrome
```
```
 mvn clean test -Dbrowser=firefox
```
```
 mvn clean test -Dbrowser=chromeHeadless
```
###### To run Cucumber with selected tags, type:
``` 
 mvn test -D tags="correctCreditCard or wrongCreditCard"
```

###### To run Cucumber with selected feature file, type ex:
``` 
 mvn test -Dcucumber.options="src/test/resources/features/ShoppingCartSummary.feature"
```
 


#### With IDE (JUnit):
```
run CucumberRunner class
```
```
or run .feature file / directory with .feature files / scenario in .feature file
```

### Reports and screenshots
Reports are placed in 'target' directory, including screenshots of failed scenarios.
To run report in browser, open 'target\html\index.html' file and choose browser.

