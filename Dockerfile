FROM gradle:7.5.0-jdk11
USER root
WORKDIR /webapp
COPY src /webapp/src
COPY build.gradle gradlew settings.gradle ./
RUN apt update \
    && apt-get install -y wget \
    && wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt-get install -y ./google-chrome-stable_current_amd64.deb
ENV PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD=1
RUN gradle wrapper
ENTRYPOINT ./gradlew clean test


