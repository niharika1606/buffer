package BlockPacakage;

import java.util.UUID;

public class Transaction {
    public String sender;
    public String receiver;
    public double amount;
    public String transactionId;

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.transactionId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return sender + " -> " + receiver + " : " + amount + " | " + transactionId;
    }
}
