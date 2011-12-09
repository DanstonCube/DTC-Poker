#!/bin/bash

mkdir ./tmp/
cd ./tmp/

#spout
wget http://ci.getspout.org/job/Spout/lastSuccessfulBuild/artifact/target/spout-dev-SNAPSHOT.jar

rm ../plugins/spout*.jar
mv spout-dev-SNAPSHOT.jar ../dist/server/plugins/


#spoutapi
wget http://ci.getspout.org/job/SpoutAPI/lastSuccessfulBuild/artifact/target/spoutapi-dev-SNAPSHOT.jar
mv spoutapi-dev-SNAPSHOT.jar ../libs/

#spoutcraftapi
wget http://ci.getspout.org/job/SpoutcraftAPI/lastSuccessfulBuild/artifact/target/spoutcraftapi-dev-SNAPSHOT.jar
mv spoutcraftapi-dev-SNAPSHOT.jar ../libs/


#craftbukkit
wget http://ci.bukkit.org/job/dev-CraftBukkit/lastSuccessfulBuild/artifact/target/craftbukkit-1.0.0-SNAPSHOT.jar
mv craftbukkit-1.0.0-SNAPSHOT.jar ../dist/server/

cd ../


