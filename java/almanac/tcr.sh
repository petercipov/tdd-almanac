#!/bin/bash

set -o xtrace

( (mvn "-Dtest=$1" compile test) && git add . && git commit -m $2 ) || git checkout .