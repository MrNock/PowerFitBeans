# PowerFitBeans

20231108 14.30.00h:
I had the following error message in Netbeans with testing the VLC Video Player:
Native library (win32-x86-64/libvlc.dll) not found in resource path

And found that the path was not correct as per the following response, because the VLC was in C:\Program Files (x86)\VideoLAN, not in C:\Program Files\VideoLAN:
https://stackoverflow.com/questions/22885679/unable-to-load-libvlc

Hence, I fixed it by uninstalling and re-install it in the correct folder path and the problem was solved.
