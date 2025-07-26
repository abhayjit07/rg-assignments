const http = require('http');

// TODO 1: Import transactions data from JSON file
const transactions = require('./data/transactions.json');

const server = http.createServer((req, res) => {
  if (req.url === '/') {
    // TODO 2: Respond to '/' with a welcome message and proper headers
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello PayPal');
  }
  else if (req.url === '/transactions') {
    // TODO 3: Respond with JSON data and proper headers
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify(transactions));
  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('404 Not Found');
  }
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
