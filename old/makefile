load:
	set -- $$(cat settings) && mv ~/Desktop/load.$$1 ./
palette:
	groovy Main.groovy
	python3 tocol.py `cat colp` >> $(img).palette
gif:
	for i in $$(ls ./gifanim/); do python3 tocol.py $$(cat ./gifanim/$$i) > ./gifout/$$i.palette; done
gout:
	for i in $$(ls ./gifout/); do ./img.sh ./gifout/$$i > ./gifcomp/$$i.txt; done 
out:
	./img.sh $(img).palette

all: load palette out
build: palette out
