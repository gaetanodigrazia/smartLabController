#! /bin/sh
docker-compose rm app
docker-compose build app
docker-compose up