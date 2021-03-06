#!/bin/bash

set +x
set -e

cf login -a $CF_API -u $CF_USER -p $CF_PWD -o $CF_ORG -s $CF_SPACE

cf delete -f $BROKER_APPNAME || echo "App could not be deleted: ${BROKER_APPNAME}"
cf delete -f $STRATOS_APPNAME || echo "App could not be deleted: ${STRATOS_APPNAME}"
cf delete -f $CONSUMER_APPNAME || echo "App could not be deleted: ${CONSUMER_APPNAME}"

cf delete-service -f $SERVICE_INSTANCE_NAME || echo "Service instance could not be deleted: ${SERVICE_INSTANCE_NAME}"
