import java.time.LocalDateTime;
import java.util.List;

public class Home {
    private LocalDateTime dateHome;
    // No transactionHome variable shown in updated diagram
    
    public LocalDateTime getDateHome() {
        return dateHome;
    }
    
    public void setDateHome(LocalDateTime dateHome) {
        this.dateHome = dateHome;
    }
    
    public List<Transaction> getTransactionHome() {
        return null;
    }
    
    public double getIncomeHome() {
        return 0;
    }
    
    public double getExpenseHome() {
        return 0;
    }
    
    public double getBalance() {
        return 0;
    }
}