# casperjs-cljs-test-example


## Description

Load an example website built in ClojureScript based on the Chestnut template. This can be used to run CasperJS tests 
written in ClojureScript and cross-compiled to JavaScript. 

## Project Structure

The example website is based on the standard Chestnut template. Added to this is a `casper` folder containing a CasperJS 
script and test and the corresponding ClojureScript translated versions.

The `casper` and `casper-test` lein aliases cross-compile the namespaces in the `casper/script` and `casper/test` 
folders respectively and run the compiled JavaScript outputs using CapserJS.

## Requirements

* [CasperJS 1.1.0-DEV](http://casperjs.readthedocs.org/en/latest/# ' target "_blank" ')
* [Leiningen 2.5.1](https://github.com/technomancy/leiningen ' target "_blank" ')

## Trying it out

Open a terminal and type `lein repl` to start a Clojure REPL
(interactive prompt).

In the REPL, type

```clojure
(run)
(browser-repl)
```

The call to `(run)` does two things, it starts the webserver at port
10555, and also the Figwheel server which takes care of live reloading
ClojureScript code and CSS. Give them some time to start.

Running `(browser-repl)` starts the Weasel REPL server, and drops you
into a ClojureScript REPL. Evaluating expressions here will only work
once you've loaded the page, so the browser can connect to Weasel.

When you see the line `Successfully compiled "resources/public/app.js"
in 21.36 seconds.`, you're ready to go. Browse to
`http://localhost:10555` and enjoy.

While this command is running, open a new terminal window and enter `lein casper` to run the CasperJS script and 
`lein casper-test` to run the tests.

Running `lein casper` should print:

```
\Compiling ClojureScript.
Compiling "casper/target/app.js" from ["casper/script"]...
Successfully compiled "casper/target/app.js" in 15.439 seconds.
Running ClojureScript test: casper
CasperJS-CLJS Test Example | Bright North
Product Feed and Image Optimisation Technology | Bright North
```

Running `lein casper-test` should print:

```
Successfully compiled "casper/target/app_test.js" in 15.252 seconds.
Running ClojureScript test: casper
Test file: casper/target/app_test.js
# Untitled suite in casper/target/app_test.js
CasperJS-CLJS Test Example | Bright North
PASS Test page title is the one expected
PASS 1 test executed in 0.423s, 1 passed, 0 failed, 0 dubious, 0 skipped.
```

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

## Chestnut

Created with [Chestnut](http://plexus.github.io/chestnut/) 0.8.1 (90e701e0).
