# Java 8 on [Lego Mindstorms](http://www.lego.com/en-us/mindstorms)

This project helps you to install a Java8 JRE on the Lego Mindstorms. It also helps you to setup a development environment where you can use gradle as a build tool for dependency management and pushing your code through WiFi to the Lego brick.

You can find this information also on [the EV3 wiki](https://sourceforge.net/p/lejos/wiki/Installing%20leJOS/) on the LeJOS website.

[Java on the EV3 brick](https://plus.google.com/+BartDeNeuter/posts/X8vqeBSyWmy)

## Install LeJOS on the EV3 brick

### Prerequisites

* An empty SD card with a FAT32 partition of at least 200MB. The card itself should be at least 1GB and no more than 32GB. SDXC cards are not supported by the EV3 hardware.
* __Optional__: If you want to push your code via WiFi to the EV3 brick, you will need a USB WiFi dongle. Driver modules for Atheros ATH9K and Realtex 8192cu based devices are included and will be loaded automatically based on the detected WiFi chipset. The EV3 has been tested using the NetGear WNA1100 and EDIMAX EW-7811Un adaptors, but others may work if they use the same chipsets. __[I'm using the EDIMAX as it is a very small dongle that is not sitting in the way while building a robot --Ed.]__

### Step 1. Install [LeJOS for EV3](http://www.lejos.org/ev3.php)

* Mount the SD card to your development machine
* Download the latest LeJOS distribution for EV3 on your development machine and unpack the archive: [leJOS_EV3_0.9.0](https://sourceforge.net/projects/lejos/files/lejos-EV3/0.9.0-beta/leJOS_EV3_0.9.0-beta.tar.gz/download)
* Unpack the archive lejosimage.zip to the root of the SD card. You find the file in the directory where you unpacked the LeJOS distribution.

### Step 2. Create an embedded Java 8 Runtime Environment for the EV3 Brick

* Go to the [Oracle website](http://www.oracle.com/technetwork/java/embedded/downloads/javase/javaseemeddedev3-1982511.html) for downloading the latest ejdk-8
* Accept the license agreement and download the latest ejdk-8 to your development machine. __ATTENTION: This is not the jre itself but contains the tools that we will use to build a jre for the EV3 brick__
* Unpack the ejdk-8 archive to your development machine
* Open a terminal/command line and go to the bin directory in the unpacked ejdk-8 directory
* execute the following command and the jre will be created in the ~/ejre-8 directory: ```./jrecreate.sh --dest ~/ejre-8```
* Create a __tar.gz__ archive from the ~/ejre-8 directory: ```cd ~ && tar -zcvf ~/ejre-8.tar.gz ejre-8```
* Copy the archive ~/ejre-8.tar.gz to the root of the SD card

### Step 3. Launch LeJOS on the EV3 brick

* Put the SD card in the EV3 brick
* * __Optional__: Put the WiFi dongle in the USB port of the EV3 brick
* Start the brick and it should after a while launch LeJOS
* * __Optional__: Configure WifI on the brick with the menu or follow [the wiki from LeJOS](https://sourceforge.net/p/lejos/wiki/Configuring%20Wifi/). The second IP is the IP we will use in our gradle build to point to the the EV3 brick.

## Create a gradle project for your application

I have created a gradle plugin for the EV3. The advantages of using a build tool like gradle are:
* Dependency management: A lot of Java libraries exist today and are published in repositories like [Maven Central](http://search.maven.org/) (ex.: guava, commons-lang3, ...). With gradle they are easy to add to your project.
* You can use your preferred IDE that supports gradle (eclipse, intellij, ...). It is a normal java project.
* Deploy your code to the EV3 brick from your IDE or from the terminal

Create a gradle project and apply the plugin 'com.github.bdeneuter.mindstorms.ev3'. Have a look at the [plugin website](https://github.com/bdeneuter/mindstorms-plugin) for more information on how to use it.

## TODO: Explain RX Java decorators around the LeJOS EV3 sensor API

Thanks to it's sensors, the EV3 is by nature event driven and therefor very suitable for toying around with reactive programming.

