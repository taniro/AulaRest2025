FROM ubuntu:latest
LABEL authors="tanir"

ENTRYPOINT ["top", "-b"]