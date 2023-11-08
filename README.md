# PowerFitBeans

**RN 2023.11.08 14:30hrs**
<br>
***Error message*** in Netbeans when testing the VLC Video Player:
<br>
Native library (win32-x86-64/libvlc.dll) not found in resource path

***Path was not correct*** as per the following response, because the VLC was in 'C:\Program Files **(x86)**\VideoLAN', not in 'C:\Program Files\VideoLAN':
<br>
https://stackoverflow.com/questions/22885679/unable-to-load-libvlc

***Solved***
<br>I fixed it by uninstalling and re-installing VLC in the correct folder path.
