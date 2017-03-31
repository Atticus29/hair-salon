import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  private Client testClient;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp() {
    testClient = new Client(1, "Victoria Porkchop Parker", "6095779090", "1 Porkchop Avenue Portland, OR 97217", "thatNoseThough@gmail.com", "Make sure to say hey to her", "Naomi Smalls", "Bennett Bennettson", "6095779091", true);
    // testClient.save();
  }

  @Test
  public void client_instantiatesCorrectly_true(){
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void getters_returnWhatTheyreSupposedTo_true(){
    assertEquals(1, testClient.getStylistid());
    assertEquals("Victoria Porkchop Parker", testClient.getName());
    assertEquals("6095779090", testClient.getPhone());
    assertEquals("thatNoseThough@gmail.com", testClient.getEmail());
    assertEquals("Make sure to say hey to her", testClient.getSpecial_details());
    assertEquals("Naomi Smalls", testClient.getPreferred_stylist());
    assertEquals("Bennett Bennettson", testClient.getEmergency_name());
    assertEquals("6095779091", testClient.getEmergency_phone());
    assertEquals(true, testClient.getOk_to_text());
  }

}
