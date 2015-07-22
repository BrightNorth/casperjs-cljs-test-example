var casper = require('casper').create();

var examplePage = 'http://localhost:10555',
  screenshotPath = 'casper/target/screenshots/example-page-body-js.png';

casper.start(examplePage, function () {
  this.echo("The title of the example page (" + examplePage + ") is: " + this.getTitle());
});

casper.waitForSelector('#bright-north', function () {
  this.captureSelector(screenshotPath, 'body');
  this.echo('Page loaded, screenshot captured! (' + screenshotPath + ')')
});

casper.run();
