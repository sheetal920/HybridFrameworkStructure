

public class notes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*    1.
 #Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      

2. cucumber plugin and natural plugin(ye agr Eclipse market me nhi hai to help --> Install new software)Eclipse market se install krne pdenge
3. tools dependency khud se add krni pdegi and feature file run krne se unimplimented method show ho jayenge

4. hme tools.jar dependency add krni hogi pom me , after jdk version 9 tools.jar file avilable nhi hai to previous jdk ka tools.jar file copy krke latest wale me paste kr denge ya fir jrt-fs hai jar file ye hme window-preference-java-installed jre-->yaha java ka version show hoga select and click on edit--> yaha .jar file mention hogi  
 5. BDD(Behaviour driven development mostly focus on accetance testing : user point of view testing while TDD focus on functional testing , In TDD we test each and every thing in detailed way)
 BDD exam: cucumber, SpecFlow
 
 6. Instead of runner class, agr hme pom.xml se run krna hai to maven-compiler plugin add krna hoga ye dependencies se phle add krna hota hai and pom.xml ko run as Maven Test krna hoga
 7. only 2 hooks is available in cucumber: before,after
 
 *
 */
		
		
	}

}
