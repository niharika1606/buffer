package BlockPacakage;

//import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

public class Block {
    public int index;
    public String previousHash;
    public String hash;
    public long timestamp;
    public int nonce;
    public List<Transaction> transactions;

    public Block(int index, String previousHash, List<Transaction> transactions) {
        this.index = index;
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.timestamp = new Date().getTime();
        this.nonce = 0;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String input = index + previousHash + timestamp + transactions.toString() + nonce;
        return Utils.applySHA256(input);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }
}
