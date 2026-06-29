# Actual image
FROM tomcat:11.0-jre25-temurin-noble

# Copy the war to the production image from the builder stage
COPY app/build/libs/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
