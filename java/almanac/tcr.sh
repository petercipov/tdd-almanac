#!/bin/bash

set -o xtrace

( (mvn "-Dtest=$1" compile test) && git add . && git commit -m "T.C.R." ) || git checkout .