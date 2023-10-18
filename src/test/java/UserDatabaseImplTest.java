import com.itfactory.User;
import com.itfactory.UserDatabaseImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserDatabaseImplTest {
    private UserDatabaseImpl userDatabase;

    @BeforeEach
    public void setUp() {
        userDatabase = new UserDatabaseImpl();
    }

    @Test
    public void testShowAllUsers() {
        List<User> users = userDatabase.showAllUsers();

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void testShowUserBasedOnID() {
        User sampleUser = new User(1, "John", "Doe", "john@example.com", 30);
        userDatabase.createUser(sampleUser);

        User retrievedUser = userDatabase.showUserBasedOnID(1);

        assertEquals(sampleUser.getId(), retrievedUser.getId());
        assertEquals(sampleUser.getNume(), retrievedUser.getNume());
        assertEquals(sampleUser.getPrenume(), retrievedUser.getPrenume());
        assertEquals(sampleUser.getEmail(), retrievedUser.getEmail());
        assertEquals(sampleUser.getVarsta(), retrievedUser.getVarsta());
    }

    @Test
    public void testUpdateUser() {
        User sampleUser = new User(1, "John", "Doe", "john@example.com", 30);
        userDatabase.createUser(sampleUser);

        userDatabase.updateUser(1, "UpdatedName", "UpdatedLastName", "updated@example.com", 35);

        User updatedUser = userDatabase.showUserBasedOnID(1);

        assertEquals("UpdatedName", updatedUser.getNume());
        assertEquals("UpdatedLastName", updatedUser.getPrenume());
        assertEquals("updated@example.com", updatedUser.getEmail());
        assertEquals(35, updatedUser.getVarsta());
    }

    @Test
    public void testDeleteUser() {
        User sampleUser = new User(1, "John", "Doe", "john@example.com", 30);
        userDatabase.createUser(sampleUser);

        userDatabase.deleteUser(1);

        User deletedUser = userDatabase.showUserBasedOnID(1);

        assertNull(deletedUser);
    }

}
