Feature: Verifying services

Background:Navigates_to_services

@Services
Scenario Outline: Navigate to service operation screen 

When User clicks on Service operations from the navigation menu
And User clicks on Service managements
And User clicks on Financial Governance
Then User is navigated to Reports
Then User clicks on specific report

@Logout
Scenario Outline: Logout functionality

When User Click on Logout button
Then User is navigated to Login screen 