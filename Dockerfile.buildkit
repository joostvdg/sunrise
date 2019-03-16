# syntax=docker/dockerfile:experimental
##################################################
##################################################
##### GRADLE_BUILD
FROM gradle:4.10-jdk8 as GRADLE_BUILD
# see https://github.com/keeganwitt/docker-gradle/issues/29
ENV GRADLE_USER_HOME=/tmp
USER root
COPY . /usr/src/sunrise
WORKDIR /usr/src/sunrise
RUN --mount=type=cache,target=/tmp gradle build -Djava.io.tmpdir=/tmp --info --stacktrace
##################################################
##################################################

##################################################
##################################################
##### NATIVE IMAGE BUILD
FROM oracle/graalvm-ce:1.0.0-rc13 as NATIVE_BUILD
COPY --from=GRADLE_BUILD /usr/src/sunrise /usr/src/sunrise
WORKDIR /usr/src/sunrise
RUN java -cp build/libs/*-all.jar \
            io.micronaut.graal.reflect.GraalClassLoadingAnalyzer \
            reflect.json
RUN native-image --no-server \
                 --class-path /usr/src/sunrise/build/libs/*-all.jar \
                 -H:ReflectionConfigurationFiles=/usr/src/sunrise/reflect.json \
                 -H:EnableURLProtocols=http \
                 -H:IncludeResources='logback.xml|application.yml|META-INF/services/*.*' \
                 -H:+ReportUnsupportedElementsAtRuntime \
                 -H:+AllowVMInspection \
                 --rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder',javax.net.ssl.SSLContext \
                 --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom,io.netty.handler.ssl.ReferenceCountedOpenSslEngine,io.netty.handler.ssl.ConscryptAlpnSslEngine,io.netty.handler.ssl.JettyNpnSslEngine,io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator,io.netty.handler.ssl.ReferenceCountedOpenSslClientContext,io.netty.handler.ssl.ReferenceCountedOpenSslServerContext,io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator \
                 -H:-UseServiceLoaderFeature \
                 --allow-incomplete-classpath \
                 -H:Name=sunrise \
                 -H:Class=com.github.joostvdg.sunrise.Application
##################################################
##################################################

##################################################
##################################################
##### BUILD RUNTIME
FROM frolvlad/alpine-glibc
EXPOSE 8080
CMD ["/usr/bin/sunrise"]
COPY --from=NATIVE_BUILD /usr/src/sunrise/sunrise /usr/bin
RUN chmod +x /usr/bin/sunrise
RUN ls -lath /usr/bin
