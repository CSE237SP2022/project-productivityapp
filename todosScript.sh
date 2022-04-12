#!/bin/bash

GIT="https://github.com/CSE237SP2022/project-productivityapp.git"

git clone $GIT

cd project-productivityapp/src

javac Todos.java

java Todos
