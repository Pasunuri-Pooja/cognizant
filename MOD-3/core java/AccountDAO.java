import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    /**
     * Transfers money from one account to another.
     * Uses JDBC transaction management.
     */
    public boolean transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            // Disable auto-commit mode
            conn.setAutoCommit(false);

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                // Debit fromAccount
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                debitStmt.setDouble(3, amount);
                int rowsDebited = debitStmt.executeUpdate();

                if (rowsDebited != 1) {
                    // Debit failed: insufficient funds or account not found
                    conn.rollback();
                    System.out.println("Debit failed: insufficient funds or invalid account.");
                    return false;
                }

                // Credit toAccount
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int rowsCredited = creditStmt.executeUpdate();

                if (rowsCredited != 1) {
                    // Credit failed: invalid account
                    conn.rollback();
                    System.out.println("Credit failed: invalid account.");
                    return false;
                }

                // If both succeed, commit the transaction
                conn.commit();
                System.out.println("Transfer successful!");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            } finally {
                conn.setAutoCommit(true);  // restore default
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
