# Spring-Boot - Camel Kafka Producer

Simple Camel Kafka Producer

### Building

The example can be built with

    mvn clean install

### Requirements

[Download and Install Code Ready Studio](https://developers.redhat.com/products/codeready-studio/download)

[Download and Install Openshift Client](https://access.redhat.com/downloads/content/290/ver=4.5/rhel---8/4.5.8/x86_64/product-software)

[Download and Install Maven](https://maven.apache.org/download.cgi)


### To deploy on Openhsift follow the steps


1. Import the fuse image

        oc import-image fuse7/fuse-java-openshift --from=registry.access.redhat.com/fuse7/fuse-java-openshift --confirm

2. Create a new build config on Openshift pointing to the Fuse Image

       oc new-build --binary=true --image-stream=fuse-java-openshift  --name=kafkaproducer

3. Start the build pointing the '--from-dir' variable to the project folder

       oc start-build kafkaproducer --from-dir=. --follow

4. Create a new app

       oc new-app kafkaproducer
    
    
    
