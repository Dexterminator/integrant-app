clj-test:
	lein test-refresh

clj-test-once:
	lein test

cljs-test:
	lein doo phantom test

cljs-test-once:
	lein doo phantom test once

cljsbuild:
	lein cljsbuild once
