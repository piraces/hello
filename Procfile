#This file tells Heroku how to run our app.
#'web' indicates that is a web application
#It sets the port with -Dserver option (set by Heroku)
#It executes dist/bin/hello script, that launches app

web:  JAVA_OPTS="-Dserver.port=$PORT" ; dist/bin/hello 