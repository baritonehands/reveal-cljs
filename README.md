# reveal-cljs

Inspired by the great work on [reveal.js](https://github.com/hakimel/reveal.js/)
and the dislike towards JavaScript, this small project was created to provide a
simple wrapper in ClojureScript to create awesome presentations.

It uses Hiccup-syntax for templating, which makes it very easy to create
slides.

Currently, there is no speaker-mode etc. available, since this project uses
[lein-figwheel](https://github.com/bhauman/lein-figwheel) to get
hotcode-support in ClojureScript.

## Requirements

This project is built using [shadow-cljs](http://shadow-cljs.org/). You also need a JDK installed.

    npm install -g shadow-cljs

## Usage

Set your desired options in
[core.cljs](https://github.com/n2o/reveal-cljs/blob/master/src/reveal/core.cljs#L10).
More options can be found
[here](https://github.com/hakimel/reveal.js#configuration).

Create your slides in
[slides.cljs](https://github.com/n2o/reveal-cljs/blob/master/src/reveal/slides.cljs)
and add them to the list in the function `all`. Code snippets will be rendered using [klipse](https://github.com/viebel/klipse) (see slide-3).

Then start the development server as seen in the Setup section.

## Installation & Setup

Download the dependency reveal.js (specified in `package.json`) with:

    npm install

To get an interactive development environment run:

    shadow-cljs clj-run build/watch

and open your browser at [localhost:8080](http://localhost:8080/).
This will auto compile and send all changes to the browser without the need to reload.

To make a release version (for Github Pages):

    shadow-cljs clj-run build/release

Then open index.html to see the prebuilt version.

## License

Copyright © 2018 Brian Gregg

Distributed under the [MIT](LICENSE) License version.
