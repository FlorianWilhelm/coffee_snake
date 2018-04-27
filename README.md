# Coffee Snake

**WORK IN PROGRESS**

## Compile

**This was only tested on Linux with Python 3.5.**

In the coffee snake repo create a virtual environment with `virtualenv venv`. Then activate with `source venv/bin/activate`
followed by `pip install jep numpy pandas scipy sckit-learn`. Run `./gradlew build` to create the jar file.

## Run

With activated virtual environment run 

```bash
LD_PRELOAD=venv/lib/libpython3.5m.so.1.0 java -Djava.library.path=venv/lib/python3.5/site-packages/jep -jar build/libs/coffee-snake-1.0-SNAPSHOT.jar
```

You should see
```bash
10.078855907238735
   0
0  1
1  2
2  3
23.999999999999996
Hello World
Hello World
ello Worl
```

# ToDo
* Run the actual `model.py` Python script and not the inlined Python code
* Pass variables back and forth from Java to Python
* Include the whole virtual environment in the JAR file
  Read: https://stackoverflow.com/questions/1429172/how-do-i-list-the-files-inside-a-jar-file
    
