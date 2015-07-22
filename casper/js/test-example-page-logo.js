var examplePage = 'http://localhost:10555',
  brightNorthLogoSelector = '#bright-north',
  screenshotPath = 'casper/target/screenshots/test-example-page-js.png';


casper.test.begin('The Bright North logo should be visible', 1, function suite(test) {

  casper.start(examplePage, function () {
    this.echo("The title of the example page (" + examplePage + ") is: " + this.getTitle());
  });

  casper.waitForSelector(brightNorthLogoSelector)
    .then(function () {
      test.assertVisible(brightNorthLogoSelector);
      this.echo('The selector "' + brightNorthLogoSelector + '" is visible!');
      this.captureSelector(screenshotPath, 'body')
    });

  casper.run(function () {
    test.done();
  });

});
