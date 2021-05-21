#!/bin/bash

( (mvn -Dtest=* compile test) && git add . && git commit -m "T.C.R." ) || git checkout .