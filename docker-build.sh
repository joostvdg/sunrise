#!/usr/bin/env bash
docker build -t sunrise --progress plain .
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run --network host sunrise"

