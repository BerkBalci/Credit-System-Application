# Credit-System-Application
Patika Paycore Bitirme Projesi


I used the layer architecture because it is easy to manage and has a flexible structure.

# Used Technologies

*Java 8

*Spring Boot

*Spring Data JPA

*Restful API

*Swagger documentation

*MapStruct

*Lombok

*H2 database

*JUnit Mockito

*Maven

# Commands

After running the application you can see all customers. For that you need to use http://www.localhost:8080/api/customer/all endpoint with get request.

If you want to find one customer especially you can find the customer via nationalId. For that you need to use http://www.localhost:8080/api/customer/nationalId endpoint. You need to use param,nationalId for key and national id number for value with get request.

If you want to add customer you need to use http://www.localhost:8080/api/customer/add endpoint with post request. You need to fill the body like that :

{
    "nationalId":"MUST BE 11 CHARACTER",
    
    "name":"NAME HERE" ,
    
    "surname":"SURNAME HERE",
    
    "monthlyIncome":"INCOME HERE",
    
    "phoneNumber":"MUST BE 11 CHARACTER"
    
}

After you created the customer it's credit score will be randomly generated between 0-1500.

If you want to make application with one customer you can use http://www.localhost:8080/api/customer/application endpoint with get request. It will return customer's information,result of credit application(Comfirmed or Uncomfirmed) and defined credit limit.


Except those you can find customer with id http://www.localhost:8080/api/customer/get and post request.
Update customer with id http://www.localhost:8080/api/customer/update/{id} and put request(Remember you need to fill all not null entities)
Delete customer with id http://www.localhost:8080/api/customer/delete/id={id} and delete request.
