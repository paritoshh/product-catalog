This is code for Contentserv Code Challenge.
https://github.com/paritoshh/product-catalog/commits/master


Kindly consider below points,

1) Used Spring Boot framework.
2) Implemented SOLID principals.
3) Each class contains single responsibility.
4) Used Factory and Command design patterns, which makes very easy for enhancement and closed for modification.
5) Beautiful implementation of Inheritance (Product-Electronics-TV/Washing Machine), Liskov Substitution Principle in Java.
6) Dependency injection used.

About Code,
7) Created swagger with all details, kindly refer for the APIs agreement at (/spec/main/resources) path.
8) Used H2 DB for storage. DB credentials (username: 'sa', password: 'password')
9) DB design and functionality could have been much more improved, due to time constraint I designed/ implemented bare minimum application with coding standards and all validations.
10) Data validations are implemented on all fields.
11) Exception Handling implemented.
12) Custom exceptions are created.

Known Issue: ()
13) Update API:
       When we update TV and provide Washing machine data, it will create an new entry.
