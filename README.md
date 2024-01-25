# Power-Plan-Switcher
The *Power Plan Switcher* is a simple system tray application for changing the windows power plans.
Primarily it is used for not having to open the settings window of windows to change the power plan.  
It works by using the *powercfg* command provided in Windows. 


## Config File (powercfg.txt)
The config file has a basic structure:
`UUID of a power plan` followed by `Name you want the power plan to have`, separated by a comma.  
You can obtain the UUID of your local power plans by either running the program for the first time, when the file hasn't been created yet.  
Or using the command prompt or powershell with this command: `powercfg -l`


## Quick Start Guide
1. First you download the installer and complete the installer process or the program itself and save it to a location you want.  
2. Then you start the program, by double-clicking, you should se the icon below appear in your system tray.  
<img src="resources/ch/giuntini/powermodeswitch/images/ico.png" width="50"></img>
3. Right-click on the icon and a menu will appear. At the top there are the different power plans from your system. 
Followed by the active power plan, the option to edit the config file and exit the program. 
4. Now you ar good to go. *The following steps are optional.*
5. If you want to change the names of your power plans for only the program. You either click in the menu on 
*Open config file...* or you head to the directory in which you saved the program and edit the file from there.
6. In that file there are all your power plans currently on your system, with their UUID and name. 
Simply edit the name and restart the program.  
Changing the names can be useful if the names of the system are long in length or for recognise them faster.
7. If you want the program to run on startup simply create a shortcut for the program. Then press `Windows-Key + R`, type in `shell:startup` and press `Enter`.
Then move your previously created shortcut in that folder and the program should now start at startup.

## Downloads
You can download the Application via Releases here on GitHub