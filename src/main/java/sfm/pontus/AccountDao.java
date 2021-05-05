package sfm.pontus;
import javax.persistence.Id;
import java.util.List;
public interface AccountDao extends AutoCloseable{
    public void saveUser (Account account);
    public void deleteUser (Account account);
    public void updateUser (Account account);
    public List<Account> getUsersAll();
    public Account getUserbyName(String account);
    public List<Account> getUsersbyName(String account);
    public Account getUserbyID(int id);
}
