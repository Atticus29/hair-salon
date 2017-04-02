import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      List<Stylist> stylists = Stylist.all();
      model.put("stylists", stylists);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.queryParams("stylist-name");
      String stylistHours = request.queryParams("stylist-hours");
      String stylistSpecialties = request.queryParams("stylist-specialties");
      String stylistImagePath = request.queryParams("stylist-image");
      Stylist newStylist = new Stylist(stylistName, stylistHours, stylistSpecialties, stylistImagePath);
      newStylist.save();
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistid");
      Stylist stylist = Stylist.findByName(stylistName);
      model.put("stylist", stylist);
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      System.out.println("You got into contact add");
      String stylistName = request.params(":stylistID");
      String stylistID = request.queryParams("stylistid");
      int stylistIDNumber = Integer.parseInt(stylistID);
      String clientName = request.queryParams("client-name");
      String clientPhone = request.queryParams("client-phone");
      String clientAddress = request.queryParams("client-address");
      String clientEmail = request.queryParams("client-email");
      String clientSpecial = request.queryParams("client-special");
      String clientStylistPref = request.queryParams("client-stylistPreference");
      String clientEmergencyName = request.queryParams("client-emergency-name");
      String clientEmergencyPhone = request.queryParams("client-emergency-phone");
      String okTextString = request.queryParams("client-textOpt");
      boolean okText = Boolean.parseBoolean(okTextString);
      Client newClient = new Client(stylistIDNumber, clientName, clientPhone, clientAddress, clientEmail, clientSpecial, clientStylistPref, clientEmergencyName, clientEmergencyPhone, okText);
      newClient.save();
      String url = String.format("/stylists/%s", stylistName);
      response.redirect(url);
      // model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistID/clients/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistID");
      int stylistID = Stylist.findByName(stylistName).getId();
      model.put("stylistName", stylistName);
      model.put("stylistID", stylistID);
      model.put("template", "templates/client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistID/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistIdName = request.params(":stylistID");
      String stylistName = request.queryParams("stylist-name");
      String stylistHours = request.queryParams("stylist-hours");
      String stylistSpecialties = request.queryParams("stylist-specialties");
      String stylistImagePath = request.queryParams("stylist-image");
      Stylist currentStylist = Stylist.findByName(stylistIdName);
      System.out.println("Right before update name is " + currentStylist.getName());
      currentStylist.update(stylistName, stylistHours, stylistSpecialties, stylistImagePath);
      System.out.println("After update name is " + currentStylist.getName());
      String url = String.format("/stylists/%s", stylistName);
      response.redirect(url);
      // model.put("template", "templates/temp-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistName/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistName");
      Stylist currentStylist = Stylist.findByName(stylistName);
      currentStylist.delete();
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistName/clients/:clientName", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistName");
      String clientName = request.params(":clientName");
      Client currentClient = Client.findByName(clientName);
      model.put("stylistID", stylistName);
      model.put("client", currentClient);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistID/clients/:clientName/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistIdName = request.params(":stylistID");
      int stylistIDNumber = Stylist.findByName(stylistIdName).getId();
      String originalClientName = request.params(":clientName");
      String updatedClientName = request.queryParams("client-name");
      String clientPhone = request.queryParams("client-phone");
      String clientAddress = request.queryParams("client-address");
      String clientEmail = request.queryParams("client-email");
      String clientSpecial = request.queryParams("client-special");
      String clientStylistPref = request.queryParams("client-stylistPreference");
      String clientEmergencyName = request.queryParams("client-emergency-name");
      String clientEmergencyPhone = request.queryParams("client-emergency-phone");
      String okTextString = request.queryParams("client-textOpt");
      boolean okText = Boolean.parseBoolean(okTextString);
      Client currentClient = Client.findByName(originalClientName);
      currentClient.update(stylistIDNumber, updatedClientName, clientPhone, clientAddress, clientEmail, clientSpecial, clientStylistPref, clientEmergencyName, clientEmergencyPhone, okText);
      String url = String.format("/stylists/%s", stylistIdName);
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistID/clients/:clientName/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistID");
      Client currentClient = Client.findByName(request.params(":clientName"));
      currentClient.delete();
      String url = String.format("/stylists/%s", stylistName);
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
