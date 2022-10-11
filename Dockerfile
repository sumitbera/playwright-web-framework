FROM ubuntu
RUN apt update \
    && apt-get -y install python3-pip \
    && apt-get install -y wget \
    && wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt-get install -y ./google-chrome-stable_current_amd64.deb

FROM python
RUN pip3 install playwright==1.25.2
ENV PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD=1
RUN python3 -m playwright install firefox

FROM gradle:7.5.0-jdk11
USER root
WORKDIR /webapp
COPY src /webapp/src
COPY build.gradle gradlew settings.gradle ./
RUN gradle wrapper
ENTRYPOINT ./gradlew clean test


