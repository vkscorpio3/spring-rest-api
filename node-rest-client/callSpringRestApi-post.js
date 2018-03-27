var Client = require('node-rest-client').Client;
var client = new Client();

var args = {
	data:{"firstName":"Neerav",
          "lastName":"Shah"},
	headers:{"Content-Type": "application/json"}   

};
client.post("http://localhost:8080/api/profile",args,function(data,response){

console.log(data);
});