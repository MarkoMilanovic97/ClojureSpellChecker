# ClojureSpellChecker/backend

## Content
This repository contains Clojure project that represents server part of the application.

## Repository structure
This project was initialized with Leiningen(build automation and dependancy management tool) command 'lein new app 'applicationName'' which generates blank template for the application.

Below will be listed only directories and files that have been configured and are crucial for the application to work.


* Directory [resources](./resources) contains contains a text file 'words.txt' which contains a huge amount of correctly written Serbian words (like dictionary).

* Directory [src/backend](./src/backend) contains 4 files:
* [core.clj](./src/backend/core.clj) - this file contains main function that is started with 'lein run' command.
* [routes.clj](./src/backend/routes.clj) - this file contains a route and a handler. The route is an API which takes as an argument a stirng and then passes that string to the handler which then proccess the word. The handler is calling a function checkSpelling (see below for more info) for the given word.
* [server.clj](./src/backend/server.clj) - this file is where a server is defined. Server is being run on port '4000', only one http method is allowed: 'post', and it accepts requests from origin 'localhost:3000'.
* [spellChecker.clj](./src/backend/spellChecker.clj) - this file contains all the logic for checking the word. It has few functions that are later combined into one function 'checkSpelling' that is being called by the above-mentioned handler. Function recives a word and then checks if that word exists in a set of words, that are loaded from the .txt file. If it does, it returns 'correct' and if not, it returns minimal Levenshtein distance between the most similar word to the entered one.


* File [project.clj](./project.clj) contains all the dependencies that are used in this Clojure project. Those are:
* http-kit - simple event-driven HTPP client and server for Clojure
* metosin/reitit - fast data-driven router for Clojure
* ring - Clojure web application library


## Setup

Follow steps below to successfully run the server:

1.Open a terminal in this directory and type a command: 'lein run'. This command starts the server. Do not close the terminal.


## Literature

For learning Clojure: https://www.braveclojure.com/

For spellchecker part of the server, literature and examples from: 
https://bernhardwenzel.com/articles/clojure-spellchecker/
were used.

For server part, literature from following sites was used:
* https://github.com/metosin/reitit/blob/master/doc/ring/ring.md
* https://github.com/http-kit/http-kit
* https://github.com/metosin/reitit
