install:
	make -C app install
run-dist:
	make -C run-dist
run:
	make -C app run
build-run: build run

.PHONY: build
