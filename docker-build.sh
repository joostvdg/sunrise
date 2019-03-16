#!/usr/bin/env bash
## This is for building with BuildKit!
echo "This will only work with BuildKit!"
docker build -t sunrise --progress plain -f Dockerfile.buildkit .
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run --network host sunrise"

