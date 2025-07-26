const express = require('express')
const morgan = require('morgan')
const bodyParser = require('body-parser')
const routes = require('./routes');

const app = express();
const PORT = 3000;

// Middlewares
app.use(bodyParser.json());
app.use(morgan('dev'));

// Routes
app.use('/', routes);

// Start server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});