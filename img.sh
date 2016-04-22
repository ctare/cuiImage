#!/bin/zsh
SIDE=50
COLP=($(cat "$1"))
COUNT=1
RESULT=""
for i in $(seq 1 $SIDE); do
  for j in $(seq 1 $SIDE); do
    RESULT+="[$(( $i - 1 ));$(( $j + $j - 1 ))H$COLP[$(( $COUNT ))]##"
    COUNT=$(( $COUNT + 1 ))
  done
done
echo $RESULT
