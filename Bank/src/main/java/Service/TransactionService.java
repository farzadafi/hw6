package Service;

import Entity.Transaction;
import Repository.TransactionRepository;

import java.sql.SQLException;

public class TransactionService {
    private TransactionRepository transactionRepository = new TransactionRepository();

    public TransactionService() throws SQLException, ClassNotFoundException {
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        transactionRepository.add(transaction);
    }
}
