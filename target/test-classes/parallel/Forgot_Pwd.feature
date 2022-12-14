Feature: This is to test Resetpassword functionality 

Background: Reset password functionality
Given User enters the website through URL https://cloudstudio.visionet.com/Login

@ResetPassword
Scenario Outline: Reset password 
When User clicks on Forgotpassword link
When User fills the Email "<Email>" for resetting the password
Then User gets the message "We have received your request. Our team of experts will connect with you shortly"
Then User navigates to login screen

Examples: 

|Email|
|amrutha@visionetsystems.com|
