# Deploy:
#
## on terminal in project location:
-1. change app version
-2. "mvn clean package"
-2. "docker build -t weedingappbe:latest ."  
###
## on gcloud cli:
-1. gcloud auth login if needed
###
-2. "docker tag weedingappbe{_version} gcr.io/gbweedingfe/weedingappbe{_version}"
###
-3. "docker push gcr.io/gbweedingbe/weedingappbe{_version}" 
###

## on cloud:
-1. go to https://console.cloud.google.com/gcr/images/gbweedingbe?project=gbweedingbe or Container Registry
###
-2. copy pushed url(weedingappfe{_version})
###
-3. go to https://console.cloud.google.com/run?referrer=search&project=gbweedingbe or Cloud Run
###
-4.Create new service, paste url to 'container image url'
###
-5.set region to warsaw
###
-6. check 'Allow unauthenticated invocations'
###
-7. Change port if needed
###
-8. Delete previous service
