# Knative Demo - Introduction to Knative
 ![Knative Tutorial](https://github.com/redhat-developer-demos/knative-tutorial/workflows/Knative%20Tutorial/badge.svg) [![Knative Serving v1.1.0](https://img.shields.io/badge/Knative%20Serving-v1.1.0-blue)](https://knative.dev/docs/serving/)
# Prerequisites
  1. Docker demon should be installed in your local machine
  2. Knative serving component should be installed in the Kubernates Cluster [Knative serving installation guide](https://knative.dev/docs/install/yaml-install/serving/install-serving-with-yaml/)
  3. kubectl cli should be installed in your local machine

# Steps to Run

  1. Clone the code from repository
  ```
    git clone https://github.com/alwaid-biswapriya/knative-demo.git
  ```
  2. Build the code
  ```
   mvn clean install
  ```
  3. Create Docker image
  ```
   docker build -t <Your repository name>/knative-demo:1.0 .
  ```
  4. Push the image to Docker hub
  ```
   docker push <Your repository name>/knative-demo:1.0
  ```
  5. Create knative-demo.yaml file
  ```
    apiVersion: serving.knative.dev/v1
    kind: Service
    metadata:
      name: knative-demo
    spec:
      template:
        spec:
          containerConcurrency: 1
          containers:
            - image: <Your repository name>/knative-demo:1.0
              ports:
                - containerPort: 8080
              env:
                - name: TARGET
                  value: "Revision1"
      traffic:
      - latestRevision: true
        percent: 100
      - latestRevision: false
        percent: 0
        revisionName: knative-demo-00001
  ```
  6. Deploy the image in Kubernates
  ```
    kubectl apply -f knative-demo.yaml
  ```



 
