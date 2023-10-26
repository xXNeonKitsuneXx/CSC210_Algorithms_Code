var exp = require('express');
const { futimes } = require('fs');
var app = exp();
const router = exp.Router();
var port = 3212;
var path = require('path');

router.get('/', function (request, response) {
    response.sendFile(path.join(__dirname + '/multiply.html')); 
});

router.get('/time', function (request, response) {
    userNum1 = request.query.number1;
    userNum2 = request.query.number2;
    answer = russianMultiplication(userNum1, userNum2);

    response.write("<html> <body>");
    response.write("<h1> 65130500212 Nithit Lertcharoensombat </h1>");
    response.write(userNum1 + " x " + userNum2 + " = " + answer);
    response.write("</body> </html>");
    response.end();
});

function russianMultiplication( n , m ) {
    n = parseInt(n);
    m = parseInt(m);
    sum = 0;
    while ( n > 1 ) {
        if ( n % 2 == 1 ) { //n is odd.
            sum += m;
        }
        // Normal way
        // n = Math.floor(n / 2);
        // m = m * 2;
        //*****************************************************
        // Computer way
        // 010111 -> shift right -> 01011
        // 010111 -> shift left  -> 0101110
        // 6 = 110
        // 6/2 = 3  -> 11
        // 6*2 = 12 -> 110
        //-----------------------------------------------------

        n = shiftRight(n);
        m = shiftLeft(m);
    }
    return (m + sum)


}

function shiftRight(x) {            // 13
    binaryX = (x + "").toString(2); // 1101
    binaryX = binaryX >> 1;         // 110
    decimalX = binaryX.toString(10);
    integerX = parseInt(decimalX);

    return integerX;
}

function shiftLeft(x) {             // 13
    binaryX = (x + "").toString(2); // 1101
    binaryX = binaryX << 1;         // 11010
    decimalX = binaryX.toString(10);
    integerX = parseInt(decimalX);

    return integerX;
}


app.use('/', router);
var server = app.listen(port, '10.4.53.25', function () {
    console.log("Multiplication app is deployed.");
})



