# Java 8 on [Lego Mindstorms](http://www.lego.com/en-us/mindstorms)

This project helps you to install a Java8 JRE on the Lego Mindstorms. It also helps you to setup a development environment where you can use gradle as a build tool for dependency management and pushing your code to the Lego brick.

You can find this information also on [the EV3 wiki](https://sourceforge.net/p/lejos/wiki/Installing%20leJOS/) on the LeJOS website.

## Install LeJOS on the EV3 brick

### Prerequisites

* An empty SD card with a FAT32 partition of at least 200MB. The card itself should be at least 1GB and no more than 32GB. SDXC cards are not supported by the EV3 hardware.
* __Optional__: If you want to push your code via WiFi to the EV3 brick, you will need a USB WiFi dongle. Driver modules for Atheros ATH9K and Realtex 8192cu based devices are included and will be loaded automatically based on the detected WiFi chipset. The EV3 has been tested using the NetGear WNA1100 and EDIMAX EW-7811Un adaptors, but others may work if they use the same chipsets. __[I'm using the EDIMAX as it is a very small dongle that is not in the way when building a robot --Ed.]__

### Step 1. Install [LeJOS for EV3](http://www.lejos.org/ev3.php)

* Mount the SD card to your development machine
* Download the latest LeJOS distribution for EV3 on your development machine and unpack the archive: [leJOS_EV3_0.9.0](https://sourceforge.net/projects/lejos/files/lejos-EV3/0.9.0-beta/leJOS_EV3_0.9.0-beta.tar.gz/download)
* Unpack the archive lejosimage.zip to the SD card. You find the file in the directory where you unpacked the LeJOS distribution.

### Step 2. Create an embedded Java 8 Runtime Environment for the EV3 Brick

* Go to the [Oracle website](http://www.oracle.com/technetwork/java/embedded/downloads/javase/javaseemeddedev3-1982511.html) for downloading the latest ejre-8
* Accept the license agreement and download the latest ejdk-8 to your development machine. __REMARK: This is not the jre itself but contains the tools that we will use to build a jre for the EV3 brick__
* Unpack the ejdk-8 to your development machine
* Open a terminal/command line and go to the bin directory in the unpacked ejdk-8 directory
* execute the command: ```./jrecreate.sh --dest ~/ejre-8 ```. The jre will be created in the ~/ejre-8 directory.
* Create a __tar.gz__ archive from the ~/ejre-8 directory: ```tar -zcvf ~/ejre-8.tar.gz ~/ejre-8  ```


