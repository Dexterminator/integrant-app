clean:
	lein clean

npm-install:
	lein npm install

stylusbuild: clean npm-install
	lein npm run watch:stylus

stylusbuild-once: clean npm-install
	lein npm run build:stylus

cljsbuild:
	lein cljsbuild once

uberjar:
	lein uberjar

clj-test: clean
	lein test-refresh

clj-test-once: clean
	lein test

cljs-test: clean
	lein doo phantom test

cljs-test-once: clean
	lein doo phantom test once
