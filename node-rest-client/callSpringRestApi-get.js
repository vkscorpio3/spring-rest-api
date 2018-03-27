var Client = require('node-rest-client').Client;
var client = new Client();

   client.get('http://localhost:8080/api/profile',function(data,response){
      console.log(data);

      //console.log(response);

   });