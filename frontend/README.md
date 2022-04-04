# ClojureSpellChecker/frontend

## Content
This repository contains React project that represents GUI part of the application.

## Repository structure
This project was initialized with 'npx create-react-app 'applicationName'' which generates blank template for the application.

Below will be listed only directories and files that have been configured and are crucial for the application to work.


* Directory [src](./src) contains 2 important files:
* [App.css](./src/App.css) - this is a .css file where styles for the application are added.
* [App.js](./src/App.js) - this file contains a JavaScript and HTML code that is being used for the application. When user goes to the page, he can see a input field in which he need to enter a word and then click on submit button which then, if the field is not empty, calls the API for the entered word. If word is spelled correctly, user can see success(green) message. If not, user can see warning(red) message and is being asked if he ment min levenshtein distance word. If the field is empty and user tries to submit, he gets the adecvate message(error label) that reminds him that field should not be empty.

* File [package.json](./package.json) contains all the dependencies that are used in this React project. Those are:
* axios - promise base HTTP client
* formik - library that keeps track of values/errors/visited fields, orchestrating validation, and handling submission
* yup - schema builder for runtime value parsing and validation
* react-notifications - notification manager for React


## Setup

Follow steps below to successfully run the GUI:

1.Open a terminal in this directory and type a command: 'npm run'. This command starts the GUI. Do not close the terminal.
