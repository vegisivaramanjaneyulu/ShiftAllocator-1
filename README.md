Shift Allocator
===============

PreRequisites:
spring, mongodb, eclipse

Description:
 The Allocation of the Employee shifts happen in a traditional Manual Manner. So we planned to address the problem area , so that this not only servers the IT 24X7 Operations resource allocation, This had made generic to server all the Industries even the mechanical based ,the beauty of the tool is that even if any number of 
 employees are planned for shifts no two people will get the same week day off apart from the one worked in the same Shift
 
 steps to be Execution:
 
 1. Download project from github
 2. and add that project into eclipse
 3. open spring-data.xml file and uncomment bellow lines
 <bean id="initMongoService" class="com.techgene.shiftAllocator.service.EmployeeService" init-method="init"/>
 4. and build the project using maven then "techgenshiftallocator" db will be created in mongodb and also for this db , "user"  collection   also will be created. for this collection
 document releated to team leader credentials will be stored, those are
  username:sivaram
  password:hadoop123
  5. Now again open the spring-data.xml file and comment bellow lines
  <bean id="initMongoService" class="com.techgene.shiftAllocator.service.EmployeeService" init-method="init"/>
  and build the project and login with above credentails  by browse the following url "http://localhost:8080/ShiftAllocator/"  then will get the login page ,now enter the credential as mention above then we able to logged in , 
  now create new users and planned for shift
  6.If user is authorized person either Team Leader or Project Manager then he 
will be able to add new Employee and also he can plan for shifts for a particular month and he can able to view the planned details  for all Employees in each month  for every week
