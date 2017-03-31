import org.sql2o.*;

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

}
