FROM java:8
ADD build/libs/*.jar XMemeApplication.java
EXPOSE 8081
ENTRYPOINT ["java","-jar","app:app/lib/*","XMemeApplication.java"]