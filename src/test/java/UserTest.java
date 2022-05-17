import junit.framework.TestCase;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class UserTest extends TestCase {

    @Test
    public void testGetAllUsers() {
        User user1 = new User("Michael", 12, Sex.Male);
        User user2 = new User("Roman", 13, Sex.Male);
        User user3 = new User("Sofi", 22, Sex.Female);
        User user4 = new User("Ann", 24, Sex.Male);

        List<User> expected = User.getAllUsers();
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        actual.add(user3);
        actual.add(user4);
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testGetAllUsers_NO_Null() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }
    @Test
    public void testGetAllUsers_MALE() {
        User user1 = new User("Michael", 12, Sex.Male);
        User user2 = new User("Roman", 13, Sex.Male);
        User user3 = new User("Sofi", 22, Sex.Female);
        User user4 = new User("Ann", 24, Sex.Female);

        List<User> expected = User.getAllUsers(Sex.Male);

        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllUsers_FEMALE() {
        User user1 = new User("Michael", 12, Sex.Male);
        User user2 = new User("Roman", 13, Sex.Male);
        User user3 = new User("Sofi", 22, Sex.Female);
        User user4 = new User("Ann", 24, Sex.Female);

        List<User> expected = User.getAllUsers(Sex.Female);

        List<User> actual = new ArrayList<>();
        actual.add(user3);
        actual.add(user4);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetAllUsers_MALE_WhenNotNull_thenCorrect() {
        User user1 = new User("Michael", 12, Sex.Male);
        User user2 = new User("Roman", 13, Sex.Male);
        User user3 = new User("Sofi", 22, Sex.Female);
        User user4 = new User("Ann", 24, Sex.Female);

        List<User> expected = User.getAllUsers(Sex.Male);

        assertThat(expected, notNullValue());
    }
    @Test
    public void testGetAllUsers_MALE_WhenTwo_thenCorrect() {
        User user1 = new User("Michael", 12, Sex.Male);
        User user2 = new User("Roman", 13, Sex.Male);
        User user3 = new User("Sofi", 22, Sex.Female);
        User user4 = new User("Ann", 24, Sex.Female);

        List<User> expected = User.getAllUsers(Sex.Male);

        assertThat(expected, hasSize(2));
    }
}