#Hello Application

##About
Hello is a web application that greets their clients and shows the current date and time. It is developed in Java and uses [Spring Framework] (http://projects.spring.io/spring-framework/).

##File organization
The project follows the recommended conventions about packaging and directories structure. The organization of the source code is explained in the next diagram:

    src
    |--main
    |  |--java
    |  |  |--es
    |  |     |--unizar
    |  |        |--webeng
    |  |           |--hello
    |  |              |--Application.java
    |  |              |--HelloController.java
    |  |--resources
    |  |  |--application.properties
    |  |--webapp
    |     |--WEB-INF
    |        |--jsp
    |        |  |--welcome.jsp (view)
    |--test (tests should be placed here)
       |--java
          |--es
             |--unizar
               |--webeng
                  |--hello
                     |--IntegrationTests.java
                     |--SystemTests.java
                     |--UnitTest.java

It is **strongly** recommended to follow this structure so as to maintain a clean and organized code.

##Gradle

###Running the server
The server can be easily executed by using `gradle run`, assuming Gradle has been properly set up. Then any client can connect and, if the application is working, the web will display the current date and time.

###Building the project
Assuming that you have set up gradle in your computer type in your console:

	$ cd hello
	$ gradle build

###Testing your code
Testing your code is very easy.

	$ cd hello
	$ gradle test

###Issues


  	 *What went wrong:
  	 A problem occurred evaluating root project 'hello'.

**Problem:** In the Ubuntu repository has a version less than 1.6 Gradle , higher versions use other syntax.

**Solution:** Download the latest version from the official website [Gradle](http://gradle.org).

Execute:

    $ ~/Gradle-XX/bin/Gradle

Or add it to the environment variables to use as command.

    $ *What went wrong:
    $ Execution failed for task ':compileJava'.
    $ >invalid source release: 1.8

**Solution 1:** Update Java Path

**Solution 2:** Make sure that you have installed JDK not the JRE

The later command will compile normal and tests classes in your project. Then test classes will be executed and tested.
Error message will appear in the screen if something has gone wrong.

##Code coverage
Code coverage is measured with JaCoCo in gradle. After tests are run, a task called jacocoTestReport is run and some reports are generated under /build/reports/jacoco/test.

##Git

###Conflicts on merge process?
If you are not able to merge your improvements on the code with your updated respository, don't panic  and stop typing random commands, this may help you.  Once you have added and committed your local files you will have to synchronize your forked repository  with your upstream repository and here is where you might find conflicts in some of the files. Solving  this issues is easy:

* Identifying the conflict:
  * When there is a conflict, you will see on the console where it is (There may be more than one).
* Now you need to open the file in conflict with any text editor and you will see that some words have appeared in this file and it will have the next format:

```
    any content
    <<<<< HEAD
    your content
    =====
    other content
    \>>>>>upstream/master
```

As you can see, `your content`  refers to what you wrote, and `other content` refers to what other people wrote, the rest added are conflict markers. Here you have a few options; you can keep your changes by
deleting `other content` , you can use `other content` instead of `your content` or you can make a new change. You always need to keep on mind the option you take must satisfy both parts, you and them, and it must make sense. Then you can delete the conflict markers.

* Repeat process above with all the conflicts you have.
* You are now ready to do `add` and `commit` , synchronize your repository again with the upstream, and `push` , you can check the [wiki](https://github.com/UNIZAR-30246-WebEngineering/hello/wiki) to do this task.

###.gitignore

####Description

Git uses this file to determinate which files and directories to ignore, before making a commit. From time to time, there are files you don`t want Git to check in to GitHub, and here is the utility of this file.

Each line in a `.gitignore` file specifies a pattern. When deciding whether to ignore a path, Git normally checks `.gitignore` patterns from multiple sources, with the following order of precedence, from highest to lowest (within one level of precedence, the last matching pattern decides the outcome). This means the following, if we have this patterns in our `.gitignore` file:

####Example

    !/foo/bar
    /foo/*

It says, don't ignore `/foo/bar` and ignore everything that begins with `/foo`. `/foo/bar` won`t be ignored because its pattern is higher in the order of precedence.

####Pattern Format

A blank line matches no files, so it can serve as a separator for readability.

A line starting with # serves as a comment. Put a backslash ("\") in front of the first hash for patterns that begin with a hash.

Trailing spaces are ignored unless they are quoted with backslash ("\").

An optional prefix "!" which negates the pattern; any matching file excluded by a previous pattern will become included again. It is not possible to re-include a file if a parent directory of that file is excluded. Git doesn’t list excluded directories for performance reasons, so any patterns on contained files have no effect, no matter where they are defined. Put a backslash ("\") in front of the first "!" for patterns that begin with a literal "!", for example, "\!important!.txt".

If the pattern ends with a slash, it is removed for the purpose of the following description, but it would only find a match with a directory. In other words, foo/ will match a directory foo and paths underneath it, but will not match a regular file or a symbolic link foo (this is consistent with the way how pathspec works in general in Git).

If the pattern does not contain a slash /, Git treats it as a shell glob pattern and checks for a match against the pathname relative to the location of the .gitignore file (relative to the toplevel of the work tree if not from a .gitignore file).

Otherwise, Git treats the pattern as a shell glob suitable for consumption by `fnmatch(3)` with the FNM_PATHNAME flag: wildcards in the pattern will not match a / in the pathname. For example, "`Documentation/*.html`" matches "`Documentation/git.html`" but not "`Documentation/ppc/ppc.html`" or "`tools/perf/Documentation/perf.html`".

A leading slash matches the beginning of the pathname. For example, "`/*.c`" matches "`cat-file.c`" but not "`mozilla-sha1/sha1.c`".

####Notes

The purpose of `.gitignore` files is to ensure that certain files not tracked by Git remain untracked. To stop tracking a file that is currently tracked, use `git rm --cached`.


###Git Best Practises
In the next lines, there are some points which are important when we are using Git:

* Do read about git
* Do commit early and often
* Don't panic
* Do backups
* Don't change published history
* Do choose a workflow
* Do divide work into repositories
* Do make useful commit messages
* Do keep up to date
* Do periodic maintenance
* Do enforce Standards
* Do use useful tools
* Do integrate with external tools

###Using Branches
A branch represent an independent line of devlopment which allows to isolate changes from the main line of
development. Usually is used when a developer wants to add a new feature or fix a bug. He spawns a new branch to
encapsulate the code's changes, which would make sure that unstable code is never commit to the main code.

#####Usage
* List all of the branches in the repository: `git branch`
* Create a branch: `git branch <branch's name>`, this command only create a new branch, if you want
  start adding commits to it, you need to select it.
* Navigate between the differents branch in a proyect: `git checkout <branch's name>`
* Merge one branch with the current branch: `git merge <branch's name>`
* Delete a branch: `git branch -d <branch's name>`
* Delete a branch on your remote repository: `git push origin :<branch's name>`
* Push the branch to your remote repository, so others can use it: `git push origin <branch's name>`
* Push all branches to your remote repository: `git push --all origin`

Here is another interesting command that you can use:
* Create a branch and move to it: `git checkout -b <branch's name>`
* See the differences between two branchs: `git diff --stat <branch 1> <branch 2>`
* Undo a merge: `git reset --hard HEAD`


###Additional info about Git

###Git commands:
####init
Create a new local repository
####fetch
Fetches all the objects from the remote repository that are not present in the local one.
####pull
Fetches the files from the remote repository and merges it with the local one. This command is equivalent to
fetch + merge sequence.
####push
Copies all the modified local objects in the staging directory (after adding and commiting them) to the remote
repository and advances its branches.
####add
Adds files changed in your working directory to the staging area.
####merge
Merges one or more branches into your current branch and automatically creates a new commit if there are no conflicts.
####branch
Lists existing branches, or creates a new branch if a name is provided. Branches are used to create another line of
development. Usually, a branch is created to work on a new feature. Once the feature is completed, it is merged back
with the master branch and we delete the branch.
####checkout
Switches from the current branch to a different one.
####commit
Takes all changes written  since the last commit, creates a new one and sets the branch to point to this last commit.
A commit is also named by SHA1 hash. Every commit object has a pointer to the parent commit object. From a given commit,
you can traverse back by looking at the parent pointer to view the history of the commit.
####clone
Makes a Git repository copy from a remote source. Automatically adds the original location as `origin` so you can fetch
again and also push (if you have permissions).
####status
List the files you've changed and those you still need to add or commit
####help
Type this into the command line to bring up the 21 most common git commands. You can also be more specific and type `git help init` or another term to figure out how to use and configure a specific git command.

###Connect to a remote repository
* If you haven't connected your local repository to a remote server, add the server to be able to push to it:
`git remote add origin <server>`
* List all currently configured remote repositories:
`git remote -v`

###Git concepts:
####Staging area
	Set of files that have been commited but not yet pushed to the remote repository. You can modify a file, add it,
	commit it with a certain message (observation) and later repeat the same process with a different file but specifying
	a different message. Executing "push" will copy all the commits saved in the staging area to the final repository.
####Origin
	Link provided when the repository was first cloned to the local machine.
####Upstream
	Link of the original master repository, the one you forked to create a copy in your account.
####Differences between these last two
	When working with other developers, you all have the same upstream from which you download the merged changes
	    (after pull requests).
	Each one of you pushes his/hers local changes to his/her origin.
	After that he/she will send a pull request to the owner of the repository.
	If the changes can be automatically merged and the owner accepts them, they will be automatically merged to the
	    existing code in the master repository.
	Then the rest of the developers will have to pull these changes to their local repositories to continue working
	    with an updated copy.


##GitHub Desktop
If you want to simplify essential steps in your GitHub workflow you can install the [GitHub Desktop] (https://desktop.github.com/) app on your Windows or Mac computer.
This app is an alternative to use git from the command line, but is more suited to developers who are in the development-to-deployment workflow and not for those working on open source projects or who use GitHub to monitor bugs, feature requests or other problems in existing applications.
[Here] (https://help.github.com/desktop/) you can find all necessary documentation for getting started.

##Permissions
If you have issues with file permissions, you can change them with the command:

    $> git update-index --chmod=[opt] [file]

Options are like linux command chmod. File can be an absolute path.

For example, if you want to remove executable permissions to the SystemTests.java file, you'd have to do:

    $> git update-index --chmod=-x src/test/java/es/unizar/webeng/hello/SystemTests.java

Then, save your changes:

    $> git commit -m "Changing file permissions"
    $> git push

##SourceTree
Other way to simplify your work with GitHub is using SourceTree with is other of app, just like GitHub desktop but with some differences.
With SourceTree you can have local repositories from other repository sites like mercurial.
SourceTree also works with windows and mac.
You can get SourceTree app from the [SourceTreeApp website] (https://www.sourcetreeapp.com/)

Installation guide (For windows):
- First you have to download the app, [Here is the link] (https://www.sourcetreeapp.com/download)
- Run the downloaded file.
- Continue the required steps until the installation ask you for you git/mercurial account. Then you can log in and get the repositories from your account or skip that phase and do it later. 
- If you want to add a repository after the installation you have to click the button at the bottom left with (Add Repository) and add the path or select it from the web and add the local path wherre you want to clone it.

##Spring Framework

###Spring Framework Annotations
You may find some [Spring Java annotations](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/package-tree.html) in specific pieces of code. The following annotations are used in this project:
* **@SpringBootApplication**: defines the main Spring Application class in this project. It must be a class annotation.
* **@Controller**: defines the main Spring Controller class in this project. It must be a class annotation.
* **@RunWith(Class)**: defines a Test Runner to run the tests instead of the one built in JUnit. It must be a class annotation.
* **@SpringApplicationConfiguration(classes = Class)**: defines a [ContextConfiguration](http://docs.spring.io/spring-framework/docs/4.1.7.RELEASE/javadoc-api/org/springframework/test/context/ContextConfiguration.html) class to load in an integration test. It must be a class annotation.
* **@WebAppConfiguration**: declares that the ApplicationContext loaded for an integration test should be a [WebApplicationContext](http://docs.spring.io/spring-framework/docs/3.2.0.BUILD-SNAPSHOT/api/org/springframework/test/context/web/WebAppConfiguration.html). It must be a class annotation.
* **@IntegrationTest("server.port=port")**: declares that the current test is an integration test. It must be a class annotation.
* **@DirtiesContext**: declares that the context related to this test should be removed from the context cache. It must be a class or method annotation.
* **@Value("${property:default_value}"): if the specified property exists, its value is assigned to a variable. Otherwise, the default value is assigned to that variable. It must be a variable annotation.
* **@Before**: declares that a function should be executed before running the tests. It must be a function annotation.
* **@Test**: declares that a function is a test. It must be a function annotation.
* **@Scheduled**: declares that a function is going to be executed periodically.
* **@EnableScheduling**: declares that an application can run programmed tasks.

##Java Anotations
Java defines a set of annotations that are built into the language.

* **@Override**: Checks that the method is an override. Causes a compile error if the method is not found in one of the parent classes or implemented interfaces.
* **@Deprecated**: Marks the method as obsolete. Causes a compile warning if the method is used.
* **@SuppressWarnings**: Instructs the compiler to suppress the compile time warnings specified in the annotation parameters.
* **@SafeVarargs**: Suppress warnings for all callers of a method or constructor with a generic varargs parameter, since Java 7.
* **@FunctionalInterface**: Specifies that the type declaration is intended to be a functional interface, since Java 8.

##Javadoc
Javadoc is an Oracle's tool which generates documentation of Java API in HTML format based on Java code.

It's need using some reserved words preceded by "@" for Generating APIs. This words are wrote before a method or a class.

Coming up next, the using of the reserved words for Javadoc are going to be explained:

* **@author**: Indicates the Development's name.
* **@deprecated**: Indicates that a method or class is obsoleted and it is not recommended use it, due to it will probably disappear in the next version.
* **@param**: Defines a parameter of a method. It's required for each parameter in the method.
* **@return**: Informs of the element which return a method. It is forbidden in constructs and "void" methods.
* **@see**: Associates with another method or class.
* **@throws**: Informs of the exception which is thrown by a method.
* **@version**: Indicates the version of the method or class.

##Travis CI

###Travis.yml
Travis CI uses [.travis.yml](.travis.yml) file in the root of your repository to learn about your project and how you want your builds to be executed.

###How does Travis CI know that you have pushed something to your repo?

Travis knows it using a feature called [webhooks](https://en.wikipedia.org/wiki/Webhook). Webhooks are HTTP requests made by a web page or application to a custom URL, triggered by some event. Usually, the custom URL belongs to a third-party service.
It allows to those third-party services to easily know when a change has been made, without being constantly checking for changes on the website.

In the case of Github, it allows you to set custom webhooks so, when something happens in your repository (like a pull, push) , an HTTP POST is made to the provided URL. It is very useful for [Continuous Integration](https://en.wikipedia.org/wiki/Continuous_integration) tools, like Travis. To view what webhooks are set-up on your repository, go to Settings -> Webhook & Services.

This is how Travis works. Travis set up a webhook on your repository, so when your code changes, Travis servers receive a request and then, build your updated code. Although Travis works with Github, if they add support for custom webhooks, it would be easy to create your owns (You would have only to make HTTP requests to Travis).

###Adding code coverage measure

[![codecov.io](http://codecov.io/github/UNIZAR-30246-WebEngineering/hello/coverage.svg?branch=master)](http://codecov.io/github/UNIZAR-30246-WebEngineering/hello?branch=master)

Since we are using JaCoCo to calculate code coverage in this project and Travis
CI doesn't support this tool, we have to use an external tool called *codecov* in
order to see the reports of code coverage. To use this tool, we must simply sign
up in https://codecov.io with our github account and grant access to the
repository. Once done, we have to add these lines to our .travis.yml file:
```
before_install:
  - pip install --user codecov
after_success:
  - codecov
```
And it's done! Now we have access to the code coverage reports on codecov's page.

Besides, codecov also supports badges with code coverage measures with this code:
```
[![codecov.io](http://codecov.io/github/UNIZAR-30246-WebEngineering/hello/coverage.svg?branch=master)](http://codecov.io/github/UNIZAR-30246-WebEngineering/hello?branch=master)
```
(This code is for Markdown files. For HTML or other languages, check [codecov's site](https://codecov.io))

##Bootstrap
Bootstrap is a common Framework for HTML, CSS and Javascript used for developing Web Applications. It
contains templates with forms, buttons and other kind of design components as well as functionalities to make a responsive application.

###Glyphicon Components
  Bootstrap includes a set of glyphs components that can be used to improve the web's design. They are
  monochromatic icons and symbols in order to enrich the usability of the web by making the navigation
  clearer and easier. Theses glyphs are usually not available for free but their creator made them free
  for Bootstrap. You can find more information going to [Glyphicons](http://glyphicons.com).

##jQuery
jQuery is a cross-platform JavaScript library designed to simplify the client-side scripting of HTML. jQuery defines itself as a lightweight, "write less, do more", JavaScript library. The main purpose of jQuery is to make it much easier to use JavaScript. This library makes things like HTML manipulation, event handling, animation and Ajax much simpler with an API that works across several browsers. It's the most popular JavaScript in use today, with several top websites using it.

###What does jQuery in this project?
jQuery provides to the main JSP page of the project, a simple way to make the client-side scripting of HTML, showing the time and the message generated by the server-side app.

###RequestMethod
It's possible diference between a POST and a GET request. We only have to indicates it in the @RequestMapping.
Example: @RequestMapping(value="/", method=RequestMethod.POST)
This is used in HelloController.java

###Obtain client's IP address
We can obtain de client's IP address or the latest proxy which he used, using "request.getRemoteAddr()".
This is used in "welcome.jsp"

###Obtain client's System Information
We can obtain de client's IP system information, using "request.getHeader("User-Agent")".
This is used in "welcome.jsp"

##Heroku

### What is it?
Heroku is a cloud-platform for automatic deployment.
Every time your code changes in your GitHub repository, Heroku notices it, builds your app and deploys it on the cloud; you only have to push your changes.
With this tool, everybody can see the status of your project without having to build and run it locally.

###Set-up Heroku in your repo
1. Register on [www.heroku.com](http://www.heroku.com) and create a new App.
2. Connect it to your Github repo and enable "Automatic Deploys".
3. Put your Heroku App URL on the README.md table
4. Done!

###How does it work?
 1. You made a push to your github repository.
 2. Using webhooks, Heroku notices it.
 3. Heroku executes "stage" task of the build.gradle file (It builds the project and generates production code)
 4. Heroku reads "Procfile" file in order to know how to execute your app.
 5. Voila! Your app is running on the cloud.

###Project changes

A few changes have been made on the project files to allow it.

**build.gradle:**

A "stage" task has been added. This tasks fires the "build" and "installApp" tasks. "installApp" task  generates production-ready files on "/dist" directory. This directory contains .jar files and a bash script file that is used to bootstrap the application.

**Procfile:**

In this file, we tell Heroku how to run our app. In this case, it executes the bash script file in "dist/bin" as a web app.

**settings.gradle:**

This file has been added in order to specify the project name. Without it, "installApp" task doesn't work well.

##VersionEye: checking dependencies automatically.

### What is it?
VersionEye is a cross-platform search engine for free/libre/open source software libraries. Currently tracking more than 650K free/libre/open source libraries from Java, Ruby, Python, Node.JS, PHP, JavaScript, CSS, Objective-C, R and Clojure. It allows to follow some dependencies and search some libraries status.

In additional to the search and follow feature, VersionEye can actively monitor source code from projects (from github too) and notify you about outdated dependencies in your project. Beside that it shows you which licenses your dependencies are using.

###Set-up dependencies checking in your repo
1. Register at [www.versioneye.com](https://www.versioneye.com) and choose "Create from GitHub" (in main projects dashboard).
2. Connect it to your Github account (if you didn't before).
3. Choose one repo to add to the dashboard and start the check.
4. Enable the branches to be checked, then click at "build.gradle" link.
5. After a little time, you'll see a graphic showing the dependencies of the repo and the licenses of them.

###How does it work?
1. It works with daily, weekly, monthly or manual sync.
2. When it's time to sync, VersionEye checks (and parses) the file "build.gradle" to obtain dependencies and versions.
3. Once checked the file, it searchs around for new versions of dependencies and licenses of dependencies.
4. If there are some updates for libraries, it will notify you in order to update "build.gradle" and use latest libraries (badge in red). Otherwise, the badge and status, don't change.
5. Congratulations! Now you'll be always updated and using the latest libraries for your project.

###The project and it's dependencies
- It's important for any project of any kind, to check dependencies frequently. Otherwise, your project can contain outdated libraries. Outdated libraries can cause security breaches or bugs of any type, than can affect to the project in a hard way.
- Several popular github (and others) repositories check their dependencies like do VersionEye. Dependencies and updates are so boring and frequently (but important). The solution is automatize the check of updates, and get notified when they are outdated. Some examples of projects using this are: bootstrap, emberjs and famous Java (or JavaScript) libraries.

###More about dependencies
- In the original project, two libraries were being used (jQuery and bootstrap). Taking a look at the dependencies (running `gradle dependencies`), it looks like it has two recursive dependencies. It's because one library used in bootstrap is jquery (that is also included). Watching this, we are making gradle to work a little more. We can just drop the jquery library and gradle will take it from the bootstrap dependency (without having recursive libraries). The problem can be seen here:

```
	+--- org.webjars:bootstrap:3.3.5
	|    \--- org.webjars:jquery:1.11.1 -> 2.1.4
	+--- org.webjars:jquery:2.1.4
```

- Another problem is libraries versions. In order to obtain the latest versions of library dependencies, we can use `gradle` or the `spring-boot-gradle` plugin to resolve that. But, in fact, the `spring-boot-gradle` plugin doesn't support automatically version resolving for bootstrap library (see the plugin [appendix](http://docs.spring.io/spring-boot/docs/current/reference/html/appendix-dependency-versions.html)), and gradle doesn't pick the correct latest version.

- Using the syntax `compile 'org.webjars:bootstrap:latest.release'` give us a alpha version of bootstrap that crashes when building the project. Also using the syntax `compile 'org.webjars:bootstrap:3.+'` to obtain latest minor version of mayor 3 version, give us the 3.3.4 version (which is outdated).

In conclusion, we need to specify the bootstrap version manually to keep the project updated and working, because other workarounds don't work. VersionEye will notify if a newer bootstrap version is available to pick it, and this doesn't suppose a problem for the project.


##Static content
For convention in using Spring Boot, static content (images for example) is served in /src/main/resources/static classpath. In this web app, we use an imaged served in /src/main/resources/static/images/Head.png. We can call this image just with the /images/Head.png path, thanks to the facilities that Spring Boot provides us.

###Logging
Logging is the common method to collect information about the system's performance or any info we think is
useful to evaluate how the system is working.
This log system uses the features that SpringBoot includes. All the configuration for this system is placed
in the logback.xml file where we can define which level we want our different loggers to be since we are
using Logback. In addition, we make use of the SpringBoot's default configuration adding a log file which
reference is the value of the field logging.file in application.properties. You can find more info about
logback [here](logback.qos.ch).


## IntelliJ IDEA

### What is it?
[IntelliJ IDEA](https://www.jetbrains.com/idea/) is a Java integrated development environment(IDE) fro developing computer software, but also offers
enterprise frameworks(Spring,Grails...), mobile and web development(Android,AngularJS,JavaScript...)

### Set-up process

1. Set up your GitHub account
2. Set up JDK home.
3. Select check out from version control and clone the "hello" repository from your GitHub account.
    * You can also use git or download from GitHub, but in this case, the project must be created manually.
4. Import project from Gradle, set up gradle home and JVM
    * This wouldn't be necessary by using a gradle wrapper
5. Select project format type: .idea(directory based).
6. IntelliJ automatically resolves dependencies and downloads necessary repositories.
7. Select Run tests in hello (Gradle option) (This will download Gradle dependencies if they aren't already installed)
8. Use VCS->Update Project and VCS->Commit changes to work with git

### Problems found
* [Solved] Maven repositories aren't updated:
    From top menu, open File -> Settings -> Maven -> Repositories and verify that you have valid remote repository.
* [Solved] Unregistered VCS root detected, directory is under Git but is not registered in the Settings, assign a root automatically:
    Go to File->Project Structure and assign a root, or click on the popup message to do it automatically
## CSS
Cascading Style
### What is it?
It's a language used to define the presentation of a document. Can define fonts, colors, margins, lines height, width, background images, advanced positioning and other subjects.
### Who controls the specification of CSS ?
It's specification is made by the World Wide Web Consortium, known as W3C, this specification serves a standard for
browsers and ither computer applications acting as clients in network protocols.
### Benefits
1. Control of presentation on a unique sheet of style.
2. Application of different presentations to different media types.
3. Quality improvement.
4. In one file Css you can define the style of multiple html files.
### Forms of use by author
1. Inline: It not recommend because the code can be dirty.
2. Internal style sheet: It's a better option than the last, because it separate the style and the code. But the file can be confuse.
3. External style sheet: It's more potent than other because it separate completely the
4. formatting of the code. This option is the most used and recommended in web development.


## [Docker] (https://www.docker.com)

### What is it?
Docker containers wrap up a piece of software in a complete filesystem that contains everything it needs to run: code, runtime, system tools, system libraries – anything you can install on a server. This guarantees that it will always run the same, regardless of the environment it is running in.

### Why use it?
1. Consistent development environments. All developers use the same OS, libraries, etc.
2. You only need Docker. Install a bunch of language environments on your machine is not needed.
3. Easy to use.
4. Save time.

### Docker-Machine
If you've OS X or Windows you probably need a little setup after installing. This is because docker run inside a lightweight Linux VM, so you need to setup a docker machine. Usually if you install Docker Toolbox it installs also the docker machine but you can also install only the docker machine.
When you init Docker, it automatically inits docker machine, but when you run a container you need some configuration (see above).

If you want to learn more about the Docker Machine: [link](https://docs.docker.com/machine/)

### Components of docker
1. A <b>container</b> is a stripped-to-basics version of a Linux operating system.
2. An <b>image</b> is software you load into a container.
3. A <b>repository</b> Docker Hub for sharing and managing Docker containers.

### Build your own <i>docker</i>

1. Write a Dockerfile that describes the software that is <i>baked</i> into an image such as environment to use or what commands to run.
Eg: A Dockerfile for a Java app

	```
	FROM java:8
	RUN apt-get update
	ADD . /src
	CMD ["java", "-jar", "/src/HelloDocker.jar"]
	```
2. Build yor docker's image (e.g.: my image) typing:

	```
	$> docker build -t myimage .
	```

	Then, docker loads the image (e.g. <i>java:8</i>) if you didn't download before.

	```
	Step 0: FROM java:8
	 ---> fb434121fc77
	```

	Later Docker moves onto the next steam, in the example update the apt-get and add the 	files:

	```
	Step 1 : RUN apt-get -y update
	 ---> Running in 27d224dfa5b2
	Ign http://archive.ubuntu.com trusty InRelease
	Ign http://archive.ubuntu.com trusty-updates InRelease
	```

	Finally, Docker finishes the build and reports comes out:

	```
	Step 3 : CMD java -jar /src/HelloDocker.jar
	 ---> Running in a8e6faa88df3
	 ---> 7d9495d03763
	Removing intermediate container a8e6faa88df3
	Successfully built 7d9495d03763
	```

3. Run your docker typing:

	<code>
	$> docker run <i>name</i>
	</code>

	And you can see:

	```
	Hello Docker!!!
	```


### Container ports
If you use windows or OSX probably you can't acces to your container. To fix this <i>problem</i> you need to expose ports from the container to your local host.

When you run a continer you need to add the flag -p for redirect a public port to a private port in the container:

```
$> docker run -p 49160:8080 myimage
```

Also you need to know the dockers' ip, you can know with the command:

```
$> docker-machine ip default
```

And it returns something like that:

```
192.168.59.103
```
Now you can acces into your docker with the following URL:

```
192.168.59.103:49160
```


### Dockerfile's command
1. FROM <i> image </i>: set the Base Image for subsequent instructions, should be a valid image.
2. RUN <i> commands </i>: execute commands in the current images.
3. ADD <i> src dst </i>: copies new files and directories from src to dst.
4. CMD <i> commands </i>: default execute for a image.

### Automated Builds from github

Automated Builds allow you to use Docker Hub’s build clusters to automatically create images from a GitHub repository containing a Dockerfile.

#### Set up
1. Create a Docker Hub account and log in.
2. Link your Hub account by referring to the GitHub.
3. Select “Create Automated Build” from the top right “Create” menu item.
4. Pick a GitHub or BitBucket project that has a Dockerfile you want to build.
5. Follow the instructions from the web page.

### Other commands:
1. List the images you have locally:

	```
	$> docker images

	REPOSITORY           TAG          IMAGE ID          CREATED             VIRTUAL SIZE
	docker-whale         latest       7d9495d03763      4 minutes ago       273.7 MB
	docker/whalesay      latest       fb434121fc77      4 hours ago         247 MB
	hello-world          latest       91c95931e552      5 weeks ago         910 B
	```

2. See the images which are running locally:

	```
	$> docker ps

	CONTAINER ID        IMAGE                        COMMAND                CREATED              	STATUS              PORTS               NAMES
	4c01db0b339c        ubuntu:12.04                 bash                   17 seconds ago       	Up 16 seconds       3300-3310/tcp       webapp
	```


## Markdown

### What is it?

Markdown is a lightweight markup language with plain text formatting syntax designed so that it can be converted to HTML and many other formats using a tool by the same name. Markdown is often used to format readme files, for writing messages in online discussion forums, and to create rich text using a plain text editor.

### Pros
- **Easy to learn:**
 - In 10 minutes you can use markdown fluently.
- **Easy to write and read:**
 - You can write and format text without using the mouse like a usual text editor (like Microsoft Word or LibreOffice Writer).
 - When you write do not use long labels to indicate the format of the text like in HTML.
 - You can read the text easily even in plain text.
- **Versatile**
 - Convertible in many other formats like HTML.

### Markdown's editors
Editors are good to learn easily all tags of markdown:
- Haroopad (my recomendation)
- Atom
- GitBook
- Remarkable
- Any notepad


### JDepend

JDepend traverses Java class file directories and generates design quality metrics for each Java package. JDepend allows you to automatically measure the quality of a design in terms of its extensibility, reusability, and maintainability to manage package dependencies effectively.

Before using JDepend, it is important to understand that "good" design quality metrics are not necessarily indicative of good designs. Likewise, "bad" design quality metrics are not necessarily indicative of bad designs. The design quality metrics produced by JDepend should not be used as yard sticks by which all designs are measured.

The design quality metrics produced by JDepend are intended to be used by designers to measure the designs they create, understand those designs, and automatically check that the designs exhibit expected qualities while undergoing continuous refactoring. Refactoring will undoubtedly lead to some adjustment of these metrics as the shape of the design changes.

The JDepend plugin for Gradle performs quality checks on your project's source files using JDepend and generates reports from these checks.


**Identify Package Dependency Cycles**

Packages participating in a package dependency cycle are in a deadly embrace with respect to reusability and their release cycle. Package dependency cycles can be easily identified by reviewing the textual reports of dependency cycles. Once these dependency cycles have been identified with JDepend, they can be broken by employing various object-oriented techniques.

Package dependency cycles are best observed using the textual or XML user interface. In general, all packages dependencies that intersect a dependency cycle are reported. This includes packages directly participating in a cycle and packages that depend on packages directly participating in a cycle.

The intent is to identify sets of packages that must be reused and released together. To break reported cycles, focus on those packages directly participating in a cycle.

Here's an example of a two-package cycle, as reported by the textual UI:

        com.xyz.ejb
           |
           |   com.xyz.servlet
           |-> com.xyz.ejb

This indicates that the com.xyz.ejb package depends on the com.xyz.servlet package, which in turn depends on the com.xyz.ejb package. These two package must be released and reused together.

Here's an example of a package that depends on the two-package cycle described above, as reported by the textual UI:

        com.xyz.client
           |
           |-> com.xyz.ejb
           |   com.xyz.servlet
           |-> com.xyz.ejb
 
This indicates that the com.xyz.client package depends on the com.xyz.ejb package, which in turn forms a cyclic dependency with the com.xyz.servlet package. The com.xyz.client package itself isn't part of the cycle, but since it depends on a package in the cycle, it can't be reused/released without it. 

#FIREBUG

###What is it?

Firebug is a free and open-source web browser extension for Mozilla Firefox that facilitates the live debugging, editing, and monitoring of any website's CSS, HTML, DOM, XHR, and JavaScript.

In addition to debugging web pages, Firebug is a useful tool for web security testing and web page performance analysis.

You can download and install this addon in: http://getfirebug.com

Press f12 to launch firebug.

### Basic Features

####Always at your service

Firebug is always just a keystroke away, but it never gets in your way. You can open Firebug in a separate window, or as a bar at the bottom of your browser. Firebug also gives you fine-grained control over which websites you want to enable it for. 


####Inspect and edit HTML

Firebug makes it simple to find HTML elements buried deep in the page. Once you've found what you're looking for, Firebug gives you a wealth of information, and lets you edit the HTML live.

Firefox has a "View Source" window, but it doesn't show you what the HTML source really looks like once it has been transformed by JavaScript. Firebug's HTML tab shows you what the HTML looks like right now.

Firebug gives you a really fun way to make experimental HTML changes and see them take effect instantly. You can create, delete, or edit HTML attributes and text just by clicking them and tabbing from one to the next. The changes will be applied immediately as you type. 

You can find elements with the mouse.

Right-click on any element, and you'll have several options for copying aspects of that element to the clipboard, including its HTML fragment, the value of its "innerHTML" property, or an XPath expression that identifies the element uniquely. 

####Visualize CSS metrics

When your CSS boxes aren't lining up correctly it can be difficult to understand why. Let Firebug be your eyes and it will measure and illustrate all the offsets, margins, borders, padding, and sizes for you.

####Monitor network activity

Allows us to analyze network traffic, load times of all components of our being able to monitor the total load time of the page and delays, also we will mark components that have not been able to load or components load times too high.

####Debug and profile JavaScript

Firebug includes a powerful JavaScript debugger that lets you pause execution at any time and have look at the state of the world. If your code is a little sluggish, use the JavaScript profiler to measure performance and find bottlenecks fast.

####Quickly find errors

When things go wrong, Firebug lets you know immediately and gives you detailed and useful information about errors in JavaScript, CSS, and XML.

####Explore the DOM

The Document Object Model is a great big hierarchy of objects and functions just waiting to be tickled by JavaScript. Firebug helps you find DOM objects quickly and then edit them on the fly.

####Execute JavaScript on the fly

The command line is one of the oldest tools in the programming toolbox. Firebug gives you a good ol' fashioned command line for JavaScript complete with very modern amenities.

####Logging for JavaScript

Having a fancy JavaScript debugger is great, but sometimes the fastest way to find bugs is just to dump as much information to the console as you can. Firebug gives you a set of powerful logging functions that help you get answers fast.

 These are the basic features you need to properly analyze and develop proper and more comfortable a web application that allows us to view, modify results in real time without modifying your source documents. 

##[PMD](https://pmd.github.io/)
PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth.
Additionally it includes CPD, the copy-paste-detector. CPD finds duplicated code.

###What does it do?
PMD checks the rules indicated in build.gradle:pmd:ruleSets (you can add or delete rules there) and make a report with the class which violate the rule, what the rule means and in which line the rule is violated. Also, the number or rules violated are shown when gradle is builded.

###How to use it?
It will be use automatically with gradle check and it will create a xml report and a html report in /build/reports/pmd from test and main folders. You can also use it with gradle pmdMain if you only want to have a report from main folder or pmdTest if you want a report from test folder.

##The Gradle Wrapper

### What is it?
The Gradle Wrapper is a script when you distribute it with your project, anyone can work with it without needing to install Gradle beforehand and users of the build are guaranteed to use the version of Gradle that the build was designed to work with. It's also great for continuous integration servers as it requires no configuration on the server.

###How do I use it?
You install the wrapper into your project by running the wrapper task. To specify a Gradle version use --gradle-version on the command-line (with Gradle 2.4 or higher)

```
> gradle wrapper --gradle-version 2.0
:wrapper

BUILD SUCCESSFUL

Total time: 1 secs
```

You need to generate wrapper's files once (for a particular version) and it will generate these new or updated files in your directory:

    simple
    |--gradlew
    |--gradlew.bat
    |--gradlew/wrapper
    |  |--gradle-wrapper.jar
    |  |--gradle-wrapper-properties

After these files have been added to the project, the project should then be built with the added **gradlew** command. The gradlew command can be used **exactly** the same way as the gradle command.