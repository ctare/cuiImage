load:
	mv ~/Desktop/load.jpg ./
palette:
	groovy Main.groovy
	python3 tocol.py `cat colp` >> $(img).palette
out:
	./img.sh $(img).palette

all: load palette out
build: palette out
