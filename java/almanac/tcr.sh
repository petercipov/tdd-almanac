#!/bin/bash

mvn -Dtest=* compile test

RESULT=$?
if [ $RESULT -eq 0 ]; then
  git commit -m ''
else
  echo "Failed"
fi