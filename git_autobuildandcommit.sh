#!/bin/bash

git fetch upstream
git merge upstream/master

./build_and_dist.sh

git commit -a -m "autobuildupdate"
git push origin master
