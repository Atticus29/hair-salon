import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class ClientTest {
  private Client testClient;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp() {
    testClient = new Client(1, "Victoria Porkchop Parker", "6095779090", "1 Porkchop Avenue Portland, OR 97217", "thatNoseThough@gmail.com", "Make sure to say hey to her", "Naomi Smalls", "Bennett Bennettson", "6095779091", true);
    testClient.save();
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

  @Test
  public void all_returnsListOfClients_true(){
    Client testClient2 = new Client (1, "Jade Jolie", "6095778080", "1 Lippy Lane Gainesville, FL 97213", "tuna_on_a_platter@gmail.com", "Make sure her hips match her shoulders", "Kim Chi", "Rebecca Rebeccasdottir", "6095778081", true);
    testClient2.save();
    List<Client> results = Client.all();
    assertEquals(2, results.size());
    assertEquals(false, results.get(0).equals(results.get(1)));
  }

  @Test
  public void save_addsEntryToDatabase_true(){
    Client retrievedClient = Client.find(testClient.getId());
    assertEquals(testClient, retrievedClient);
  }

  @Test
  public void find_returnsSecondClient_true(){
    Client testClient2 = new Client (1, "Jade Jolie", "6095778080", "1 Lippy Lane Gainesville, FL 97213", "tuna_on_a_platter@gmail.com", "Make sure her hips match her shoulders", "Kim Chi", "Rebecca Rebeccasdottir", "6095778081", true);
    testClient2.save();
    int Client2Id = testClient2.getId();
    assertEquals(testClient2, Client.find(Client2Id));
  }

  @Test
  public void equals_correctlyAssessesTheEqualityOfClientObjects_true(){
    Client testClient2 = new Client (1, "Victoria Porkchop Parker", "6095779090", "1 Porkchop Avenue Portland, OR 97217", "thatNoseThough@gmail.com", "Make sure to say hey to her", "Naomi Smalls", "Bennett Bennettson", "6095779091", true);
    testClient2.setId(testClient.getId());
    assertEquals(testClient, testClient2);
  }

  @Test
  public void setStylistId_allowsUserToChangeStylistID_true(){
    int originalStylistid = testClient.getStylistid();
    testClient.setStylistId(originalStylistid + 1);
    assertFalse(originalStylistid == testClient.getStylistid());
  }

  @Test
  public void update_changesTheValuesOfAStylistInDatabase_true(){
    Client retrievedClient = Client.find(testClient.getId());
    assertTrue(retrievedClient.equals(testClient));
    testClient.update(1, "Bebe Zahara Benet", "6095779090", "1 Porkchop Avenue Portland, OR 97217", "beautyFace@gmail.com", "Make sure to say hey to her", "Naomi Smalls", "Bennett Bennettson", "5555555555", true);
    // assertFalse(retrievedClient.equals(testClient));
  }

}
