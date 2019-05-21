Endpoints
------------------------------
1) http://localhost:5656/api/v1/user/{userid} (GET) 

response type : JSON

Out put : {"uuid":"752c0efb-5671-4727-b880-4dd8c536548c","userName":"Bhargav53"}



2) http://localhost:5656/api/v1/user (GET) 
   http://localhost:5656/api/v1/user/0/5 (with "page number" and "no.of records") (GET)

response type: JSON



3) http://localhost:5656/api/v1/user (POST)

input JSON
------------
{
  "userName": "Bhargav53",
  "password": "password"
}

response type : JSON
 
Out put : {"uuid":"752c0efb-5671-4727-b880-4dd8c536548c","userName":"Bhargav53"}



NOTE: All endpoints are secured with Basic Authentication
-----
username:bhargav
password:password

