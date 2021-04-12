# spring-mongodb

Task:
myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores
across the east coast. myRetail wants to make its internal data available to any number
of client devices, from myRetail.com to native mobile apps.
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API,
which will aggregate product data from multiple sources and return it as JSON to the
caller.
Your goal is to create a RESTful service that can retrieve product and price details by ID.
The URL structure is up to you to define, but try to follow some sort of logical
convention.
Build an application that performs the following actions:
 Write a rest API to do a CURD operations and store the data id, current_price,
currency_code
 Accepts an HTTP PUT request at the same path (/products/{id}), containing a
JSON request body similar to the GET response, and updates the product’s price
in the data store.
 Example:
{&quot;id&quot;:13860428,&quot;current_price&quot;:{&quot;value&quot;:13.49,&quot;currency_code&quot;:&quot;USD&quot;}}
 Rest API - HTTP GET request at /products/{id} and delivers product data as JSON
(where {id} will be a number.
 Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793)
 Example response: {&quot;id&quot;:13860428,&quot;current_price&quot;:{&quot;value&quot;:
13.49,&quot;currency_code&quot;:&quot;USD&quot;}}
 Assume there is a mongo DB which has product description and reads product
information from a NoSQL data store and combines it with the product id and
name from the HTTP request into a single response.  
 Example: {&quot;id&quot;:13860428,&quot;current_price&quot;:{&quot;value&quot;:
13.49,&quot;currency_code&quot;:&quot;USD&quot;, &quot;product_desc&quot;:&quot;Shirt&quot;}}
 The service should be secured.
Build a Performance test that can be run on the application for 10 Transactions per
second (TPS) using the tool/framework of choice (JMeter/Gatling/others)

Technologies Used:
1) MongoDB
2) Spring Boot

Implementation
Data is stored in the database in the following format:
[
    {
        "productPrice": {
            "currentPrice": 50.0,
            "currencyCode": "INR"
        },
        "descriptionModel": {
            "description": "Choco Bar",
            "productName": "Jenny's Icecream House"
        },
        "id": 5
    }
]
Where there is one collection which contains 2 json objects enwrapped in one object.

1) CURD Operations
    Create - https://localhost:8443/addShop
    Update - https://localhost:8443/findAllShops/13
    Read - https://localhost:8443/findAllShops
    Delete - https://localhost:8443/delete/13
2)  Accepts an HTTP PUT request at the same path (/products/{id}), containing a
    JSON request body similar to the GET response, and updates the product’s price
    in the data store. - https://localhost:8443/findAllShops/13
3)  Assume there is a mongo DB which has product description and reads product
    information from a NoSQL data store and combines it with the product id and
    name from the HTTP request into a single response. - https://localhost:8443/findNameId/{id}/{name} eg: https://localhost:8443/findNameId/4/Dairy Milk Silk
4)  To make the service secure we have used SSL encryption 
5)  We have tested the performance on JMeter
    ![image](https://user-images.githubusercontent.com/31889341/114415477-57e29480-9bcd-11eb-9002-4ba9aa0c6f76.png)
