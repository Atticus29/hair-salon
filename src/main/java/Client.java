import org.sql2o.*;
import java.util.List;

public class Client {
  private int id;
  private int stylistid;
  private String name;
  private String phone;
  private String address;
  private String email;
  private String special_details;
  private String preferred_stylist;
  private String emergency_name;
  private String emergency_phone;
  private boolean ok_to_text;

  public Client(int stylistid, String name, String phone, String address, String email, String special_details, String preferred_stylist, String emergency_name, String emergency_phone, boolean ok_to_text) {
    this.stylistid = stylistid;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.email = email;
    this.special_details = special_details;
    this.preferred_stylist = preferred_stylist;
    this.emergency_name = emergency_name;
    this.emergency_phone = emergency_phone;
    this.ok_to_text = ok_to_text;
  }

  public int getId(){
    return this.id;
  }

  public int getStylistid(){
    return this.stylistid;
  }

  public String getName(){
    return this.name;
  }

  public String getPhone(){
    return this.phone;
  }

  public String getAddress(){
    return this.address;
  }

  public String getEmail(){
    return this.email;
  }

  public String getSpecial_details(){
    return this.special_details;
  }

  public String getPreferred_stylist(){
    return this.preferred_stylist;
  }

  public String getEmergency_name(){
    return this.emergency_name;
  }

  public String getEmergency_phone(){
    return this.emergency_phone;
  }

  public boolean getOk_to_text(){
    return this.ok_to_text;
  }

  @Override
  public boolean equals(Object secondClient){
    if(!(secondClient instanceof Client)){
      return false;
    } else{
      Client newClient = (Client) secondClient;
      return newClient.getStylistid() == this.getStylistid() &&
      newClient.getName().equals(this.getName()) &&
      newClient.getPhone().equals(this.getPhone()) &&
      newClient.getAddress().equals(this.getAddress()) &&
      newClient.getEmail().equals(this.getEmail()) &&
      newClient.getSpecial_details().equals(this.getSpecial_details()) &&
      newClient.getPreferred_stylist().equals(this.getPreferred_stylist()) &&
      newClient.getEmergency_name().equals(this.getEmergency_name()) &&
      newClient.getEmergency_phone().equals(this.getEmergency_phone()) &&
      newClient.getOk_to_text() == this.getOk_to_text() &&
      newClient.getId() == this.getId();
    }
  }

  public void save(){
    String sqlCommand = "INSERT INTO clients (stylistid, name, phone, address, email, special_details, preferred_stylist, emergency_name, emergency_phone, ok_to_text) VALUES (:stylistid, :name, :phone, :address, :email, :special_details, :preferred_stylist, :emergency_name, :emergency_phone, :ok_to_text);";
    try(Connection con=DB.sql2o.open()){
      this.id = (int) con.createQuery(sqlCommand, true)
      .addParameter("stylistid", this.stylistid)
      .addParameter("name", this.name)
      .addParameter("phone", this.phone)
      .addParameter("address", this.address)
      .addParameter("email", this.email)
      .addParameter("special_details", this.special_details)
      .addParameter("preferred_stylist", this.preferred_stylist)
      .addParameter("emergency_name", this.emergency_name)
      .addParameter("emergency_phone", this.emergency_phone)
      .addParameter("ok_to_text", this.ok_to_text)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find(int id){
    String sqlCommand = "SELECT * FROM clients WHERE id=:id;";
    try(Connection con = DB.sql2o.open()){
      Client result = con.createQuery(sqlCommand)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
      return result;
    }
  }

  public static List<Client> all(){
    String sqlCommand = "SELECT * FROM clients;";
    try(Connection con = DB.sql2o.open()){
      List<Client> results = con.createQuery(sqlCommand)
      .executeAndFetch(Client.class);
      return results;
    }
  }

  public void setId(int id){
    this.id = id;
  }

  public void setStylistId(int id){
    this.stylistid = id;
  }

  public void update(int stylistid, String name, String phone, String address, String email, String special_details, String preferred_stylist, String emergency_name, String emergency_phone, boolean ok_to_text){
    String sqlCommand = "UPDATE clients SET stylistid=:stylistid, name=:name, phone=:phone, address=:address, email=:email, special_details=:special_details, preferred_stylist=:preferred_stylist, emergency_name=:emergency_name, emergency_phone=:emergency_phone, ok_to_text=:ok_to_text WHERE id=:id;";
    try(Connection con=DB.sql2o.open()){
      con.createQuery(sqlCommand)
      .addParameter("stylistid", stylistid)
      .addParameter("name", name)
      .addParameter("phone", phone)
      .addParameter("address", address)
      .addParameter("email", email)
      .addParameter("special_details", special_details)
      .addParameter("preferred_stylist", preferred_stylist)
      .addParameter("emergency_name", emergency_name)
      .addParameter("emergency_phone", emergency_phone)
      .addParameter("ok_to_text", ok_to_text)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }


}
