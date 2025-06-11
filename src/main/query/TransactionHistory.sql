USE MYMONEY

CREATE TABLE TransactionHistory(
    TransactionID INT PRIMARY KEY NOT NULL,
    Amount MONEY NOT NULL,
    TransactionDate DATE NOT NULL,
    TranscationType VARCHAR(7) NOT NULL,
    Description VARCHAR(255) NOT NULL
)