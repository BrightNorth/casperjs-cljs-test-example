var casper = require('casper').create();

casper.start('http://www.brightnorth.co.uk/', function() {
  this.echo(this.getTitle());
});

casper.thenOpen('http://www.brightnorth.co.uk/contact-us.html', function() {
  this.echo(this.getTitle());
});

casper.run();
