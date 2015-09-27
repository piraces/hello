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

###Static content
For convention in using Spring Boot, static content (images for example) is served in /src/main/resources/static classpath. In this web app, we use an image served in /src/main/resources/static/images/Head.png. We can call this image just with the /images/Head.png path, thanks to the facilities that Spring Boot provides us.
