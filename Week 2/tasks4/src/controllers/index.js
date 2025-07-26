const txnService = require('../services');

async function getTransactions(req, res) {
    try {
        const transactions = await txnService.getTransactions();
        return res.status(200).json(transactions); // ✅ sends status + JSON
    } catch (err) {
        return res.status(500).json({ error: 'Something went wrong' });
    }
}

async function getSingleTransaction(req, res) {
}

async function createTransaction(req, res) {
}

module.exports = { getTransactions, getSingleTransaction, createTransaction };