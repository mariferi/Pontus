package sfm.pontus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaAccountDao implements  AccountDao{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveUser(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(Account account) {
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(Account account) {
        saveUser(account);
    }

    @Override
    public List<Account> getUsersAll() {
        String sqlstr="SELECT account FROM Account account";
        TypedQuery<Account> query=entityManager.createQuery(sqlstr,Account.class);
        return query.getResultList();
    }

    @Override
    public Account getUserbyName(String name) {
        String sqlstr="SELECT account FROM Account account WHERE NAME="+"'"+name+"'";
        TypedQuery<Account> query=entityManager.createQuery(sqlstr,Account.class);
        return query.getSingleResult();
    }

    @Override
    public List<Account> getUsersbyName(String name) {
        String sqlstr="SELECT account FROM Account account WHERE NAME="+"'"+name+"'";
        TypedQuery<Account> query=entityManager.createQuery(sqlstr,Account.class);
        return query.getResultList();
    }

    @Override
    public Account getUserbyID(int id) {
        String sqlstr="SELECT account FROM Account account WHERE ID="+id;
        TypedQuery<Account> query=entityManager.createQuery(sqlstr,Account.class);
        return query.getSingleResult();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
