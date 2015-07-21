var casper = require('casper').create();

casper.start('http://localhost:10555/', function() {
  this.echo(this.getTitle());
});

casper.thenOpen('http://www.brightnorth.co.uk/', function() {
  this.echo(this.getTitle());
});

casper.run();
