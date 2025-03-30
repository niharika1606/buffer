package BlockPacakage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Blockchain {
    private ArrayList<Block> chain;
    private int difficulty;
    private Queue<Transaction> transactionPool;

    public Blockchain(int difficulty) {
        this.chain = new ArrayList<>();
        this.difficulty = difficulty;
        this.transactionPool = new LinkedList<>();
        this.chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block(0, "0", new ArrayList<>());
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addTransaction(Transaction transaction) {
        transactionPool.add(transaction);
    }

    public void addBlock() {
        List<Transaction> transactionsToInclude = new ArrayList<>();
        while (!transactionPool.isEmpty()) {
            transactionsToInclude.add(transactionPool.poll());
        }
        Block newBlock = new Block(chain.size(), getLatestBlock().hash, transactionsToInclude);
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                return false;
            }
        }
        return true;
    }

    public void displayChain() {
        for (Block block : chain) {
            System.out.println("\nBlock " + block.index);
            System.out.println("Transactions: " + block.transactions);
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous Hash: " + block.previousHash);
        }
    }
}
