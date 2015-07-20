var url = 'http://www.brightnorth.co.uk/contact-us.html';

//var casper = require('casper').create();

casper.test.begin('', 1, function suite(test) {

  casper.start(url, function () {
    this.echo(this.getTitle());
    test.assertTitle("Improve Your eCommerce Product Data Feeds | Bright North",
      "bright north homepage title is the one expected");

  });


  casper.run(function () {
    test.done();
  });

});
