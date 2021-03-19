$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/cucumber/features/google-text-search.feature");
formatter.feature({
  "line": 1,
  "name": "Google search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "user can search any keyword",
  "description": "",
  "id": "google-search;user-can-search-any-keyword",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "an open browser with google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "a keyword \u003ckeyword\u003e is entered in input field",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the first one should contain \u003cexpectedWord\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "close browser",
  "keyword": "And "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "google-search;user-can-search-any-keyword;",
  "rows": [
    {
      "cells": [
        "keyword",
        "expectedWord"
      ],
      "line": 9,
      "id": "google-search;user-can-search-any-keyword;;1"
    },
    {
      "cells": [
        "karol",
        "karol"
      ],
      "line": 10,
      "id": "google-search;user-can-search-any-keyword;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "user can search any keyword",
  "description": "",
  "id": "google-search;user-can-search-any-keyword;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "an open browser with google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "a keyword karol is entered in input field",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the first one should contain karol",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearch.openGoogleSearch()"
});
formatter.result({
  "duration": 4670244001,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "karol",
      "offset": 10
    }
  ],
  "location": "GoogleSearch.enterKeyword(String)"
});
formatter.result({
  "duration": 1909944900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "karol",
      "offset": 29
    }
  ],
  "location": "GoogleSearch.theFirstOneShouldContainSelenium(String)"
});
formatter.result({
  "duration": 93400,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.closeBrowser()"
});
formatter.result({
  "duration": 699217000,
  "status": "passed"
});
});