$(function(){
  $("#stylist-reveal").click(function(){
    event.preventDefault();
    $("#about-content").hide();
    $("#main-content").show();
  });

  $("#about-reveal").click(function(){
    event.preventDefault();
    $("#main-content").hide();
    $("#about-content").show();
  });

  $("#stylist-edit-trigger").click(function(){
    event.preventDefault();
    $("#hidden-edit-form").show();
  });

  $("#update-button").click(function(){
    event.preventDefault();
    $("#hidden-edit-form").hide();
  });
});
