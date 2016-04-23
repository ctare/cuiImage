load:
	set -- $$(cat settings) && mv ~/Desktop/load.$$1 ./
palette:
	groovy Main.groovy
	python3 tocol.py `cat colp` >> $(img).palette
out:
	./img.sh $(img).palette

all: load palette out
build: palette out
