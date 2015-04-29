<<<<<<< HEAD
echo off
SETLOCAL enabledelayedexpansion
cd ..
call setEnv.cmd

echo on
"%JAVA_HOME%\bin\java" %MEM_ARGS% -classpath "%CLASSPATH%" twitter4j.examples.favorite.DestroyFavorite %*

ENDLOCAL
=======
echo off
SETLOCAL enabledelayedexpansion
cd ..
call setEnv.cmd

echo on
"%JAVA_HOME%\bin\java" %MEM_ARGS% -classpath "%CLASSPATH%" twitter4j.examples.favorite.DestroyFavorite %*

ENDLOCAL
>>>>>>> 18c36eaf14f735c7f9df0adb4548e65099390378
