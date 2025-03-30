package BlockPacakage;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(3);

        System.out.println("Adding Transactions...");
        blockchain.addTransaction(new Transaction("Alice", "Bob", 10));
        blockchain.addTransaction(new Transaction("Bob", "Charlie", 5));

        System.out.println("Mining new Block...");
        blockchain.addBlock();

        System.out.println("\nBlockchain Validation: " + blockchain.isChainValid());
        blockchain.displayChain();
    }
    }

