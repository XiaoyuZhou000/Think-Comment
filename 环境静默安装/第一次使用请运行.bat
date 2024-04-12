@echo off
set InstallerPath=.\jdk-21_windows-x64_bin.exe
set InstallDir=C:\Program Files\Java\jdk-21

echo ----------50%%----------

"%InstallerPath%" /s INSTALLDIR="%InstallDir%"
echo ----------100%%----------
echo Press any key to exit...按任意键退出...
pause > nul