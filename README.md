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
<img src="resources/ch/giuntini/powermodeswitch/images/ico.png" width="50">
3. Right-click on the icon and a menu will appear. At the top there are the different power plans from your system. 
Followed by the active power plan, the option to edit the config file and exit the program. 
4. Now you ar good to go. *The following steps are optional.*
5. If you want to change the names of your power plans for only the program. You either click in the menu on 
*Open config file...* or you head to the directory in which you saved the program and edit the file from there.
6. In that file there are all your power plans currently on your system, with their UUID and name. 
Simply edit the name and restart the program.  
Changing the names can be useful if the names of the system are long in length or for recognise them faster.
7. If you want the program to run on startup simply create a link for the program. Then press `Windows-Key + R`, type in shell:startup and press `Enter`.
Then move your previously created link in that folder and the program should now start at startup.

## Downloads
The Installer is recommended. **Note: installers are not yet made, will be updated when they can be downloaded.**  
The Program itself is more of a portable version.

### Program
#### JAR
[Power Plan Switcher.jar](https://www.donwloads.giuntini.ch/jar/Power%20Plan%20Switcher.jar)  
> MD5: 0a315c8c522af7368b309ae51ad5347a  
> SHA256: 2c44d3e1709f6673634a2842c94a4c77a668e8c7972eace3fa3969fbe821bf6f

#### EXE
[Power Plan Switcher.exe](https://www.donwloads.giuntini.ch/exe/Power%20Plan%20Switcher.exe)  
> MD5: a660a95846df17394535415485fc1d0c  
> SHA256: 2e742b3733b66564c12cf8f7d08c4c173085d9a60b3f64d0b0e424710ccf435f

---

### Installer
#### EXE
[Power Plan Switcher.exe]()
> MD5:   
> SHA256:

#### MSI
[Power Plan Switcher.msi]()
> MD5:   
> SHA256: 
