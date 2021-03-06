#!/bin/bash

set -e

if [ "$1" = "" ]; then
  echo $0: usage: $0 target
  exit
fi

target=$1
this_directory=`dirname "$0"`

fly -t ${target} set-pipeline -p cg-customer-broker-tutorial -c ${this_directory}/tutorial-pipeline.yml

fly -t ${target} set-pipeline -p stratos-in-dev -c ${this_directory}/stratos-pipeline.yml
