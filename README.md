# Utau Harmonizer
## Introduction
Hi, I'm Dodger Akame, the coder of that UST harmonies generator.
I'm here to explain to you how to make the program work for you

### 1. Installation 
First, you'll require atleast Java 1.8.
#### 1.1) What is Java
If you know what is Java, you can skip this part of course. Else I'll be explained briefly so you know what you're about to download.

Java is a language used for programming and developed by Oracle. You may have heard of it thanks to Minecraft, which is fully developed in Java.
The language is not installed by default in your computer, so you'll need a **JRE** (Java Runtime Edition), or a version of Java made for running Java programs.

#### 1.2) Download the JRE
Go to [Oracle's Website](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) to download the JRE.
You should land on that page :
![Java's download page](https://raw.githubusercontent.com/DodgerAkame/UtauHarmonizer/v0.1/readmePictures/v0.1/firefox_2018-04-02_10-10-32.png)

You may need to create an account to download.

Go on that section of the page :
![Where to download the JRE](https://raw.githubusercontent.com/DodgerAkame/UtauHarmonizer/v0.1/readmePictures/v0.1/firefox_2018-04-02_12-02-57.png)

Check the "Accept License Agreement" and click on the version of your OS. (If Windows, take the one finishing by **.exe** as it will be easier to install. If Linux or Mac, I guess you know which one to take.)

Launch the installation and follow the instructions.

When it's done, we will check if the installation proceeded correctly.

If you are on Windows, press Windows + R. You will have this window :
![When you press Windows + R](https://raw.githubusercontent.com/DodgerAkame/UtauHarmonizer/v0.1/readmePictures/v0.1/explorer_2018-04-02_12-54-17.png)
Then type cmd and hit Enter. A black window will open, called "cmd.exe". Type "java" and hit Enter.
If you have this screen : 
![When you type 'Java'](https://raw.githubusercontent.com/DodgerAkame/UtauHarmonizer/v0.1/readmePictures/v0.1/cmd_2018-04-02_12-55-39.png)
Then you're all good! Else, you might redo the installation, or you can contact me at *dodgerakame.contact@gmail.com*

For Mac and Linux users, you should normally know how to open a terminal. The operation is the same right after you have opened it.

#### 1.3) Download the Utau Harmonizer
The program is available to download here :
![Where to download the Utau Harmonizer](https://github.com/DodgerAkame/UtauHarmonizer/blob/v0.1/out/artifacts/UtauHarmonizer_jar/UtauHarmonizer.jar)

On the page, you'll find a "Download" button. Click on it and accept the download.
The file is a **JAR**, or  **J**ava **Ar**chive, it contains all the program inside.

#### 1.4) Launch the UTAU Harmonizer
Double click on the JAR file. If you have the interface shown below, everything is okay. Else, right-click on the file, "Launch with", then click on "Java" or something that has "Java" in its name

### 2. How to use the Utau Harmonizer
![The interface of Utau Harmonizer](https://raw.githubusercontent.com/DodgerAkame/UtauHarmonizer/v0.1/readmePictures/v0.1/javaw_2018-04-02_14-42-13.png)

#### 2.1) Search a source file 
Click on the first button "Search".
A new window will open where you can pick the UST source file that'll be used. When you have picked the file, the text next to the button will be changed with the path to the file. The destination file's path will be changed as well.

#### 2.2) Choose a method of generation
The list of radio buttons presents all the generation methods available so far. Here's the description of the methods :
* Range + 3 : Upscale the notes by 3 notes (higher pitch)
* Range + 5 : Upscale the notes by 5 notes (higher pitch)
* Range - 3 : Downscale the notes by 3 notes (lower pitch)
* Range - 5 : Downscale the notes by 5 notes (lower pitch)
* Using range : All the notes of the song will be exclusively used and stored in a sorted array, from lower to higher note. Every note used in the harmony will be the note lower by 2 spaces in the array from the actual note.
Example : [B4, A4, F4, C4, B3] is our array of notes, our range. If the song uses the **A4**, then the harmony will use the **C4** note. If the source's **F4**, then the harmony'll be **B3**.

#### 2.3) Search a destination file
Click on the second button "Search".
A new window will open where you can pick the UST source file that'll be used. If you have chosen a source file, a destination file will be written by default.


#### 2.4) Generate the file
When everything is ready, please click on "Process" button. The file will be generated, and a window will popup when the operation is done. Voilà!

### 3. How to report a bug or to suggestions some improvments
Address me a mail at **dodgerakame.contact@gmail.com**
Please specify if it's a bug report, a suggestion or something else in the mail's object.

If you report a bug, please provide the more information that you can : what happened exactly, how to redo it, a screenshot, anything explicit.

If you want to suggest anything to make the app, better, please do! Be the more explicit, and do not be afraid of long explanations if it's needed!
 