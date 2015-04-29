<<<<<<< HEAD
echo off
SETLOCAL enabledelayedexpansion
call setEnv.cmd

echo on
"%JAVA_HOME%\bin\java" %MEM_ARGS% -classpath "%CLASSPATH%" twitter4j.examples.oauth.GetAccessToken %*

=======
echo off
SETLOCAL enabledelayedexpansion
call setEnv.cmd

echo on
"%JAVA_HOME%\bin\java" %MEM_ARGS% -classpath "%CLASSPATH%" twitter4j.examples.oauth.GetAccessToken %*

>>>>>>> 18c36eaf14f735c7f9df0adb4548e65099390378
ENDLOCAL