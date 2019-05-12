.PHONY: all commit

BUILDID=$(shell date +%Y%m%d-%H:%M:%S)
CFLAGS=-Wall -g

all: myprogram commit

commit:
    git add -A .
    git commit -m 'Automatic commit of successful build $(BUILDID)'

clean:
    rm -f *.o
    rm -f myprogram