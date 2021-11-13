var axios = require('axios');

var config = {
  method: 'get',
  url: 'localhost:8080/locatarios',
  headers: { }
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
})
.catch(function (error) {
  console.log(error);
});