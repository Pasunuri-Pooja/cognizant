$(document).ready(function () {
  $('#registerBtn').click(function () {
    const card = $('#eventCard');

    if (card.is(':visible')) {
      card.fadeOut(400);
    } else {
      card.fadeIn(400);
    }
  });
});
