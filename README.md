# AWS SQS demo

## setup

deploy to AWS

```
sam build
sam deploy --guided
``` 

## Test

grab the url in the output from running the above deploy step.  Should end in /Prod/hello/.

put that url in browser which should return hello world

check in aws in sqs. there should be a queue create with the name sam-app-MySqsQueue-?????. click on monitoring and you should see message come in.

go to lambdas and there should be a second lambda called sam-app-SecondFunction-????. select monitoring tab and then cloud watch logs and there should be a "hello world" message received in the logs. 



## clean up

```

sam delete

```