var url = 'http://www.brightnorth.co.uk/contact-us.html';

casper.test.begin('', 1, function suite(test) {

  casper.start(url, function () {
    this.echo(this.getTitle());
    test.assertTitle("CasperJS-CLJS Test Example | Bright North",
      "Test page title is the one expected");

  });

  casper.run(function () {
    test.done();
  });

});
