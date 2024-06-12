const express = require('express');
const app = express();
const port = 3000;
const axios = require('axios');

app.set('view engine', 'ejs');
app.use('/bootstrap', express.static(__dirname + '/node_modules/bootstrap/dist/'));

app.get('/', (req, res) => {

    var params = {
        title: 'NodeJS example with EJS template engine',
        message: 'List of users fetched from database',
        users: [],
        page: Number(req.query.page) || 0,
        size: Number(req.query.size) || 6
    };

    axios.get('http://localhost:8080/users/paged?page='+params.page+'&size='+params.size)
        .then(function (response) {
            // handle success
            console.log(response.data);
            params.users = response.data;
            res.render('index', params);
        })
        .catch(function (error) {
            // handle error
            console.log(error);
        });

});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
 