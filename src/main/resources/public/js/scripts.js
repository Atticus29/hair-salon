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
    $('html, body').animate({
       scrollTop: $("#hidden-edit-form").offset().top
   }, 2000);
  });

  $("#client-update-button").click(function(){
    event.preventDefault();
    $("#client-update-form").show();
    $('html, body').animate({
       scrollTop: $("#client-update-form").offset().top
   }, 2000);
  });

  // $("#stylist-update-form").submit(function(){
  //   event.preventDefault();
  //   $("#hidden-edit-form").hide();
  // });
});
