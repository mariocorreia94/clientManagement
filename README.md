# clientManagement

* http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/


# Features:

* Remote database;
* Full REST Api


# REST Api use cases:

* List all Clients (GET method): http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/service/users/
* Find Clients by name (GET method): http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/service/users/?name=rio
* Find Client by NIF (GET method): http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/service/users/123456789
* Delete a Client (DELETE method): http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/service/users/123456789
* Add a Client (POST method and needs to consume JSON Object): http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/service/users/
```
{ 
"name":"New User",
"nif":"562103298",
"adress":"Lisbos",
"phone":"920130268" 
}
```

* Add a Client (POST method and needs to consume JSON Object): http://restapi-env-1.evgwkbyv3x.us-east-2.elasticbeanstalk.com/service/users/651478302
```
{ 
"name":"restAPI",
"nif":"651478302",
"adress":"Lisboa",
"phone":"923654010" 
}
```