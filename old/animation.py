#!/usr/bin/python3
import subprocess
import time
files = [open("./gifcomp/" + f.decode("utf-8")).read() for f in subprocess.check_output(["ls", "./gifcomp/"]).split()]
while True:
    for f in files:
        time.sleep(0.15)
        print("[s{}[u".format(f), end="")
