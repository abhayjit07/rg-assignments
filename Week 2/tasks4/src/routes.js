const { getTransactions, getSingleTransaction, createTransaction } = require('./controllers');

function routes(app) {
    app.get("/", (req, res) => {
        res.send("Welcome to the Transactions API");
    });
    app.get("/transactions", getTransactions);

}

module.exports = routes;